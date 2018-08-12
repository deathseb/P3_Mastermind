package fr.deathseb.jeupm.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import fr.deathseb.jeupm.beans.Propriete;
import fr.deathseb.jeupm.controller.IA;
import fr.deathseb.jeupm.controller.Joueur;




public class JFrameMastermind extends JFrame {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenuBar 			jmbMenu = new JMenuBar();
	
	private JMenu 					jmJeu = new JMenu("Jeu");
	private JMenuItem 					jmiMastermind = new JMenuItem("Mastermind");
	private JMenuItem 					jmiPlusMoins = new JMenuItem("+ ou -");
	
	private JMenu 					jmMode = new JMenu("Mode");
	private ButtonGroup 				bgModeJeu = new ButtonGroup();
	private JRadioButtonMenuItem 			jrbmiModeChallenger = new JRadioButtonMenuItem("Challenger");
	private JRadioButtonMenuItem 			jrbmiModeDefenseur = new JRadioButtonMenuItem("Défenseur");
	private JRadioButtonMenuItem 			jrbmiModeDuel = new JRadioButtonMenuItem("Duel");
	
	private JMenu 					jmConfig = new JMenu("Configuration");
	private JMenuItem 					jmiConfiguration = new JMenuItem("Configuration");
	
	private JMenu 					jmInfo = new JMenu ("A Propos");
	private JMenuItem 					jmiApropos = new JMenuItem("A Propos");

	private JDialogConfiguration jdConfiguration;
	
	private Propriete propriete;
	
	private Joueur	joueur;
	private IA 		ia;

	public JFrameMastermind() {
		this.setTitle("P3 - Mettez votre logique à l'épreuve");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,400);
		this.setLocationRelativeTo(null);

		jmJeu.add(jmiMastermind);
		jmJeu.add(jmiPlusMoins);
		jmbMenu.add(jmJeu);
		
		bgModeJeu.add(jrbmiModeChallenger);
		bgModeJeu.add(jrbmiModeDefenseur);
		bgModeJeu.add(jrbmiModeDuel);
		jmbMenu.add(jmMode);
		
		jrbmiModeChallenger.setSelected(true);

		jmMode.add(jrbmiModeChallenger);
		jmMode.add(jrbmiModeDefenseur);
		jmMode.add(jrbmiModeDuel);

		jmConfig.add(jmiConfiguration);
		jmbMenu.add(jmConfig);
		
		jmInfo.add(jmiApropos);
		jmbMenu.add(jmInfo);
		
		this.setJMenuBar(jmbMenu);
		
		JFrame jfMastermind = this;
		


		//-- Afficher le jeu suivant le mode
		jmiPlusMoins.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (jrbmiModeChallenger.isSelected()) {
					jdConfiguration = new JDialogConfiguration();
					propriete = jdConfiguration.getProperties();
					joueur = new Joueur(jfMastermind, propriete);

				} else if (jrbmiModeDefenseur.isSelected()) {
					jdConfiguration = new JDialogConfiguration();
					propriete = jdConfiguration.getProperties();
					ia = new IA (jfMastermind, propriete);
				} else {
					JLabel info = new JLabel();
					info.setText("Mode Duel en cours d'édition");
					getContentPane().add(info);
					setVisible(true);
				}
			}
		});

		//-- Afficher la boite de dialogue "Configuration"
		jmiConfiguration.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jdConfiguration = new JDialogConfiguration();
				jdConfiguration.setVisible(true);
			}
		});

		//-- Afficher la boite de dialogue "A propos"
		jmiApropos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JDialogAPropos apropos = new JDialogAPropos();
				apropos.setVisible(true);
			}
		});
		
		this.setVisible(true);
	}

	/**
	 * 
	 * @param prop
	 */
	public void setProperties (Propriete prop) {
		this.propriete = prop;
	}

	/**
	 * Lancement du programme.
	 * @param args
	 */
	public static void main(String[] args) { //créer le menu et lance le jeu sélectionné
		JFrameMastermind mastermind = new JFrameMastermind();
	}
}
