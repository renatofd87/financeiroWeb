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

import com.financeiro.dto.Receita;
import com.financeiro.util.Constantes;
import com.financeiro.util.MyFormValidator;

@Controller
@RequestMapping("/receita")
public class ReceitaController {
	
	
	@Autowired
//	private ReceitaService receitaService;
	
	@RequestMapping
	public ModelAndView pesquisa() {
		System.out.println("CHEGOU NO PESQUISA");
		ModelAndView mv = new ModelAndView("/receita/ListagemReceitas");
		
//		mv.addObject("receitas", receitaService.listagemReceitas());
		
		return mv;
	}
	
	@RequestMapping(Constantes.URL_NOVO)
	public ModelAndView novo(Receita receita) {
		ModelAndView mv = new ModelAndView("/receita/CadastroReceita");
		
		mv.addObject("receita", receita);
		
		return mv;
	}
	
	@RequestMapping(value = Constantes.URL_NOVO, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Receita receita, BindingResult result, RedirectAttributes attributes) {
		new MyFormValidator().validate(new Object[]{null,receita}, result);
		 
		 if (result.hasErrors()) {
			return novo(receita);
		}
		
		String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
		 
//		receitaService.salvar(receita, usuario);
		attributes.addFlashAttribute(Constantes.VAR_MENSAGEM, "Receita Salva com Sucesso !!");
		
		return new ModelAndView("redirect:/receita/novo");
	}
	
	@RequestMapping(Constantes.PARAM_CODIGO)
	public ModelAndView visualizar(@PathVariable(Constantes.VAR_CODIGO) Long idreceita) {
		ModelAndView mv = new ModelAndView("/receita/CadastroReceita");
		
//		Receita receita = receitaService.buscarPorID(idreceita);
		
//		mv.addObject("receita", receita);
		
		return mv;
		
	}
	
	@RequestMapping("/delete/{idreceita}")
	public ModelAndView deletarDespesa(@PathVariable("idreceita") Long idreceita) {
		System.out.println("VAI DELETAR "+idreceita);
		ModelAndView mv = new ModelAndView("/receita/ListagemReceitas");
		
//			receitaService.deletarReceita(idreceita);
//			
//			mv.addObject("receitas", receitaService.listagemReceitas());
			
		return mv;
		
	}
	
}
