package MultidimensionalArraysExercises;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = Integer.parseInt(sc.nextLine());
		int[][] matrix = new int[size][size];
		for (int row = 0; row < size; row++) {
			String[] rowInput = sc.nextLine().split(" ");
			for (int col = 0; col < size; col++) {
				matrix[row][col] = Integer.parseInt(rowInput[col]);
			}

		}
		int mainDiagonalSum = 0;
		for (int counter = 0; counter < size; counter++) {
	//		mainDiagonalSum += matrix[counter][counter];
		}
		int secondaryDiagonalSum = 0;
		for (int row = 0, col = size - 1; row < size; row++, col--) {
			mainDiagonalSum += matrix[row][row];
			secondaryDiagonalSum += matrix[row][col];
		}

		System.out.println(Math.abs(mainDiagonalSum - secondaryDiagonalSum));
	}

}
