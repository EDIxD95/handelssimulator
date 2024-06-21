package model;

import java.util.ArrayList;

public class Lager {
	private int maxKapazitaet;
	private int gold;
	private ArrayList<Produkt> inhalt;

	// Constructor
	public Lager(int maxKapazitaet, int gold) {
		this.maxKapazitaet = maxKapazitaet;
		this.gold = gold;
		inhalt = new ArrayList<>();
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
	
	// Befehle
	public void addProdukt(Produkt produkt) {
		inhalt.add(produkt);
	}
	public void takeProdukt(String name) {
		for (Produkt produkt : inhalt) {
			if (produkt.getName().equalsIgnoreCase(name)) { // Überprüfung ob String name als Produkt existiert
				inhalt.remove(produkt);						// Und nimmt es aus der Liste wenn ja
			}
		}
	}
}
