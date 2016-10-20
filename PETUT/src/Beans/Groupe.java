package Beans;
import java.util.*;

public class Groupe {

	private String id;
	private String libelle;
	private List<Eleve> compositionGroupe;
	
	public Groupe(String id, String libelle, List<Eleve> compositionGroupe) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.compositionGroupe = compositionGroupe;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Eleve> getCompositionGroupe() {
		return compositionGroupe;
	}

	public void setCompositionGroupe(List<Eleve> compositionGroupe) {
		this.compositionGroupe = compositionGroupe;
	}
	
	
}
