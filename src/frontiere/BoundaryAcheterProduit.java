package frontiere;

import java.util.Scanner;
import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolé "+nomAcheteur+" mais il faut"
					+ " être un habitant pour commercer ici.");
		}
		String produit=Clavier.entrerChaine("Chez produit voulez-vous acheter ?");
		String[] vendeur=controlAcheterProduit.trouverNomVendeur(produit);
		if(vendeur==null) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
		}
		
		System.out.println("Chez quel commerçant voulez-vous acheter des "+produit+" ?");
		for (int i=0;i<vendeur.length;i++) {
			System.out.println((i+1)+" - "+vendeur[i]);
		}
	
		int numEtal=Clavier.entrerEntier("");
		String vendeurChoisi=vendeur[numEtal-1];
		
		if(!controlAcheterProduit.verifierIdentite(vendeurChoisi)) {
			System.out.println("Je suis désolé "+vendeurChoisi+" mais il faut"
					+ " être un habitant pour commercer ici.");
		}
		
		System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+vendeurChoisi+""
				+ "\nBonjour "+ nomAcheteur);
		int quantiteProduit=controlAcheterProduit.quantiteVendeur(vendeurChoisi);
		int quantiteAcheter=Clavier.entrerEntier("Combien de fleurs voulez vous acheter ?");
		quantiteAcheter=controlAcheterProduit.acheterProduit(vendeurChoisi,quantiteAcheter );
		if(quantiteAcheter==0) {
			System.out.print(nomAcheteur+" veut acheter "+quantiteAcheter+" "+produit+""
					+ ", malheureusement il n'y en a plus !");
		}
		else if(quantiteAcheter>quantiteProduit) {
			System.out.print(nomAcheteur+" veut acheter "+quantiteAcheter+" "+produit+""
					+ ", malheureusement "+vendeurChoisi+" n'en a plus que 3. "
							+ nomAcheteur+" achète tout le stock de "+vendeurChoisi);
		}
		else {
			System.out.print(nomAcheteur+" achète "+quantiteAcheter+produit+" à "+ vendeurChoisi);
		}

	}
}
