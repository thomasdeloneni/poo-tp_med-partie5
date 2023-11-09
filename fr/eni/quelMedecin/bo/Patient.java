package fr.eni.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


/**
 * Classe modélisant un patient, spécialisant la classe Personne
 * 
 * @author ENI
 * @version 3.0
 */
public class Patient extends Personne {
	//ATTRIBUTS D'INSTANCE
	private char sexe;
	private long numSecu;
	private LocalDate dateNaissance;
	private String commentaires;

	//CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de type Patient
	 * 
	 * @param nom - nom du patient
	 * @param prenom - prénom du patient
	 * @param numeroDeTelephone - numéro de téléphone du patient
	 * @param sexe - sexe du patient : 'F' pour Féminin ou 'M' pour Masculin
	 * @param numSecu - numéro de sécurité sociale du patient
	 * @param dateNaissance - date de naissance du patient
	 * @param commentaires - commentaires associé à ce patient (allergie, antécédents médicaux…)
	 * @param adresse - adresse postale du patient
	 */
	public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numSecu,
			LocalDate dateNaissance, String commentaires, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
		this.setSexe(sexe);
		this.setNumSecu(numSecu);
		this.setDateNaissance(dateNaissance);
		this.setCommentaires(commentaires);
	}

	//AUTRES METHODES
	/**
	 * Affiche sur la console sous la forme :
	 * NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Sexe : Féminin ou Masculin
	 * Numéro de Sécurité sociale XXXXXXXXXXXXXXX
	 * Date de naissance : XX mois XXXX
	 * Commentaires : XXXXXXXXXXXXXXX ou [aucun commentaire]
	 */
	@Deprecated
	public void afficher() {
		super.afficher();
		System.out.printf(
				"Sexe : %s%nNuméro de Sécurité sociale : %d%nDate de naissance : %s%nCommentaires : %s%nAdresse :%n",
				this.getSexe() == 'F' ? "Féminin" : "Masculin",
				this.getNumSecu(), this.getDateNaissance().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)),
				this.commentaires != null ? this.getCommentaires() : "[aucun commentaire]");
		this.adresse.afficher();
	}

	/**
	 * Formate les informations sur le Patient sous la forme :
	 * NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Adresse :
	 * xxxxxxxx (cf méthode toString() de Personne
	 * Sexe : Féminin ou Masculin
	 * Numéro de Sécurité sociale XXXXXXXXXXXXXXX
	 * Date de naissance : XX mois XXXX
	 * Commentaires : XXXXXXXXXXXXXXX ou [aucun commentaire]
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Sexe :").append(this.getSexe() == 'F' ? "Féminin" : "Masculin").append("\n");
		sb.append("Numéro de Sécurité sociale : ").append(this.getNumSecu()).append("\n");
		sb.append("Date de naissance : ").append(this.getDateNaissance().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))).append("\n");
		sb.append(this.commentaires != null ? this.getCommentaires() : "[aucun commentaire]").append("\n");
		return sb.toString();
	}

	
	//ACCESSEURS ET MUTATEURS
	/**
	 * Getter pour sexe
	 * @return le sexe du patient : 'F' pour Féminin ou 'M' pour Masculin
	 * @see Patient#setSexe(char)
	 */
	public char getSexe() {
		return sexe;
	}

	/**
	 * Setter pour sexe
	 * @param sexe - le sexe du patient : 'F' pour Féminin ou 'M' pour Masculin
	 * @see Patient#getSexe()
	 */
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	/**
	 * Getter pour numSecu
	 * @return the numero de secu du patient
	 * @see Patient#setNumSecu(long)
	 */
	public long getNumSecu() {
		return numSecu;
	}

	/**
	 * Setter pour numSecu
	 * @param numSecu - le numero de secu du patient
	 * @see Patient#getNumSecu()
	 */
	public void setNumSecu(long numSecu) {
		this.numSecu = numSecu;
	}

	/**
	 * Getter pour dateNaissance
	 * @return la date de naissance du patient
	 * @see Patient#setDateNaissance(LocalDate)
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Setter pour dateNaissance
	 * @param dateNaissance t- la date de naissance du patient
	 * @see Patient#getNumSecu()
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Getter pour commentaires
	 * @return les commentaires sur le patient
	 * @see Patient#setCommentaires(String)
	 */
	public String getCommentaires() {
		return commentaires;
	}

	/**
	 * Setter pour commentaires
	 * @param commentaires - les commentaires sur le patient
	 * @see Patient#getCommentaires()
	 */
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	
}
