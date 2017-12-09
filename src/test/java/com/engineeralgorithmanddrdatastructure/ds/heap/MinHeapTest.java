package com.engineeralgorithmanddrdatastructure.ds.heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MinHeapTest {
	@Test(expected = InvalidComparator.class)
	public void minHeapInitializationTest() {
		Heap<Integer> heap = new Heap<>((Integer a, Integer b) -> a.compareTo(b));
		assertNotNull(heap);
		heap = new Heap<>(null);
		fail("It worked without comparator which should not happen");
	}

	@Test
	public void testMinHeapPeekFunction() {
		Heap<Integer> minHeap = new Heap<>((Integer a, Integer b) -> a.compareTo(b));
		minHeap.add(10);
		minHeap.add(20);
		minHeap.add(30);
		minHeap.add(50);
		minHeap.add(5);
		minHeap.add(53);
		minHeap.add(51);
		minHeap.add(45);
		minHeap.add(55);
		minHeap.add(955);
		minHeap.add(265);
		minHeap.add(1455);
		minHeap.add(5225);
		minHeap.add(515);
		minHeap.add(52);
		assertEquals(5, minHeap.peek().intValue());
		minHeap.add(1);
		assertEquals(1, minHeap.peek().intValue());
	}

	@Test
	public void testMinHeapPollFunction() {
		Heap<Integer> minHeap = new Heap<>((Integer a, Integer b) -> a.compareTo(b));
		minHeap.add(10);
		minHeap.add(20);
		minHeap.add(30);
		minHeap.add(5);
		minHeap.add(1);
		assertEquals(1, minHeap.poll().intValue());
		assertEquals(5, minHeap.poll().intValue());
		assertEquals(10, minHeap.poll().intValue());
		assertEquals(20, minHeap.poll().intValue());
		assertEquals(30, minHeap.poll().intValue());
		minHeap.add(53);
		minHeap.add(51);
		minHeap.add(45);
		minHeap.add(55);
		minHeap.add(955);
		minHeap.add(265);
		minHeap.add(1455);
		minHeap.add(5225);
		minHeap.add(515);
		minHeap.add(52);
		assertEquals(45, minHeap.poll().intValue());
	}

	@Test
	public void allFunctionTests() {
		Heap<Integer> minHeap = new Heap<>((Integer a, Integer b) -> a.compareTo(b));
		minHeap.add(10);
		assertEquals(10, minHeap.poll().intValue());
		minHeap.add(20);
		assertEquals(20, minHeap.poll().intValue());
		minHeap.add(30);
		assertEquals(30, minHeap.poll().intValue());
		minHeap.add(10);
		minHeap.add(20);
		minHeap.add(30);
		assertEquals(10, minHeap.poll().intValue());
		assertEquals(20, minHeap.poll().intValue());
		assertEquals(30, minHeap.poll().intValue());
		minHeap.add(10);
		minHeap.add(30);
		minHeap.add(30);
		minHeap.add(40);
		minHeap.add(50);
		minHeap.add(60);
		minHeap.add(30);
		assertEquals(10, minHeap.poll().intValue());

	}

	@Test(expected = EmptyHeapException.class)
	public void testMinHeapPollFunctionWithEmptyHeap() {
		Heap<Integer> minHeap = new Heap<>((Integer a, Integer b) -> a.compareTo(b));
		minHeap.poll();
		fail("Polling on empty heap and if it is working I should give up coding!");
	}

	@Test(expected = EmptyHeapException.class)
	public void testMinHeapPeekFunctionWithEmptyHeap() {
		Heap<Integer> minHeap = new Heap<>((Integer a, Integer b) -> a.compareTo(b));
		minHeap.peek();
		fail("peeking on empty heap and if it is working I should give up coding!");
	}
}
