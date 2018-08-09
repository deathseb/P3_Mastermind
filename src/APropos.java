package jeuPM;

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

@SuppressWarnings("serial")
public class APropos extends JDialog {
	
	private Locale locale = new Locale("fr", "FR");
	private ResourceBundle properties = ResourceBundle.getBundle("ressources/ressourcePM", locale);
	
	private JPanel panOk = new JPanel();
	private JButton ok = new JButton("ok");
	private JTextPane jtp = new JTextPane();
	private JDialog jd = this;
	
	public APropos() {
		this.setTitle("A Propos");
		this.setSize(new Dimension(500, 250));
		this.setLocationRelativeTo(null);

		jtp.setEditable(false); //retire la possibilité d'écrire
		jtp.setText("Auteur : LE BAIL Sébastien\nVersion : " + (String) properties.getObject("version"));
		panOk.add(ok);
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jd.setVisible(false);
			}
			
		});
		
		this.add(panOk, BorderLayout.SOUTH);
		this.add(jtp, BorderLayout.CENTER);
	}

}
