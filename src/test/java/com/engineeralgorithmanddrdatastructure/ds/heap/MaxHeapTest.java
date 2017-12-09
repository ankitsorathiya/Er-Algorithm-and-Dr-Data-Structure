package com.engineeralgorithmanddrdatastructure.ds.heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MaxHeapTest {
	@Test
	public void testMaxHeapPeekFunction() {
		Heap<Integer> maxHeap = new Heap<>((Integer a, Integer b) -> b.compareTo(a));
		maxHeap.add(10);
		maxHeap.add(20);
		maxHeap.add(30);
		maxHeap.add(50);
		maxHeap.add(5225);
		maxHeap.add(515);
		maxHeap.add(52);
		assertEquals(5225, maxHeap.peek().intValue());
	}

	@Test
	public void testMaxHeapPollFunction() {
		Heap<Integer> maxHeap = new Heap<>((Integer a, Integer b) -> b.compareTo(a));
		maxHeap.add(10);
		maxHeap.add(20);
		maxHeap.add(30);
		maxHeap.add(5);
		maxHeap.add(1);
		assertEquals(30, maxHeap.poll().intValue());
		assertEquals(20, maxHeap.poll().intValue());
		assertEquals(10, maxHeap.poll().intValue());
		assertEquals(5, maxHeap.poll().intValue());
		maxHeap.add(53);
		maxHeap.add(51);
		maxHeap.add(45);
		maxHeap.add(55);
		maxHeap.add(955);
		maxHeap.add(265);
		maxHeap.add(1455);
		maxHeap.add(5225);
		maxHeap.add(515);
		maxHeap.add(52);
		assertEquals(5225, maxHeap.poll().intValue());
	}

	@Test(expected = EmptyHeapException.class)
	public void testMaxHeapPollFunctionWithEmptyHeap() {
		Heap<Integer> maxHeap = new Heap<>((Integer a, Integer b) -> b.compareTo(a));
		maxHeap.poll();
		fail("Polling on empty heap and if it is working I should give up coding!");
	}

	@Test(expected = EmptyHeapException.class)
	public void testMaxHeapPeekFunctionWithEmptyHeap() {
		Heap<Integer> maxHeap = new Heap<>((Integer a, Integer b) -> b.compareTo(a));
		maxHeap.peek();
		fail("peeking on empty heap and if it is working I should give up coding!");
	}
}
