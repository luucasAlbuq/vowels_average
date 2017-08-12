package com.luucasalbuq.VowelsAverage.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Builder Pattern for the instantiation a {@link VowelTotal} from a word. 
 * @author lucas.almeida
 *
 */
public class VowelTotalBuilder {
	
	private final String word;
	
	public VowelTotalBuilder(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return word;
	}

	/**
	 * Creates a {@code VowelTotal} going thru all characters 
	 * @param word
	 * @return
	 */
	public VowelTotal build() {
		if(word == null || word.isEmpty()) {
			throw new RuntimeException("Invalid Word");
		}
		
		Set<Character> vowels = new HashSet<Character>();
		int wordLength = word.length();
		int totalVowel = 0;
		
		for(int i = 0; i < wordLength; i++) {
			final char letter = word.charAt(i);
			if(letter == 'a' || letter == 'e' || letter == 'o' || 
					letter == 'u' || letter == 'A' || letter == 'E' || letter == 'O' || letter == 'U' ) {
				vowels.add(Character.toLowerCase(letter));
				totalVowel += 1;
			}
		}
		
		return new VowelTotal(vowels, wordLength ,totalVowel);
	}
}
