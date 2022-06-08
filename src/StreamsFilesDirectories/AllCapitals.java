package StreamsFilesDirectories;

import java.io.*;
import java.util.Scanner;

public class AllCapitals {

	public static void main(String[] args) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/resources/input.txt"));
				PrintWriter printWriter = new PrintWriter(new FileWriter("src/resources/output.txt"));) {
			bufferedReader.lines()
					.forEach(line -> printWriter.println(line.toUpperCase()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
