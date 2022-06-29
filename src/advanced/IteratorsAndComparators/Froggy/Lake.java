package advanced.IteratorsAndComparators.Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {

	private List<Integer> numbers;

	public Lake(List<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Frog();
	}

	class Frog implements Iterator<Integer> {

		private int index = 0;
		boolean firstIterFinished = false;

		@Override
		public boolean hasNext() {
			return this.index < numbers.size();
		}

		@Override
		public Integer next() {
			int numReturn = numbers.get(index);
			index += 2;
			if (index >=numbers.size() && !firstIterFinished){
				index = 1;
				firstIterFinished = true;
			}
			return numReturn;
		}
	}
}
