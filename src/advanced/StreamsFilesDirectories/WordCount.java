package advanced.StreamsFilesDirectories;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(new FileReader("src/advanced.resources/words.txt"));
				Scanner textScanner = new Scanner(new FileReader("src/advanced.resources/text.txt"));
				PrintWriter pw = new PrintWriter("src/advanced.resources/results.txt")
		) {
			LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<>();
			Arrays.stream(scan.nextLine().split(" ")).forEach(word -> wordMap.put(word, 0));

			while (textScanner.hasNext()) {
				String textInput = textScanner.next();
				if (wordMap.containsKey(textInput)) {
					wordMap.put(textInput, wordMap.get(textInput) + 1);
				}
			}
			wordMap.forEach((key, value) -> pw.printf("%s - %d%n", key, value));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
