package com.engineeralgorithmanddrdatastructure.anagram;

import java.util.Arrays;

/**
 * 
 * @author ankit.sorathiya
 * 
 *         Given array of words, return array of words with anagram word
 *         together.
 * 
 *         input=> ["cat", "dog", "tac", "god","act"]
 * 
 *         output=> ["cat", "tac", "act","dog", "god" ]
 * 
 */
public class AnagramProblem {
	public static String[] neighbourAnagrams(String[] words) {
		if (words == null || words.length == 0) {
			return words;
		}
		Word[] wordsArr = initializeIndexes(words);
		sortWords(wordsArr);
		return getNeighbourAnagrams(words, wordsArr);
	}

	private static Word[] initializeIndexes(String[] words) {
		Word[] wordsArr = new Word[words.length];
		for (int index = 0; index < words.length; index++) {
			char[] word = words[index].toCharArray();
			Arrays.sort(word);
			wordsArr[index] = new Word(index, new String(word));
		}
		return wordsArr;
	}

	private static void sortWords(Word[] words) {
		Arrays.sort(words, (wordA, wordB) -> wordA.getWord().compareTo(wordB.getWord()));
	}

	private static String[] getNeighbourAnagrams(String[] original, Word[] words) {
		String[] neighbourAnagrams = new String[original.length];
		for (int index = 0; index < words.length; index++) {
			neighbourAnagrams[index] = original[words[index].getIndex()];
		}
		return neighbourAnagrams;
	}

}

class Word {
	private int index;
	private String word;

	public Word(int index, String word) {
		super();
		this.index = index;
		this.word = word;
	}

	public int getIndex() {
		return index;
	}

	public String getWord() {
		return word;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
