package com.luucasalbuq.VowelsAverage;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.luucasalbuq.VowelsAverage.util.WordHelper;

public class WordHelperTest {
	
	private String validLine;
	private String invalidLine;
	
	@Before
	public void setUp() {
		validLine = "Platon made bamboo boats";
		invalidLine = null;
	}
	
	@Test
	public void getWordsFromLineTest() {
		List<String> wordList = Arrays.asList("platon","made","bamboo","boats");
		assertTrue(WordHelper.getWordsFromLine(validLine).equals(wordList));
		
		validLine = "Platon            made bamboo boats";
		assertTrue(WordHelper.getWordsFromLine(validLine).equals(wordList));
	}
	
	@Test(expected = Exception.class)
	public void getWordsFromLineWithInvalidInputTest() {
		List<String> wordList = Arrays.asList("platon","made","bamboo","boats");
		assertTrue(WordHelper.getWordsFromLine(invalidLine).equals(wordList));
	}
}
