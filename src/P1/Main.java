package P1;

import java.sql.Date;

public class Main {
	public static void main(String[] args) {
		Reiziger r0 = new Reiziger(0, "Martijn", Date.valueOf("1990-01-01"));
		Reiziger r0update = new Reiziger(0, "Martie", Date.valueOf("1995-01-01"));
		Reiziger r1 = new Reiziger(1, "Piet", Date.valueOf("1977-10-23"));
		Reiziger r2 = new Reiziger(2, "Henk", Date.valueOf("1999-12-11"));
		
		ReizigerDAOImpl dao = new ReizigerDAOImpl();
		
		dao.save(r0);
		dao.save(r1);
		dao.save(r2);
		
		System.out.println("Opgeslagen reizigers:");
		for(Reiziger alleReizigers : dao.findAll()) {
			System.out.println(alleReizigers);
		}
		
		System.out.println("");		
		System.out.println("Reiziger met id 0 wordt geupdate:");
		
		dao.update(r0update);
		for(Reiziger reizigerUpdate : dao.findAll()) {
			System.out.println(reizigerUpdate);
		}
		
		System.out.println("");		
		System.out.println("Er is een reiziger verwijderd:");
		dao.delete(r2);
		for(Reiziger reizigerVerwijderd : dao.findAll()) {
			System.out.println(reizigerVerwijderd);
		}
		
		System.out.println("");	
		System.out.println("Reiziger opzoeken met gebortedatum: 1977-10-23");
		for(Reiziger reizigerGB : dao.findByGBdatum("1977-10-23")) {
			System.out.println(reizigerGB);
		}	
		
	}
}
