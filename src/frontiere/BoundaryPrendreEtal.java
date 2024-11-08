package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		//TODO a completer
		if(!(controlPrendreEtal.verifierIdentite(nomVendeur))) {
			System.out.println("Je suis désolée "+nomVendeur+" mais il faut être un habitant de "
					+ " notre village pour commencer ici.");
		}
		else {
			System.out.println("Bonjour "+nomVendeur+" , je vais regarder si je peux vous trouvez "
					+ "un étal.");
			if (controlPrendreEtal.resteEtals()!=true) {
				System.out.println("Désolée "+nomVendeur+" je n'ai plu d'étal "
						+ "qui ne soit déjà occupé.");
			}
			else {
				installerVendeur(nomVendeur);
				
				
			}
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous!");
		
		String produit=Clavier.entrerChaine("Quel prooduit souhaitez-vos vendre?");
		int nbProduit=Clavier.entrerEntier("Combien souhaitez-vous en vendre?");
		
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=-1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est installé à "
					+ "l'etal n°"+numeroEtal);
		}
		
	}

}
