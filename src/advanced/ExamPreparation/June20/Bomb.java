package advanced.ExamPreparation.June20;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = Integer.parseInt(sc.nextLine());
		String[] commands = sc.nextLine().split(",");
		char[][] field = new char[size][size];

		int sapperRow = 0;
		int sapperCol = 0;
		int bombCounter = 0;

		for (int row = 0; row < size; row++) {
			String line = sc.nextLine();
			List<Character> charsList = Arrays.stream(line.split(" "))
					.map(s -> s.charAt(0))
					.collect(Collectors.toList());

			//char[] arrOfChars = sc.nextLine().replace(" ", "").toCharArray();

			for (int col = 0; col < field[row].length; col++) {
				char currChar = charsList.get(col);
				if (currChar == 's') {
					sapperRow = row;
					sapperCol = col;
				} else if (currChar == 'B') {
					bombCounter++;
				}
				field[row][col] = currChar;
			}
		}
		int bombsFound = 0;
		for (int i = 0; i < commands.length; i++) {
			String commandName = commands[i];
			switch (commandName) {
				case "up":
					if (sapperRow != 0) {
						sapperRow--;
					}
					break;
				case "down":
					if (sapperRow != size - 1) {
						sapperRow++;
					}
					break;
				case "right":
					if (sapperCol != size - 1) {
						sapperCol++;
					}
					break;
				case "left":
					if (sapperCol != 0) {
						sapperCol--;
					}
					break;
			}

			if (field[sapperRow][sapperCol] == 'B') {
				System.out.println("You found a bomb!");
				field[sapperRow][sapperCol] = '+';
				bombsFound++;
				if (bombCounter == bombsFound) {
					System.out.println("Congratulations! You found all bombs!");
					return;
				}
			} else if (field[sapperRow][sapperCol] == 'e') {
				System.out.printf("END! %d bombs left on the field%n", bombCounter - bombsFound);
				return;
			}
		}

		System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", bombCounter - bombsFound, sapperRow, sapperCol);

		//print2dMatrix(field);
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
