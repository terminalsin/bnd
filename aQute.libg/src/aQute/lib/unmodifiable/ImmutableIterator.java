package aQute.lib.unmodifiable;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ImmutableIterator<E> implements Iterator<E> {
	final E[]	elements;
	int index;

	ImmutableIterator(E[] elements) {
		this.elements = elements;
		this.index = 0;
	}

	ImmutableIterator(E[] elements, int index) {
		this.elements = elements;
		this.index = index;
		if ((index < 0) || (index > elements.length)) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public boolean hasNext() {
		return index < elements.length;
	}

	@Override
	public E next() {
		if (hasNext()) {
			return elements[index++];
		}
		throw new NoSuchElementException();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
