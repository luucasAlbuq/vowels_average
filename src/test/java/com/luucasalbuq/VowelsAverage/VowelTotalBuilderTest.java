package com.luucasalbuq.VowelsAverage;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.luucasalbuq.VowelsAverage.model.VowelSet;
import com.luucasalbuq.VowelsAverage.model.VowelTotal;
import com.luucasalbuq.VowelsAverage.model.VowelTotalBuilder;

public class VowelTotalBuilderTest {
	
	@Test
	public void buildTest() {
		String word = "Platon";
		VowelTotalBuilder builder = new VowelTotalBuilder(word);
		
		Collection<Character> vowels =Arrays.asList('a','o');
		VowelSet vowelSet = new VowelSet(vowels, word.length());
		VowelTotal vowelTotalExpected = new VowelTotal(vowelSet, 2);
		assertTrue(builder.build().equals(vowelTotalExpected));
	}
	
	@Test(expected = RuntimeException.class)
	public void buildWhenWordIsNullTest() {
		VowelTotalBuilder builder = new VowelTotalBuilder(null);
		builder.build();
	}
	
	@Test(expected = RuntimeException.class)
	public void buildWhenWordIsEmptyTest() {
		VowelTotalBuilder builder = new VowelTotalBuilder("");
		builder.build();
	}
}
