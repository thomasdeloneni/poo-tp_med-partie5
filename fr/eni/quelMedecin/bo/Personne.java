package fr.eni.quelMedecin.bo;

import fr.eni.quelMedecin.exception.UtilisateurException;

import java.util.Comparator;

/**
 * Classe abstraite servant de modele à notre relation d'héritage avec les classes dérivées 
 * Cette classe regroupe les éléments communs à toutes les personnes 
 * qu'elles soient médecin ou patient
 * Elle généralise les classes Medecin et Patient
 * 
 * @author ENI
 * @version 3.0
 */
public abstract class Personne {
	//ATTRIBUTS D'INSTANCE
	protected String nom;
	protected String prenom;
	protected String numeroDeTelephone;
	//association unidirectionnelle
	protected Adresse adresse;

	//CONSTRUCTEURS
	/**
	 * Constructeur : modele pour le relation d'héritage
	 * 
	 * @param nom - nom de la personne
	 * @param prenom - prénom de la personne
	 * @param numeroDeTelephone - numéro de téléphone de la personne
	 * @param adresse - adresse postale de la personne
	 */
	public Personne(String nom, String prenom, String numeroDeTelephone, Adresse adresse) throws UtilisateurException {
		this.setNom(nom.toUpperCase());
		this.setPrenom(prenom);
		this.setNumeroDeTelephone(numeroDeTelephone);
		this.setAdresse(adresse);
	}

	//AUTRES METHODES
	/**
	 * Affiche les information sur la personne sous la forme :
	 * NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Adresse :
	 * ......(cf méthode afficher() de Adresse)
	 */
	@Deprecated
	public void afficher() {
		System.out.printf("%s %s%nTéléphone : %s%n", 
				this.getNom(), 
				this.getPrenom(), 
				this.getNumeroDeTelephone());
		if (this.adresse != null)
			this.getAdresse().afficher();
	}

	/**
	 * Formate les informations sur la Personne sous la forme :
	 * NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Adresse :
	 * ......(cf méthode toString() de Adresse)
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getNom()).append(" ").append(this.getPrenom()).append("\n");
		sb.append("Téléphone : ").append(this.getNumeroDeTelephone()).append("\n");
		if (this.adresse != null) {
			sb.append(this.getAdresse().toString());
		}
		return sb.toString(); 
	}

	/**
	 * Creation d'un objet de type Comparator afin de permettre son passage en argument dans 
	 * certaines methodes, comme la fonction de tri (Collections.sort()). Le tri sera croissant
	 * sur le nom et le prenom
	 */
	public static Comparator<Personne> comparatorNomPrenomCroissant = new Comparator<Personne>() {

		@Override
		public int compare(Personne p1, Personne p2) {
			int compareNom = p1.getNom().compareTo(p2.getNom());
			if (compareNom!=0) {
				return compareNom;
			} else {
				return p1.getPrenom().compareTo(p2.getPrenom());
			}
		}
	};

	/**
	 * Creation d'un objet de type Comparator afin de permettre son passage en argument dans 
	 * certaines methodes, comme la fonction de tri (Collections.sort()). Le tri sera décroissant
	 * sur le nom et le prenom
	 */
	public static Comparator<Personne> comparatorNomPrenomDecroissant = new Comparator<Personne>() {

		@Override
		public int compare(Personne p1, Personne p2) {
			int compareNom = p2.getNom().compareTo(p1.getNom());
			if (compareNom!=0) {
				return compareNom;
			} else {
				return p2.getPrenom().compareTo(p1.getPrenom());
			}
		}
	};
	
	//ACCESSEURS ET MUTATEURS
	/**
	 * Getter pour nom.
	 * @return le nom du médecin
	 * @see MedecinGeneraliste#setNom(String)
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour nom.
	 * @param nom - le nom du medecin
	 * @see MedecinGeneraliste#getNom()
	 */
	public void setNom(String nom) throws UtilisateurException {
		if(!nom.isBlank())
			this.nom = nom;
		else
			throw new UtilisateurException("le nom est obligatoire");
	}

	/**
	 * Getter pour prenom.
	 * @return le prenom du médecin
	 * @see MedecinGeneraliste#setPrenom(String)
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter pour prenom.
	 * @param prenom - le prenom du medecin
	 * @see MedecinGeneraliste#getPrenom()
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter pour numeroDeTelephone.
	 * @return le numéro de téléphone
	 * @see MedecinGeneraliste#setNumeroDeTelephone(String)
	 */
	public String getNumeroDeTelephone() {
		return this.numeroDeTelephone;
	}

	/**
	 * Setter pour numeroDeTelephone.
	 * @param numeroDeTelephone -le numéro de téléphone
	 * @see MedecinGeneraliste#getNumeroDeTelephone()
	 */
	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}

	/**
	 * Getter pour adresse
	 * @return l'adresse du medecin
	 * @see MedecinGeneraliste#setAdresse(Adresse)
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * Setter pour adresse
	 * @param adresse - l'adresse du medecin
	 * @see MedecinGeneraliste#getAdresse()
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
}