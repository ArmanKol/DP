package P3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartDaoImpl extends OracleBaseDAO implements OVChipkaartDao{
	
	private ProductDao pDao = new ProductDaoImpl();
	private ReizigerDAOImpl rDao = new ReizigerDAOImpl();
	
	public OVChipkaartDaoImpl() throws SQLException{
		getConnection();
	}
	
	@Override
	public List<OVChipkaart> findAll(){
		ArrayList<OVChipkaart> list = new ArrayList<OVChipkaart>();
		OVChipkaart ovc = null;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from OV_CHIPKAART");
			
			while(rs.next()) {
				ovc = new OVChipkaart(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getDouble(4),
						rDao.findByID(rs.getInt(5)));
				
				for(Product product : pDao.findByOVChipkaart(ovc)) {
					ovc.getOVChipkaartProducten().add(product);
				}
				
				list.add(ovc);
			}
			
			rs.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	@Override
	public List<OVChipkaart> findByReiziger(Reiziger reiziger){
		ArrayList<OVChipkaart> findList = new ArrayList<>();
		OVChipkaart ovc = null;
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet findReizigerid = stmt.executeQuery("select * from ov_chipkaart where reizigerid = " + reiziger.getId());
		
			while(findReizigerid.next()) {
				ovc = new OVChipkaart(findReizigerid.getInt("kaartnummer"), findReizigerid.getDate("geldigtot"), findReizigerid.getInt("klasse"), findReizigerid.getDouble("saldo"), reiziger);
				ovc.setOVChipkaartProducten(pDao.findByOVChipkaart(ovc));
				
				findList.add(ovc);
			}
			
			findReizigerid.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return findList;
	}
	
	@Override
	public OVChipkaart save(OVChipkaart ovchipkaart) {
		try {
			String query = "insert into OV_CHIPKAART(KAARTNUMMER, GELDIGTOT, KLASSE, SALDO, REIZIGERID) values(?, ?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, ovchipkaart.getKaartnummer());
			stmt.setDate(2, ovchipkaart.getDate());
			stmt.setInt(3, ovchipkaart.getKlasse());
			stmt.setDouble(4, ovchipkaart.getSaldo());
			stmt.setInt(5, ovchipkaart.getReiziger().getId());
			
			stmt.executeUpdate();
			connection.commit();
		}catch(Exception e) {
			System.out.println(e);
		}
		return ovchipkaart;
	}
	
	@Override 
	public OVChipkaart update(OVChipkaart ovchipkaart) {
		try {
			String query = "update ov_chipkaart set kaartnummer = ?, geldigtot = ?, klasse = ?, saldo = ?, reizigerid = ?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, ovchipkaart.getKaartnummer());
			stmt.setDate(2, ovchipkaart.getDate());
			stmt.setInt(3, ovchipkaart.getKlasse());
			stmt.setDouble(4, ovchipkaart.getSaldo());
			stmt.setInt(5, ovchipkaart.getReiziger().getId());
			
			stmt.executeUpdate();
			connection.commit();
		
		}catch(Exception e){
			System.out.println(e);
		}
		
		return ovchipkaart;
	}
	
	@Override
	public boolean delete(OVChipkaart ovchipkaart) {
		boolean deleted = false;
		try {
			String query = "delete from ov_chipkaart where kaartnummer = ?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, ovchipkaart.getKaartnummer());
			
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
