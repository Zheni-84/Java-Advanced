package oop.interfacesAndAbstraction.telephony;

import java.util.List;

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
		StringBuilder sb = new StringBuilder();
		for (String number : numbers) {
			if (!hasOnlyNumbers(number)) {
				sb.append("Invalid number!").append(System.lineSeparator());
			} else {
				sb.append(String.format("Calling... %s!%n", number));
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
