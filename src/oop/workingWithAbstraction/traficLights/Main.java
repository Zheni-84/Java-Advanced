package oop.workingWithAbstraction.traficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<String> colors = Arrays.stream(sc.nextLine().split(" "))
				.collect(Collectors.toList());

		List<TrafficLight> trafficLights = new ArrayList<>();

		for (String color : colors) {
			Color currentColor = Color.valueOf(color);

			TrafficLight currentTrafficLight = new TrafficLight(currentColor);

			trafficLights.add(currentTrafficLight);
		}
		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; i++) {
			for (TrafficLight trafficLight : trafficLights) {
				trafficLight.changeColor();
				System.out.print(trafficLight.getColor() + " ");
			}
			System.out.println();
		}


	}

}
