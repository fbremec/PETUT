package Beans;
import java.util.*;

public class Groupe {

	private String id;
	private String libelle;
	private List<Eleve> compositionGroupe;
	private int numeroSemestre;
	
	public Groupe(String id, String libelle, List<Eleve> compositionGroupe, int s) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.compositionGroupe = compositionGroupe;
		this.numeroSemestre = s;
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
	public Integer getS() {
		return numeroSemestre;
	}
	public void setNumeroSemestre(int s) {
		this.numeroSemestre = s;
	}
	
	
	
	
}