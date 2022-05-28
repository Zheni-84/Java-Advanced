package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		TreeMap<String, LinkedHashMap<String, Integer>> userMap = new TreeMap<>();
		while (!input.equals("end")) {
			String[] inputParts = input.split(" ");
			String ipParts = inputParts[0];
			String userNameParts = inputParts[2];
			String userName = userNameParts.substring(5);
			String ipAddress = ipParts.substring(3);

			LinkedHashMap<String, Integer> userAttacks = userMap.computeIfAbsent(userName, k -> new LinkedHashMap<>());
			userAttacks.putIfAbsent(ipAddress, 0);

			userAttacks.put(ipAddress, userAttacks.get(ipAddress) + 1);

			input = sc.nextLine();
		}

		userMap.forEach((key1, value1) -> {
			System.out.printf("%s:%n", key1);
			StringBuilder sb = new StringBuilder();
			value1.forEach((key, value) -> {
				sb.append(String.format("%s => %d, ", key, value));
			});
			String finalOutput = sb.substring(0, sb.length()-2);
			finalOutput = finalOutput + ".";
			System.out.println(finalOutput);
		});
	}
}
