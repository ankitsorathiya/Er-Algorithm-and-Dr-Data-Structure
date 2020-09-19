package com.engineeralgorithmanddrdatastructure.array;

/**
 * guy 1 calendar[already booked] => [[9:00,10:30],[12:00,13:00][16:00,17:00]]
 * guy 1 working hours=> 9:00-20:00
 * guy2 calendar[already booked]=>  [[10:00,11:30],[12:30,14:30],[14:30,15:00],[16:00,17:00]]
 * guy2 working hours=> 10:00:18:30
 * wants to schedule 30 minutes meeting find out available blocks, note block could be more than 30 minutes
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MixCalendarProblem {
    public static void main(String[] args) {
        String[][] guy1Calendar = new String[][]{{"9:00", "10:30"}, {"12:00", "13:00"}, {"16:00", "18:00"}};
        String[] guy1WorkingHours = new String[]{"9:00", "20:00"};
        String[][] guy2Calendar = new String[][]{{"10:00", "11:30"}, {"12:30", "14:30"}, {"14:30", "15:00"}, {"16:00", "17:00"}};
        String[] guy2WorkingHours = new String[]{"10:00", "18:30"};

        System.out.println("Using solution1");
        List<String[]> result = new Solution1().findAvailableTimeBlocks(guy1Calendar, guy1WorkingHours, guy2Calendar, guy2WorkingHours, 30);
        for (String[] output : result) {
            System.out.println(Arrays.toString(output));
        }

        System.out.println("Using solution2");
        result = new Solution2().findAvailableTimeBlocks(guy1Calendar, guy1WorkingHours, guy2Calendar, guy2WorkingHours, 30);
        for (String[] output : result) {
            System.out.println(Arrays.toString(output));
        }
    }

    private static int buildMinutes(String time) {
        String[] chunks = time.split(":");
        return Integer.parseInt(chunks[0]) * 60 + Integer.parseInt(chunks[1]);
    }

    private static String buildTime(int minutes) {
        int remainingMinutes = minutes % 60;
        int hours = minutes / 60;
        return hours + ":" + (remainingMinutes > 9 ? remainingMinutes : "0" + remainingMinutes);
    }

    /**
     * for the given day we have 24*60=1200+240=1440
     * array that holds availability
     * mark guy1 booked slots.
     * mark guy2 booked slots
     * start looking in array from max(guy1 starting Time,guy2 StartingTime)
     * end looking in array at min(guy1 ending time,guy2 endingTime)
     */


    static class Solution1 {
        public List<String[]> findAvailableTimeBlocks(String[][] guy1Calendar, String[] guy1WorkingHours, String[][] guy2Calendar,
                                                      String[] guy2WorkingHours, int minTimeBlockInMinutes) {
            boolean[] availability = initialize();
            blockMinutes(guy1Calendar, availability);
            blockMinutes(guy2Calendar, availability);
            int guy1Start = buildMinutes(guy1WorkingHours[0]);
            int guy2Start = buildMinutes(guy2WorkingHours[0]);
            int maxStart = Math.max(guy1Start, guy2Start);
            int guy1End = buildMinutes(guy1WorkingHours[1]);
            int guy2End = buildMinutes(guy2WorkingHours[1]);
            int minEnd = Math.min(guy1End, guy2End);
            return findAvailable(availability, maxStart, minEnd, minTimeBlockInMinutes);
        }

        private List<String[]> findAvailable(boolean[] availability, int startIndex, int endIndex, int minTimeBlockInMinutes) {
            List<String[]> result = new ArrayList<>();
            int index = startIndex;
            while (index < endIndex) {
                Integer blockStartIndex = null;
                Integer blockEndIndex = null;
                if (availability[index]) {
                    blockStartIndex = index;
                    blockEndIndex = blockStartIndex;
                    while (availability[blockEndIndex] && blockEndIndex < endIndex) {
                        blockEndIndex++;
                    }
                    int delta = ((blockEndIndex) - blockStartIndex) + 1;
                    if (delta >= minTimeBlockInMinutes) {
                        String[] availableTime = new String[]{buildTime(blockStartIndex - 1), buildTime(blockEndIndex)};
                        result.add(availableTime);
                    }
                    index = blockEndIndex;
                }
                index++;
            }
            return result;
        }

        private boolean[] initialize() {
            boolean[] availability = new boolean[1441];
            for (int index = 0; index < availability.length; index++) {
                availability[index] = true;
            }
            return availability;

        }

        private void blockMinutes(String[][] calendar, boolean[] availability) {
            for (int row = 0; row < calendar.length; row++) {
                int start = buildMinutes(calendar[row][0]);
                int end = buildMinutes(calendar[row][1]);
                for (int index = start; index <= end; index++) {
                    availability[index] = false;
                }
            }
        }

    }

    /**
     * merge both the calendar based on end time
     * iterate over it to find the difference.
     */
    static class Solution2 {
        public List<String[]> findAvailableTimeBlocks(String[][] guy1Calendar, String[] guy1WorkingHours, String[][] guy2Calendar,
                                                      String[] guy2WorkingHours, int minTimeBlockInMinutes) {
            String[][] calendar = new String[guy1Calendar.length + guy2Calendar.length][2];
            int guy1Index = 0;
            int guy2Index = 0;
            int mergePointer = 0;
            while (mergePointer < calendar.length && guy1Index < guy1Calendar.length && guy2Index < guy2Calendar.length) {
                int guy1ScheduleEnd = buildMinutes(guy1Calendar[guy1Index][1]);
                int guy2ScheduleEnd = buildMinutes(guy2Calendar[guy2Index][1]);
                if (guy1ScheduleEnd < guy2ScheduleEnd) {
                    calendar[mergePointer] = guy1Calendar[guy1Index];
                    guy1Index++;
                } else {
                    calendar[mergePointer] = guy2Calendar[guy2Index];
                    guy2Index++;
                }
                mergePointer++;
            }
            mergePointer = merge(guy1Calendar, calendar, guy1Index, mergePointer);
            mergePointer = merge(guy2Calendar, calendar, guy2Index, mergePointer);
            int maxStart = Math.max(buildMinutes(guy1WorkingHours[0]), buildMinutes(guy2WorkingHours[0]));
            int minEnd = Math.max(buildMinutes(guy1WorkingHours[1]), buildMinutes(guy2WorkingHours[1]));
            List<String[]> result = new ArrayList<>();
            for (int index = 1; index < calendar.length; index++) {
                String[] previous = calendar[index - 1];
                String[] current = calendar[index];
                int previousEnd = buildMinutes(previous[1]);
                int currentStart = buildMinutes(current[0]);
                if (currentStart - previousEnd >= minTimeBlockInMinutes && previousEnd >= maxStart && currentStart <= minEnd) {
                    String[] availableSlot = new String[]{previous[1], current[0]};
                    result.add(availableSlot);
                }
            }
            String[] slot = calendar[calendar.length - 1];
            if (minEnd - buildMinutes(slot[1]) >= minTimeBlockInMinutes) {
                String[] availableSlot = new String[]{slot[1], buildTime(minEnd)};
                result.add(availableSlot);
            }
            return result;
        }

        private int merge(String[][] guy1Calendar, String[][] calendar, int guy1Index, int mergePointer) {
            while (mergePointer < calendar.length && guy1Index < guy1Calendar.length) {
                calendar[mergePointer] = guy1Calendar[guy1Index];
                guy1Index++;
                mergePointer++;
            }
            return mergePointer;
        }
    }
}
