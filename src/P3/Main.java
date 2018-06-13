package P3;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws SQLException {
		
		OVChipkaartDao ovDAO = new OVChipkaartDaoImpl();
		ReizigerDao rDAO = new ReizigerDAOImpl();
		ProductDao pDAO = new ProductDaoImpl();
		
		Reiziger r1 = new Reiziger(6, "H", "", "Boom", Date.valueOf("1998-08-01"));
		OVChipkaart ov1 = new OVChipkaart(5000, Date.valueOf("2020-02-06"), 1, 500, r1);
		OVChipkaart ov2 = new OVChipkaart(35283);
		
		//rDAO.save(r1);
		//ovDAO.save(ov1);
		
		
		//ovDAO.delete(ov1);
		//rDAO.delete(r1);
		System.out.println("OVCHIPKAART PRODUCTEN");
		for(Product listp : pDAO.findByOVChipkaart(ov1)) {
			System.out.println(listp);
		}
		
		System.out.println("REIZIGERS");
		for(OVChipkaart listp : ovDAO.findAll()) {
			System.out.println(listp);
		}		
		
		/*
		System.out.println("OVCHIPKAART FIND ALL");
		for(OVChipkaart listOVChipkaart : ovDAO.findByReiziger(r1)) {
			System.out.println(listOVChipkaart.getOVChipkaartProducten());
		}
		
		System.out.println("");
		System.out.println("REIZIGER FIND ALL");
		
		for(Reiziger listReiziger : rDAO.findAll()) {
			System.out.println(listReiziger.getOVChipkaartList());
		}
	
		
		System.out.println("");
		System.out.println("REIZIGER FIND BY GB DATUM");
		
		for(Reiziger listGBDatum : rDAO.findByGBdatum("17-09-02")){
			System.out.println(listGBDatum);
		}
		
		System.out.println("");
		System.out.println("OVCHIPKAART FIND BY REIZIGER");
		
		for(OVChipkaart listID : ovDAO.findByReiziger(r1)) {
			System.out.println(listID);
		}
		
		System.out.println("");
		System.out.println("OVCHIPKAART PRODUCTEN");
		for(Product listp : pDAO.findByOVChipkaart(ov2)) {
			System.out.println(listp);
		}*/
		
	}

}