package Beans;

public class Eleve {
	
	private int id;
	private String nom;
	private String adresse;
	private String telephone;
	private String mailPerso;
	private String mdp;
	private String mailSite;
	
	public Eleve(int id, String nom, String adresse, String telephone, String mailPerso, String mdp, String mailSite) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.mailPerso = mailPerso;
		this.mdp = mdp;
		this.mailSite = mailSite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMailPerso() {
		return mailPerso;
	}

	public void setMailPerso(String mailPerso) {
		this.mailPerso = mailPerso;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getMailSite() {
		return mailSite;
	}

	public void setMailSite(String mailSite) {
		this.mailSite = mailSite;
	}
	
	
	
	
}
