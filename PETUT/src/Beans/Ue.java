package Beans;

import java.util.List;

public class Ue {
	
	private int id;
	private int numero;
	private String libelle;
	private Semestre s;
	private Enseigne e;
	private List<Module> l;
	
	public Ue(int id, int numero, String libelle) {
		super();
		this.id = id;
		this.numero = numero;
		this.libelle = libelle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Semestre getS() {
		return s;
	}
	public void setS(Semestre s) {
		this.s = s;
	}
	public Enseigne getE() {
		return e;
	}
	public void setE(Enseigne e) {
		this.e = e;
	}
	public List<Module> getL() {
		return l;
	}
	public void setL(List<Module> l) {
		this.l = l;
	}
	

}
