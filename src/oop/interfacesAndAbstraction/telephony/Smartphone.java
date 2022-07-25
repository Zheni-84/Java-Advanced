package oop.interfacesAndAbstraction.telephony;

import java.util.List;
import java.util.stream.Collectors;

public class Smartphone implements Browsable, Callable {

	private final List<String> numbers;
	private final List<String> urls;

	public Smartphone(List<String> numbers, List<String> urls) {
		this.numbers = numbers;
		this.urls = urls;
	}

	@Override
	public String browse() {
		StringBuilder sb = new StringBuilder();
		for (String url : urls) {
			if (hasNumbers(url)) {
				sb.append("Invalid URL!").append(System.lineSeparator());
			} else {
				sb.append(String.format("Browsing: %s!%n", url));
			}
		}
		return sb.toString().trim();
	}

	@Override
	public String call() {
		//		numbers.stream()
		//				.map(number -> number.matches(".*\\D+.*") ? "Invalid number!" : "Calling... " + number)
		//				.collect(Collectors.joining(System.lineSeparator()));

		StringBuilder sb = new StringBuilder();
		for (String number : numbers) {
			if (hasOnlyNumbers(number)) {
				sb.append(String.format("Calling... %s!%n", number));
			} else {
				sb.append("Invalid number!").append(System.lineSeparator());
			}
		}
		return sb.toString().trim();
	}

	private boolean hasNumbers(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (Character.isDigit(text.charAt(i))) {
				return true;
			}
		}

		return false;
	}

	private boolean hasOnlyNumbers(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}

		return true;
	}
}
