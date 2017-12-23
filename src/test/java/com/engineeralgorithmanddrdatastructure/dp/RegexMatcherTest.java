package com.engineeralgorithmanddrdatastructure.dp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RegexMatcherTest {
	private boolean expected;
	private String regex;
	private String input;

	public RegexMatcherTest(boolean expected, String regex, String input) {
		super();
		this.expected = expected;
		this.regex = regex;
		this.input = input;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] { { true, "", "" }, { true, "*a*b", "ankitsorathiyaasorathiyab" },
				{ false, "*aankit*_b", "ankitsorathiyaasorathiyab" },
				{ true, "*ankit*_b", "ankitsorathiyaasorathiyab" },
				{ true, "*hello_*_hello", "whatUp  helloIIhello" } });
	}

	@Test
	public void testRegexMatcher() {
		assertEquals(expected, RegexMatcher.doesMatch(regex, input));
	}
}
