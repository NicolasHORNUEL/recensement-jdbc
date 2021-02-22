package fr.diginamic.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import fr.diginamic.connexion.ConnectionMySQL;

public class CreateTable {

	public static void main(String[] args) throws IOException  {
		
		String villeModel = ("(id INTEGER NOT NULL AUTO_INCREMENT, "
				+ " codeRegion VARCHAR(80) NOT NULL, "
				+ " nomRegion VARCHAR(80) NOT NULL, "
				+ " codeDepartement VARCHAR(80) NOT NULL, "
				+ " codeVille VARCHAR(80) NOT NULL, "
				+ " nom VARCHAR(80) NOT NULL, "
				+ " population INTEGER NOT NULL, "
				+ " PRIMARY KEY ( id ))");
		
		String departementModel = ("(id INTEGER NOT NULL AUTO_INCREMENT, "
				+ " codeDepartement VARCHAR(80) NOT NULL, "
				+ " population INTEGER NOT NULL, "
				+ " PRIMARY KEY ( id ))");
		
		String regionModel = ("(id INTEGER NOT NULL AUTO_INCREMENT, "
				+ " codeRegion VARCHAR(80) NOT NULL, "
				+ " nomRegion VARCHAR(80) NOT NULL, "
				+ " population INTEGER NOT NULL, "
				+ " PRIMARY KEY ( id ))");
		
		try {
			Connection connection = ConnectionMySQL.getConnection();
			Statement statement = connection.createStatement();
			String sql = ("CREATE TABLE region " + regionModel);
			System.out.println(sql);
			Boolean result = statement.execute(sql);
			System.out.println(result);
			statement.close();
			connection.close();
			System.out.println(connection.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
