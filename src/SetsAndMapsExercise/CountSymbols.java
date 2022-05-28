package SetsAndMapsExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();

		TreeMap<Character, Integer> symbolMap = new TreeMap<>();
		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			symbolMap.putIfAbsent(currentChar, 0);
			int currentCharCount = symbolMap.get(currentChar);
			symbolMap.put(currentChar, currentCharCount + 1);
		}

		for (Map.Entry<Character, Integer> pair : symbolMap.entrySet()) {
			System.out.printf("%c: %d time/s%n", pair.getKey(), pair.getValue());
		}
	}

}
