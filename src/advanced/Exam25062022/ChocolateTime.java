package advanced.Exam25062022;

import java.util.*;
import java.util.stream.Collectors;

public class ChocolateTime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayDeque<Double> milkQueue = Arrays.stream(sc.nextLine().split(" "))
				.map(Double::parseDouble)
				.collect(Collectors.toCollection(ArrayDeque::new));

		ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
		Arrays.stream(sc.nextLine().split(" "))
				.map(Double::parseDouble)
				.forEach(cacaoStack::push);

		Map<String, Integer> cookedChocolates = new TreeMap<>();

		while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
			double milk = milkQueue.poll();
			double cacao = cacaoStack.pop();
			double percentage = cacao / (milk + cacao) * 100;

			String chocolateType = null;
			if (percentage == 100.0) {
				chocolateType = "Baking Chocolate";
			} else if (percentage == 50.0) {
				chocolateType = "Dark Chocolate";
			} else if (percentage == 30.0) {
				chocolateType = "Milk Chocolate";
			}
			if (chocolateType != null) {
				cookedChocolates.putIfAbsent(chocolateType, 0);
				cookedChocolates.put(chocolateType, cookedChocolates.get(chocolateType) + 1);
			} else {
				milkQueue.offer(milk + 10);
			}
		}

		if (cookedChocolates.size() >= 3) {
			System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
		} else {
			System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
		}

		cookedChocolates.forEach((key, value) -> System.out.printf(" # %s --> %d%n", key, value));
	}

}
