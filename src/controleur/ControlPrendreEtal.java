package controleur;

import villagegaulois.Village;
import personnages.Gaulois;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		
		return village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		Gaulois gaulois=village.trouverHabitant(nomVendeur);
		int numeroEtal=village.installerVendeur(gaulois, produit, nbProduit);
		
		return numeroEtal+1;
	}

	public boolean verifierIdentite(String nomVendeur) {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
}
