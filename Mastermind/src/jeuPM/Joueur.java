package jeuPM;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Joueur extends GameMaster{

	
	
	public Joueur(JFrame frame) {
		super();
		JPanel pan = new JPanel();
		JPanel panEnvoie = new JPanel();
		JTextField jtf = new JTextField();
		JButton envoie = new JButton("Proposer");
		GridLayout gl = new GridLayout(this.nbTours + 1, 2);
		GridLayout gl2 = new GridLayout (2, 1);
		JLabel prop = new JLabel("Proposition");
		JLabel rep = new JLabel("Réponse");
		
		envoie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JLabel prop = new JLabel();
				prop.setText(jtf.getText());
				pan.add(prop);
				pan.add(reponse(prop));
				jtf.setText("");
			}
			
		});
		panEnvoie.setLayout(gl2);
		panEnvoie.add(jtf);
		panEnvoie.add(envoie);
		pan.setLayout(gl);
		pan.add(prop);
		pan.add(rep);
		
		
		frame.getContentPane().add(pan, BorderLayout.CENTER);
		frame.getContentPane().add(panEnvoie, BorderLayout.SOUTH);
		
		
		
	}
	
}
