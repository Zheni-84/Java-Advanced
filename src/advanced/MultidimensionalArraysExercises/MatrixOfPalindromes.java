package advanced.MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = Arrays.stream(sc.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int rows = input[0];
		int cols = input[1];

		String[][] matrix = new String[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				char outside = (char) ('a' + row);
				char middle = (char) (outside + col);
				matrix[row][col] = String.valueOf(outside) + middle + outside;
			}
		}
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}


}