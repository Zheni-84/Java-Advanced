package Generics.GenericBox;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		//Box<Integer> box = new Box<>();
		//Box<String> box = new Box<>();
		Box<Double> box = new Box<>();

		for (int i = 0; i < n; i++) {
			//Integer element = Integer.parseInt(sc.nextLine());
			Double element = Double.parseDouble(sc.nextLine());
			//String element = sc.nextLine();
			box.add(element);
		}

//		String[] indices = sc.nextLine().split(" ");
//		int firstIndex = Integer.parseInt(indices[0]);
//		int secondIndex = Integer.parseInt(indices[1]);
//		box.swap(firstIndex, secondIndex);
//		System.out.println(box);
		Double elementToCompare = Double.parseDouble(sc.nextLine());
		System.out.println(box.countGreaterItems(elementToCompare));
	}
}
