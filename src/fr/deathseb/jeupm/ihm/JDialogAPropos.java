package fr.deathseb.jeupm.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * Boite de dialogue "A Propos".
 * @author vifie
 *
 */
public class JDialogAPropos extends JDialog {
	
    //-- Default UID for Serializable Object
	private static final long serialVersionUID = 1L;
	
	//-- Variable d'instances
	private Locale locale; //-- Par défaut en fr_FR sur le PC d'un Français
	private ResourceBundle properties;
	
	private JPanel panOk = new JPanel();
	private JButton ok = new JButton("ok");
	private JTextPane jtp = new JTextPane();
	private JDialog jd = this;
	
	/**
	 * Constructeur
	 */
	public JDialogAPropos() {
		
		//-- Les caractéristiques de la boite de dialogue
		this.setTitle("A Propos");
		this.setSize(new Dimension(500, 250));
		this.setLocationRelativeTo(null);
		
		//-- Le fichier properties
		//System.out.println("Current Locale: " + Locale.getDefault());
		locale = Locale.getDefault();
		properties = ResourceBundle.getBundle("ressourcePM", locale);
		
		//-- Affichage de propriétés
		jtp.setEditable(false); //-- Retire la possibilité d'écrire.
		jtp.setText("Auteur : LE BAIL Sébastien\nVersion : " + properties.getString("version"));
		panOk.add(ok);
		
		//-- Cacher la boite de dialogue
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jd.setVisible(false);
			}
		});
		
		this.add(panOk, BorderLayout.SOUTH);
		this.add(jtp, BorderLayout.CENTER);
	}

}
