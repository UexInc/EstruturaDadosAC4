package com.datastructure.Comparators;

public class PacketOfBullets {

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroBalas() {
		return numeroBalas;
	}

	public void setNumeroBalas(int numeroBalas) {
		this.numeroBalas = numeroBalas;
	}

}
