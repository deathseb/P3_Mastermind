package jeuPM;

import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public abstract class GameMaster {

	protected int nbTours;
	protected int nbChiffre;
	protected String combi = "";
	protected boolean dev;
	protected String egale ="";

	protected Properties properties;

	protected JLabel retour = new JLabel();

	public GameMaster(Propriete properties) {
		/*String temp = properties.getProperty("nbTours");
		System.out.println(temp);
		nbTours = Integer.parseInt(temp);
		temp = (String) properties.getProperty("modeDev");
		dev = Boolean.parseBoolean(temp);
		temp = (String) properties.getProperty("nbChiffre");
		int nbChiffre = Integer.parseInt(temp);*/
		nbTours = Integer.parseInt(properties.getNbTours());
		nbChiffre = Integer.parseInt(properties.getNbChiffres());
		dev = properties.isModeDev();
		for(int i=0; i< nbChiffre; i++) {
			Double d= (Math.random() * (10 - 0));
			combi = combi + d.intValue();
			egale = egale +"=";
		}

	}

	public JLabel reponse (JLabel prop, JFrame frame) {
		String res = "";

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
