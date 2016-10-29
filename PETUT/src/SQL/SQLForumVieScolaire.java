package SQL;

import java.sql.SQLException;
import java.util.*;

import Beans.*;

public class SQLForumVieScolaire extends SQL{
	
	/**
	 * Cr�er une instance de la class SQLForumVieScolaire et la connecte � la base de donn�es
	 */
	public SQLForumVieScolaire(){
		super();
	}
	
	/**
	 * R�cup�re la liste des semestres d'une enseigne donn�
	 * @param idEnseigne identifiant de l'enseigne
	 * @return la liste des semestres en fonction d'une enseigne donn�
	 */
	public List<Semestre> getSemestresByIdEnseigne(int idEnseigne){
		List<Semestre> listeSemestre = new ArrayList<Semestre>();
		try {
			this.setStatement(this.getConnexion().createStatement());
		} catch (SQLException e) {
			System.out.println("erreur dans la cr�ation du statement");
			e.printStackTrace();
		}
		try {
			this.setResultat(this.getStatement().executeQuery("SELECT * FROM SEMESTRE WHERE id_Enseigne = "+idEnseigne+";"));
		} catch (SQLException e) {
			System.out.println("erreur dans l'execution de la requete SQL");
			e.printStackTrace();
		}
		try {
			while ( this.getResultat().next() ) {
				Semestre s = new Semestre(this.getResultat().getInt("id_Semestre"),this.getResultat().getInt("numero"));
				listeSemestre.add(s);
			}
		} catch (SQLException e) {
			System.out.println("erreur dans la recup�ration des donn�es");
			e.printStackTrace();
		}
		return listeSemestre;
	}
	/**
	 * R�cup�re la liste des Ue en fonction d'un identifiant de semestre
	 * @param idSemestre identifiant du semestre
	 * @return la liste des Ue en fonction d'un identifiant de semestre
	 */
	public List<Ue> getUesByIdSemestre(int idSemestre){
		List<Ue> listeUe = new ArrayList<Ue>();
		try {
			this.setStatement(this.getConnexion().createStatement());
		} catch (SQLException e) {
			System.out.println("erreur dans la cr�ation du statement");
			e.printStackTrace();
		}
		try {
			this.setResultat(this.getStatement().executeQuery("SELECT * FROM Ue WHERE id_Semestre = "+idSemestre+";"));
		} catch (SQLException e) {
			System.out.println("erreur dans l'execution de la requete SQL");
			e.printStackTrace();
		}
		try {
			while ( this.getResultat().next() ) {
				Ue ue = new Ue(this.getResultat().getInt("id_Ue"),this.getResultat().getInt("numero"),this.getResultat().getString("libelle"));
				listeUe.add(ue);
			}
		} catch (SQLException e) {
			System.out.println("erreur dans la recup�ration des donn�es");
			e.printStackTrace();
		}
		return this.getModulesByListeUe(listeUe);
	}
	/**
	 * R�cup�re la liste des module d'un Ue donn�
	 * @param listeUe liste des Ue d'un semestre
	 * @return la liste des modules d'un Ue donn�
	 */
	private List<Ue> getModulesByListeUe(List<Ue> listeUe){
		for(int i =0; i<listeUe.size();i++){
			List<Module> listeModule = new ArrayList<Module>();
			try {
				this.setStatement(this.getConnexion().createStatement());
			} catch (SQLException e) {
				System.out.println("erreur dans la cr�ation du statement");
				e.printStackTrace();
			}
			try {
				this.setResultat(this.getStatement().executeQuery("SELECT * FROM Module WHERE id_Ue ="+listeUe.get(i).getId()+";"));
			} catch (SQLException e) {
				System.out.println("erreur dans l'execution de la requete SQL");
				e.printStackTrace();
			}
			try {
				while ( this.getResultat().next() ) {
					Module m = new Module(this.getResultat().getInt("id_Module"),this.getResultat().getString("numero"),this.getResultat().getString("libell�"),this.getResultat().getInt("id_Ue"));
					listeModule.add(m);
				}
			} catch (SQLException e) {
				System.out.println("erreur dans la recup�ration des donn�es");
				e.printStackTrace();
			}
			listeUe.get(i).setL(listeModule);
		}
		return listeUe;
		
	}
	/**
	 * R�cup�re la liste des Sujets d'un module et d'un nom de forum donn�, nomForum E {Cours,Partiels,Travaux Pratique,Travaux Dirig�} pour forum.type = vieScolaire
	 * @param idModule identifiant du module
	 * @param idForum id du forum
	 * @return la liste des Sujets d'un module et d'un nom de forum donn�, nomForum E {Cours,Partiels,Travaux Pratique,Travaux Dirig�} pour forum.type = vieScolaire
	 */
	public List<Sujet> getSujetsByIdModuleAndIdForum(int idModule, int idForum){
		return null;
	}
	/**
	 * R�cup�re la liste des forums de la vie scolaire des �tudiants d'une enseigne donn�e (forum.type = "vieScolaire" in BDD)
	 * @return la liste des forums de la vie scolaire des �tudiants d'une enseigne donn�e
	 */
	public List<Forum> recupererForums(){
		return null;
	}
	/**
	 * R�cup�re la liste des topics d'un sujet donn�
	 * @param s sujet
	 * @return la liste des topics d'un sujet donn�
	 */
	public List<Commentaire> recupererTopics(Sujet s){
		return null;
	}
	
	
	
	
}
