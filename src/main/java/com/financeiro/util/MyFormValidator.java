package com.financeiro.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.financeiro.dto.Despesa;

public class MyFormValidator implements Validator{

@Override
public boolean supports(Class<?> clazz) {
    return Despesa.class.equals(clazz);
}

@Override
public void validate(Object obj, Errors errors) {
	Object[] objs = (Object[])obj;
    Despesa despesa = (Despesa)objs[0];
    System.out.println("VALIDADOR ::::::::::::::: "+despesa);
    
	if(despesa != null && despesa.getCategoria() != null && despesa.getCategoria().getIdcategoria() == null){
		errors.rejectValue(Constantes.VAR_CATEGORIA, Constantes.MSG_PROPERTIE_DESPESA_CATEGORIA_VAZIO);
	}
	
	if(despesa != null && despesa.getConta() != null && despesa.getConta().getIdConta() == null){
		errors.rejectValue(Constantes.VAR_CONTA, Constantes.MSG_PROPERTIE_DESPESA_CONTA_VAZIO);
	}
	
	if(despesa != null && despesa.getValordespesa() != null && despesa.getValordespesa().toString().equals(Constantes.VAR_VALORDESPESA_ZERADO)){
		errors.rejectValue(Constantes.VAR_VALORDESPESA, Constantes.MSG_PROPERTIE_DESPESA_VALOR_VAZIO);
	}
	
}

}
