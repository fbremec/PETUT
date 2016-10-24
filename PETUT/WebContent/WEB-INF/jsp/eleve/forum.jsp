<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PETUT/css/main.css"/>
<link rel ="stylesheet" href = "/PETUT/css/allSemestres.css"/>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="../../javascript/premierScript.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	<div style="position: fixed;width:100%;z-index:10;">
	<jsp:include page="/WEB-INF/jsp/enTete.jsp"/>
	<div class="navigation" id="navigation">
		<ul>
			<li class="semestre">
				<form>
					<input type="radio" name="semestre" value="0">S1</>
					<input type="radio" name="semestre" value="1">S2</>
					<input type="radio" name="semestre" value="0">S3</>
					<input type="radio" name="semestre" value="1">S4</>
				</form>
			</li>
			<li class="parent" id="parent1"><p class="ue" id="ue1">UE 1</p>
				<div class="rubrique" id="module1">
					<ul >
						<li><p class="module" id="1101" >M1101</p></li>
						<li><p class="module" id="1102">M1102</p></li>
						<li><p class="module">M1103</p></li>
						<li><p class="module">M1104</p></li>
						<li><p class="module">M1105</p></li>
						<li><p class="module">M1106</p></li>
						<li><p class="module">M1107</p></li>
					</ul>
				</div>
			</li>
			
			<li class="parent" id="parent2"><p class="ue" id="ue2">UE 2</p>
				<div class="rubrique" id="module2">
					<ul>
						<li><p class="module">M1201</p></li>
						<li><p class="module">M1202</p></li>
						<li><p class="module">M1203</p></li>
						<li><p class="module">M1204</p></li>
						<li><p class="module">M1205</p></li>
						<li><p class="module">M1206</p></li>
						<li><p class="module">M1207</p></li>
					</ul>
				</div>
			</li>
			
		</ul>
		
	</div>
	
	<div class="arborescence" style="display:inline-block;">
		<ul>
			<li class="parent" id="parent1"><p class="ue" id="ue1">UE 1</p>
				<div class="rubrique" id="module1">
					<ul >
						<li><p class="module" id="1101" >M1101</p></li>
						<li><p class="module" id="1102">M1102</p></li>
						<li><p class="module">M1103</p></li>
						<li><p class="module">M1104</p></li>
						<li><p class="module">M1105</p></li>
						<li><p class="module">M1106</p></li>
						<li><p class="module">M1107</p></li>
					</ul>
				</div>
			</li>
			
			<li class="parent" id="parent2"><p class="ue" id="ue2">UE 2</p>
				<div class="rubrique" id="module2">
					<ul>
						<li><p class="module">M1201</p></li>
						<li><p class="module">M1202</p></li>
						<li><p class="module">M1203</p></li>
						<li><p class="module">M1204</p></li>
						<li><p class="module">M1205</p></li>
						<li><p class="module">M1206</p></li>
						<li><p class="module">M1207</p></li>
					</ul>
				</div>
			</li>
		</ul>
	</div>
	<div class="conteneurGeneral" id="conteneurGeneral">
		<div class="tableauTopic">
			<div style="position:relative;display:inline-block">
				<table id="listeSujet">
					<tr>
						<td>Question</td>
						<td>Auteur</td>
						<td>Date de publication</td>
					</tr>
					
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
		
		
		$( '#boutonHautBas' ).click(function(){
			slideUp()});
		
		$( '#parent1' ).click(function(){
			sildeModule1()});
		$( '#parent2' ).click(function(){
			sildeModule2()});
		
		
		var idModule = null;
		$( '.module' ).click(function(){
			idModule = this.getAttribute('id');
			slideUp();
		});
		
		
		//function ajax pour afficher les sujets d'une mati�re donn�e et d'un forum donn�e
		$( '.forum' ).click(function(){
			if(idModule != null){
				$.ajax({
					url : '/PETUT/eleves/forum',
					type : 'POST',
					data : 'idModule=' + idModule + '&idForum='+this.getAttribute('id'),
					success : function(valeur){
						$('.sujet').remove();
						var listeSujets = JSON.parse(valeur);
						//identifiant = identifiant du sujet se trouvant dans la listeSujets.id
						var tr = $('<tr class="sujet" id=""/>');
						$(tr).appendTo($("#listeSujet"));
						var tdQuestion = $('<td/>');
						var tdAuteur = $('<td/>');
						var tdDate = $('<td/>');
						tdQuestion.text("quel est le resultat de la requete");
						tdAuteur.text("Bremec Florian");
						tdDate.text("14/05/2016");
						$(tdQuestion).appendTo(tr);
						$(tdAuteur).appendTo(tr);
						$(tdDate).appendTo(tr);
				    },
					dataType : 'text'
				});
			}
		});
		
		
		
		
		
		
		
	</script>
</body>
</html>