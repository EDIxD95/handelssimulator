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
		System.out.println("Lager: L");
		System.out.println("Marktplatz: M");
		System.out.println("Beenden: B");
		auswahl = benutzereingabe().toUpperCase();
		switch (auswahl) {
		case "H":
			
			break;
		case "L":
			
			break;
		case "M":
			
			break;
		default:
			System.out.println("Falsche Auswahl!");
			Menue();
			break;
		}
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
	
	public void marktplatz(Marktplatz m, Lager l) {
		String auswahl;
		System.out.println("Willkommen auf dem Marktplatz!");
		System.out.println("Möchtest du Kaufen oder Verkaufen:");
		System.out.println("Kaufen: K");
		System.out.println("Verkaufen: V");
		auswahl = benutzereingabe().toUpperCase();
		Produkt p;
		switch (auswahl) {
		case "K":
			System.out.println("Welches Material möchtest du kaufen?:");
			m.listMaterialien();
			auswahl = benutzereingabe();
			p = m.getMaterialien().get(Integer.parseInt(auswahl)-1);
			boolean gekauft;
			gekauft = m.kaufen(p.getName(), l);
			if (gekauft) {
				System.out.println(p.getName()+" wurde gekauft.");
			} else {
				System.out.println(p.getName()+" konnte nicht gekauft werden.");
			}
			break;
		case "V":
			System.out.println("Was möchtest du verkaufen:");
			l.listInhalt();
			auswahl = benutzereingabe();
			p = m.getMaterialien().get(Integer.parseInt(auswahl)-1);
			boolean verkauft;
			verkauft = m.verkaufen(p.getName(), l);
			if (verkauft) {
				System.out.println(p.getName()+" wurde verkauft.");
			} else {
				System.out.println(p.getName()+" konnte nicht verkauft werden.");
			}
			break;
		default:
			System.out.println("Falsche Auswahl!");
			marktplatz(m, l);
		}
		
	}
	
	public void lager() {
		
	}
}
