package com.luucasalbuq.VowelsAverage.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents the set of vowels in a word
 * 
 * eg: For the word 'made' the correspond VowelSet should be ({a, e}, 4)
 * 
 * @author lucas.almeida
 *
 */
public class VowelSet {
	
	private final Set<Character> vowels;
	private final int wordLength;
	
	public VowelSet(Collection<Character> vowels, int wordLength) {
		this.vowels = new HashSet<Character>(vowels);
		this.wordLength = wordLength;
	}

	public Set<Character> getVowels() {
		return vowels;
	}

	public int getWordLength() {
		return wordLength;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vowels == null) ? 0 : vowels.hashCode());
		result = prime * result + wordLength;
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
		VowelSet other = (VowelSet) obj;
		if (vowels == null) {
			if (other.vowels != null)
				return false;
		} else if (!vowels.equals(other.vowels))
			return false;
		if (wordLength != other.wordLength)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{" + vowels + "}, " + wordLength;
	}
	
}
