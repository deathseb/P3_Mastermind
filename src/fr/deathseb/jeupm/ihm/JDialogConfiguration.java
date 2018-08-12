package fr.deathseb.jeupm.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.deathseb.jeupm.beans.Propriete;

/**
 * LA boite de dialogue de configuration des propriétés du jeu.
 * @author vifie
 *
 */
public class JDialogConfiguration extends JDialog {

    //-- Default UID for Serializable Object
	private static final long serialVersionUID = 1L;
	
	//-- Les variables d'instances
	private JPanel panDev = new JPanel();
	private JPanel panOk = new JPanel();
	private JPanel panInfo = new JPanel();
	private JCheckBox modeDev = new JCheckBox("Mode Développeur");
	private JDialog jd = this;
	private JLabel tours = new JLabel("Nombre de tours de jeu : ");
	private JLabel chiffre = new JLabel ("Nombre de chiffre dans la combinaison : ");
	private JTextField textTours = new JTextField();
	private JTextField textChiffre = new JTextField();
	private JButton ok = new JButton("Valider");
	private GridLayout gl = new GridLayout(2,2);

	private Propriete p = new Propriete();
	private String version;

	private Properties prop = new Properties();
	private File fProp = new File("resources/ressourcePM_fr_FR.properties");
	private Locale locale = Locale.getDefault();
	private ResourceBundle properties = ResourceBundle.getBundle("ressourcePM", locale);


	/**
	 * Constructeur de la boite de Dialogue.
	 */
	public JDialogConfiguration() {
		initContent();
	}

	/**
	 * Initialiser le contenu de la boite de dialogue.
	 */
	private void initContent() {
		this.setTitle("Configuration");
		this.setSize(new Dimension(500,250));
		this.setLocationRelativeTo(null);

		panOk.add(ok);
		panInfo.setLayout(gl);
		panInfo.add(tours);
		panInfo.add(textTours);
		panInfo.add(chiffre);
		panInfo.add(textChiffre);
		this.getContentPane().add(panInfo, BorderLayout.NORTH);
		this.getContentPane().add(panOk, BorderLayout.CENTER);

		loadProperties();

		p.setModeDev(modeDev.isSelected());
		p.setNbChiffres(textChiffre.getText());
		p.setNbTours(textTours.getText());

		//Fermeture de la fen�tre et gestion de la sauvegarde
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				//-- Le nombre de tours de jeu.
				String tours = textTours.getText();
				prop.setProperty("nbTours",tours) ;
				
				//-- Le nombre de chiffre.
				String chiffre = textChiffre.getText();
				prop.setProperty("nbChiffre", chiffre);
				
				//-- Le mode développeur.
				boolean b = modeDev.isSelected();
				if (b) {
					prop.setProperty("modeDev", "true");
				}else {
					prop.setProperty("modeDev", "false");
				}
				//-- On ne change pas la version.
				prop.setProperty("version", version);

				// Charge le contenu de ton objet Properties dans ton fichier properties
				FileOutputStream oStream = null;
				try {
					oStream = new FileOutputStream(fProp);
					prop.store(oStream, "") ;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally {
					try {
						oStream.close();
						System.out.println("Le fichier properties a été modifié");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				p.setModeDev(modeDev.isSelected());
				p.setNbChiffres(textChiffre.getText());
				p.setNbTours(textTours.getText());
				jd.setVisible(false);		
			}
		});
	}

	/**
	 * 
	 */
	private void loadProperties() { //Charge le contenu du fichier properties dans les objects pr�vu
		String dev = (String) properties.getObject("modeDev");
		panDev.add(modeDev);
		modeDev.setSelected(true);
		if (dev.equals("true")) {
			this.getContentPane().add(panDev, BorderLayout.SOUTH);
		}
		textTours.setText(properties.getString("nbTours"));
		textChiffre.setText(properties.getString("nbChiffre"));
		version = properties.getString("version");
	}

	/**
	 * 
	 * @return
	 */
	public Propriete getProperties() {
		return p;
	}

}
