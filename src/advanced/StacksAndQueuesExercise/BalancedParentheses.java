package advanced.StacksAndQueuesExercise;

import java.util.*;

public class BalancedParentheses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String brackets = sc.nextLine();
		ArrayDeque<Character> openingBrackets = new ArrayDeque<>();
		boolean isBalanced = true;
		for (int i = 0; i < brackets.length(); i++) {
			char currentBracket = brackets.charAt(i);
			if (Arrays.asList('[', '(', '{').contains(currentBracket)) {
				openingBrackets.push(currentBracket);
			} else {
				if (openingBrackets.isEmpty()) {
					isBalanced = false;
					continue;
				}
				char lastOpeningBracket = openingBrackets.pop();
				if (currentBracket == '}' && lastOpeningBracket != '{') {
					isBalanced = false;
				}
				if (currentBracket == ']' && lastOpeningBracket != '[') {
					isBalanced = false;
				}
				if (currentBracket == ')' && lastOpeningBracket != '(') {
					isBalanced = false;
				}
			}
		}
		if (isBalanced && openingBrackets.isEmpty()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
