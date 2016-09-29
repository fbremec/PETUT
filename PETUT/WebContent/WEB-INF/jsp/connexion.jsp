<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PETUT/css/main.css"/>
<link rel ="stylesheet" href = "/PETUT/css/connexion.css"/>	
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="enTete.jsp" />
	<div class="conteneurGeneral">
		<form method="post" action="connexion">
			<div class="radio">
				<input type="radio"  id="case1" class="case" name="id" value="enseignant"><p class="textRadio"> enseignant</p>
				<input type="radio"  id="case2" class="case" name="id" value="eleve"><p class="textRadio"> �l�ve</p>
			</div>
			<br/>
	    	<fieldset>
	        	<legend>Connexion</legend>
	                           
				<label for="nomCompte">Nom de compte<span class="requis"></span></label>
	            <input type="nomCompte" id="connexionNomCompte" name="connexionNomCompte" size="20" maxlength="60" />
	            <span class="erreur">${traitement.erreurs['connexionNomCompte']}</span>
	            <br />
	                
	            <label for="connexionMotdepasse">Mot de passe <span class="requis"></span></label>
	            <input type="password" id="connexionMotdepasse" name="connexionMotdepasse" value="" size="20" maxlength="20" />
	            <span class="erreur">${traitement.erreurs['connexionMotdepasse']}</span>
	            <br />
	                
	            <input type="submit" value="connexion" class="sansLabel" />
	            <br />
	                
	            <!-- <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>-->
	     	</fieldset>
		</form>
	</div>
</body>
</html>