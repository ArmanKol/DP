package P3;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReizigerDAOImpl extends OracleBaseDAO implements ReizigerDao{
	
	public ReizigerDAOImpl() throws SQLException{
		getConnection();
	}
	
	@Override
	public Reiziger save(Reiziger reiziger) {
		try {
			String query = "insert into reiziger(reizigerid, voorletters, tussenvoegsel, achternaam, gebortedatum) values(?, ?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, reiziger.getId());
			stmt.setString(2, reiziger.getVoorletter());
			stmt.setString(3, reiziger.getTussenvoegsel());
			stmt.setString(4, reiziger.getAchternaam());
			stmt.setDate(5, (Date)reiziger.getGBdatum());
			
			stmt.executeUpdate();
			connection.commit();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return reiziger;
	}

	@Override
	public List<Reiziger> findAll() {
		ArrayList<Reiziger> list = new ArrayList<Reiziger>();
		Reiziger rr = null;
		
		try {
			OVChipkaartDaoImpl ovDAO = new OVChipkaartDaoImpl();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from reiziger");
			
			while(rs.next()) {
				rr = new Reiziger(rs.getInt("reizigerid"), rs.getString("voorletters"),rs.getString("tussenvoegsel"), rs.getString("achternaam"), rs.getDate("gebortedatum"));
				for(OVChipkaart ovkaart : ovDAO.findByReiziger(rr)) {
					rr.getOVChipkaartList().add(ovkaart);
				}
				
				list.add(rr);
			}
			rs.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public List<Reiziger> findByGBdatum(String GBdatum) {
		ArrayList<Reiziger> findList = new ArrayList<>();
		Reiziger rr = null;
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet findGB = stmt.executeQuery("select * from reiziger where gebortedatum = '" + GBdatum + "'");
			
			while (findGB.next()){
				rr = new Reiziger(findGB.getInt("reizigerid"), findGB.getString("voorletters"), findGB.getString("tussenvoegsel"), findGB.getString("achternaam"), findGB.getDate("gebortedatum"));
				findList.add(rr);
			}
			
			findGB.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return findList;
	}
	
	public Reiziger findByID(int id) {
		Reiziger rr = null;
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet findGB = stmt.executeQuery("select * from reiziger where reizigerid = '" + id + "'");
			
			while (findGB.next()){
				rr = new Reiziger(findGB.getInt("reizigerid"), findGB.getString("voorletters"), findGB.getString("tussenvoegsel"), findGB.getString("achternaam"), findGB.getDate("gebortedatum"));
			}
			
			findGB.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return rr;
	}

	@Override
	public Reiziger update(Reiziger reiziger) {
		try {
			String query = "update reiziger set voorletters = ?, tussenvoegsel = ?, achternaam = ?, gebortedatum = ? where reizigerid = ?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, reiziger.getVoorletter());
			stmt.setString(2, reiziger.getTussenvoegsel());
			stmt.setString(3, reiziger.getAchternaam());
			stmt.setDate(4, (Date)reiziger.getGBdatum());
			stmt.setInt(5, reiziger.getId());
			
			stmt.executeUpdate();
			connection.commit();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return reiziger;
	}

	@Override
	public boolean delete(Reiziger reiziger) {
		boolean deleted = false;
		try {
			String query = "delete from reiziger where reizigerid = ?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, reiziger.getId());
			
			if(stmt.executeUpdate() == 1) {
				deleted = true;
			}
			stmt.executeUpdate();
			connection.commit();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return deleted;
	}
}
