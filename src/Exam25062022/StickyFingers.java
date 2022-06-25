package Exam25062022;

import java.util.Scanner;

public class StickyFingers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = Integer.parseInt(sc.nextLine());
		String[] commands = sc.nextLine().split(",");
		char[][] field = new char[size][size];

		int dillingerRow = 0;
		int dillingerCol = 0;

		for (int row = 0; row < field.length; row++) {
			String line = sc.nextLine().replace(" ", "");
			field[row] = line.toCharArray();

			if (line.contains("D")) {
				dillingerRow = row;
				dillingerCol = line.indexOf("D");
			}
		}

		int dillingerPocket = 0;
		boolean gotCaughtByPolice = false;

		field[dillingerRow][dillingerCol] = '+';

		for (int i = 0; i < commands.length; i++) {
			String commandName = commands[i];
			switch (commandName) {
				case "up":
					if (dillingerRow != 0) {
						dillingerRow--;
					} else {
						System.out.println("You cannot leave the town, there is police outside!");
					}
					break;
				case "down":
					if (dillingerRow != size - 1) {
						dillingerRow++;
					} else {
						System.out.println("You cannot leave the town, there is police outside!");
					}
					break;
				case "right":
					if (dillingerCol != size - 1) {
						dillingerCol++;
					} else {
						System.out.println("You cannot leave the town, there is police outside!");
					}
					break;
				case "left":
					if (dillingerCol != 0) {
						dillingerCol--;
					} else {
						System.out.println("You cannot leave the town, there is police outside!");
					}
					break;
			}
			if (field[dillingerRow][dillingerCol] == '$'){
				field[dillingerRow][dillingerCol] = '+';
				int moneyRobbed = dillingerRow * dillingerCol;
				dillingerPocket += moneyRobbed;
				System.out.printf("You successfully stole %d$.%n", moneyRobbed);
			}
			if (field[dillingerRow][dillingerCol] == 'P'){
				System.out.printf("You got caught with %d$, and you are going to jail.%n", dillingerPocket);
				field[dillingerRow][dillingerCol] = '#';
				gotCaughtByPolice = true;
				break;
			}
		}
		if (!gotCaughtByPolice){
			field[dillingerRow][dillingerCol] = 'D';
			System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", dillingerPocket);
		}

		print2dMatrix(field);
	}

	private static void print2dMatrix(char[][] field) {
		for (char[] arr : field) {
			for (char c : arr) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
}
