package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = Arrays.stream(sc.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int countToPush = input[0];
		int countToPop = input[1];
		int elmentToSerch = input[2];

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int[] numbers = Arrays.stream(sc.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		for (int i = 0; i < countToPush; i++) {
			queue.offer(numbers[i]);
		}
		for (int i = 0; i < countToPop; i++) {
			queue.poll();
		}
		if (queue.isEmpty()) {
			System.out.println("0");
		} else {
			if (queue.contains(elmentToSerch)) {
				System.out.println("true");
			} else {
				System.out.println(Collections.min(queue));
			}
		}
	}
}
