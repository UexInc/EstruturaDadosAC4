package com.datastructure.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.datastructure.node_position_list.Position;
import com.datastructure.node_position_list.PositionList;

public class ListIterator<E> implements Iterator<E> {

	protected PositionList<E> list;
	protected Position<E> cursor;

	public ListIterator(PositionList<E> L) {
		list = L;
		cursor = (list.isEmpty()) ? null : list.first();
	}

	public boolean hasNext() {
		return (cursor != null);
	}

	public E next() throws NoSuchElementException {
		if (cursor == null)
			throw new NoSuchElementException("No next element");
		E toReturn = cursor.element();
		cursor = (cursor == list.last()) ? null : list.next(cursor);
		return toReturn;
	}
	
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("remove");
	}

}