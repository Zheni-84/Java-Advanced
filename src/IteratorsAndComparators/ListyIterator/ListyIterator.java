package IteratorsAndComparators.ListyIterator;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {

	private List<String> elements;
	private int currentIndex;

	public ListyIterator(String... elements) {
		this.elements = List.of(elements);
		this.currentIndex = 0;
	}

	public boolean hasNext() {
		return this.currentIndex < this.elements.size() - 1;
	}

	public boolean move() {
		if (hasNext()) {
			this.currentIndex++;
			return true;
		}
		return false;
	}

	public void print() {
		if (this.elements.isEmpty()) {
			throw new IllegalStateException("Invalid operation");
		}
		System.out.println(this.elements.get(currentIndex));
	}

	@Override public Iterator iterator() {
		return new Iterator() {
			private int index;
			@Override public boolean hasNext() {
				return this.index < elements.size();
			}

			@Override public Object next() {
				String element = elements.get(index);
				index++;
				return element;
			}
		};
	}
}
