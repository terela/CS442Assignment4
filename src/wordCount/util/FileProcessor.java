package wordCount.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * FileProcessor - contains methods to read a line and write to a file
 */
public class FileProcessor {

	private String inputFile;

	/**
	 * Constructor - constructs a file processor object
	 *
	 * @return the file processor object
	 */
	public FileProcessor(String inputFileIn) {

		MyLogger.printToStdout(2, "Constructor in FileProcessor called.");

		inputFile = inputFileIn;
	
	}

	// read line method
	
	/**
	 * readLine - reads and returns the current line of the file as a string
	 *
	 * @return line the current line of the file
	 */
	public String readLine(String inputFile) {

		MyLogger.printToStdout(3, "readLine() in FileProcessor called.");

		String line = null;

		try {
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			line = bufferedReader.readLine();

			bufferedReader.close();

		} catch (IOException e) {

			MyLogger.printToStdout(0, "Error message in FileProcessor called.");

			e.printStackTrace();

			System.exit(1);

		} finally {

		}
		
		return line;
	
	}
	
	// write to file method
	
	/**
	 * writeToFile - writes the value parameter to the outputFile parameter
	 *
	 * @return none
	 */
	public void writeToFile(String value, String outputFile) {

		MyLogger.printToStdout(3, "writeToFile() in FileProcessor called.");

		try {

			PrintWriter output = new PrintWriter(new FileWriter(outputFile, true));
			
			output.write(value);
			
			output.close();

		} catch (IOException e) {

			MyLogger.printToStdout(0, "Error message in FileProcessor called.");

			e.printStackTrace();

			System.exit(1);

		} finally {

		}

	}
	
	/**
	 * getInputFile - gets and returns the input file name
	 *
	 * @return inputFile the inputFile name
	 */
	public String getInputFile() {

		MyLogger.printToStdout(3, "getInputFile() in FileProcessor called.");

		return inputFile;

	}

}
