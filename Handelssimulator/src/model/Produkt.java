package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Produkt {
	private String name;
	private int wert;
	private String[] material;
	private int stueckzahl;
	
	public static ArrayList<Produkt> produktListe = new ArrayList<Produkt>();
	
	public Produkt(String name, int wert, int stueckzahl, String[] material){
		this.name = name;
		this.wert = wert;
		this.stueckzahl = stueckzahl;
		this.material = material;
	}
	
	public Produkt(String name, int wert, int stueckzahl){
		this.name = name;
		this.wert = wert;
		this.stueckzahl = stueckzahl;
		this.material = null;
	}
	
	public Produkt(String name, int wert){
		this.name = name;
		this.wert = wert;
		this.stueckzahl = 1;
		this.material = null;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWert() {
		return wert;
	}
	
	public void setWert(int wert) {
		this.wert = wert;
	}

	public String[] getMaterial() {
		return material;
	}

	public void setMaterial(String[] material) {
		this.material = material;
	}
	
	public int getStueckzahl() {
		return stueckzahl;
	}

	public void setStueckzahl(int stueckzahl) {
		this.stueckzahl = stueckzahl;
	}
	
	public void addStueckzahl(int stueckzahl) {
		this.stueckzahl += stueckzahl;
	}

	public ArrayList<Produkt> getProduktListe() {
		return produktListe;
	}
	
	public Produkt getProdukt() {
		
	}
	
	public void loadProduktListe() {
		String fileName = "Produkt.csv";
        Produkt p = null;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(";");
                String name = data[0];
                int stueckzahl = Integer.parseInt(data[1]);
                int wert = Integer.parseInt(data[2]);
                String[] material = new String[data.length-3];
                if (material.length != 0) {
                	for (int i = 3; i < material.length; i++) {
    					material[i-3] = data[i];
    				}
                    p = new Produkt(name, wert, stueckzahl, material);
                    produktListe.add(p);
				} else {
					p = new Produkt(name, wert, stueckzahl);
                    produktListe.add(p);
				}
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void herstellen(String name, Lager lager) {
		Produkt p = getProdukt(name);
		lager.addProdukt(p);
	}
}
