package fr.diginamic.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.cj.jdbc.Driver;

public class ConnectionMySQL {

	static {
		try {
			DriverManager.registerDriver(new Driver());
		} catch (SQLException e) {
			System.out.println("impossible de charger le driver MySQL");
		}
	}

	public static Connection getConnection() {
		try {
			ResourceBundle fichierConf = ResourceBundle.getBundle("mySQL");
			String url = fichierConf.getString("url");
			String user = fichierConf.getString("user");
			String password = fichierConf.getString("password");
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			System.out.println("impossible de se connecter à la base de données: " + e.getMessage());
			return null;
		}
	}

}