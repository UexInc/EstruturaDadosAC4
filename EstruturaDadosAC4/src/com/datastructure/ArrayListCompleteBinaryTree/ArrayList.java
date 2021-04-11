package com.datastructure.ArrayListCompleteBinaryTree;

import java.util.Iterator;

import com.datastructure.interfaces.IndexList;
import com.datastructure.iterators.ListIterator;
import com.datastructure.node_position_list.PositionList;

public class ArrayList<T> implements IndexList<T> {

	private T[] A;

	private int capacity = 16;

	private int size = 0;

	@SuppressWarnings("unchecked")
	public ArrayList() {
		A = (T[]) new Object[capacity];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public T get(int r) throws IndexOutOfBoundsException {
		checkIndex(r, size());
		return A[r];
	}

	public T set(int r, T e) throws IndexOutOfBoundsException {
		checkIndex(r, size());
		T temp = A[r];
		A[r] = e;
		return temp;
	}

	public void add(int r, T e) throws IndexOutOfBoundsException {
		checkIndex(r, size() + 1);
		if (size == capacity) {
			capacity *= 2;
			@SuppressWarnings("unchecked")
			T[] B = (T[]) new Object[capacity];
			for (int i = 0; i < size; i++)
				B[i] = A[i];
			A = B;
		}
		for (int i = size - 1; i >= r; i--)
			A[i + 1] = A[i];
		A[r] = e;
		size++;
	}
	
	public T remove(int r) throws IndexOutOfBoundsException {
		checkIndex(r, size());
		T temp = A[r];
		for (int i = r; i < size - 1; i++)
			A[i] = A[i + 1];
		size--;
		return temp;
	}

	protected void checkIndex(int r, int n) throws IndexOutOfBoundsException {
		if (r < 0 || r >= n)
			throw new IndexOutOfBoundsException("Illegal index: " + r);
	}

	public String toString() {
		String toReturn = "[";
		if (size() == 0)
			return "[]";
		for (int i = 0; i < size(); i++)
			toReturn += A[i].toString() + ", ";
		return toReturn.substring(0, toReturn.length() - 2) + "]";
	}

	@SuppressWarnings("unchecked")
	public Iterator<T> iterator() {
		return new ListIterator<T>((PositionList<T>) this);
	}

}