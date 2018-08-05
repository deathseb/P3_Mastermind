package jeuPM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Mastermind{

	private static Propriete propriete;

	private static JFrame frame = new JFrame();
	private static JMenuBar menu = new JMenuBar();
	private static JMenu jeu = new JMenu("Jeu");
	private static JMenu mode = new JMenu("Mode");
	private static JMenu config = new JMenu("Configuration");
	private static JMenu info = new JMenu ("A Propos");
	private static JMenuItem mastermind = new JMenuItem("Mastermind");
	private static JMenuItem plusMoins = new JMenuItem("+ ou -");
	private static ButtonGroup bg = new ButtonGroup();
	private static JRadioButtonMenuItem chall = new JRadioButtonMenuItem("Challenger");
	private static JRadioButtonMenuItem def = new JRadioButtonMenuItem("Défenseur");
	private static JRadioButtonMenuItem duel = new JRadioButtonMenuItem("Duel");
	private static JMenuItem apropos = new JMenuItem("A Propos");
	private static JMenuItem configuration = new JMenuItem("Configuration");

	private static Configuration c;



	public static void main(String[] args) { //créer le menu et lance le jeu sélectionné

		frame.setTitle("P3 - Mettez votre logique à l'épreuve");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,400);
		frame.setLocationRelativeTo(null);

		jeu.add(mastermind);
		jeu.add(plusMoins);

		bg.add(chall);
		bg.add(def);
		bg.add(duel);

		chall.setSelected(true);

		mode.add(chall);
		mode.add(def);
		mode.add(duel);

		apropos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				APropos apropos = new APropos();
				apropos.setVisible(true);
			}

		});

		info.add(apropos);

		configuration.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent arg0) {
				c = new Configuration();
				c.setVisible(true);
			}
		});
		config.add(configuration);

		plusMoins.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (chall.isSelected()) {
					c = new Configuration();
					propriete = c.getProperties();
					Joueur j = new Joueur(frame, propriete);

				} else if (def.isSelected()) {
					c = new Configuration();
					propriete = c.getProperties();
					IA ordi = new IA (frame, propriete);
				} else {
					JLabel info = new JLabel();
					info.setText("Mode Duel en cours d'édition");
					frame.getContentPane().add(info);
					frame.setVisible(true);
				}
			}

		});

		menu.add(jeu);
		menu.add(mode);
		menu.add(config);
		menu.add(info);


		frame.setJMenuBar(menu);
		frame.setVisible(true);

	}

	public void setProperties (Propriete prop) {
		this.propriete = prop;
	}

}
