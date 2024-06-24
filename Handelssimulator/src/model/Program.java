package model;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Marktplatz marktplatz = new Marktplatz(1000);
		Lager lager = new Lager(100, 1000);
		Produkt.loadProduktListe();
		System.out.println("Handelssimulator..");
		
	}
	
	public void Menue() {
		String auswahl;
		System.out.println("Was wollen Sie tun?:");
		System.out.println("Herstellung: H");
		System.out.println("Marktplatz: M");
		System.out.println("Lager: L");
	}
	
	public String benutzereingabe() {
		Scanner scanner = new Scanner(System.in);
		String eingabe = scanner.nextLine();
		scanner.close();
		return eingabe;
	}
	
	public void herstellung() {
		System.out.println("Welches Produkt möchtest du Herstellen?:");
		
	}
	
	public void marktplatz() {
		String auswahl;
		System.out.println("Willkommen auf dem Marktplatz!");
		System.out.println("Möchtest du Kaufen oder Verkaufen:");
		System.out.println("Kaufen: K");
		System.out.println("Verkaufen: V");
		auswahl = benutzereingabe().toUpperCase();
		switch (auswahl) {
		case "M": {
			
			yield type;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + auswahl);
		}
		
	}
	
	public void lager() {
		
	}
}
