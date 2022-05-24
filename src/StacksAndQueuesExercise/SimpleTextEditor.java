package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		StringBuilder text = new StringBuilder();
		ArrayDeque<String> commands = new ArrayDeque<>();
		ArrayDeque<String> removedElements = new ArrayDeque<>();

		//String test = sc.nextLine();
		for (int i = 0; i < n; i++) {
			String rawCommand = sc.nextLine();
			String[] commandArguments = rawCommand.split(" ");
			String command = commandArguments[0];
			switch (command) {
				case "1":
					commands.push(rawCommand);
					executeAdd(commandArguments[1], text);
					//System.out.println("after 1: " + text);
					break;
				case "2":
					commands.push(rawCommand);
					int countToDelete = Integer.parseInt(commandArguments[1]);
					StringBuilder elementToBeDeleted = new StringBuilder();
					for (int j = text.length() - countToDelete; j < text.length(); j++) {
						elementToBeDeleted.append(text.charAt(j));
					}
					removedElements.push(elementToBeDeleted.toString());
					executeDelete(countToDelete, text);
					//System.out.println("after 2: " + text);
					break;
				case "3":
					int index = Integer.parseInt(commandArguments[1]);
					System.out.println(text.charAt(index - 1));
					break;
				case "4":
					String lastCommand = commands.pop();
					String[] lastCommandArguments = lastCommand.split(" ");
					String lastCommandType = lastCommandArguments[0];
					switch (lastCommandType) {
						case "1":
							int elementsToDelete = lastCommandArguments[1].length();
							executeDelete(elementsToDelete, text);
							break;
						case "2":
							String elementsToAddBack = removedElements.pop();
							executeAdd(elementsToAddBack, text);
							break;
					}
					//System.out.println("after 4: " + text);
					break;
			}
		}
	}

	private static void executeDelete(int countToDelete, StringBuilder text) {
		for (int i = 0; i < countToDelete; i++) {
			text.deleteCharAt(text.length() - 1);
		}
	}

	private static void executeAdd(String commandArgument, StringBuilder text) {
		text.append(commandArgument);
	}

}
