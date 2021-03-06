package SQL;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Beans.Utilisateur;



public class SQLInfoUtilisateur extends SQL{

	public SQLInfoUtilisateur() {
		super();
	}
	

	public Utilisateur getUtilisateurByIdUtilisateur( String id_Utilisateur ) {
		Utilisateur utilisateur = null;
		System.out.println(id_Utilisateur);
		try {
			this.setPreparedStatement( (PreparedStatement) this.getConnexion().prepareStatement("SELECT u.id_Utilisateur, u.Nom, u.Prenom, u.DateNaissance, u.Adresse, u.Code_Postal, u.Ville, u.Telephone, u.Adresse_Mail, g.Libelle, s.Numero, u.TypeU,u.MotDepasse "
																			       			 + "FROM Utilisateur AS u, Groupe AS g, Semestre AS s "
																			       			 + "WHERE u.id_Groupe = g.id_Groupe "
																			       			 + "AND g.id_Semestre = s.id_Semestre "
																			       			 + "AND id_Utilisateur = ?;")); 
        } catch ( SQLException e ) {
            System.out.println( "Erreur dans la cr�ation du statement getUtilisateurByIdUtilisateur()" );
            e.printStackTrace();
        }
        try {
        	this.getPreparedStatement().setString(1,id_Utilisateur);
        } catch ( SQLException e ) {
            System.out.println( "Erreur dans l'execution de la requete SQL getUtilisateurByIdUtilisateur()" );
            e.printStackTrace();
        }
        
        try {
        	this.setResultat(this.getPreparedStatement().executeQuery());
        	this.getResultat().next();
            utilisateur = new Utilisateur( this.getResultat().getString( 1 ), //identifiant
            							   this.getResultat().getString( 2 ), //nom
            							   this.getResultat().getString(3),   //prenom
            							   this.getResultat().getString(13),							//mdp
            							   new SimpleDateFormat("dd/MM/yyyy").format(this.getResultat().getDate(4)), //datenaissance
            							   this.getResultat().getString( 5 ),	//adresse
            							   this.getResultat().getInt( 6 ), 	//codepostal
            							   this.getResultat().getString( 7 ),	//ville
            							   " ",								//photo
            							   this.getResultat().getInt( 8 ),	//telephone
            							   this.getResultat().getString( 9 ), //adressemail
            							   this.getResultat().getString(12),//type
            							   this.getResultat().getString( 10 ),//groupe
            							   this.getResultat().getInt( 11 )); 	//semestre

        } catch ( SQLException e ) {
            System.out.println( "Erreur dans la recup�ration des donn�es getUtilisateurByIdUtilisateur()" );
            e.printStackTrace();

        }   
        return utilisateur;

        
	}
	
	public Utilisateur getUtilisateurByNom( String nom ) {
		Utilisateur utilisateur = null;
		System.out.println(nom);
		try {
			this.setPreparedStatement( (PreparedStatement) this.getConnexion().prepareStatement("SELECT u.id_Utilisateur, u.Nom, u.Prenom, u.DateNaissance, u.Adresse, u.Code_Postal, u.Ville, u.Telephone, u.Adresse_Mail, g.Libelle, s.Numero, u.TypeU,u.MotDepasse "
																			       			 + "FROM Utilisateur AS u, Groupe AS g, Semestre AS s "
																			       			 + "WHERE u.id_Groupe = g.id_Groupe "
																			       			 + "AND g.id_Semestre = s.id_Semestre "
																			       			 + "AND (Nom = ? OR id_Utilisateur = ?);")); 
        } catch ( SQLException e ) {
            System.out.println( "Erreur dans la cr�ation du statement getUtilisateurByIdUtilisateur()" );
            e.printStackTrace();
        }
        try {
        	this.getPreparedStatement().setString(1,nom);
        	this.getPreparedStatement().setString(2,nom);
        } catch ( SQLException e ) {
            System.out.println( "Erreur dans l'execution de la requete SQL getUtilisateurByIdUtilisateur()" );
            e.printStackTrace();
        }
        
        try {
        	this.setResultat(this.getPreparedStatement().executeQuery());
        	this.getResultat().next();
            utilisateur = new Utilisateur( this.getResultat().getString( 1 ), //identifiant
            							   this.getResultat().getString( 2 ), //nom
            							   this.getResultat().getString(3),   //prenom
            							   this.getResultat().getString(13),							//mdp
            							   new SimpleDateFormat("dd/MM/yyyy").format(this.getResultat().getDate(4)), //datenaissance
            							   this.getResultat().getString( 5 ),	//adresse
            							   this.getResultat().getInt( 6 ), 	//codepostal
            							   this.getResultat().getString( 7 ),	//ville
            							   " ",								//photo
            							   this.getResultat().getInt( 8 ),	//telephone
            							   this.getResultat().getString( 9 ), //adressemail
            							   this.getResultat().getString(12),//type
            							   this.getResultat().getString( 10 ),//groupe
            							   this.getResultat().getInt( 11 )); 	//semestre

        } catch ( SQLException e ) {
            System.out.println( "Erreur dans la recup�ration des donn�es getUtilisateurByIdUtilisateur()" );
            e.printStackTrace();

        }   
        return utilisateur;
}
	
	public List<Utilisateur> getListUtilisateurs( String nom ) {
		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
		System.out.println(nom);
		try {
			this.setPreparedStatement( (PreparedStatement) this.getConnexion().prepareStatement("SELECT u.id_Utilisateur, u.Nom, u.Prenom, u.DateNaissance, u.Adresse, u.Code_Postal, u.Ville, u.Telephone, u.Adresse_Mail, g.Libelle, s.Numero, u.TypeU,u.MotDepasse "
																			       			 + "FROM Utilisateur AS u, Groupe AS g, Semestre AS s "
																			       			 + "WHERE u.id_Groupe = g.id_Groupe "
																			       			 + "AND g.id_Semestre = s.id_Semestre "
																			       			 + "AND (Nom = ? OR id_Utilisateur = ?);")); 
        } catch ( SQLException e ) {
            System.out.println( "Erreur dans la cr�ation du statement getUtilisateurByIdUtilisateur()" );
            e.printStackTrace();
        }
        try {
        	this.getPreparedStatement().setString(1,nom);
        	this.getPreparedStatement().setString(2,nom);
        } catch ( SQLException e ) {
            System.out.println( "Erreur dans l'execution de la requete SQL getUtilisateurByIdUtilisateur()" );
            e.printStackTrace();
        }
        
        try {
        	this.setResultat(this.getPreparedStatement().executeQuery());
        	while(this.getResultat().next()){
        		Utilisateur utilisateur = new Utilisateur( this.getResultat().getString( 1 ), //identifiant
						   this.getResultat().getString( 2 ), //nom
						   this.getResultat().getString(3),   //prenom
						   this.getResultat().getString(13),							//mdp
						   new SimpleDateFormat("dd/MM/yyyy").format(this.getResultat().getDate(4)), //datenaissance
						   this.getResultat().getString( 5 ),	//adresse
						   this.getResultat().getInt( 6 ), 	//codepostal
						   this.getResultat().getString( 7 ),	//ville
						   " ",								//photo
						   this.getResultat().getInt( 8 ),	//telephone
						   this.getResultat().getString( 9 ), //adressemail
						   this.getResultat().getString(12),//type
						   this.getResultat().getString( 10 ),//groupe
						   this.getResultat().getInt( 11 )); 	//semestre
        		listeUtilisateurs.add(utilisateur);
        	}
            

        } catch ( SQLException e ) {
            System.out.println( "Erreur dans la recup�ration des donn�es getUtilisateurByIdUtilisateur()" );
            e.printStackTrace();

        }   
        return listeUtilisateurs;
}
	}
