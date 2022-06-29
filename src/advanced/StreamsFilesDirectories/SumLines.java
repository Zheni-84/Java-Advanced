package advanced.StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SumLines {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/advanced.resources/input.txt"))){
			String line = bufferedReader.readLine();
			while (line != null){
				long sum = 0;
				char[] charactersFromLine = line.toCharArray();
				for (char singleChar : charactersFromLine) {
					sum += singleChar;
				}
				System.out.println(sum);
				line = bufferedReader.readLine();
			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
