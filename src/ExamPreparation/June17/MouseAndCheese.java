package ExamPreparation.June17;

import java.util.Scanner;

public class MouseAndCheese {

	private static int row = 0;
	private static int col = 0;
	private static int eatenCheese = 0;

	private static boolean isMouseInField = true;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = Integer.parseInt(sc.nextLine());

		char[][] field = new char[size][size];

		for (int i = 0; i < size; i++) {
			String line = sc.nextLine();
			field[i] = line.toCharArray();

			if (line.contains("M")) {
				row = i;
				col = line.indexOf("M");
			}
		}

		String command = sc.nextLine();

		while (!command.equals("end")) {
			if (command.equals("up")) {
				moveMouse(field, -1, 0);
			} else if (command.equals("down")) {
				moveMouse(field, 1, 0);
			} else if (command.equals("left")) {
				moveMouse(field, 0, -1);
			} else if (command.equals("right")) {
				moveMouse(field, 0, 1);
			}
			if (!isMouseInField){
				break;
			}

			command = sc.nextLine();
		}

		if (!isMouseInField) {
			System.out.println("Where is the mouse?");
		}

		if (eatenCheese >= 5) {
			System.out.println("Great job, the mouse is fed " + eatenCheese + " cheeses!");

		} else {
			System.out.println("The mouse couldn't eat the cheeses, she needed " + (5 - eatenCheese) + " cheeses more.");
		}

		print2dMatrix(field);
	}

	private static void moveMouse(char[][] field, int rowMutator, int colMutator) {
		int nextRow = row + rowMutator;
		int nextCol = col + colMutator;
		boolean isBonusHit = false;

		if (!isMouseinBpunds(field, nextRow, nextCol)) {
			isMouseInField = false;
			field[row][col] = '-';
			return;
		}

		char currentPositionChar = field[nextRow][nextCol];
		if (currentPositionChar == 'c') {
			eatenCheese++;
		} else if (currentPositionChar == 'B') {
			isBonusHit = true;
		}
		field[row][col] = '-';
		field[nextRow][nextCol] = 'M';
		row = nextRow;
		col = nextCol;
		if (isBonusHit) {
			moveMouse(field, rowMutator, colMutator);
		}
	}

	private static boolean isMouseinBpunds(char[][] field, int r, int c) {

		return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
	}

	private static void print2dMatrix(char[][] field) {
		for (char[] arr : field) {
			for (char c : arr) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

}
