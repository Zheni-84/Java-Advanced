package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] dimensions = readPositions(scanner.nextLine());
		int rows = dimensions[0];
		int cols = dimensions[1];

		int[][] galaxy = new int[rows][cols];

		fillInGalaxy(rows, cols, galaxy);

		String command = scanner.nextLine();

		while (!command.equals("Let the Force be with you")) {
			int[] jediPosition = readPositions(command);
			int[] evilPosition = readPositions(scanner.nextLine());
			int currentRowEvil = evilPosition[0];
			int currentColEvil = evilPosition[1];

			moveEvil(galaxy, currentRowEvil, currentColEvil);

			int currentRowJedi = jediPosition[0];
			int currentColJedi = jediPosition[1];

			long starsCollected = moveJedi(galaxy, currentRowJedi, currentColJedi);

			command = scanner.nextLine();
			System.out.println(starsCollected);
		}


	}

	private static void moveEvil(int[][] galaxy, int currentRowEvil, int currentColEvil) {
		while (currentRowEvil >= 0 && currentColEvil >= 0) {
			if (isInbounds(galaxy, currentRowEvil, currentColEvil)) {
				galaxy[currentRowEvil][currentColEvil] = 0;
			}
			currentRowEvil--;
			currentColEvil--;
		}
	}

	private static long moveJedi(int[][] galaxy, int currentRowJedi, int currentColJedi) {
		long starsCollected = 0;

		while (currentRowJedi >= 0 && currentColJedi < galaxy[1].length) {
			if (isInbounds(galaxy, currentRowJedi, currentColJedi)) {
				starsCollected += galaxy[currentRowJedi][currentColJedi];
			}

			currentColJedi++;
			currentRowJedi--;
		}
		return starsCollected;
	}

	private static int[] readPositions(String command) {
		return Arrays.stream(command.split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

	private static boolean isInbounds(int[][] galaxy, int row, int col) {
		return row >= 0 && col >= 0 && row < galaxy.length && col < galaxy[row].length;
	}

	private static void fillInGalaxy(int rows, int cols, int[][] galaxy) {
		int value = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				galaxy[row][col] = value++;
			}
		}
	}
}
