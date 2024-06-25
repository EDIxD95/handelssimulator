package Project;

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
	
	public ArrayList<Produkt> getInhalt(){
		return inhalt;
	}
	
	public Produkt getProdukt(int i) {
		return inhalt.get(i);
	}
	
	public Produkt getProdukt(String name) {
		for (Produkt p : inhalt) {
			if (p.getName().equalsIgnoreCase(p.getName())) {	// Überprüfung ob String name als Produkt existiert
				return p;
			}
		}
		return null;
	}
	
	// Befehle
	public void addProdukt(Produkt produkt) {
		for (Produkt p : inhalt) {
			if (p.getName().equalsIgnoreCase(produkt.getName())) {	// Überprüfung ob String name als Produkt existiert
				p.setStueckzahl(p.getStueckzahl()+p.getStueckzahl());					// Und nimmt es aus der Liste wenn ja
				return;
			}
		}
		inhalt.add(produkt);
	}
	public Produkt takeProdukt(String name) {
		for (Produkt produkt : inhalt) {
			if (produkt.getName().equalsIgnoreCase(name)) { // Überprüfung ob String name als Produkt existiert
				if (produkt.getStueckzahl() > 1) {
					produkt.takeStueckzahl(1);
				} else {
					inhalt.remove(produkt);
				}						// Und nimmt es aus der Liste wenn ja
				return produkt;
			}
		}
		return null;
	}
	
	public void listInhalt() {
		System.out.println("Auswahl\tProduktname\tWert\tStückzahl");
		for (int i = 0; i < inhalt.size(); i++) {
			Produkt p = inhalt.get(i);
			System.out.println((i+1)+".\t"+p.getName()+"\t"+p.getWert()+"\t"+p.getStueckzahl());
		}
	}
}
