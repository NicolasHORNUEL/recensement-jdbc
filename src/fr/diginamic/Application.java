package fr.diginamic;

import java.io.IOException;
import java.util.Scanner;

import fr.diginamic.services.RecherchePopulationVilleService;

/**
 * @author nicolas
 * Classe exécutable.
 */
public class Application {

	/**
	 * @param args
	 * @throws IOException
	 * Méthode main.
	 */
	public static void main(String[] args) throws IOException {
		
		// AFFICHAGE DU MENU
		String menu = 
				"MENU RECENSEMENT :" + "\n" +
				"------------------------------------------------------------" + "\n" +
				"1. Population d’une ville donnée" + "\n" +
				"2. Population d’un département donné" + "\n" +
				"3. Population d’une région donnée" + "\n" +
				"4. Afficher les 10 régions les plus peuplées" + "\n" +
				"5. Afficher les 10 départements les plus peuplés" + "\n" +
				"6. Afficher les 10 villes les plus peuplées d’un département" + "\n" +
				"7. Afficher les 10 villes les plus peuplées d’une région" + "\n" +
				"8. Afficher les 10 villes les plus peuplées de France" + "\n" +
				"9. Sortir" + "\n" +
				"------------------------------------------------------------" + "\n" +
				"Choisir une option : ";
		System.out.print(menu);
		
		// OUVERTURE DU SCANNER
		Scanner scanner = new Scanner(System.in);
		int choix = scanner.nextInt();
		
		// INTERACTION ET AFFICHAGE RESULTAT SELON LE CHOIX DE L'UTILISATEUR
		while (choix != 9) {
			switch (choix) {
			case 1 :
				RecherchePopulationVilleService rechercheVille = new RecherchePopulationVilleService();
				rechercheVille.traiter(scanner);
				break;
			default :
				System.out.println( "Veuillez saisir une option existante :" );
			    break;					
			}
			System.out.println("------------------------------------------------------------");
			System.out.print("RETOUR MENU Y/N : ");
			//scanner.nextLine();
			String retourMenu = scanner.nextLine();
			if (retourMenu.equals("Y")) {
				System.out.println();
				System.out.print(menu);
				choix = scanner.nextInt();
			} else {
				System.out.print("Choisir une option : ");
				choix = scanner.nextInt();
			}
	
		}
		
		// FERMETURE DU SCANNER
	    scanner.close();
	    System.err.println("SORTIE" );
		
	}

}
