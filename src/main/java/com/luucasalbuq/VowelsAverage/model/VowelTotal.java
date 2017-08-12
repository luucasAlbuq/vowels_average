package com.luucasalbuq.VowelsAverage.model;

import java.util.Set;

/**
 * Represents the number of vowels in a word.
 * 
 * eg: For the word 'made' the correspond VowelAvg should be ({@link VowelSet}, 2), 
 * where 2 is the total number of vowels in a word.
 * 
 * @author lucas.almeida
 *
 */
public class VowelTotal {
	
	/*Set of vowels that are in the word*/
	private final VowelSet vowelSet;
	
	/*The number of vowels in the word*/
	private final int numberOfVowels;

	public VowelTotal(VowelSet vowelSet, int numberOfVowels) {
		this.vowelSet = vowelSet;
		this.numberOfVowels = numberOfVowels;
	}
	
	public VowelTotal(Set<Character> vowels, int wordLength, int numberOfVowels) {
		this.vowelSet = new VowelSet(vowels, wordLength);
		this.numberOfVowels = numberOfVowels;
	}

	public VowelSet getVowelSet() {
		return vowelSet;
	}

	public int getNumberOfVowels() {
		return numberOfVowels;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfVowels;
		result = prime * result + ((vowelSet == null) ? 0 : vowelSet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VowelTotal other = (VowelTotal) obj;
		if (numberOfVowels != other.numberOfVowels)
			return false;
		if (vowelSet == null) {
			if (other.vowelSet != null)
				return false;
		} else if (!vowelSet.equals(other.vowelSet))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VowelTotal [" + vowelSet.toString() + ", numberOfVowels=" + numberOfVowels + "]";
	}

}
