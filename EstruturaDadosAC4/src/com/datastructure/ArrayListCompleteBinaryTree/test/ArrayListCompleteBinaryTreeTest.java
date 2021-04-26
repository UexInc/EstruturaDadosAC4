package com.datastructure.ArrayListCompleteBinaryTree.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.datastructure.ArrayListCompleteBinaryTree.ArrayListCompleteBinaryTree;
import com.datastructure.node_position_list.Position;

class ArrayListCompleteBinaryTreeTest {
	
	// 1. b) TAD Árvore Binária Completa (Slides de 40 a 47)
	@Test
	void test() {
		ArrayListCompleteBinaryTree<Integer> T = new ArrayListCompleteBinaryTree<Integer>();
		assertEquals(true, T.isEmpty());
		T.add(42);
		T.add(13);
		T.add(7);
		T.add(99);
		T.add(31);
		T.add(4);
		T.add(3);
		T.add(2);
		T.add(1);
		T.add(123);
		T.add(456);
		T.add(789);
		Position<Integer> saida = T.add(10);
		assertEquals(true, T.isExternal(saida));
		assertEquals(
				"[null, [42,1], [13,2], [7,3], [99,4], [31,5], [4,6], [3,7], [2,8], [1,9], [123,10], [456,11], [789,12], [10,13]]",
				T.toString());
	}
}






