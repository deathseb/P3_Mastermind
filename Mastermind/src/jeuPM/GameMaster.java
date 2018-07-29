package jeuPM;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JLabel;

public abstract class GameMaster {

	protected int nbTours;
	protected String combi;
	protected boolean dev;
	
	public GameMaster() {
		Locale locale = new Locale("fr","FR");
		ResourceBundle properties = ResourceBundle.getBundle("ressources/ressourcesPM",locale);
		nbTours = (int) properties.getObject("nbTours");
		dev = (boolean) properties.getObject("modeDev");
		for(int i=0; i< (int) properties.getObject("nbChiffre"); i++) {
			Double d= (Math.random() * (10 - 0));
			combi = combi + d.toString();
		}
	}
	
	public JLabel reponse (JLabel prop) {
		String res = null;
		for (int i =0; i< combi.length(); i++) {
			if (combi.charAt(i)==prop.getText().charAt(i)) {
				res = res+ "=";
			} else {
				int j = Character.getNumericValue(combi.charAt(i));
				int k = Character.getNumericValue(prop.getText().charAt(i));
				if (j>k) {
					res = res + "+";
				} else {
					res = res + "-";
				}
			}
		}
		JLabel retour = new JLabel();
		retour.setText(res);
		return retour;
	}
}
