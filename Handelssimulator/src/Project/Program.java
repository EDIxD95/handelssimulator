package Project;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Marktplatz marktplatz = new Marktplatz(1000);
		Lager lager = new Lager(100, 1000);
		Produkt.loadProduktListe();
		System.out.println("Handelssimulator..");
		Menue(marktplatz, lager);
	}
	
	public static void Menue(Marktplatz m, Lager l) {
		String auswahl;
		System.out.println("Menü!");
		System.out.println("Was wollen Sie tun?:");
		System.out.println("Herstellung: H");
		System.out.println("Lager: L");
		System.out.println("Marktplatz: M");
		System.out.println("Beenden: B");
		auswahl = benutzereingabe().toUpperCase();
		switch (auswahl) {
		case "H":
			herstellung(m, l);
			break;
		case "L":
			lager(m, l);
			break;
		case "M":
			marktplatz(m, l);
			break;
		case "B":
			
			break;
		default:
			System.out.println("Falsche Auswahl!");
			Menue(m, l);
			break;
		}
	}
	
	public static String benutzereingabe() {
		Scanner scanner = new Scanner(System.in);
		String eingabe = scanner.nextLine();
		scanner.close();
		return eingabe;
	}
	
	public static void herstellung(Marktplatz m, Lager l) {
		String auswahl;
		System.out.println("Willkommen im Herstellungsmenü!");
		System.out.println("Welches Produkt möchtest du Herstellen?:");
		Produkt.listProduktListe();
		auswahl = benutzereingabe();
		Produkt p = Produkt.produktListe.get(Integer.parseInt(auswahl)-1);
		Produkt.herstellen(p.getName(), l);
	}
	
	public static void marktplatz(Marktplatz m, Lager l) {
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
			p = l.getProdukt(Integer.parseInt(auswahl)-1);
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
	
	public static void lager(Marktplatz m, Lager l) {
		System.out.println("Willkommen im Lager!");
		System.out.println("Du hast folgende Produkte im Lager ("+l.getAktuelleKapazitaet()+"/"+l.getMaxKapazitaet()+"):");
		l.listInhalt();
	}
}
