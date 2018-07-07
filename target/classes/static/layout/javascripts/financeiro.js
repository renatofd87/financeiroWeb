  $(function() {
    $( "#datepicker" ).datepicker({
	    dateFormat: 'dd/mm/yy',
	    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
	    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
	    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
	    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
	    nextText: 'Próximo',
	    prevText: 'Anterior'
	});
  });
  
  function repeticao(){
	  if($(".ui-spinner.ui-corner-all.ui-widget.ui-widget-content").hide()){
			$(".ui-spinner.ui-corner-all.ui-widget.ui-widget-content").show();
			$("#personalisado").hide();
			$("#spinner").val("");
		}
  }
  
  function salvarDespesa(){
	  removerMascaraDinheiroDespesa();
  }
  
  function salvarConta(){
	  removerMascaraDinheiroConta();
  }
  
  function removerMascaraDinheiroDespesa(){
	  valor  = $("#valorMostrar").val();
	  valor1 = valor.split("R$")[1].trim();

	  if(valor1.indexOf(".") != -1){
	     valor2 = valor1.replace(".","").replace(",",".");
	      $("#valor").val(valor2);
	  }else{
	     valor3 =  valor1.replace(",",".");
	      $("#valor").val(valor3);
	  }
  }
  
  function removerMascaraDinheiroConta(){
	  valor  = $("#saldoMostrar").val();
	  valor1 = 'R$ 0,00';
	  
	  if(valor != ''){
	  	valor1 = valor.split("R$")[1].trim();
  	  }else{
  		valor1 = valor1.split("R$")[1].trim();  
  	  }
	  
	  if(valor1.indexOf(".") != -1){
	     valor2 = valor1.replace(".","").replace(",",".");
	      $("#saldo").val(valor2);
	  }else{
	     valor3 =  valor1.replace(",",".");
	      $("#saldo").val(valor3);
	  }
  }
  
  function mostraMes(mes){
	  switch (mes) { 
	  	case 1: 
	  		$("#mes").html("Janeiro");
	  		$("#mes").attr("mes", mes);
	  		break;
	  	case 2: 
	  		$("#mes").html("Fevereiro");
	  		$("#mes").attr("mes", mes);
	  		break;
	  	case 3: 
	  		$("#mes").html("Março");
	  		$("#mes").attr("mes", mes);
	  		break;		
	  	case 4: 
	  		$("#mes").html("Abril");
	  		$("#mes").attr("mes", mes);
	  		break;
	  	case 5: 
	  		$("#mes").html("Maio");
	  		$("#mes").attr("mes", mes);
	  		break;
	  	case 6: 
	  		$("#mes").html("junho");
	  		$("#mes").attr("mes", mes);
	  		break;
	  	case 7: 
	  		$("#mes").html("Julho");
	  		$("#mes").attr("mes", mes);
	  		break;
	  	case 8: 
	  		$("#mes").html("Agosto");
	  		$("#mes").attr("mes", mes);
	  		break;
	  	case 9: 
	  		$("#mes").html("Setembro");
	  		$("#mes").attr("mes", mes);
	  		break;
	  	case 10: 
	  		$("#mes").html("Outubro");
	  		$("#mes").attr("mes", mes);
	  		break;
	  	case 11: 
	  		$("#mes").html("Novembro");
	  		$("#mes").attr("mes", mes);
	  		break;
	  	case 12: 
	  		$("#mes").html("Dezembro");
	  		$("#mes").attr("mes", mes);
	  		break;
	  	default:
	  		alert('Erro ao Encontrar Mês');
	  }
  }

  
  $(document).ready(function () {
	  $(".repeticaoDiv").hide();
	  $("#personalisado").hide();
	  $("#valorMostrar").val($("#valor").val());
	  $("#saldoMostrar").val($("#saldo").val());
	  
	  var data = new Date;
	  var mes = data.getMonth()+1;
	  var ano = data.getFullYear();
	  $("#ano").html(ano);
	  
	  $("#ListagemDespesas").attr('href', '/despesa/ListagemDespesas/'+mes+'/'+ano);
	  
	  mostraMes(mes);
	  
	  $(function(){
		  $("#valorMostrar").maskMoney({symbol:'R$ ', 
		 showSymbol:true, thousands:'.', decimal:',', symbolStay: true});
		  $("#saldoMostrar").maskMoney({symbol:'R$ ', 
				 showSymbol:true, thousands:'.', decimal:',', symbolStay: true});
	  })
	  
	  
	  $("#spinner").spinner({
		  min:0,
	   	  max:0
	  });
	  
	  $("#fixa"). click(function () {
		    if($("#fixa").is(":checked")){
		    	$('#repeticao' ).prop("checked" , false)
		    	$(".repeticaoDiv").hide();
		    }
		  
		});
	  
	  $("#repeticao"). click(function () {
		    if($("#repeticao").is(":checked")){
		    	$(".repeticaoDiv").show();
		    	$('#fixa' ).prop("checked" , false)
		    }else{
		    	$(".repeticaoDiv").hide();
		    }
		  
	  });
	  
	  $('#repetir').on('change', function() {
			if($('#repetir option:selected').text() == 'Selecione o Periodo'){
				repeticao();
				$("#spinner").spinner({
			    	min:0,
			   		max:0
			    });
			}
			if($('#repetir option:selected').text() == 'Diário'){
				repeticao();
			    $("#spinner").spinner({
			    	min:1,
			   		max:31
			    });
			}
			if($('#repetir option:selected').text() == 'Mensal'){
				repeticao();
				$("#spinner").spinner({
			    	min:1,
			   		max:12
			    });
			}
			if($('#repetir option:selected').text() == 'Semanal'){
				repeticao();
				$("#spinner").spinner({
			    	min:1,
			   		max:7
			    });
			}
			if($('#repetir option:selected').text() == 'Anual'){
				repeticao();
				$("#spinner").spinner({
			    	min:1,
			   		max:20
			    });
			}
			if($('#repetir option:selected').text() == 'Personalisado'){
				$(".ui-spinner.ui-corner-all.ui-widget.ui-widget-content").hide();
				 $("#personalisado").show();
			}
		});
	  
	    $("#anterior"). click(function () {
	    	var mes = $("#mes").attr("mes");
	    	var ano = $("#ano").html();
	    	
	    	if(mes != 1){
	    		mes = mes - 1;
	    	}else{
	    		$("#mes").attr("mes", 12);
	    		mes = 12;
	    		ano = ano - 1;
	    		$("#ano").html(ano);
	    	}
	    	mostraMes(mes);
	    	
	    	var url = '/despesa/ListagemDespesas/'+mes+'/'+ano;
	    	$.ajax({
			      url: url,
			      type: 'get',
			      data: {},
			      success: function(response) {
			       var tabela = $(response).find('#tabela-despesas').html();
			       var despesaspendentes = $(response).find('#despesaspendentes').html();
			       var despesaspagas = $(response).find('#despesaspagas').html();
			       var total = $(response).find('#total').html();
			       
			       $("#tabela-despesas").html(tabela);
			       
			       $("#despesaspendentes").html(despesaspendentes);
			       $("#despesaspagas").html(despesaspagas);
			       $("#total").html(total);
			      }
			  });
		  });
	    $("#proximo"). click(function () {
	    	var mes = $("#mes").attr("mes");
	    	var ano = $("#ano").html();
	    	
	    	if(mes != 12){
	    		mes =  parseInt(mes) + parseInt(1);
	    	}else{
	    		$("#mes").attr("mes", 1);
	    		mes = 1;
	    		ano = parseInt(ano) + parseInt(1);
	    		$("#ano").html(ano);
	    	}
	    	mostraMes(mes);
	    	
	    	var url = '/despesa/ListagemDespesas/'+mes+'/'+ano;
	    	$.ajax({
			      url: url,
			      type: 'get',
			      data: {},
			      success: function(response) {
			       var tabela = $(response).find('#tabela-despesas').html();
			       var despesaspendentes = $(response).find('#despesaspendentes').html();
			       var despesaspagas = $(response).find('#despesaspagas').html();
			       var total = $(response).find('#total').html();
			       
			       $("#tabela-despesas").html(tabela);
			       
			       $("#despesaspendentes").html(despesaspendentes);
			       $("#despesaspagas").html(despesaspagas);
			       $("#total").html(total);
			      }
			  });
		  });
  });

  $(window).load(function() {
	  $("#valorMostrar").maskMoney('mask', 1999.99);
	  $("#saldoMostrar").maskMoney('mask', 1999.99);
	  $("#valorMostrarLista").maskMoney('mask', 1999.99);
	  
	  if($("#repeticao").is(":checked")){
		  $(".repeticaoDiv").show();
	  }
  });
  
  $( function() {
	    // run the currently selected effect
	    function runEffect() {
	    	console.log("RUN EFFECT");
	      // Most effect types need no options passed by default
	      var options = {};
	 
	      // Run the effect
	      $( "#menu" ).show( "blind", options, 500, null );
	      console.log("PASSOU");
	    };
	    
	    function removeEffect() {
	        // Most effect types need no options passed by default
	        var options = {};
	   
	        // Run the effect
	        $( "#menu" ).effect( "blind", options, 500, callback );
	      };
	      
	      // Callback function to bring a hidden box back
	      function callback() {
	        setTimeout(function() {
	          
	        }, 1000 );
	      };
	   
	      
	    // Set effect from select menu value
	    $( "#botaoMenu" ).on( "click", function() {
    	if($("#menu").is( ":visible" )){
    		removeEffect();
    		console.log('Esta Visivel');
    	}else{
    		runEffect();
    	}
	      
	    });
	 
	  } );
  function deletarDespesa(iddespesa){
	  var ano = $("#ano").html();
	  var mes = $("#mes").attr("mes");
	  $( "#dialog-confirm" ).dialog({
	      resizable: false,
	      height: "auto",
	      width: 400,
	      modal: true,
	      buttons: {
	        "Excluir": function() {
	        	var url = '/despesa/delete/'+iddespesa+'&'+mes+'&'+ano;
	         	$.ajax({
				      url: url,
				      type: 'get',
				      data: {},
				      success: function(response) {
				    	  var tabela = $(response).find('#tabela-despesas').html();
				    	  $( "#dialog-confirm" ).dialog( "close" );
				    	  $("#tabela-despesas").html(tabela);
				      }
				  });
	        },
	        "Cancelar": function() {
	          $( this ).dialog( "close" );
	        }
	      }
	    });
  }
  
  function deletarConta(idconta){
	  $( "#dialog-confirm-conta" ).dialog({
	      resizable: false,
	      height: "auto",
	      width: 400,
	      modal: true,
	      buttons: {
	        "Excluir": function() {
	        	var url = '/conta/delete/'+idconta;
	         	$.ajax({
				      url: url,
				      type: 'get',
				      data: {},
				      success: function(response) {
				    	  var tabela = $(response).find('#tabela-contas').html();
				    	  var valoratual = $(response).find('#saldoatualgreen').html();
				    	  
				    	  $( "#dialog-confirm-conta" ).dialog( "close" );
				    	  $("#tabela-contas").html(tabela);
				    	  
				    	  $("#saldoatualred").html(valoratual);
				    	  $("#saldoatualgreen").html(valoratual);
				      }
				  });
	        },
	        "Cancelar": function() {
	          $( this ).dialog( "close" );
	        }
	      }
	    });
  }
  
  function deletarCategoria(idcategoria){
	  $( "#dialog-confirm-categoria" ).dialog({
	      resizable: false,
	      height: "auto",
	      width: 400,
	      modal: true,
	      buttons: {
	        "Excluir": function() {
	        	var url = '/categoria/delete/'+idcategoria;
	         	$.ajax({
				      url: url,
				      type: 'get',
				      data: {},
				      success: function(response) {
				    	  var tabela = $(response).find('#tabela-categorias').html();
				    	  $("#dialog-confirm-categoria" ).dialog( "close" );
				    	  $("#tabela-categorias").html(tabela);
				      },
				      error: function(response) {				    	  
				    	  $("#dialog-confirm-categoria" ).dialog( "close" );
				    	  $( "#dialog-categoria-usando" ).dialog({
				    	      resizable: false,
				    	      height: "auto",
				    	      width: 400,
				    	      modal: true,
				    	      buttons: {
				    	    	     "OK": function() {
				    	   	          $( this ).dialog( "close" );
				    	   	        }
				    	      }
				    	  });
				      }
				  });
	        },
	        "Cancelar": function() {
	          $( this ).dialog( "close" );
	        }
	      }
	    });
  }
  
  function deletarTipoConta(idTipoConta){
	  $( "#dialog-confirm-tipoConta" ).dialog({
	      resizable: false,
	      height: "auto",
	      width: 400,
	      modal: true,
	      buttons: {
	        "Excluir": function() {
	        	var url = '/tipoconta/delete/'+idTipoConta;
	         	$.ajax({
				      url: url,
				      type: 'get',
				      data: {},
				      success: function(response) {
				    	  var tabela = $(response).find('#tabela-tiposConta').html();
				    	  $("#dialog-confirm-tipoConta" ).dialog( "close" );
				    	  $("#tabela-tiposConta").html(tabela);
				      },
				      error: function(response) {				    	  
				    	  $("#dialog-confirm-tipoConta" ).dialog( "close" );
				    	  $( "#dialog-tipoConta-usando" ).dialog({
				    	      resizable: false,
				    	      height: "auto",
				    	      width: 400,
				    	      modal: true,
				    	      buttons: {
				    	    	     "OK": function() {
				    	   	          $( this ).dialog( "close" );
				    	   	        }
				    	      }
				    	  });
				      }
				  });
	        },
	        "Cancelar": function() {
	          $( this ).dialog( "close" );
	        }
	      }
	    });
  }
  
  function mostraModalFixa(){
	  console.log('terrgt');
	  $( "#dialog-fixa" ).dialog({
	      resizable: false,
	      height: "auto",
	      width: 400,
	      modal: true,
	      buttons: {
	        "Excluir": function() {
	        	var url = '/despesa/delete/'+iddespesa+'&'+mes+'&'+ano;
	         	$.ajax({
				      url: url,
				      type: 'get',
				      data: {},
				      success: function(response) {
				    	  var tabela = $(response).find('#tabela-despesas').html();
				    	  $( "#dialog-confirm" ).dialog( "close" );
				    	  $("#tabela-despesas").html(tabela);
				      }
				  });
	        },
	        "Cancelar": function() {
	          $( this ).dialog( "close" );
	        }
	      }
	    });
  }