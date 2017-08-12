package com.luucasalbuq.VowelsAverage.util;

import com.luucasalbuq.VowelsAverage.model.VowelSet;
import com.luucasalbuq.VowelsAverage.model.VowelTotal;
import java.util.Map;

/**
 * Provides the basics calculation that we will need to calculate
 * the average number of vowels for many words.
 * 
 * @author lucas.almeida
 *
 */
public interface VowelMath {
	
	/**
	 * Add a set of vowels and number of vowels for the words
	 * tha has this set of vowels
	 * 
	 * @param vowels
	 * @param numberOfVowels
	 */
	public void add(VowelSet vowels, int numberOfVowels);
	
	/**
	 * Add a set of vowels and number of vowels for the words
	 * tha has this set of vowels
	 * 
	 * @param VowelTotal
	 */
	public void add(VowelTotal vowelTotal);
	
	/**
	 * Calculates the average number for a set of vowels
	 * 
	 * @return Map<VowelSet, avgNumber>
	 */
	public Map<VowelSet, Double> calculateAvg();
}
