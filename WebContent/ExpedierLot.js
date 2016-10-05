$(document).ready(function() {
	$('#ajouter').click(function(){
		var val1=$("#reference").val();
		var  ligne = '<tr>' +
					'<td>'+val1+'</td>' +
					'<td>toto</td>' +
					'<td>36</td>' +
					'<td><a href="#">Edit</a></td>'+
					'<td><a href="#">Delete</a></td>'+
					'</tr>';

		$(ligne).prependTo("#tabArticle");
	});	
	$(document).on("click",'#tabArticle a',function(){
		if($(this).html()=="Edit"){
			var select=$(this).closest("tr").children("td").text();
			alert(select);}
		if($(this).html()=="Delete"){
			$(this).closest("tr").hide('slow');
		}
	});
});