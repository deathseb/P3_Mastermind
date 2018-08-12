package fr.deathseb.jeupm.controller;

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

import fr.deathseb.jeupm.beans.Propriete;

public class IA extends GameMaster{

	private String lastProp ="";

	private JPanel pan = new JPanel();
	private JPanel panEnvoie = new JPanel();
	private JPanel panDev = new JPanel();
	private JTextField jtf = new JTextField();
	private JButton envoie = new JButton("Proposer");
	private GridLayout gridGenerale = new GridLayout();
	private GridLayout gridDonnees = new GridLayout (2, 1);
	private GridLayout gridInfo = new GridLayout(1,2);
	private JLabel prop = new JLabel("Proposition");
	private JLabel rep = new JLabel("Réponse");
	private JLabel comptTours = new JLabel();
	private JLabel propo = new JLabel();
	private JLabel modeDev = new JLabel();
	private JLabel repo = new JLabel();


	public IA(JFrame frame, Propriete properties) {
		super(properties);
		panDev.setLayout(gridInfo);
		comptTours.setText("Il reste " + nbTours + " tours.");
		panDev.add(comptTours);
		gridGenerale.setColumns(2);
		gridGenerale.setRows(gridGenerale.getRows()+1);

		if (lastProp == "") {
			for (int i=0; i < combi.length(); i++) {
				lastProp = lastProp +"5";
			}
			propo.setText(lastProp);
		}

		envoie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (jtf.getText().length()!=combi.length()) {
						JOptionPane.showMessageDialog(null, "Veuillez rentrer une combinaison de " + combi.length() + " chiffres", "Erreur", JOptionPane.ERROR_MESSAGE);
					}else if(! (nbTours == -1)){
						comptTours.setText("Il reste " + nbTours + " tours.");
						panDev.add(comptTours);
						repo.setText(jtf.getText());
						gridGenerale.setRows(gridGenerale.getRows()+1);
						pan.add(repo);
						if (repo.getText().equals(egale)) {
							JOptionPane.showMessageDialog(null, "Vous avez trouvez la combinaison, bravo !!" ,"Félicitations!!", JOptionPane.INFORMATION_MESSAGE);
							frame.getContentPane().remove(pan);
							frame.getContentPane().remove(panEnvoie);
							frame.getContentPane().remove(panDev);
							frame.getContentPane().add(new JPanel());
							frame.setVisible(true);
						} else {
							propo.setText(IAProp (repo.getText()));
							jtf.setText("");
							pan.add(propo);
							frame.getContentPane().add(pan);
							frame.setVisible(true);
						}

					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Veuillez rentrer une combinaison de " + combi.length() + " chiffres", "Erreur", JOptionPane.ERROR_MESSAGE);
				}

			}

		});


		modeDev.setText("Combinaison : " + combi);
		panDev.add(modeDev);
		frame.getContentPane().add(panDev, BorderLayout.NORTH);
		panEnvoie.setLayout(gridDonnees);
		panEnvoie.add(jtf);
		panEnvoie.add(envoie);
		pan.setLayout(gridGenerale);
		pan.add(prop);
		pan.add(rep);
		pan.add(propo);

		frame.getContentPane().add(pan, BorderLayout.CENTER);
		frame.getContentPane().add(panEnvoie, BorderLayout.SOUTH);
		frame.setVisible(true);



	}

	public String IAProp (String rep) {
		String prop = "";
		char r =' ';
		char p = ' ';
		for (int i=0; i < rep.length(); i++) {
			r = rep.charAt(i);
			p = lastProp.charAt(i);
			if(p == '5') {
				if (r =='=') {
					prop = prop + '5';
				}else if (r == '+') {
					prop = prop + '8';
				} else {
					prop = prop + '2';
				}
			}
			if(p == '2') {
				if (r =='=') {
					prop = prop + '2';
				}else if (r == '+') {
					prop = prop + '3';
				} else {
					prop = prop + '1';
				}
			}
			if(p == '8') {
				if (r =='=') {
					prop = prop + '8';
				}else if (r == '+') {
					prop = prop + '9';
				} else {
					prop = prop + '7';
				}
			}
			if(p == '3') {
				if (r =='=') {
					prop = prop + '3';
				}else if (r == '+') {
					prop = prop + '4';
				} else {
					prop = prop + '2';
				}
			}
			if(p == '7') {
				if (r =='=') {
					prop = prop + '7';
				}else if (r == '+') {
					prop = prop + '8';
				} else {
					prop = prop + '6';
				}
			}
			if(p == '1') {
				if (r =='=') {
					prop = prop + '1';
				}else if (r == '+') {
					prop = prop + '2';
				} else {
					prop = prop + '0';
				}
			}
			if(p == '9') {
				if (r =='=') {
					prop = prop + '9';
				} else {
					prop = prop + '8';
				}
			}

		}

		lastProp = prop;
		return prop;

	}

}
