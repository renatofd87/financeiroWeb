package com.financeiro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.financeiro.dto.Conta;
import com.financeiro.service.ContaService;
import com.financeiro.service.TipoContaService;
import com.financeiro.util.Constantes;
import com.financeiro.util.MyFormValidator;

@Controller
@RequestMapping("/conta")
public class ContaController {
	
	
	@Autowired
	private ContaService contaService;
	
	@Autowired
	private TipoContaService tipoContaService;
	
	@RequestMapping
	public ModelAndView pesquisa() {
		ModelAndView mv = new ModelAndView("/conta/ListagemContas");
		
		mv.addObject("contas", contaService.listagemContas());
		
		return mv;
	}
	
	@RequestMapping(Constantes.URL_NOVO)
	public ModelAndView novo(Conta conta) {
		ModelAndView mv = new ModelAndView("/conta/CadastroConta");
		
		mv.addObject("tiposConta", tipoContaService.buscarTudo());
		mv.addObject("conta", conta);
		
		return mv;
	}
	
	@RequestMapping(value = Constantes.URL_NOVO, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Conta conta, BindingResult result, RedirectAttributes attributes) {
		new MyFormValidator().validate(new Object[]{null,conta}, result);
		 
		 if (result.hasErrors()) {
			return novo(conta);
		}
		
		String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
		 
		contaService.salvar(conta, usuario);
		attributes.addFlashAttribute(Constantes.VAR_MENSAGEM, "Conta Salva com Sucesso !!");
		
		return new ModelAndView("redirect:/conta/novo");
	}
	
	@RequestMapping(Constantes.PARAM_CODIGO)
	public ModelAndView visualizar(@PathVariable(Constantes.VAR_CODIGO) Long idconta) {
		ModelAndView mv = new ModelAndView("/conta/CadastroConta");
		
		Conta conta = contaService.buscarPorID(idconta);
		
		mv.addObject("tiposConta", tipoContaService.buscarTudo());
		mv.addObject("conta", conta);
		
		return mv;
		
	}
	
	@RequestMapping("/delete/{idconta}")
	public ModelAndView deletarDespesa(@PathVariable("idconta") Long idconta) {
		System.out.println("VAI DELETAR "+idconta);
		ModelAndView mv = new ModelAndView("/conta/ListagemContas");
		
			contaService.deletarConta(idconta);
			
			mv.addObject("contas", contaService.listagemContas());
			
		return mv;
		
	}
	
}
