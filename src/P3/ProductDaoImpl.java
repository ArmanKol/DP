package P3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends OracleBaseDAO implements ProductDao {

	@Override
	public List<Product> findAll() {
		ArrayList<Product> list = new ArrayList<Product>();
		Product product = null;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");
			while(rs.next()) {
				product = new Product(rs.getInt("productnummer"), rs.getString("productnaam"), rs.getString("beschrijving"), rs.getDouble("prijs"));
				list.add(product);
			}
			rs.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	@Override
	public List<Ov_chipkaart_product> findByPK(OVChipkaart ovchipkaart){
		ArrayList<Ov_chipkaart_product> findList = new ArrayList<>();
		Ov_chipkaart_product p = null;
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet findProductnummer = stmt.executeQuery("select * from ov_chipkaart_product where kaartnummer = " + ovchipkaart.getKaartnummer());
			
			while(findProductnummer.next()) {
				p = new Ov_chipkaart_product(findProductnummer.getInt("kaartnummer"), findProductnummer.getInt("productnummer"));
				findList.add(p);
			}
			
			findProductnummer.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return findList;
	}


	@Override
	public List<Product> findByOVChipkaart(OVChipkaart ovchipkaart) {
		ArrayList<Product> findList = new ArrayList<>();
		Product p = null;
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet findProduct = stmt.executeQuery("select * from product");
			while(findProduct.next()) {
				for(Ov_chipkaart_product productid : findByPK(ovchipkaart)) {
					if(findProduct.getInt("productnummer") == productid.getProductnummer()) {
						p = new Product(findProduct.getInt("productnummer"), findProduct.getString("productnaam"), findProduct.getString("beschrijving"), findProduct.getDouble("prijs"));
						findList.add(p);
					}
				}
			}
			
			findProduct.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return findList;
	}

	@Override
	public Product save(Product product) {
		try {
			String query = "insert into product(PRODUCTNUMMER, PRODUCTNAAM, BESCHRIJVING, PRIJS values(?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, product.getpNummer());
			stmt.setString(2, product.getBeschrijving());
			stmt.setString(3, product.getBeschrijving());
			stmt.setDouble(4, product.getPrijs());
			
			stmt.executeUpdate();
			connection.commit();
		}catch(Exception e) {
			System.out.println(e);
		}
		return product;
	}

	@Override
	public Product update(Product product) {
		try {
			String query = "update product set productnummer = ?, productnaam = ?, beschrijving = ?, prijs = ?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, product.getpNummer());
			stmt.setString(2, product.getBeschrijving());
			stmt.setString(3, product.getBeschrijving());
			stmt.setDouble(4, product.getPrijs());
			
			stmt.executeUpdate();
			connection.commit();
		}catch(Exception e) {
			System.out.println(e);
		}
		return product;
	}

	@Override
	public boolean delete(Product product) {
		boolean deleted = false;
		try {
			String query = "delete from product where productnummer = ?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, product.getpNummer());
			
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
