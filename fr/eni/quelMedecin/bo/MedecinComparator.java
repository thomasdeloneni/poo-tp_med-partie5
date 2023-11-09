package fr.eni.quelMedecin.bo;

import java.util.Comparator;

public class MedecinComparator implements Comparator<MedecinSpecialiste> {

	/**
	 * Methode permettant de comparer sur la specialite
	 */
	@Override
	public int compare(MedecinSpecialiste m1, MedecinSpecialiste m2) {
		return m1.getSpecialite().compareTo(m2.getSpecialite());
	}

}
