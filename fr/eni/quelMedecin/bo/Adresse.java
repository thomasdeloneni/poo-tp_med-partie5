package fr.eni.quelMedecin.bo;

/**
 * Classe modélisant une adresse française en respectant les recommandations de
 * la poste.
 * 
 * @author ENI
 * @version 3.0
 *
 */
public class Adresse {
	//ATTRIBUTS D'INSTANCE
	private String mentionsCompl;
	private int numero;
	private String complNumero;
	private String rue;
	private int cp;
	private String ville;

	//CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de type Adresse
	 * 
	 * @param mentionsCompl - mentions complémentaires éventuelles (comme l’appartement,
	 *            l’étage, l’escalier, « chez… », le bâtiment ou de la résidence)
	 * @param numero - numéro dans la voie
	 * @param complNumero - complément facultatif de numéro tel bis, ter, quater...
	 * @param rue - type de voie (rue, avenue, etc.) et nom de celle-ci
	 * @param cp - code postal
	 * @param ville - nom de la commune
	 */
	public Adresse(String mentionsCompl, int numero, String complNumero, String rue, int cp, String ville) {
		this.setMentionsCompl(mentionsCompl);
		this.setNumero(numero);
		this.setComplNumero(complNumero);
		this.setRue(rue);
		this.setCp(cp);
		this.setVille(ville);
	}

	/**
	 * 
	 * Constructeur : crée une instance de type Adresse
	 * 
	 * @param numero - numéro dans la voie
	 * @param complNumero - complément facultatif de numéro tel bis, ter, quater...
	 * @param rue - type de voie (rue, avenue, etc.) et nom de celle-ci
	 * @param cp - code postal
	 * @param ville - nom de la commune
	 */
	public Adresse(int numero, String complNumero, String rue, int cp, String ville) {
		this(null, numero, complNumero, rue, cp, ville);
	}

	//AUTRES METHODES
	/**
	 * Affiche sur la console sous la forme :
	 * [Complément]
	 * XXbis rue XXXXXXXXX
	 * 00000 XXXXXXXXXXXXX
	 */
	@Deprecated
	public void afficher() {
		if (this.mentionsCompl != null)
			System.out.println(this.getMentionsCompl());
		System.out.printf("%d%s %s%n%05d %s%n", this.getNumero(), this.complNumero != null ? this.getComplNumero() : "", this.getRue(),
				this.getCp(), this.getVille().toUpperCase());
	}

	/**
	 * Formate l'adresse sous la forme :
	 * [Complément]
	 * XXbis rue XXXXXXXXX
	 * 00000 XXXXXXXXXXXXX
	 * Affiche le complément seulement s'il n'est pas null
	 * @return la chaîne de caractères représentant l'adresse 
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this.mentionsCompl != null) {
			sb.append(this.getMentionsCompl()).append("\n");
		}
		sb.append(this.getNumero()).append(this.complNumero != null ? this.getComplNumero() : "");
		sb.append(" ").append(this.getRue()).append("\n");
		sb.append(String.format("%05d", this.getCp())).append(" ").append(this.getVille()).append("\n");
		return sb.toString();
		
	}

	//ACCESSEURS ET MUTATEURS
	/**
	 * Getter pour mentionsCompl
	 * @return les mentions complementaire de l'adresse
	 * @see Adresse#setMentionsCompl(String)
	 */
	public String getMentionsCompl() {
		return mentionsCompl;
	}

	/**
	 * Setter pour mentionsCompl
	 * @param mentionsCompl - les mentions complementaire de l'adresse
	 * @see Adresse#getMentionsCompl()
	 */
	public void setMentionsCompl(String mentionsCompl) {
		this.mentionsCompl = mentionsCompl;
	}

	/**
	 * Getter pour numero
	 * @return le numero de la rue
	 * @see Adresse#setNumero(int)
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Setter pour numero
	 * @param numero - le numero de la rue
	 * @see Adresse#getNumero()
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Getter pour complNumero
	 * @return le complement du numero de la rue
	 * @see Adresse#setComplNumero(String)
	 */
	public String getComplNumero() {
		return complNumero;
	}

	/**
	 * Setter pour complNumero
	 * @param complNumero - le complement du numero de la rue
	 * @see Adresse#getComplNumero()
	 */
	public void setComplNumero(String complNumero) {
		this.complNumero = complNumero;
	}

	/**
	 * Getter pour rue
	 * @return le nom de la rue
	 * @see Adresse#setRue(String)
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Setter pour rue
	 * @param rue - le nom de la rue
	 * @see Adresse#getRue()
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Getter pour cp
	 * @return le code postal
	 * @see Adresse#setCp(int)
	 */
	public int getCp() {
		return cp;
	}

	/**
	 * Setter pour cp
	 * @param cp - le code postal
	 * @see Adresse#getCp()
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}

	/**
	 * Getter pour ville
	 * @return le nom de la ville
	 * @see Adresse#setVille(String)
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter pour ville
	 * @param ville - le nom de la ville
	 * @see Adresse#getVille()
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
}