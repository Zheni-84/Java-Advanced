package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SumBytes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/resources/input.txt"))) {
			String line = bufferedReader.readLine();
			long sum = 0;
			while (line != null) {
				char[] charactersFromLine = line.toCharArray();
				for (char singleChar : charactersFromLine) {
					sum += singleChar;
				}
				line = bufferedReader.readLine();
			}
			System.out.println(sum);

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
