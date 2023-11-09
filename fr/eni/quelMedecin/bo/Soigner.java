package fr.eni.quelMedecin.bo;

/**
 * Interface soigner definissant les comportements de Soigner
 * 
 * @author ENI
 * @version 3.0
 *
 */
public interface Soigner {

	/**
	 * Methode par defaut permettant d'examiner un patient
	 */
	public default void examiner() {
		System.out.println("le medecin procède à des examens de routine sur les patients (auscultation, prise de tensions, ...)");
	}

	/**
	 * Methode par defaut permettant de diagnostiquer un probleme
	 */
	public default void diagnostiquer() {
		System.out.println("le médecin évalue l'etat de santé du patient pour découvrir d'éventuels problèmes");
	}

	/**
	 * Methode par defaut permettant de traiter un probleme
	 */
	public default void traiter() {
		System.out.println("le médecin met en place un traitement adapté");
	}

	/**
	 * Methode par defaut permettantd de conseiller le patient
	 */
	public default void conseiller() {
		System.out.println("le médecin dispense des conseils appropriés pour des habitudes saines (régime, hygiène, etc.)");
	}

	/**
	 * Methode par default permettant d'orienter un patient vers un spécialiste
	 */
	public default void orienter() {
	}

}
