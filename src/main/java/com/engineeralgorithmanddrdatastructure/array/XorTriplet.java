package com.engineeralgorithmanddrdatastructure.array;

public class XorTriplet {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 8, 9};
        System.out.println(findXorTripletSum(arr));
    }

    public static int findXorTripletSum(int[] arr) {
        int result = 0;
        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            int setCount = 0;
            int num = 1 << bitIndex;
            for (int index = 0; index < arr.length; index++) {
                if ((arr[index] & num) > 0) {
                    setCount++;
                }
            }
            int unsetCount = arr.length - setCount;
            int zeroPair = (unsetCount * (unsetCount - 1)) / 2;
            int onePair = (setCount * (setCount - 1)) / 2;
            int zeroPairWithOne = zeroPair * setCount;
            int onePairWithZero = onePair * unsetCount;
            int totalPair = zeroPairWithOne + onePairWithZero;
            result += Math.pow(2, bitIndex) * totalPair;
        }
        return result;
    }
}
