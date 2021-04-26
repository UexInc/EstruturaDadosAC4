package com.datastructure.SortedListPriorityQueue.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.datastructure.Comparators.PacketOfBullets;
import com.datastructure.SortedListPriorityQueue.SortedListPriorityQueue;
import com.datastructure.exceptions.EmptyPriorityQueueException;
import com.datastructure.interfaces.Entry;

class SortedListPriorityQueueTest {

	// 1. a) TAD Fila de Prioridade baseado em lista (slides de 21 a 31)
	@Test
	void grupo_teste() {
		SortedListPriorityQueue<Integer, String> P = new SortedListPriorityQueue<Integer, String>();
		Entry<Integer, String> saida;
		
		saida = P.insert(6, "Willian");
		assertEquals("(6,Willian)", saida.toString());
		
		saida = P.insert(4, "Raphael");
		assertEquals("[(4,Raphael), (6,Willian)]", P.toString());
		
		saida = P.insert(7, "Geisa");
		assertEquals("(7,Geisa)", saida.toString());
		
		assertEquals("(4,Raphael)", P.min().toString());
		
		saida = P.insert(9, "Gabriel");
		assertEquals("[(4,Raphael), (6,Willian), (7,Geisa), (9,Gabriel)]", P.toString());
		
		saida = P.insert(10, "Ricardo");
		saida = P.removeMin();
		assertEquals("(4,Raphael)", saida.toString());
		
		assertEquals(false, P.isEmpty());
		saida = P.removeMin();
		assertEquals("(6,Willian)", saida.toString());
		
		assertEquals("(7,Geisa)", P.min().toString());
		saida = P.insert(8, "Willian");
		saida = P.insert(6, "Raphael");
		
		assertEquals("[(6,Raphael), (7,Geisa), (8,Willian), (9,Gabriel), (10,Ricardo)]", P.toString());
		assertEquals("(6,Raphael)", P.removeMin().toString());
		assertEquals("(7,Geisa)", P.removeMin().toString());
		assertEquals("(8,Willian)", P.removeMin().toString());
		assertEquals("(9,Gabriel)", P.removeMin().toString());
		
		assertEquals("(10,Ricardo)", P.min().toString());
		assertEquals("(10,Ricardo)", P.removeMin().toString());
		assertEquals(true, P.isEmpty());
		assertThrows(EmptyPriorityQueueException.class, () -> { P.removeMin(); });
	}
	
	@Test
	void compara_pacotes() {
		SortedListPriorityQueue<PacketOfBullets, PacketOfBullets> P = new SortedListPriorityQueue<PacketOfBullets, PacketOfBullets>();
		Entry<PacketOfBullets, PacketOfBullets> saida;
		PacketOfBullets p1;
		
		p1 = new PacketOfBullets("Fini Morango", 15);
		saida = P.insert(p1, null);
		assertEquals("(Pacote[nome=Fini Morango, numero=15],null)", saida.toString());
		assertEquals("[(Pacote[nome=Fini Morango, numero=15],null)]", P.toString());

		p1 = new PacketOfBullets("Bubbaloo", 17);
		saida = P.insert(p1, null);
		assertEquals("(Pacote[nome=Bubbaloo, numero=17],null)", saida.toString());
		assertEquals("[(Pacote[nome=Fini Morango, numero=15],null), (Pacote[nome=Bubbaloo, numero=17],null)]", P.toString());
	}

}
