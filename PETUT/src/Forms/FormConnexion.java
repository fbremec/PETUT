package Forms;


import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import SQL.*;



public class FormConnexion {
	
	private static final String CHAMP_ID    = "connexionIdentifiant";
    private static final String CHAMP_PASS   = "connexionMotdepasse";
    private Map<String, String> erreurs      = new HashMap<String, String>();
    
    public int connexionUtilisateur( HttpServletRequest request ) throws Exception {
        
    	String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String identifiant = getValeurChamp( request, CHAMP_ID );
        boolean valideId;
        boolean valideMotdepasse;
        int id = 0;
        SQLConnexion sql = new SQLConnexion();
        valideId = sql.validerId(identifiant);
		if(!valideId){
			this.setErreur(CHAMP_ID, "Email invalide");
			throw new Exception("Email invalide");
		}
		valideMotdepasse = sql.validerMotPasse(identifiant, motDePasse);
		if(!valideMotdepasse){
			this.setErreur(CHAMP_PASS, "Mot de passe invalide");
			throw new Exception("Mot de passe invalide");
		}
        id = sql.recupererIdUtilisateur(identifiant);
        sql.disconnect();
        return id;
        
    }
    
    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }

}
