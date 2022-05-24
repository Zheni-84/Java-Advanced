package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithStack {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//String[] numbers =
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		Arrays.stream(sc.nextLine().split(" "))
				.forEach(number-> stack.push(Integer.parseInt(number)));
		while (!stack.isEmpty()){
			System.out.printf("%s ", stack.pop());
		}
	}

}
