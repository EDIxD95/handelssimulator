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
	
	public Produkt(String name, int wert, String[] material){
		this.name = name;
		this.wert = wert;
		this.material = material;
		this.stueckzahl = 1;
	}
	
	public Produkt(String name, int wert){
		this.name = name;
		this.wert = wert;
		this.material = null;
		this.stueckzahl = 1;
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
	
	public void loadProduktListe() {
		String fileName = "Produkt.csv";
        Produkt p = null;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(";");
                String name = data[0];
                int wert = Integer.parseInt(data[1]);
                String[] material = new String[data.length-2];
                if (material.length != 0) {
                	for (int i = 2; i < material.length; i++) {
    					material[i-2] = data[i];
    				}
                    p = new Produkt(name, wert, material);
                    produktListe.add(p);
				} else {
					p = new Produkt(name, wert);
                    produktListe.add(p);
				}
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
