package com.datastructure.Comparators;

public class PacketOfBullets implements Comparable<PacketOfBullets> {

	private String nome;
	private int numeroBalas;

	public PacketOfBullets(String nome, int numeroBalas) {
		this.nome = nome;
		this.numeroBalas = numeroBalas;
	}
	
	public int compareTo(PacketOfBullets packet) {
		if(this.numeroBalas < packet.numeroBalas) return -1;
		if(this.numeroBalas > packet.numeroBalas) return 1;
		return 0;
	}
	
	public String toString() {
		return "Pacote[nome=" + nome + ", numero=" + numeroBalas + "]";
	}

	String getNome() { return nome; }

	int getNumeroBalas() { return numeroBalas; }

}
