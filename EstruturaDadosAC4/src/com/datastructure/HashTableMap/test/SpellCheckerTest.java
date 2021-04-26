package com.datastructure.HashTableMap.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.datastructure.HashTableMap.SpellChecker;
import com.datastructure.HeapPriorityQueue.HeapPriorityQueue;
import com.datastructure.interfaces.Entry;

class SpellCheckerTest {

	/*
		23. Desafio:
		a) Escreva uma classe de verificação ortográfica que armazena conjuntos de palavras,
		W, em uma tabela hash e implementa o método spellCheck(s) que executa uma
		verificação ortográfica sobre a string s relativa ao conjunto de palavras, W.
		
		b) Se s está em W, então a chamada para spellCheck(s) retorna uma coleção iterável
		que contém apenas s, assumindo-se que tenha sido grafada corretamente neste
		caso.
		
		c) Por outro lado, se s não está em W, então a chamada para spellCheck retona a
		coleção iterável de todas as palavras de W que podem corresponder à grafia
		correta de s.
		
		d) O programa pode ser capaz de tratar todas as formas normais que s pode omitir
		uma palavra em W, incluindo trocar caracteres adjacentes de uma palavra,
		inserção de um único caractere entre outros dois, remoção de um único caractere
		de uma palavra e substituição de um caractere em uma palavra por outro.
	 */
	
	@Test
	void test() {
		SpellChecker s = new SpellChecker();

		assertNotNull(s.spellCheck("Brasil"));
		assertEquals("{brasil, brasileiro}", ordenar(s.spellCheck("Brasil")));
		assertEquals("{brasil}", ordenar(s.spellCheck("brasil")));
		assertEquals("{amazonica}", ordenar(s.spellCheck("zonica")));
		assertEquals("{america, americano}", ordenar(s.spellCheck("merica")));
		assertEquals("{limitando}", ordenar(s.spellCheck("limit")));
		assertEquals("{estende, noroeste, oeste}", ordenar(s.spellCheck("teste")));
		assertEquals("{fantasias, praias}", ordenar(s.spellCheck("asia")));
	}

	private Object ordenar(Iterable<String> keySet) {
		String saida = "{";

		HeapPriorityQueue<String, String> P = new HeapPriorityQueue<String, String>();
		for (String ent : keySet) {
			P.insert(ent, ent);
		}

		Entry<String, String> e;
		while (!P.isEmpty()) {
			e = P.removeMin();
			saida += e.getKey() + ", ";
		}

		return saida.substring(0, saida.length() - 2) + "}";
	}

}
