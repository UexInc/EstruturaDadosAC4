package com.datastructure.SortedListPriorityQueue.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.datastructure.SortedListPriorityQueue.SortedListPriorityQueue;
import com.datastructure.exceptions.EmptyPriorityQueueException;
import com.datastructure.interfaces.Entry;

class SortedListPriorityQueueTest {

	@Test
	void teste_basico() {
		SortedListPriorityQueue<Integer, String> P = new SortedListPriorityQueue<Integer, String>();
		Entry<Integer, String> saida;
		saida = P.insert(5, "A");
		assertEquals("(5,A)", saida.toString());
		assertEquals("[(5,A)]", P.toString());
		saida = P.insert(9, "C");
		assertEquals("(9,C)", saida.toString());
		assertEquals("[(5,A), (9,C)]", P.toString());
		saida = P.insert(3, "B");
		assertEquals("(3,B)", saida.toString());
		assertEquals("[(3,B), (5,A), (9,C)]", P.toString());
		saida = P.insert(7, "D");
		assertEquals("(7,D)", saida.toString());
		assertEquals("[(3,B), (5,A), (7,D), (9,C)]", P.toString());
		saida = P.min();
		assertEquals("(3,B)", saida.toString());
		assertEquals("[(3,B), (5,A), (7,D), (9,C)]", P.toString());
		saida = P.removeMin();
		assertEquals("(3,B)", saida.toString());
		assertEquals("[(5,A), (7,D), (9,C)]", P.toString());
		assertEquals(3, P.size());
		saida = P.removeMin();
		assertEquals("(5,A)", saida.toString());
		assertEquals("[(7,D), (9,C)]", P.toString());
		saida = P.removeMin();
		assertEquals("(7,D)", saida.toString());
		assertEquals("[(9,C)]", P.toString());
		saida = P.removeMin();
		assertEquals("(9,C)", saida.toString());
		assertEquals("[]", P.toString());
		assertThrows(EmptyPriorityQueueException.class, () -> {
			P.removeMin();
		});
	}

}
