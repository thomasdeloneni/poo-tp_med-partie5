package fr.eni.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe modélisant le fichier médical d'un patient
 * 
 * @author ENI
 * @version 3.0
 */
public class FichierMedical {

	//ATRIBUTS D'INSTANCE
	private int poids;
	private int taille;
	private String tension;
	private int oxygenation;
	private int pulsation;
	private String probleme;
	private String prescription;
	private LocalDate dateSoin;
	//associations unidirectionnelles
	private Patient patient;
	private Medecin medecin;

	
	//CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de FichierMedical
	 * 
	 * @param poids - le poids du patient en kilogrammes (ex: 80)
	 * @param taille - la taille du patient en centimetres (ex: 176)
	 * @param tension - la tension du patient en cmHg - centimètre de mercure (ex: 12/7) 
	 * @param oxygenation - la saturation artérielle en oxygene dans le sang du patient en % (ex: 95)
	 * @param pulsation - la rythme cardiaque du patient (ex: 75)
	 * @param probleme - le probleme soulevé par le patient
	 * @param prescription - la prescription medicale du medecin
	 * @param dateSoin - la date du soin
	 * @param patient - une instance de Patient
	 * @param medecin - une instance de Medecin
	 */
	public FichierMedical(int poids, int taille, String tension, int oxygenation, int pulsation, String probleme, String prescription,
			LocalDate dateSoin, Patient patient, Medecin medecin) {
		this.setPoids(poids);
		this.setTaille(taille);
		this.setTension(tension);
		this.setOxygenation(oxygenation);
		this.setPulsation(pulsation);
		this.setProbleme(probleme);
		this.setPrescription(prescription);
		this.setDateSoin(dateSoin);
		this.setPatient(patient);
		this.setMedecin(medecin);
	}

	//AUTRES METHODES
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Fichier médical de :\n ");
		sb.append(getPatient().toString());
		sb.append("Poids : ").append(getPoids());
		sb.append(" kg, taille : ").append(getTaille()).append(" cm\n");
		sb.append("Tension : ").append(getTension()).append("cmHg, saturation : ").append(getOxygenation());
		sb.append("%, pulsation : ").append(getPulsation()).append("\n");
		sb.append("Probleme : ").append(getProbleme()).append("\n");
		sb.append("Prescription : ").append(getPrescription()).append("\n");
		sb.append("Date de soin : ").append(getDateSoin().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))).append("\n");
		if (getMedecin() instanceof MedecinGeneraliste) {
			sb.append("Le medecin généraliste responsable : ");
			sb.append(affichageSpecifique());
			sb.append("Tarif : ").append(MedecinGeneraliste.getTarif()).append("\n");
		}
		if (getMedecin() instanceof MedecinSpecialiste) {
			sb.append("Le medecin spécialiste responsable : ");
			sb.append(affichageSpecifique());
			MedecinSpecialiste m = (MedecinSpecialiste) getMedecin();
			sb.append("Spécialité : ").append(m.getSpecialite()).append("\n");
			sb.append("Tarif : ").append(m.getTarif()).append("\n");
		}
		return sb.toString();
	}

	private String affichageSpecifique() {
		StringBuilder sb = new StringBuilder();
		sb.append(getMedecin().getNom()).append(" ").append(getMedecin().getPrenom()).append("\n");
		sb.append("Téléphone : ").append(getMedecin().getNumeroDeTelephone()).append("\n");
		if (getMedecin().adresse != null) {
			sb.append(getMedecin().getAdresse().toString());
		}
		return sb.toString();
	}
	
	//ACCESSEURS ET MUTATEURS
	/**
	 * @return the poids
	 */
	public int getPoids() {
		return poids;
	}
	/**
	 * @param poids the poids to set
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}
	/**
	 * @return the taille
	 */
	public int getTaille() {
		return taille;
	}
	/**
	 * @param taille the taille to set
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}
	/**
	 * @return the tension
	 */
	public String getTension() {
		return tension;
	}
	/**
	 * @param tension the tension to set
	 */
	public void setTension(String tension) {
		this.tension = tension;
	}
	/**
	 * @return the oxygenation
	 */
	public int getOxygenation() {
		return oxygenation;
	}
	/**
	 * @param oxygenation the oxygenation to set
	 */
	public void setOxygenation(int oxygenation) {
		this.oxygenation = oxygenation;
	}

	/**
	 * @return the pulsation
	 */
	public int getPulsation() {
		return pulsation;
	}


	/**
	 * @param pulsation the pulsation to set
	 */
	public void setPulsation(int pulsation) {
		this.pulsation = pulsation;
	}


	/**
	 * @return the probleme
	 */
	public String getProbleme() {
		return probleme;
	}
	/**
	 * @param probleme the probleme to set
	 */
	public void setProbleme(String probleme) {
		this.probleme = probleme;
	}
	/**
	 * @return the prescription
	 */
	public String getPrescription() {
		return prescription;
	}
	/**
	 * @param prescription the prescription to set
	 */
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	/**
	 * @return the dateSoin
	 */
	public LocalDate getDateSoin() {
		return dateSoin;
	}
	/**
	 * @param dateSoin the dateSoin to set
	 */
	public void setDateSoin(LocalDate dateSoin) {
		this.dateSoin = dateSoin;
	}
	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}
	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	/**
	 * @return the medecin
	 */
	public Medecin getMedecin() {
		return medecin;
	}
	/**
	 * @param medecin the medecin to set
	 */
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	
}
