package com.luucasalbuq.VowelsAverage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Map;

import com.luucasalbuq.VowelsAverage.model.VowelSet;
import com.luucasalbuq.VowelsAverage.model.VowelTotal;
import com.luucasalbuq.VowelsAverage.model.VowelTotalBuilder;
import com.luucasalbuq.VowelsAverage.util.StreamHelper;
import com.luucasalbuq.VowelsAverage.util.VowelCounter;
import com.luucasalbuq.VowelsAverage.util.WordHelper;

public class VowelsProcessorImpl implements VowelsProcessor {
	
	public Map<VowelSet, Double> readAndCalculateAvg(String fileName) throws IOException {
		
		final VowelCounter vowelCounter = new VowelCounter();
		
		BufferedReader bufferedReader = StreamHelper.getInputBufferReader(fileName);
		
		for(String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
			for(String word : WordHelper.getWordsFromLine(line)) {
				VowelTotal vowelTotal = new VowelTotalBuilder(word).build();
				if(vowelTotal != null) vowelCounter.add(vowelTotal);
			}
		}
		
		return vowelCounter.calculateAvg();
	}
	
	public void writeAvgResult(Map<VowelSet, Double> avgResults, String fileName) throws IOException {

		OutputStream outputStream = StreamHelper.getOutputStream(fileName);
		
		final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.#");
		final String ENCODING = "UTF-8";
		final String OUTPUT_FORMAT = "(%s) -> %s\n";

		for (Map.Entry<VowelSet, Double> entry : avgResults.entrySet()) {

			VowelSet key = entry.getKey();
			Double avgNumber = entry.getValue();

			final String number = DECIMAL_FORMAT.format(avgNumber);
			final String line = String.format(OUTPUT_FORMAT, key, number);

			outputStream.write(line.replaceAll("\\[", "").replaceAll("\\]", "").getBytes(ENCODING));
		}
		outputStream.close();
	}
	
}
