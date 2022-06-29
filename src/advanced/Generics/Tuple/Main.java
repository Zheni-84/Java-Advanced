package advanced.Generics.Tuple;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		String first = input[0];
		String second = input[1];
		String address = input[2];
		Tuple<String, String> tuple = new Tuple<>(first + " " + second, address);
		System.out.println(tuple);

		input = sc.nextLine().split(" ");
		 first = input[0];
		int beerLitters = Integer.parseInt(input[1]);
		Tuple<String, Integer> tuple2 = new Tuple<>(first, beerLitters);
		System.out.println(tuple2);

		input = sc.nextLine().split(" ");
		int integrNum = Integer.parseInt(input[0]);
		double doubleNum = Double.parseDouble(input[1]);
		Tuple<Integer, Double> tuple3 = new Tuple<>(integrNum, doubleNum);
		System.out.println(tuple3);
	}
}
