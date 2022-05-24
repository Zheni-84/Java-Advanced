package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String rotationInput = sc.nextLine();
		String input = sc.nextLine();

		int maxColumnLength = Integer.MIN_VALUE;
		List<String> wordList = new ArrayList<>();
		while (!input.equals("END")) {
			int currentLen = input.length();
			if (currentLen > maxColumnLength) {
				maxColumnLength = currentLen;
			}
			wordList.add(input);
			input = sc.nextLine();
		}
		int rows = wordList.size();
		int cols = maxColumnLength;
		char[][] matrix = new char[rows][cols];
		for (int row = 0; row < rows; row++) {
			String currentWord = wordList.get(row);
			for (int col = 0; col < cols; col++) {
				if (col < currentWord.length()) {
					char currentChar = currentWord.charAt(col);
					matrix[row][col] = currentChar;
				} else {
					matrix[row][col] = ' ';
				}
			}
		}
		String angleString = rotationInput.split("[()]")[1];
		int angle = Integer.parseInt(angleString);
		int angleOfRotation = angle % 360;
		printMatrix(matrix, rows, cols, angleOfRotation);
	}

	private static void printMatrix(char[][] matrix, int rows, int cols, int angleOfRotation) {
		switch (angleOfRotation) {
			case 0:
				for (int row = 0; row < rows; row++) {
					for (int col = 0; col < cols; col++) {
						System.out.print(matrix[row][col]);
					}
					System.out.println();
				}
				break;
			case 90:
				for (int col = 0; col < cols; col++) {
					for (int row = rows - 1; row >= 0; row--) {
						System.out.print(matrix[row][col]);
					}
					System.out.println();
				}
				break;
			case 180:
				for (int row = rows - 1; row >= 0; row--) {
					for (int col = cols - 1; col >= 0; col--) {
						System.out.print(matrix[row][col]);
					}
					System.out.println();
				}
				break;
			case 270:
				for (int col = cols - 1; col >= 0; col--) {
					for (int row = 0; row < rows; row++) {
						System.out.print(matrix[row][col]);
					}
					System.out.println();
				}
				break;
		}
	}
}
