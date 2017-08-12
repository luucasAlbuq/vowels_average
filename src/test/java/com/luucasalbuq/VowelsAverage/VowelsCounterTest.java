package com.luucasalbuq.VowelsAverage;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.luucasalbuq.VowelsAverage.model.VowelSet;
import com.luucasalbuq.VowelsAverage.model.VowelTotal;
import com.luucasalbuq.VowelsAverage.util.VowelCounter;


import java.util.Map;
import java.util.List;

public class VowelsCounterTest {
	
	private VowelCounter vowelCounter;
	private VowelSet vowelSet_1,vowelSet_2,vowelSet_3;
	
	@Before
	public void setUp() {
		vowelCounter = new VowelCounter();
		vowelSet_1 = new VowelSet(Arrays.asList('a','o'), 6);
		vowelSet_2 = new VowelSet(Arrays.asList('a', 'o'), 5);
		vowelSet_3 = new VowelSet(Arrays.asList('a', 'e'), 4);
	}
	
	@Test
	public void addTest() {
		vowelCounter.add(vowelSet_1, 2);
		vowelCounter.add(vowelSet_1, 3);
		vowelCounter.add(vowelSet_2, 2);
		vowelCounter.add(vowelSet_3, 2);
		
		Map<VowelSet, List<Integer>> expectedMap = new HashMap<VowelSet, List<Integer>>();
		expectedMap.put(vowelSet_1, Arrays.asList(2,3));
		expectedMap.put(vowelSet_2, Arrays.asList(2));
		expectedMap.put(vowelSet_3, Arrays.asList(2));
		
		assertTrue(vowelCounter.getVowelCounter().equals(expectedMap));
	}
	
	@Test
	public void addVowelTotalTest() {
		VowelTotal vowelTotal_1 = new VowelTotal(vowelSet_1, 2);
		VowelTotal vowelTotal_2 = new VowelTotal(vowelSet_1, 3);
		VowelTotal vowelTotal_3 = new VowelTotal(vowelSet_2, 2);
		VowelTotal vowelTotal_4 = new VowelTotal(vowelSet_3, 2);
		vowelCounter.add(vowelTotal_1);
		vowelCounter.add(vowelTotal_2);
		vowelCounter.add(vowelTotal_3);
		vowelCounter.add(vowelTotal_4);
		
		Map<VowelSet, List<Integer>> expectedMap = new HashMap<VowelSet, List<Integer>>();
		expectedMap.put(vowelSet_1, Arrays.asList(2,3));
		expectedMap.put(vowelSet_2, Arrays.asList(2));
		expectedMap.put(vowelSet_3, Arrays.asList(2));
		
		assertTrue(vowelCounter.getVowelCounter().equals(expectedMap));
	}
	
	@Test(expected = Exception.class)
	public void addInvalidInputTest() {
		vowelCounter.add(null, 3);
		vowelCounter.add(null);
	}
	
	@Test
	public void calculateAvgTest() {
		vowelCounter.add(vowelSet_1, 2);
		vowelCounter.add(vowelSet_1, 3);
		vowelCounter.add(vowelSet_2, 2);
		vowelCounter.add(vowelSet_3, 2);
		
		Map<VowelSet, Double> expectedResult = new HashMap<VowelSet, Double>();
		expectedResult.put(vowelSet_1, 2.5);
		expectedResult.put(vowelSet_2, 2.0);
		expectedResult.put(vowelSet_3, 2.0);
		
		assertTrue(vowelCounter.calculateAvg().equals(expectedResult));
	}
	
	@Test
	public void calculateAvgWhenWeDontHaveInputsTest() {
		Map<VowelSet, Double> expectedResult = new HashMap<VowelSet, Double>();
		assertTrue(vowelCounter.calculateAvg().equals(expectedResult));
	}
	
}
