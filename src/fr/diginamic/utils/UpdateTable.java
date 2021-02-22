package fr.diginamic.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import fr.diginamic.connexion.ConnectionMySQL;

public class UpdateTable {

	public static void main(String[] args) throws IOException  {
		
		String ajoutColonne = ("ALTER TABLE ville "
				+ "ADD id_departement INTEGER,"
				+ "ADD id_region INTEGER ");
		
		String creerContrainte = ("ALTER TABLE ville "
				+ "ADD CONSTRAINT fk_departement "
				+ "FOREIGN KEY (id_departement) "
				+ "REFERENCES departement(id), "
				+ "ADD CONSTRAINT  fk_region "
				+ "FOREIGN KEY (id_region) "
				+ "REFERENCES region(id)");
		
		String insertionDep = ("INSERT INTO departement(codeDepartement, population) "
				+ "SELECT DISTINCT ville.codeDepartement, SUM(population) "
				+ "FROM ville "
				+ "GROUP BY ville.codeDepartement ;");

		String remplirForeignIdDep = ("UPDATE ville "
				+ "SET ville.id_departement = "
				+ "(SELECT id FROM departement WHERE departement.codeDepartement = ville.codeDepartement);");
		
		String insertionReg = ("INSERT INTO region(codeRegion, nomRegion, population) "
				+ "SELECT DISTINCT ville.codeRegion, ville.nomRegion, SUM(population) "
				+ "FROM ville "
				+ "GROUP BY ville.codeRegion, ville.nomRegion;");

		String remplirForeignIdReg = ("UPDATE ville "
				+ "SET ville.id_region = "
				+ "(SELECT id FROM region WHERE region.codeRegion = ville.codeRegion);");
		
		try {
			Connection connection = ConnectionMySQL.getConnection();
			Statement statement = connection.createStatement();
			System.out.println(remplirForeignIdReg);
			Boolean result = statement.execute(remplirForeignIdReg);
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
