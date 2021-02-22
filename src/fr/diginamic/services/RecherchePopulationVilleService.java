package fr.diginamic.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import fr.diginamic.connexion.ConnectionMySQL;

/**
 * @author nicolas
 * Cette classe hérite d'une classe et méthode abstraite.
 * C'est une classe de service.
 * Elle permet d'afficher la population d'une ville donnée.
 */
public class RecherchePopulationVilleService {

	/**
	 * 
	 * @param scanner est une instance de la classe java.util.Scanner
	 */
	public void traiter(Scanner scanner) {	
		
		// CHOIX DU NOM DE LA VILLE
		scanner.nextLine();
		System.out.print("Saisir une ville : ");
		String choix = scanner.nextLine();	
		
		String population = null;
		try {
			Connection connection = ConnectionMySQL.getConnection();
			Statement statement = connection.createStatement();
			String sql = ("SELECT * FROM ville WHERE nom = \"" + choix + "\"");
			ResultSet curseur = statement.executeQuery(sql);
			while (curseur.next()) {
				population = curseur.getString("population");
			}
			// Fermeture dans l'ordre inverse d'ouverture
			curseur.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// AFFICHAGE DU RESULTAT
		System.out.println("La Population de " + choix + " est de " + population + " habitants.");		
	}

	
}
