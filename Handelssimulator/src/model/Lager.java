package model;

import java.util.ArrayList;

public class Lager {
	private int maxKapazitaet;
	private int gold;
	private ArrayList<Produkt> inhalt = new ArrayList<Produkt>();

	// Constructor
	public Lager(int maxKapazitaet, int gold) {
		this.maxKapazitaet = maxKapazitaet;
		this.gold = gold;
	}
	
	// getter & setter
	public int getMaxKapazitaet() {
		return maxKapazitaet;
	}
	public void setMaxKapazitaet(int maxKapazitaet) {
		this.maxKapazitaet = maxKapazitaet;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public void addGold(int gold) {
		this.gold += gold;
	}
	
	public int takeGold(int gold) {
		this.gold -= gold;
		return gold;
	}
	
	public int getAktuelleKapazitaet() {
		int kapazitaet = 0;
		for (Produkt p : inhalt) {
			kapazitaet += p.getStueckzahl();
		}
		return kapazitaet;
	}
	
	// Befehle
	public void addProdukt(Produkt produkt) {
		for (Produkt p : inhalt) {
			if (p.getName().equalsIgnoreCase(produkt.getName())) {	// Überprüfung ob String name als Produkt existiert
				p.setStueckzahl(p.getStueckzahl()+1);					// Und nimmt es aus der Liste wenn ja
				return;
			}
		}
		inhalt.add(produkt);
	}
	public Produkt takeProdukt(String name) {
		for (Produkt produkt : inhalt) {
			if (produkt.getName().equalsIgnoreCase(name)) { // Überprüfung ob String name als Produkt existiert
				inhalt.remove(produkt);						// Und nimmt es aus der Liste wenn ja
				return produkt;
			}
		}
		return null;
	}
}
