package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Produkt {
	String Name;
	int Wert;
	String[] Material;

	int stueckzahl;
	
	private static ArrayList<Produkt> ProduktListe = new ArrayList<Produkt>();
	
	public Produkt(String Name, int Wert, String[] Material){
		this.Name = Name;
		this.Wert = Wert;
		this.Material = Material;
		this.stueckzahl = 1;
	}
	
	public Produkt(String Name, int Wert){
		this.Name = Name;
		this.Wert = Wert;
		this.Material = null;
		this.stueckzahl = 1;
	}
	
	public String getName(){
		return Name;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public int getWert() {
		return Wert;
	}
	
	public void setWert(int Wert) {
		this.Wert = Wert;
	}

	public String[] getMaterial() {
		return Material;
	}

	public void setMaterial(String[] Material) {
		this.Material = Material;
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
		return ProduktListe;
	}
	
	public void loadProduktListe() {
		String fileName = "Produkt.csv";
        Produkt p = null;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(";");
                String Name = data[0];
                int Wert = Integer.parseInt(data[1]);
                String[] Material = new String[data.length-2];
                if (Material.length != 0) {
                	for (int i = 2; i < Material.length; i++) {
    					Material[i-2] = data[i];
    				}
                    p = new Produkt(Name, Wert, Material);
                    ProduktListe.add(p);
				} else {
					p = new Produkt(Name, Wert);
                    ProduktListe.add(p);
				}
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
