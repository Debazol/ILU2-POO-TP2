package controleur;

import villagegaulois.Village;

public class ControlAfficherMarche {
	private Village village;

	public ControlAfficherMarche(Village village) {
		this.village = village;
	}

	//TODO a completer
	public String[] donnerInfosMarche() {
		String[] infoMarche=null;
		infoMarche=village.donnerEtatMarche();
		return infoMarche;
	}
}
