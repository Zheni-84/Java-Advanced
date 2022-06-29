package advanced.StreamsFilesDirectories;

import java.io.*;

public class AllCapitals {

	public static void main(String[] args) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/advanced.resources/input.txt"));
				PrintWriter printWriter = new PrintWriter(new FileWriter("src/advanced.resources/output.txt"));) {
			bufferedReader.lines()
					.forEach(line -> printWriter.println(line.toUpperCase()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
