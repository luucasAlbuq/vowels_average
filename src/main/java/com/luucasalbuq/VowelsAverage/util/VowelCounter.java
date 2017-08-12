package com.luucasalbuq.VowelsAverage.util;

import java.util.Map;

import com.luucasalbuq.VowelsAverage.model.VowelSet;
import com.luucasalbuq.VowelsAverage.model.VowelTotal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

/**
 * The responsibility of {@link VowelCounter} is calculate the total number of vowels
 * and the average number of vowels in a word.
 * 
 * @author lucas.almeida
 *
 */
public class VowelCounter implements VowelMath{
	
	/*
	 * Must to be a list because is possible a same set of vowels appear in more then one
	 * word' that has the same length. Eg: 'Platon'and 'bamboo', both words has 6 letters
	 * and the some set of vowels (a,o), In this case we will have the avg number 2.5 because
	 * ( (a,o) + (a,o,o) ) / 2, where 2 is the total number of words.
	 * 
	 * The Key: is a set of vowels
	 * The Value: is the total number of vowels of each word that has the same key (set of vowels).
	 */
	private Map<VowelSet, List<Integer>> vowelCounter;
	
	public VowelCounter() {
		vowelCounter = new Hashtable<VowelSet, List<Integer>>();
	}

	public Map<VowelSet, List<Integer>> getVowelCounter() {
		return vowelCounter;
	}

	public void setVowelCounter(Map<VowelSet, List<Integer>> vowelCounter) {
		this.vowelCounter = vowelCounter;
	}
	
	public void add(VowelSet vowels, int numberOfVowels) {
		if(!vowelCounter.containsKey(vowels)) {
			vowelCounter.put(vowels, new ArrayList<Integer>());
		}
		vowelCounter.get(vowels).add(numberOfVowels);
	}

	public void add(VowelTotal vowelTotal) {
		if(!vowelCounter.containsKey(vowelTotal.getVowelSet())){
			vowelCounter.put(vowelTotal.getVowelSet(),new ArrayList<Integer>());
		}
		vowelCounter.get(vowelTotal.getVowelSet()).add(vowelTotal.getNumberOfVowels());
	}

	public Map<VowelSet, Double> calculateAvg() {
		/* Needs to have the same number of keys and values fo the vowelCounter Map,
		 * for that reason we are using vowelCounter.size() */
		Map<VowelSet, Double> avgResult = new HashMap<VowelSet, Double>(vowelCounter.size());
		
		for(Map.Entry<VowelSet, List<Integer>> entry: vowelCounter.entrySet()) {
			avgResult.put(entry.getKey(), calculateAvgForAVowelSet(entry.getValue()));
		}
		
		return avgResult;
	}
	
	/*
	 * Calculates the average number of vowels per {@Link VowelSet}
	 */
	private Double calculateAvgForAVowelSet(List<Integer> numbersOfVowels) {
		Double avg = 0.0;
		
		if(numbersOfVowels != null) {
			int count = 0;
			double sum = 0.0;
			
			for(Integer value: numbersOfVowels) {
				sum += value;
				count++;
			}
			if(count > 0) {
				avg = sum / count;
			}
		}
		return avg;
	}
	
}
