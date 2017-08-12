package com.luucasalbuq.VowelsAverage.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Manipulates the string lines from the input file 
 * 
 * @author lucas.almeida
 *
 */
public abstract class WordHelper {
	
	/**
	 * Split all words of a line.
	 * 
	 * @param line
	 * @return list of words
	 */
	public static List<String> getWordsFromLine(String line){
		List<String> wordsList = new ArrayList<String>();
		
		if(line == null || line.isEmpty()) {
			return null;
		}
		
		String[] parts = line.split("[^a-zA-Z0-9\\-\']");
		for (String word : parts) {
            if(word.matches("^[a-zA-Z0-9\\-']{1,}$")) {
            	wordsList.add(word.toLowerCase());
            }
        }
		return wordsList;
	}
}
