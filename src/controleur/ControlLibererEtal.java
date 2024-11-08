package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isVendeur(String nomVendeur) {
		 return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)!=null;
	}

	/**
	 * 
	 * @param produit
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		//TODO a completer
		String[] donneesEtal = null;
		//String[] donneesEtal = new String[5];
		
		if (!isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui!");
		}
		else {
			Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
			donneesEtal=etal.etatEtal();
		}
		
		return donneesEtal;
	}

}
