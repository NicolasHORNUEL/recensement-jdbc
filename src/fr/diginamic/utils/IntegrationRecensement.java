package fr.diginamic.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.connexion.ConnectionMySQL;
import fr.diginamic.entites.Ville;

public class IntegrationRecensement {

	public static void main(String[] args) throws IOException, SQLException  {
		
		List<String> lines = new ArrayList<>();
	
		try {
			Path path = Paths.get("../../recensement.csv");
			lines = Files.readAllLines(path);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Connection connection = ConnectionMySQL.getConnection();
			Statement statement = connection.createStatement();
			for (String line : lines) {
				String[] morceaux = line.split(";");
				int int9 = Integer.parseInt(morceaux[9].replaceAll(" ", ""));	
				Ville ville = new Ville(morceaux[0], morceaux[1], morceaux[2], morceaux[5], morceaux[6], int9);
				String sql = ("INSERT INTO "
						+ "ville (codeRegion,  nomRegion, codeDepartement, codeVille, nom, population) "
						+ "VALUES(" + ville + ")");
				int result = statement.executeUpdate(sql);
				System.out.println(result);
			}
			statement.close();
			connection.close();
			System.out.println(connection.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
