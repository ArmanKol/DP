package SimpleJDBC;

import java.sql.*;

public class Main {
	
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "arman";
	private static final String DB_PASS = "zxcvbnm";
	private static Connection conn;
	
	
	public static void main(String[] args) throws SQLException{
		try {
			Class.forName(DB_DRIV).newInstance();
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		// Leg de connectie met de database
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		System.out.println("Connection made");
		
		Statement stmt = conn.createStatement();
		String strQuery = "DELETE FROM cursussen WHERE code = 'JAV'";
		
		// Een eerste SQL statement uitvoeren
		stmt.executeUpdate(strQuery);
		
		String queryText = "Select * FROM cursussen";
		
		ResultSet rs = stmt.executeQuery(queryText);
		
		System.out.println("Eerste ResultSet: " + rs + "\n");
		
		
		int anr;
		String naam;
		String locatie; 
		while (rs.next()) {   
			anr = rs.getInt("ANR");	
			naam = rs.getString("naam");
			locatie = rs.getString("locatie"); 
			System.out.println("Afdeling nr: " + anr + ", " + naam + " in " + locatie);
		}	
		rs.close();
		stmt.close();	
		System.out.println("");

		strQuery = "DELETE FROM afdelingen WHERE anr = ? AND locatie = ?";
		PreparedStatement pstmt = conn.prepareStatement(strQuery);
		pstmt.setInt(1, 60);
		pstmt.setString(2, "BAARN");

		pstmt.executeUpdate();
		System.out.println("Afdeling 60 verwijderd.\n");
	
		pstmt.close();
		conn.close();

	}
}