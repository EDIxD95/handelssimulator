package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Marktplatz {
	private int gold; // das Geld welches das Marktplatz für den Tag zur Verfügung hat?
	private ArrayList<Produkt> materialien; // die Produkte die im Markt momentan verfügbar sind?

	// Constructor
	public Marktplatz(int gold) {
		this.gold = gold;
		materialien = loadMaterialien();
	}
	
	// Verkauf und Kauf von Produkte an/vom Marktplatz
	public void verkaufen(String name, Lager lager) { // Lager wurde dem Konstruktor hinzugefuegt, ist das nötig?
		Produkt produkt = lager.takeProdukt(name);
		lager.addGold(produkt.getWert());
	}
	
	public Produkt kaufen(String name) {
		for (Produkt produkt : materialien) {				//
			if (produkt.getName().equalsIgnoreCase(name)) {	// Überprüfung ob String name als Produkt existiert
				return produkt;								// Und gibt es zurück wenn ja, ansonsten Null
			}
		}
		return null;
	}
	
	// getter & setter
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public void addGold(int gold) {
		this.gold += gold;
	}
	
	public ArrayList<Produkt> getMaterialien(){
		return materialien;
	}
	
	public ArrayList<Produkt> loadMaterialien() {
		String fileName = "Materialien.csv";
		ArrayList<Produkt> m = new ArrayList<Produkt>();
        Produkt p = null;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(";");
                String name = data[0];
                int wert = Integer.parseInt(data[1]);
                p = new Produkt(name, wert);
                m.add(p);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return m;
    }
}
