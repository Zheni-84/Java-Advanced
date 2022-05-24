package MultidimensionalArraysExercises;

import java.util.Scanner;

public class FillTheMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] input = sc.nextLine().split(", ");

		int n = Integer.parseInt(input[0]);
		String pattern = input[1];
		int[][] matrix = new int[n][n];
		if (pattern.equals("A")) {
			fillInMatrixPatternA(n, matrix);
		} else if (pattern.equals("B")) {
			fillInMatrixPatternB(n, matrix);
		}

		printMatrix(n, matrix);

	}

	private static void printMatrix(int n, int[][] matrix) {
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}

	private static void fillInMatrixPatternB(int n, int[][] matrix) {
		int counter = 1;
		for (int col = 0; col < n; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < n; row++) {
					matrix[row][col] = counter;
					counter++;
				}
			} else{
				for (int row = n -1; row >=0; row--) {
					matrix[row][col] = counter;
					counter++;
				}
			}
		}
	}

	private static void fillInMatrixPatternA(int n, int[][] matrix) {
		int counter = 1;
		for (int col = 0; col < n; col++) {
			for (int row = 0; row < n; row++) {
				matrix[row][col] = counter;
				counter++;
			}
		}
	}

}
