package com.datastructure.HeapPriorityQueue.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.datastructure.HeapPriorityQueue.HeapPriorityQueue;

class HeapPriorityQueueTest {

	// 1. c) TAD Fila de Prioridade usando Heap (slides de 75 a 79)
	@Test
	void test() {
		HeapPriorityQueue<Integer, String> P = new HeapPriorityQueue<Integer, String>();
		assertEquals(true, P.isEmpty());
		P.insert(1, "Alan Mathison Turing");
		P.insert(2, "Dennis Ritchie");
		P.insert(12, "Linus Torvalds");
		P.insert(3, "Bjarne Stroustrup");
		P.insert(18, "Tim Berners-Lee");
		P.insert(9, "Ken Thompson");
		P.insert(10, "Brian Kernighan");
		P.insert(7, "Bill Gates");
		P.insert(25, "John Backus");
		P.insert(91, "Grace Hooper");
		assertEquals("[null, [(1,Alan Mathison Turing),1], [(2,Dennis Ritchie),2], [(9,Ken Thompson),3], "
				+ "[(3,Bjarne Stroustrup),4], [(18,Tim Berners-Lee),5], [(12,Linus Torvalds),6], "
				+ "[(10,Brian Kernighan),7], [(7,Bill Gates),8], [(25,John Backus),9], "
				+ "[(91,Grace Hooper),10]]", P.toString());
		P.insert(69, "Mark Zuckerberg");
		assertEquals("[null, [(1,Alan Mathison Turing),1], [(2,Dennis Ritchie),2], [(9,Ken Thompson),3], "
				+ "[(3,Bjarne Stroustrup),4], [(18,Tim Berners-Lee),5], [(12,Linus Torvalds),6], "
				+ "[(10,Brian Kernighan),7], [(7,Bill Gates),8], [(25,John Backus),9], "
				+ "[(91,Grace Hooper),10], [(69,Mark Zuckerberg),11]]", P.toString());
		P.removeMin();
		assertEquals(
				"[null, [(2,Dennis Ritchie),1], [(3,Bjarne Stroustrup),2], [(9,Ken Thompson),3], "
				+ "[(7,Bill Gates),4], [(18,Tim Berners-Lee),5], [(12,Linus Torvalds),6], "
				+ "[(10,Brian Kernighan),7], [(69,Mark Zuckerberg),8], [(25,John Backus),9], "
				+ "[(91,Grace Hooper),10]]",
				P.toString());
	}
	
	// 1. D)
	@Test
	void test_collection() {
		HeapPriorityQueue<Integer, Integer> P = new HeapPriorityQueue<Integer, Integer>();
		assertEquals(true, P.isEmpty());
		P.insert(9, 9);
		P.insert(1, 1);
		P.insert(3, 3);
		P.insert(6, 6);
		P.insert(2, 2);
		P.insert(7, 7);
		P.insert(8, 8);
		assertEquals("[null, [(1,1),1], [(2,2),2], [(3,3),3], "
				+ "[(9,9),4], [(6,6),5], [(7,7),6], [(8,8),7]]", P.toString());
	}

}