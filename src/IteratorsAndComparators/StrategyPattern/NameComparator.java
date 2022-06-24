package IteratorsAndComparators.StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

	@Override
	public int compare(Person f, Person s) {
		if (f.getName().length() == s.getName().length()){
			char fChar = f.getName().toLowerCase().charAt(0);
			char sChar = s.getName().toLowerCase().charAt(0);
			return Character.compare(fChar, sChar);
		}
		return Integer.compare(f.getName().length(), s.getName().length());
	}
}
