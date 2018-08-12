package fr.deathseb.jeupm.beans;

public class Propriete {
	
	//---------- Les variables d'instance
	private String nbTours;
	private String nbChiffres;
	private boolean modeDev;
	private String version;

	//---------- Le nombre de tours de jeu --
	
	/**
	 * Retourne le nombre de tours de jeu.
	 * @return String
	 */
	public String getNbTours() {
		return nbTours;
	}
	/**
	 * Fixe le nombre de tours
	 * @param nbTours
	 */
	public void setNbTours(String nbTours) {
		this.nbTours = nbTours;
	}

	//---------- Le nombre de chiffre à deviner --
	public String getNbChiffres() {
		return nbChiffres;
	}
	public void setNbChiffres(String nbChiffres) {
		this.nbChiffres = nbChiffres;
	}
	
	//---------- Le mode développeur --
	public boolean isModeDev() {
		return modeDev;
	}
	public void setModeDev(boolean modeDev) {
		this.modeDev = modeDev;
	}
	
	//---------- La version --
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}


}
