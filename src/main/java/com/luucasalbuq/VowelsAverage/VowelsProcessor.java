package com.luucasalbuq.VowelsAverage;

import java.io.IOException;
import java.util.Map;

import com.luucasalbuq.VowelsAverage.model.VowelSet;

/**
 * Defines the tasks related to the processing input and output files. 
 * 
 * @author lucas.almeida
 *
 */
public interface VowelsProcessor {
	
	/**
	 * Reds from a txt file and calculate the avg number of vowels
	 * present in the file.
	 * 
	 * @param fileName
	 * @return Map<VowelSet, AvgNumber>
	 * @throws IOException
	 */
	public Map<VowelSet, Double> readAndCalculateAvg(final String fileName) throws IOException;
	
	/**
	 * Write the avg results in a output txt file.
	 * 
	 * @param avgResults
	 * @param fileName
	 * @throws IOException
	 */
	public void writeAvgResult(final Map<VowelSet, Double> avgResults, final String fileName) throws IOException;
	
}
