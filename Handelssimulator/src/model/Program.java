package model;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Marktplatz marktplatz = new Marktplatz(1000);
		Lager lager = new Lager(100, 1000);
		Produkt.loadProduktListe();
		System.out.println(Handelssimulator..);
		
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
}
