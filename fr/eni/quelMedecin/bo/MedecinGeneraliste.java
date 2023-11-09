package fr.eni.quelMedecin.bo;

import fr.eni.quelMedecin.exception.UtilisateurException;

/**
 * Classe modélisant un médecin généraliste. C'est une specialisation de la classe Medecin
 * Elle ne peut pas etre une généralisation de classes dérivées
 * 
 * @author ENI
 * @version 3.0
 */
public final class MedecinGeneraliste extends Medecin {

	//ATTRIBUTS DE CLASSE
	private static int tarif = 25;

	//CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de MedecinGeneraliste
	 * 
	 * @param nom - nom du médecin généraliste
	 * @param prenom - prénom du médecin généraliste
	 * @param numeroDeTelephone - numéro de téléphone du médecin généraliste
	 * @param adresse - adresse postale du medecin généraliste
	 */
	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) throws UtilisateurException {
		super(nom, prenom, numeroDeTelephone, adresse);
	}

	//AUTRES METHODES
	/** 
	 * {@inheritDoc}
	 * @see fr.eni.ecole.quelMedecin3.bo.Personne#afficher()
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void afficher() {
		super.afficher();
		System.out.printf("Tarif : %d€%n", MedecinGeneraliste.getTarif());
		this.AfficherAdresseEtCreneaux();
	}

	/**
	 * Formate les informations sur le MedecinGeneraliste sous la forme :
	 * NOM Prénom 
	 * Téléphone : XXXXXXXXXX
	 * Adresse :
	 * Complément
	 * XXbis rue XXXXXXXXX
	 * 00000 XXXXXXXXXXXXX 
	 * Créneaux :
	 * 00:00 - 00:00 (XX minutes) 
	 * 00:00 - 00:00 (XX minutes)
	 * 00:00 - 00:00 (XX minutes)
	 * 00:00 - 00:00 (XX minutes) (cf méthode toString() de Medecin)
	 * Tarif : XXXXX
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Tarif : ").append(MedecinGeneraliste.getTarif()).append("\n");
		return sb.toString();
	}
	
	/**
	 * Methode permettant d'orienter un patient vers un spécialiste
	 */
	@Override
	public void orienter() {
		System.out.println("le médecin oriente vers un spécialiste en cas de besoin");
	}


	//ACCESSEURS ET MUTATEURS
	/**
	 * Getter pour tarif.
	 * @return le tarif de la consultation
	 * @see MedecinGeneraliste#setTarif(int)
	 */
	public static int getTarif() {
		return MedecinGeneraliste.tarif;
	}

	/**
	 * Setter pour tarif.
	 * @param tarif - le tarif de la consultation
	 * @see MedecinGeneraliste#getTarif()
	 */
	public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}


}
