package controleur;

import villagegaulois.Village;
import personnages.Gaulois;
import villagegaulois.Etal;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	public boolean isVendeur(String nomVendeur) {
		 return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)!=null;
	}
	public boolean verifierIdentite(String nomAcheteur) {
		//TODO a completer, 
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public String[] trouverNomVendeur(String produit) {
		Gaulois [] vendeur=village.rechercherVendeursProduit(produit);
		String[] nomVendeur=null;
		nomVendeur=new String[vendeur.length]; 
		if (vendeur!=null) {
			for (int i=0;i<vendeur.length;i++) {
				nomVendeur[i]=vendeur[i].getNom();
			}
		}
	return nomVendeur;
	}
	
	public int quantiteVendeur(String nomVendeur) {

		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		int quantiteProduit=etal.getQuantite();
		return quantiteProduit;
	}
	
	public int acheterProduit(String nomVendeur,int quantiteAcheter) {
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		quantiteAcheter=etal.acheterProduit(quantiteAcheter);
		
		return quantiteAcheter;
	}
	
	
}
