package com.datastructure.HashTableMap;

import java.util.Scanner;

import com.datastructure.node_position_list.NodePositionList;
import com.datastructure.node_position_list.PositionList;

public class SpellChecker {

	private String words = "O Brasil, um vasto pais sul-americano, estende-se da Bacia Amazonica, no norte, ate os vinhedos "
	+ "e as gigantescas Cataratas do Iguacu, no sul. O Rio de Janeiro, simbolizado pela sua estatua de 38 metros de altura "
	+ "do Cristo Redentor, situada no topo do Corcovado, e famoso pelas movimentadas praias de Copacabana e Ipanema, "
	+ "bem como pelo imenso e animado Carnaval, com desfiles de carros alegoricos, fantasias extravagantes e samba.\r\n"
	+ "O Brasil e um pais localizado no subcontinente da America do Sul. O territorio brasileiro e banhado pelo oceano "
	+ "Atlantico, limitando-se ao norte, com a Guiana Francesa, Suriname, Guiana, Venezuela e Colombia; a noroeste, "
	+ "com o Peru; a oeste, com a Bolivia, Paraguai e Argentina; e ao sul, com o Uruguai. O Brasil é lindo";
	
	private HashTableMap<String, String> W = new HashTableMap<String, String>();
	
	public SpellChecker() {
		this.fillHashMap();
	}
	
	public SpellChecker(String wordsToCompare) {
		this.words = wordsToCompare;
		this.fillHashMap();
	}
	
	protected void fillHashMap() {
		@SuppressWarnings("resource")
		Scanner doc = new Scanner(this.words);
		doc.useDelimiter("[^a-zA-Z]");
		String word;
		while (doc.hasNext()) {
			word = doc.next();
			if(word.equals("")) continue;
			if (word.length() < 3) continue;
			word = word.toLowerCase();
			W.put(word, word);
		}
	}
	
	protected boolean checkSimilar(String word, String comparate) {
		if (word.contains(comparate) 
				|| word.equalsIgnoreCase(comparate)
				|| (word.contains(comparate.subSequence(0, comparate.length() / 2))
				&& word.contains(comparate.subSequence(comparate.length() / 2, comparate.length())))
				|| word.contains(comparate)) {
			return true;
		}
		return false;
	}
	
	public Iterable<String> spellCheck(String s) {
		PositionList<String> positions = new NodePositionList<String>();
		String lower = s.toLowerCase();

		if (W.get(s) != null) {
			positions.addLast(s);
			return positions;
		} else {
			Iterable<String> similarWords = W.keySet();
			for (String word : similarWords) {
				if (checkSimilar(word, lower)) positions.addLast(word);
			}
		}
		return positions;
	}
}
