package fr.demos.model;

public class Compteur {
	private int valeur = 0;

	public Compteur() {

	}

	public int getValeur() {
		return this.valeur;
	}

	// synchronized ==>
	public synchronized void incremente() {
		this.valeur++;
	}

	public synchronized void decremente() {
		this.valeur--;
	}
}
