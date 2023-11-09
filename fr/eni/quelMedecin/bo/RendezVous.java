package fr.eni.quelMedecin.bo;

import fr.eni.quelMedecin.exception.ProgrammeurException;
import fr.eni.quelMedecin.exception.UtilisateurException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe modélisant un rendez-vous pris entre un patient et un médecin sur l'un
 * de ses créneaux pour une date donnée
 * 
 * @author ENI
 * @version 2.0
 */
public class RendezVous {
	//ATTRIBUTS D'INSTANCE
	private LocalDate dateRDV;
	//association unidirectionnelle
	//navigation vers Creneau 0..1
	private Creneau creneau;
	//association unidirectionnelle
	//navigation vers Patient 0..1
	private Patient patient;
	
	//CONSTRUCTEURS
	/**
	 * Constructeur crée une instance de RendezVous
	 * @param creneau créneau horaire du médecin pour le rendez-vous
	 * @param patient patient ayant pris rendez-vous
	 * @param dateRDV date du rendez-vous
	 */
	public RendezVous(Creneau creneau, Patient patient, LocalDate dateRDV) throws ProgrammeurException, UtilisateurException {
		this.setCreneau(creneau);
		this.setPatient(patient);
		this.setDateRDV(dateRDV);
	}
	
	//AUTRES METHODES
	/**
	 * Affiche sous la forme :
	 * Rendez-vous du 00 XXXXXXX 0000 00:00 - 00:00 (00 minutes)
	 * avec le Dr Nom
	 * pour NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Sexe : Féminin ou Masculin
	 * Numéro de Sécurité sociale XXXXXXXXXXXXXXX
	 * Date de naissance : XX mois XXXX
	 * Commentaires : XXXXXXXXXXXXXXX ou [aucun commentaire]
	 */
	@Deprecated
	public void afficher() {
		System.out.printf("Rendez-vous du %s ",
				this.getDateRDV().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		this.creneau.afficher();
		System.out.printf("avec le Dr %s%npour ", this.getCreneau().getMedecin().getNom());
		this.getPatient().afficher();
	}

	/**
	 * Formate les informations sur le Rendez vous sous la forme :
	 * Rendez-vous du 00 XXXXXXX 0000 00:00 - 00:00 (00 minutes)
	 * avec le Dr Nom
	 * pour NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Adresse :
	 * XXXXXXXXXX	
	 * Sexe : Féminin ou Masculin
	 * Numéro de Sécurité sociale XXXXXXXXXXXXXXX
	 * Date de naissance : XX mois XXXX
	 * Commentaires : XXXXXXXXXXXXXXX ou [aucun commentaire]
	 * (cf methode toString() de Patient)
	 */
	@Override
	public String toString() {
		return String.format("Rendez-vous du %s %savec le Dr %s%npour %s",
				this.getDateRDV().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)),
				this.getCreneau().toString(),
				this.getCreneau().getMedecin().getNom(),
				this.getPatient().toString());
	}	
	
	//ACCESSEURS ET MUTATEURS
	/**
	 * Getter pour creneau
	 * @return le creneau du rendez-vous
	 * @see RendezVous#setCreneau(Creneau)
	 */
	public Creneau getCreneau() {
		return creneau;
	}

	/**
	 * Setter pour creneau
	 * @param creneau  - le creneau du rendez-vous
	 * @see RendezVous#getCreneau()
	 */
	public void setCreneau(Creneau creneau) throws ProgrammeurException {
		if (creneau != null)
			this.creneau = creneau;
		else
			throw new ProgrammeurException("instance de type Creneau inexistante");
	}

	/**
	 * Getter pour patient
	 * @return le patient du rendez-vous
	 * @see RendezVous#setPatient(Patient)
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Setter pour patient
	 * @param patient - le patient du rendez-vous
	 * @see RendezVous#getPatient()
	 */
	public void setPatient(Patient patient) throws ProgrammeurException {
		if (patient !=null)
			this.patient = patient;
		else
			throw new ProgrammeurException("instance de type Patient inexistante");
	}

	/**
	 * Getter dateRDV
	 * @return la date de rendez-vous
	 * @see RendezVous#setDateRDV(LocalDate)
	 */
	public LocalDate getDateRDV() {
		return dateRDV;
	}

	/**
	 * Setter dateRDV
	 * @param dateRDV - la date de rendez-vous
	 * @see RendezVous#getDateRDV()
	 */
	public void setDateRDV(LocalDate dateRDV) throws UtilisateurException {
		if(dateRDV.isAfter(LocalDate.now()))
			this.dateRDV = dateRDV;
		else
			throw new UtilisateurException("la date de rendez-vous ne peut pas être antérieure à la date du jour");
	}	
	
}
