package advanced.SetsAndMapsExercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

//https://pastebin.com/88mYHps0
public class CommonElement2Arrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] firstArr = Arrays.stream(sc.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt)
				.toArray();
		int[] secondArr = Arrays.stream(sc.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt)
				.toArray();

		if (firstArr.length == 0 || secondArr.length == 0) {
			System.out.println("None common elements");
		}
		HashSet<Integer> set = new HashSet<>();
		for (int num : firstArr) {
			set.add(num);
		}
		for (int num : secondArr) {
			if (set.contains(num)) {
				System.out.println(num);
			}
		}
	}

}
