package P2;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException {
		
		OVChipkaartDao ovDAO = new OVChipkaartDaoImpl();
		ReizigerDao rDAO = new ReizigerDAOImpl();
		
		Reiziger r1 = new Reiziger(6, "H", "", "Boom", Date.valueOf("1998-08-01"));
		OVChipkaart ov1 = new OVChipkaart(5000, Date.valueOf("2020-02-06"), 1, 500, r1);
		
		//rDAO.save(r1);
		//ovDAO.save(ov1);
		
		
		//ovDAO.delete(ov1);
		//rDAO.delete(r1);
		
		
		System.out.println("OVCHIPKAART FIND ALL");
		for(OVChipkaart listOVChipkaart : ovDAO.findAll()) {
			System.out.println(listOVChipkaart);
		}
		System.out.println("");
		System.out.println("REIZIGER FIND ALL");
		
		for(Reiziger listReiziger : rDAO.findAll()) {
			System.out.println(listReiziger);
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
	}

}