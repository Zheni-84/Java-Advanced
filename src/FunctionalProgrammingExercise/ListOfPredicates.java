package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		List<Integer> numbersToDivide = Arrays.stream(sc.nextLine().split("\\s+"))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		Predicate<Integer> isDivisble = num ->{
			for (Integer numDiv : numbersToDivide) {
				if (num % numDiv != 0){
					return  false;
				}
			}
			return true;
		};
		for (int i = 1; i <=n; i++) {
			if (isDivisble.test(i)){
				System.out.print(i + " ");
			}
		}
	}

}
