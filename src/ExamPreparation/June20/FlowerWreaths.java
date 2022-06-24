package ExamPreparation.June20;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
		Arrays.stream(sc.nextLine().split(", "))
				.map(Integer::parseInt)
				.forEach(liliesStack::push);

		ArrayDeque<Integer> rosesQueue = Arrays.stream(sc.nextLine().split(", "))
				.map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayDeque::new));

		int wreaths = 0;
		int otherFlowers = 0;

		while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
			int lily = liliesStack.pop();
			int rose = rosesQueue.poll();

			int sum = lily + rose;

			while (sum > 15) {
				lily -= 2;
				sum = lily + rose;
			}
			if (sum == 15) {
				wreaths++;
			} else {
				otherFlowers += sum;
			}
		}
		int leftoverWreaths = otherFlowers / 15;
		wreaths += leftoverWreaths;
		if (wreaths >= 5) {
			System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
		} else {
			System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
		}
	}
}
