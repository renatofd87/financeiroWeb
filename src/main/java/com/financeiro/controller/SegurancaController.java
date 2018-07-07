package com.financeiro.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financeiro.util.Constantes;

@Controller
public class SegurancaController {
	
	@RequestMapping(Constantes.URL_LOGIN)
	public String login(@AuthenticationPrincipal User user) {
		if (user != null) {
			return Constantes.URL_REDIRECT_DESPESA_NOVO;
		}
		
		return Constantes.VAR_LOGIN;
	}
	
}
