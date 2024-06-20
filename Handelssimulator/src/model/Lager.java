package model;

import java.util.ArrayList;

public class Lager {
	private int maxKapazitaet;
	private int gold;
	
	//ArrayList<Produkt> Lagerbestand = new ArrayList<Produkt>();

	public Lager() {}
	
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

	
}
