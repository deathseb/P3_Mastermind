package jeuPM;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Joueur extends GameMaster{

	
	
	public Joueur(JFrame frame) {
		super();
		JPanel pan = new JPanel();
		JPanel panEnvoie = new JPanel();
		JTextField jtf = new JTextField();
		JButton envoie = new JButton("Proposer");
		GridLayout gridGenerale = new GridLayout(this.nbTours + 1, 2);
		GridLayout gridDonnees = new GridLayout (2, 1);
		JLabel prop = new JLabel("Proposition");
		JLabel rep = new JLabel("Réponse");
		GridLayout gridInfo = new GridLayout(1,2);
		JLabel comptTours = new JLabel();
		JPanel panDev = new JPanel();
		
		
		panDev.setLayout(gridInfo);
		comptTours.setText("Il reste " + nbTours + " tours.");
		panDev.add(comptTours);
		
		envoie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
				    @SuppressWarnings("unused")
					int test = Integer.parseInt(jtf.getText());
				    if (jtf.getText().length()!=combi.length()) {
				    	JOptionPane.showMessageDialog(null, "Veuillez rentrer une combinaison de " + combi.length() + " chiffres", "Erreur", JOptionPane.ERROR_MESSAGE);
				    }else if(! (nbTours == -1)){
				    	comptTours.setText("Il reste " + nbTours + " tours.");
				    	panDev.add(comptTours);
				    	JLabel prop = new JLabel();
				    	prop.setText(jtf.getText());
				    	pan.add(prop);
				    	JLabel retour = reponse(prop, frame);
				    	if (retour.getText().equals(egale)) {
				    		JOptionPane.showMessageDialog(null, "Vous avez trouvez la combinaison, bravo !!" ,"Félicitations!!", JOptionPane.INFORMATION_MESSAGE);
							frame.getContentPane().remove(pan);
							frame.getContentPane().remove(panEnvoie);
							frame.getContentPane().remove(panDev);
							frame.getContentPane().add(new JPanel());
							frame.setVisible(true);
				    	} else {
				    		pan.add(retour);
					    	jtf.setText("");
					    	frame.getContentPane().add(pan);
					    	frame.setVisible(true);
				    	}
				    	
				    }
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Veuillez rentrer une combinaison de " + combi.length() + " chiffres", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		
		if (dev) {
			JLabel modeDev = new JLabel();
			modeDev.setText("Mode développeur activé.   Combinaison : " + combi);
			panDev.add(modeDev);
			frame.getContentPane().add(panDev, BorderLayout.NORTH);
		}
		panEnvoie.setLayout(gridDonnees);
		panEnvoie.add(jtf);
		panEnvoie.add(envoie);
		pan.setLayout(gridGenerale);
		pan.add(prop);
		pan.add(rep);
		
		frame.getContentPane().add(pan, BorderLayout.CENTER);
		frame.getContentPane().add(panEnvoie, BorderLayout.SOUTH);
		frame.setVisible(true);
		
		
		
	}
	
}
