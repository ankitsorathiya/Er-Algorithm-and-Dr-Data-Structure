package com.engineeralgorithmanddrdatastructure.search;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class BidirectionalGraphSearchTest {
	Map<String, List<String>> connectivity;
	BidirectionalGraphSearch graphSearch;

	@Before
	public void initialize() throws Exception {
		graphSearch = new BidirectionalGraphSearch();
		connectivity = new HashMap<>();
		connectivity.put("0", new ArrayList<>(Arrays.asList("4")));
		connectivity.put("1", new ArrayList<>(Arrays.asList("4")));
		connectivity.put("2", new ArrayList<>(Arrays.asList("5")));
		connectivity.put("3", new ArrayList<>(Arrays.asList("5")));
		connectivity.put("4", new ArrayList<>(Arrays.asList("6", "0", "1")));
		connectivity.put("5", new ArrayList<>(Arrays.asList("6", "2", "1")));
		connectivity.put("6", new ArrayList<>(Arrays.asList("7", "4", "5")));
		connectivity.put("7", new ArrayList<>(Arrays.asList("8", "6")));
		connectivity.put("8", new ArrayList<>(Arrays.asList("7", "9", "10")));
		connectivity.put("9", new ArrayList<>(Arrays.asList("8", "11", "12")));
		connectivity.put("10", new ArrayList<>(Arrays.asList("8", "13", "14")));
		connectivity.put("11", new ArrayList<>(Arrays.asList("9")));
		connectivity.put("12", new ArrayList<>(Arrays.asList("9")));
		connectivity.put("13", new ArrayList<>(Arrays.asList("10")));
		connectivity.put("14", new ArrayList<>(Arrays.asList("10")));
		connectivity.put("15", new ArrayList<>(Arrays.asList()));
	}

	@Test
	public void testValidPath() {
		Graph graph = GraphFactory.buildGraph(connectivity);
		Node source = graph.getNode("0");
		Node destination = graph.getNode("14");
		Path path = graphSearch.bidirectionalSearch(source, destination, graph);
		assertEquals("0=>4=>6=>7=>8=>10=>14", path.toString());
	}

	@Test
	public void testValidPathWithOverloadedMethod() {
		Path path = graphSearch.bidirectionalSearch("0", "14", connectivity);
		assertEquals("0=>4=>6=>7=>8=>10=>14", path.toString());
	}

	@Test
	public void testNotFoundPath() {
		Graph graph = GraphFactory.buildGraph(connectivity);
		Node source = graph.getNode("0");
		Node destination = graph.getNode("15");
		Path path = graphSearch.bidirectionalSearch(source, destination, graph);
		String expected = source + "=> no path exists <=" + destination;
		assertEquals(expected, path.toString());
	}

}
