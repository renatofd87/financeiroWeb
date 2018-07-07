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
  
  function removerMascaraDinheiro(){
	  valor  = $("#valorMostrar").val();
	  valor1 = valor.split("R$")[1].trim();

	  if(valor1.indexOf(".") != -1){
	     console.log("Existe Ponto");
	     valor2 = valor1.replace(".","").replace(",",".");
	      $("#valor").val(valor2);
	  }else{
	     valor3 =  valor1.replace(",",".");
	      $("#valor").val(valor3);
	  }
  }
  
  $(document).ready(function () {
	  $(".repeticaoDiv").hide();
	  $("#personalisado").hide();
	  $("#valorMostrar").val($("#valor").val());
	  
	  $(function(){
		  $("#valorMostrar").maskMoney({symbol:'R$ ', 
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
  });
  
  $(window).load(function() {
	  $("#valorMostrar").maskMoney('mask', 1999.99);
	  $("#valorMostrarLista").maskMoney('mask', 1999.99);
  })

