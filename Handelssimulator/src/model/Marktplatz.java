package model;

import java.util.ArrayList;

public class Marktplatz {
	private int gold; // das Geld welches das Marktplatz für den Tag zur Verfügung hat?
	private ArrayList<Produkt> verfuegbarkeit; // die Produkte die im Markt momentan verfügbar sind?

	
	
	// getter & setter
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	
}
