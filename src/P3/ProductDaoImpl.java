package P3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends OracleBaseDAO implements ProductDao {
	
	public ProductDaoImpl() throws SQLException{
		getConnection();
	}
	
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
	public List<Product> findByOVChipkaart(OVChipkaart ovchipkaart) {
		ArrayList<Product> findList = new ArrayList<>();
		Product p = null;
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet findProduct = stmt.executeQuery("select * from product p, ov_chipkaart_product ocp where p.productnummer = ocp.productnummer and kaartnummer =" + ovchipkaart.getKaartnummer());
			while(findProduct.next()) {
				p = new Product(findProduct.getInt("productnummer"), findProduct.getString("productnaam"), findProduct.getString("beschrijving"), findProduct.getDouble("prijs"));
				findList.add(p);
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
