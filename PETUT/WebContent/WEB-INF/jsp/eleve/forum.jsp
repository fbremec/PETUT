<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel ="stylesheet" href = "/PE2I/css/main.css"/>
		<link rel ="stylesheet" href = "/PE2I/css/forum.css"/>
		<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
		<title>PE2I</title>
	</head>
	<body>
		<div style="position: fixed;width:100%;z-index:10;">
			<div class=enTete>
				<p class="boutonHautBas" id="boutonHautBas">Modules</p>
				<ul class="nav" id="nav">
					<c:forEach var="forum" items="${listeForum}">
						<li class=" partie"><a class="forum" id="forum${forum.id}"><c:out value="${forum.nom}"/></a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="navigation" id="navigation">
				<ul id="context">
					<li class="semestres" id="semestre">
						<form>
							<c:forEach var="semestre" items="${listeSemestre}">
								<input class= "semestre" id = "${semestre.id}" type="radio" name="semestre"><c:out value="S${semestre.numero}"/></>
							</c:forEach>
						</form>
					</li>
				</ul>
			</div>
		</div>
		<div class="conteneurGeneral" id="conteneurGeneral">
			
		</div>
		<script type="text/javascript">
			var idModuleClick;
			$( '.semestre' ).click(function(){
				$('.forum').hide(200);
				$("#navigation").find('li').each(
					function(){
						if(this.id != "semestre"){
							$("#"+this.id).remove();
						}
					}
				)
				idSemestre = this.getAttribute('id');
				if(idSemestre != null){
					$.ajax({
						url : '/PE2I/eleves/forum',
						type : 'POST',
						data : 'idSemestre=' + idSemestre,
						success: function(valeur){
							//listeSemestreCLick.addNumeroSemestre(idSemestre,valeur);
							var listeUes = JSON.parse(valeur);
							for(i = 0; i < listeUes.length; i++){
								var li = $("<li class='parent' id='parent"+i+"'/>");
								var p = $("<p class='ue' id='ue"+i+"'> UE "+listeUes[i].numero + " : " +listeUes[i].libelle+"</p>");
								var div = $("<div class='rubrique' id='rubrique"+i+"'/>");
								var ul = $("<ul id=moduleUe"+i+"></ul>")
								$(li).appendTo($("#context"));
								$(p).appendTo(li);
								$(div).appendTo(li);
								$(ul).appendTo(div);
							}
							for(j = 0; j < listeUes.length; j++){
								for(k=0;k<listeUes[j].l.length;k++){
									var li2 = $("<li class='module' id='module"+listeUes[j].l[k].id+"'><p>"+listeUes[j].l[k].numero+"</p></li>")
									$(li2).appendTo($("#moduleUe"+j));
								}
							}
							$(".module").hide();
							$( '.parent' ).click(function(){
								$(".module").slideUp();
								$("#"+this.id).find('li').each( 
									function(){
										if(($(this)).is(":visible")){
											cacher($(this).attr('id'));
										}else{
											afficher($(this).attr('id'));
										}
										
									}
								)
							});
							function afficher(id){
								$("#"+id).slideDown();
							}
							function cacher(id){
								$("#"+id).slideUp();
							}
							$(".module").click(function(){
								$('.forum').show(200);
								idModuleClick = (this.id).replace('module', '');
								return false;
							});
						},
						dataType : 'text'
					})
				}
			});
			//function ajax pour afficher les sujets d'une mati�re donn�e et d'un forum donn�e
			$( '.forum' ).click(function(){
				slideBarreModule();
				if(idModuleClick != null){
					$.ajax({
						url : '/PE2I/eleves/forum',
						type : 'POST',
						data : 'idModule=' + idModuleClick + '&idForum='+((this.id).replace('forum','')),
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
			var haut = false;
			function slideBarreModule(){
				if(!haut){
					$('#context').slideUp()
					if($('#context').is(':animated')){
						checkAnimate();
					}
					haut = true;
				}else{
					document.getElementById('conteneurGeneral').style.marginLeft="20%";
					document.getElementById('conteneurGeneral').style.width="80%";
					$('#context').slideDown();
					if($('#context').is(':animated')){
						checkAnimate();
					}
					haut = false;
				}
			}	
			function checkAnimate() {
	            if( $( '#context' ).is( ':animated' )) {
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
			$( '#boutonHautBas' ).click(function(){
				slideBarreModule()});
				
			$('.forum').hide();
		</script>
	</body>
</html>