package com.luucasalbuq.VowelsAverage;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.luucasalbuq.VowelsAverage.model.VowelSet;

public class VowelProcessorTest {
	
	
	private VowelsProcessor vowelsProcessor;
	private final String fileNameInput = "input_for_test.txt";
	private final String fileNameOutput = "output_for_test.txt";
	private VowelSet vowelSet_1, vowelSet_2, vowelSet_3;
	
	@Before
	public void setUp() {
		vowelsProcessor = new VowelsProcessorImpl();
		vowelSet_1 = new VowelSet(Arrays.asList('a','o'), 6);
		vowelSet_2 = new VowelSet(Arrays.asList('a', 'o'), 5);
		vowelSet_3 = new VowelSet(Arrays.asList('a', 'e'), 4);
	}
	
	@Test
	public void readAndCalculateAvgTest() throws IOException {
		Map<VowelSet, Double> expectedResult = new HashMap<VowelSet, Double>();
		expectedResult.put(vowelSet_1, 2.5);
		expectedResult.put(vowelSet_2, 2.0);
		expectedResult.put(vowelSet_3, 2.0);
        
        assertTrue(vowelsProcessor.readAndCalculateAvg(fileNameInput).equals(expectedResult));
	}
	
	@Test(expected = IOException.class)
	public void readAndCalculateAvgFromIvalidFileTest() throws IOException {
		Map<VowelSet, Double> expectedResult = new HashMap<VowelSet, Double>();
		expectedResult.put(vowelSet_1, 2.5);
		expectedResult.put(vowelSet_2, 2.0);
		expectedResult.put(vowelSet_3, 2.0);
		
        assertTrue(vowelsProcessor.readAndCalculateAvg("nonexistent.txt").equals(expectedResult));
        assertTrue(vowelsProcessor.readAndCalculateAvg("").equals(expectedResult));
        assertTrue(vowelsProcessor.readAndCalculateAvg(null).equals(expectedResult));
	}
	
	@Test
	public void writeAvgResultTest() throws IOException {
		Map<VowelSet, Double> expectedResult = new HashMap<VowelSet, Double>();
		expectedResult.put(vowelSet_1, 2.5);
		expectedResult.put(vowelSet_2, 2.0);
		expectedResult.put(vowelSet_3, 2.0);
		
		vowelsProcessor.writeAvgResult(expectedResult, fileNameOutput);
		File file = new File(fileNameOutput);
		assertTrue(file.exists());
		file.delete();
	}
	
}