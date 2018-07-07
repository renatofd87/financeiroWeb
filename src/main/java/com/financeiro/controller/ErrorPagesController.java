package com.financeiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financeiro.util.Constantes;

@Controller
public class ErrorPagesController {

	@RequestMapping(Constantes.URL_404)
	public String notFound() {
		return Constantes.URL_ERRO_404;
	}
	
	@RequestMapping(Constantes.URL_403)
	public String forbidden() {
		return Constantes.URL_ERRO_403;
	}
	
	@RequestMapping(Constantes.URL_500)
	public String internalServerError() {
		return Constantes.URL_ERRO_500;
	}
	
}
