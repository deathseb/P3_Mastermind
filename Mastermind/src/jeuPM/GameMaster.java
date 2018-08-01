package jeuPM;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public abstract class GameMaster {

	protected int nbTours;
	protected String combi = "";
	protected boolean dev;
	protected String egale ="";
	
	public GameMaster() {
		Locale locale = new Locale("fr","FR");
		ResourceBundle properties = ResourceBundle.getBundle("ressources/ressourcePM",locale);
		String temp = (String) properties.getObject("nbTours");
		nbTours = Integer.parseInt(temp);
		temp = (String) properties.getObject("modeDev");
		dev = Boolean.parseBoolean(temp);
		temp = (String) properties.getObject("nbChiffre");
		int nbChiffre = Integer.parseInt(temp);
		for(int i=0; i< nbChiffre; i++) {
			Double d= (Math.random() * (10 - 0));
			combi = combi + d.intValue();
			egale = egale +"=";
		}
		
	}
	
	public JLabel reponse (JLabel prop, JFrame frame) {
		String res = "";
		JLabel retour = new JLabel();
		if (nbTours == 0) {
			JOptionPane.showMessageDialog(null, "Game Over ! Vous n'avez pas réussi à trouver la combinaison qui était " + combi, "Game Over!!", JOptionPane.INFORMATION_MESSAGE);
			frame.getContentPane().removeAll();
		}else {
			for (int i =0; i < combi.length(); i++) {
				int j = Character.getNumericValue(combi.charAt(i));
				int k = Character.getNumericValue(prop.getText().charAt(i));
				if (j==k) {
					res = res+ "=";
				} else {
					if (j>k) {
						res = res + "+";
					} else {
						res = res + "-";
					}
				}
			}
			nbTours = nbTours-1;
			retour.setText(res);
		}
		return retour;
		
		
	}
}
