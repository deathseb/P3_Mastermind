package jeuPM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Mastermind {

	public static void main(String[] args) { //créer le menu et lance le jeu sélectionné
		// TODO Auto-generated method stub
		//initialiserPM();
		
		JFrame frame = new JFrame();
		//JPanel pan = new JPanel();
		JMenuBar menu = new JMenuBar();
		JMenu jeu = new JMenu("Jeu");
		JMenu mode = new JMenu("Mode");
		JMenu config = new JMenu("Configuration");
		JMenu info = new JMenu ("A Propos");
		JMenuItem mastermind = new JMenuItem("Mastermind");
		JMenuItem plusMoins = new JMenuItem("+ ou -");
		ButtonGroup bg = new ButtonGroup();
		JRadioButtonMenuItem chall = new JRadioButtonMenuItem("Challenger");
		JRadioButtonMenuItem def = new JRadioButtonMenuItem("Défenseur");
		JRadioButtonMenuItem duel = new JRadioButtonMenuItem("Duel");
		JMenuItem apropos = new JMenuItem("A Propos");
		JMenuItem configuration = new JMenuItem("Configuration");
		
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
				// TODO Auto-generated method stub
				JDialog jd = new JDialog();
				jd.setTitle("A Propos");
				jd.setSize(new Dimension(500, 250));
				jd.setLocationRelativeTo(null);
				
				Locale locale = new Locale("fr", "FR");
				ResourceBundle properties = ResourceBundle.getBundle("ressources/ressourcePM", locale);
				JTextPane jtp = new JTextPane();
				jtp.setEditable(false); //retire la possibilité d'écrire
				
				jtp.setText("Auteur : LE BAIL Sébastien\nVersion : " + (String) properties.getObject("version"));
				
				jd.add(jtp);
				jd.setVisible(true);
			}
			
		});
		info.add(apropos);
		
		configuration.addActionListener(new ActionListener() { //incomplet

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JPanel pan = new JPanel();
				JDialog jd = new JDialog();
				jd.setTitle("Configuration");
				jd.setSize(new Dimension(500,250));
				jd.setLocationRelativeTo(null);
				GridLayout gl = new GridLayout(2,2);
				Locale locale = new Locale("fr", "FR");
				ResourceBundle properties = ResourceBundle.getBundle("ressources/ressourcePM", locale);
				JButton ok = new JButton("Valider");
				JPanel panOk = new JPanel();
				
				JLabel tours = new JLabel("Nombre de tours de jeu : ");
				JLabel chiffre = new JLabel ("Nombre de chiffre dans la combinaison : ");
				JTextField textTours = new JTextField();
				JTextField textChiffre = new JTextField();
				textTours.setText((String) properties.getObject("nbTours"));
				textChiffre.setText((String) properties.getObject("nbChiffre"));
			
				pan.setLayout(gl);
				pan.add(tours);
				pan.add(textTours);
				pan.add(chiffre);
				pan.add(textChiffre);
				
				String dev = (String) properties.getObject("modeDev");
				JCheckBox modeDev = new JCheckBox("Mode Développeur");
				JPanel panDev = new JPanel();
				modeDev.setSelected(true);
				panDev.add(modeDev);
				if (dev.equals("true")) {
					jd.add(panDev, BorderLayout.SOUTH);
				}
					
				
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
						Properties prop = new Properties() ;
						File fProp = new File("src/ressources/ressourcePM.properties") ;
						 
						// Charge le contenu de ton fichier properties dans un objet Properties
						FileInputStream stream;
						try {
							stream = new FileInputStream(fProp);
							prop.load(stream) ;
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						 
						// Change la valeur de la clé taCle dans l'objet Properties
						String tours= textTours.getText();
						prop.setProperty("nbTours",tours) ;
						String chiffre = textChiffre.getText();
						prop.setProperty("nbChiffre", chiffre);
						boolean b = modeDev.isSelected();
						if (b) {
							prop.setProperty("modeDev", "true");
						}else {
							prop.setProperty("modeDev", "false");
						}
						
						// Charge le contenu de ton objet Properties dans ton fichier properties
						FileOutputStream oStream;
						try {
							oStream = new FileOutputStream(fProp);
							prop.store(oStream, "") ;
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						jd.dispose();					
					}
					
				});
				panOk.add(ok, BorderLayout.SOUTH);
				
				jd.add(pan, BorderLayout.NORTH);
				jd.add(panOk, BorderLayout.CENTER);
				
							
				jd.setVisible(true);
			}
			
		});
		config.add(configuration);
		
		plusMoins.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (chall.isSelected()) {
					@SuppressWarnings("unused")
					Joueur j = new Joueur(frame);
					
				} else if (def.isSelected()) {
					JLabel info = new JLabel();
					info.setText("Mode Défenseur en cours d'édition");
					frame.getContentPane().add(info);
					frame.setVisible(true);
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

}
