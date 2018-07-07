package com.financeiro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.financeiro.dto.TipoConta;
import com.financeiro.service.TipoContaService;
import com.financeiro.util.Constantes;

@Controller
@RequestMapping("/tipoconta")
public class TipoContaController {
	
	
	@Autowired
	private TipoContaService tipoContaService;
	
	@RequestMapping
	public ModelAndView pesquisa() {
		System.out.println("CHEGOU NO PESQUISA");
		ModelAndView mv = new ModelAndView("/tipoconta/ListagemTipoConta");
		
		mv.addObject("tiposConta", tipoContaService.buscarTudo());
		
		return mv;
	}
	
	@RequestMapping(Constantes.URL_NOVO)
	public ModelAndView novo(TipoConta tipoConta) {
		ModelAndView mv = new ModelAndView("/tipoconta/CadastroTipoConta");
		
		mv.addObject("tipoConta", tipoConta);
		
		return mv;
	}
	
	@RequestMapping(value = Constantes.URL_NOVO, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid TipoConta tipoConta, BindingResult result, RedirectAttributes attributes) {
		 if (result.hasErrors()) {
			return novo(tipoConta);
		}
		
		tipoContaService.salvar(tipoConta);
		attributes.addFlashAttribute(Constantes.VAR_MENSAGEM, "Tipo de Conta Salva com Sucesso !!");
		
		return new ModelAndView("redirect:/tipoconta/novo");
	}
	
	@RequestMapping(Constantes.PARAM_CODIGO)
	public ModelAndView visualizar(@PathVariable(Constantes.VAR_CODIGO) Long idtipoConta) {
		ModelAndView mv = new ModelAndView("/tipoconta/CadastroTipoConta");
		
		TipoConta tipoConta = tipoContaService.buscarPorID(idtipoConta);
		
		mv.addObject("tipoConta", tipoConta);
		
		return mv;
		
	}
	
	@RequestMapping("/delete/{idtipoConta}")
	public ModelAndView deletarDespesa(@PathVariable("idtipoConta") Long idtipoConta) {
		System.out.println("VAI DELETAR "+idtipoConta);
		ModelAndView mv = new ModelAndView("/tipoconta/ListagemTipoConta");
		
			tipoContaService.deletarTipoConta(idtipoConta);
			
			mv.addObject("tiposConta", tipoContaService.buscarTudo());
			
		return mv;
		
	}
	
}
