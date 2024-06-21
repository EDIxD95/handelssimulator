package model;

import java.util.ArrayList;

public class Lager {
	private int maxKapazitaet;
	private int gold;
	private ArrayList<Produkt> inhalt;

	public Lager(int maxKapazitaet, int gold) {
		this.maxKapazitaet = maxKapazitaet;
		this.gold = gold;
		inhalt = new ArrayList<>();
	}
	
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
	
	public void addProdukt(Produkt produkt) {
		inhalt.add(produkt);
	}
	public void removeProdukt(Produkt produkt) {
		inhalt.remove(produkt);
	}
	
}
