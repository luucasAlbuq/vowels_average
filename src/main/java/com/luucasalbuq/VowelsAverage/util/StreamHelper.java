package com.luucasalbuq.VowelsAverage.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Provides the input and output stream for the file manipulation
 * 
 * @author lucas.almeida
 *
 */
public abstract class StreamHelper {
	
	public static BufferedReader getInputBufferReader(final String fileName) throws IOException{
		return Files.newBufferedReader(Paths.get(fileName));
	}
	
	/**
	 * When not pass a valid file, the result I will showed in the console
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static OutputStream getOutputStream(String fileName) throws IOException {
        if (fileName == null || fileName.isEmpty()) {
            return System.out;
        }

        return Files.newOutputStream(Paths.get(fileName));
    }
}
