package leetcode;

import java.util.Iterator;

class FIterator<E> implements Iterator<E> {
	Iterator currentIterator = null;
	Iterator<Iterator> nested = null;

	public FIterator(Iterator<Iterator> nested) {
		this.nested = nested;
	}

	public boolean hasNext() {
		while (((null != currentIterator) && (!currentIterator.hasNext()))
				|| ((null != currentIterator) && (nested.hasNext()))) {
			currentIterator = nested.next();
		}
		return (currentIterator != null);
	}

	public E next() {
		if (!hasNext())
			return null;
		return (E) currentIterator.next();
	}
}

public class FlattenIterator {

	public static <E> Iterator flattenIterator(Iterator<Iterator> nested) {
		return new FIterator<E>(nested);
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
