package fr.diginamic.connexion;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		
		try {
			Connection connection = ConnectionMySQL.getConnection();
			connection.close();
			System.out.println(connection.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
