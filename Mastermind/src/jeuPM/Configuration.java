package jeuPM;

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

@SuppressWarnings("serial")
public class Configuration extends JDialog {

	
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

	private Properties prop = new Properties();
	private File fProp = new File("src/ressources/ressourcePM.properties");
	private Locale locale = new Locale("fr", "FR");
	private ResourceBundle properties = ResourceBundle.getBundle("ressources/ressourcePM", locale);



	public Configuration() {
		initContent();
	}

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

		//Fermeture de la fenêtre et gestion de la sauvegarde
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// Change la valeur de la clé dans l'objet Properties
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
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				p.setModeDev(modeDev.isSelected());
				p.setNbChiffres(textChiffre.getText());
				p.setNbTours(textTours.getText());
				jd.setVisible(false);		
			}

		});

	}

	private void loadProperties() { //Charge le contenu du fichier properties dans les objects prévu
		String dev = (String) properties.getObject("modeDev");
		panDev.add(modeDev);
		modeDev.setSelected(true);
		if (dev.equals("true")) {
			this.getContentPane().add(panDev, BorderLayout.SOUTH);
		}
		textTours.setText((String) properties.getObject("nbTours"));
		textChiffre.setText((String) properties.getObject("nbChiffre"));
	}
	
	
	public Propriete getProperties() {
		return p;
	}

}
