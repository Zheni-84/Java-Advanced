package advanced.Generics.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

	private final List<T> values;

	public CustomList() {
		this.values = new ArrayList<>();
	}

	public void add(T element) {
		values.add(element);
	}

	public T remove(int index) {
		return values.remove(index);
	}

	public boolean contains(T element) {
		return this.values.contains(element);
	}

	public void swap(int firstIndex, int secondIndex) {
		Collections.swap(this.values, firstIndex, secondIndex);
	}

	public long countGreaterThan(T element) {
		return this.values.stream().filter(e -> e.compareTo(element) > 0).count();
	}

	public T max() {
		return this.values.stream().max(Comparator.naturalOrder()).get();
	}

	public T min() {
		return this.values.stream().min(Comparator.naturalOrder()).get();
	}

	public  int size(){
		return this.values.size();
	}

	public T get(int index){
		return this.values.get(index);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (T value : values) {
			sb.append(String.format("%s%n", value.toString()));
		}
		return sb.toString().trim();
	}
}
