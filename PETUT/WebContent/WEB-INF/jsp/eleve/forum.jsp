<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PETUT/css/main.css"/>
<link rel ="stylesheet" href = "/PETUT/css/allSemestres.css"/>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	<div style="position: fixed;width:100%;z-index:10;">
	<jsp:include page="/WEB-INF/jsp/enTete.jsp"/>
	<div class="navigation" id="navigation">
		<ul id="context">
			<li class="semestres">
				<form>
					<c:forEach var="semestre" items="${listeSemestre}">
						<input class= "semestre" id = "${semestre.id}" type="radio" name="semestre"><c:out value="S${semestre.numero}"/></>
					</c:forEach>
				</form>
			</li>
			<!-- ><li class="parent" id="parent1"><p class="ue" id="ue1">UE 1</p>
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
			</li>-->
			
		</ul>
		
	</div>
	
	<div class="arborescence" style="display:inline-block;">
		<!-- <ul>
			<li class="dossier" onclick='slideDossier(this,"dossier")'> TP1: Machine virtuelle linux
				<ul>
					<li class="sousDossier"> Comment on fait ?</li>
				</ul>
			</li>
			<li class="dossier"> TP2: serveur virtuelle
				<ul>
					<li class="sousDossier"> Ca marche pas</li>
				</ul>
			</li>
		</ul>-->
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
		
		var haut = false
		function slideUp(){
			if(!haut){
				$('#navigation').slideUp()
				if($('#navigation').is(':animated')){
					checkAnimate();
				}
				haut = true;
			}else{
				document.getElementById('conteneurGeneral').style.marginLeft="20%";
				document.getElementById('conteneurGeneral').style.width="80%";
				$('#navigation').slideDown();
				haut = false;
			}
		}
				
		function checkAnimate() {
            if( $( '#navigation' ).is( ':animated' )) {
                setTimeout(function() {
                    checkAnimate();
                }, 0 );
            }else{
            	if(haut){
            		document.getElementById('conteneurGeneral').style.marginLeft="0%";
            		document.getElementById('conteneurGeneral').style.width="100%";
            	}	
            }
        }
		
		
		
		var hautModule1 = true;
		function sildeModule1(){
			if(!hautModule2){
				$("#module1").slideUp();
				hautModule2=true;
			}
			if(hautModule1){
				$("#module0").slideDown();
				hautModule1=false;
				
			}else{
				$("#module0").slideUp();
				hautModule1=true;
			}
		}
		
		var hautModule2 = true;
		function sildeModule2(){
			if(!hautModule1){
				$("#module0").slideUp();
				hautModule1=true;
			}
			if(hautModule2){
				$("#module1").slideDown();
				hautModule2=false;
				
			}else{
				$("#module1").slideUp();
				hautModule2=true;
			}
		}
		
		function slideDosier(nom,numero,nombrePere){
			for(var i = 1; i<nombrePere+1;i++){
				$(nom+i).slideUp();
			}
			if(!$(nom+numero).is(":visible"))
				$(nom+numero).slideDown();
		}
		
		$( '#boutonHautBas' ).click(function(){
			slideUp()});
		
		$( '#parent0' ).click(function(){
			alert("je suis la");
			sildeModule1()});
		$( '#parent1' ).click(function(){
			sildeModule2()});
		
		
		var idModule = null;
		$( '.module' ).click(function(){
			idModule = this.getAttribute('id');
			slideUp();
		});
		$( '.semestre' ).click(function(){
			idSemestre = this.getAttribute('id');
			if(idSemestre != null){
				$.ajax({
					url : '/PETUT/eleves/forum',
					type : 'POST',
					data : 'idSemestre=' + idSemestre,
					success: function(valeur){
						var listeContext = JSON.parse(valeur);
						var listeUes = listeContext[0];
						var listeModules = listeContext[1];
						for(i = 0; i < listeUes.length; i++){
							var li = $("<li class='parent' id='parent"+i+"'/>");
							var p = $("<p class='ue' id='ue"+i+"'> UE "+listeUes[i].numero + " : " +listeUes[i].libelle+"</p>");
							var div = $("<div class='rubrique' id='module"+i+"'/>");
							var ul = $("<ul id=moduleUe"+i+"></ul>")
							$(li).appendTo($("#context"));
							$(p).appendTo(li);
							$(div).appendTo(li);
							$(ul).appendTo(div);
							
						}
						for(j = 0; j < listeModules.length; j++){
							var li2 = $("<li><p class='module'>"+listeModules[j].numero+"</p></li>")
							$(li2).appendTo($("#moduleUe0"))
						}
						
						
						
					},
					dataType : 'text'
				})
			}
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
		
		$( '.sousDossier').slideUp();
		
		
		function slideDossier(dossierClicker,nom){
			
			$(nom).slideUp();
		
			if(!$(dossierClicker).is(":visible"))
				$(dossierClicker).slideDown();
		}
		
			
		
	</script>
</body>
</html>