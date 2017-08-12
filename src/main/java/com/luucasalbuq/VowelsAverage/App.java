package com.luucasalbuq.VowelsAverage;

import com.luucasalbuq.VowelsAverage.model.VowelSet;

import java.io.IOException;
import java.util.Map;
/**
 * 
 * @author lucas.almeida
 *
 */
public class App {
    
    public static final String INPUT_DEFAULT_FILE_NAME = "input.txt";
    
    public static final String OUTPUT_DEFAULT_FILE_NAME = "output.txt";

	public static void main( String[] args ){
		VowelsProcessor vowelsProcessor = new VowelsProcessorImpl();
		try {
			final Map<VowelSet, Double> result = vowelsProcessor.readAndCalculateAvg(INPUT_DEFAULT_FILE_NAME);
			vowelsProcessor.writeAvgResult(result, OUTPUT_DEFAULT_FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
