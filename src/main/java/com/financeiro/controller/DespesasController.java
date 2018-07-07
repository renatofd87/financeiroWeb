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

import com.financeiro.dto.Despesa;
import com.financeiro.dto.Periodos;
import com.financeiro.service.CategoriaService;
import com.financeiro.service.ContaService;
import com.financeiro.service.DespesaService;
import com.financeiro.util.Constantes;
import com.financeiro.util.MyFormValidator;

@Controller
@RequestMapping(Constantes.URL_DESPESA)
public class DespesasController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private DespesaService despesaService;
	
	@Autowired
	private ContaService contaService;
	
	@RequestMapping
	public ModelAndView pesquisa() {
		ModelAndView mv = new ModelAndView(Constantes.URL_LISTAGEM_DESPESA);
		
		mv.addObject(Constantes.VAR_DESPESAS, despesaService.buscarTudo());
		
		return mv;
	}
	
	@RequestMapping(value="ListagemDespesas/{mes}/{ano}")
	public ModelAndView buscaDespesaPorMes(@PathVariable("mes") Long mes, @PathVariable("ano") Long ano) {
		ModelAndView mv = new ModelAndView("/despesa/ListagemDespesas");
		String nomeusuario = SecurityContextHolder.getContext().getAuthentication().getName();
        
		mv.addObject(Constantes.VAR_DESPESAS, despesaService.buscarDespesasPorMesAno(mes, ano, nomeusuario));
		return mv;
	}
	
	@RequestMapping(Constantes.URL_NOVO)
	public ModelAndView novo(Despesa despesa) {
		ModelAndView mv = new ModelAndView(Constantes.URL_CADASTRO_DESPESA);
		
		mv.addObject(Constantes.VAR_CATEGORIAS, categoriaService.buscarTudo());
		mv.addObject(Constantes.VAR_CONTAS, contaService.buscarTudo());
		mv.addObject(Constantes.VAR_DESPESA, despesa);
		mv.addObject(Constantes.VAR_PERIODOS, Periodos.values());
		
		return mv;
	}
	
	@RequestMapping(value = Constantes.URL_NOVO, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Despesa despesa, BindingResult result, RedirectAttributes attributes) {
		new MyFormValidator().validate(new Object[]{despesa, null}, result);
		 
		 if (result.hasErrors()) {
			return novo(despesa);
		}
		
		String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
		 
		despesaService.salvar(despesa, usuario);
		attributes.addFlashAttribute(Constantes.VAR_MENSAGEM, Constantes.MSG_SUCESSO_DESPESA_SALVAR);
		
		return new ModelAndView(Constantes.URL_REDIRECT_DESPESA_NOVO);
	}
	
	@RequestMapping(Constantes.PARAM_CODIGO)
	public ModelAndView visualizar(@PathVariable(Constantes.VAR_CODIGO) Long iddespesa) {
		ModelAndView mv = new ModelAndView(Constantes.URL_CADASTRO_DESPESA);
		
		Despesa despesa = despesaService.buscarPorID(iddespesa);
		
		mv.addObject(Constantes.VAR_CATEGORIAS, categoriaService.buscarTudo());
		mv.addObject(Constantes.VAR_CONTAS, contaService.buscarTudo());
		mv.addObject(Constantes.VAR_PERIODOS, Periodos.values());
		mv.addObject(Constantes.VAR_DESPESA, despesa);
		
		return mv;
		
	}
	
	@RequestMapping("/delete/{parametro}")
	public ModelAndView deletarDespesa(@PathVariable("parametro") String parametro) {
		System.out.println("VAI DELETAR "+parametro);
		ModelAndView mv = new ModelAndView("/despesa/ListagemDespesas");
		String[] params = parametro.split("&");
		
		if(params.length > 0){
			Long iddespesa = Long.parseLong(params[0]);
			Long mes = Long.parseLong(params[1]); 
			Long ano = Long.parseLong(params[2]); 
			
			despesaService.deletarDespesa(iddespesa);
			
			String nomeusuario = SecurityContextHolder.getContext().getAuthentication().getName();
			
			mv.addObject(Constantes.VAR_DESPESAS, despesaService.buscarDespesasPorMesAno(mes, ano, nomeusuario));
		}
		return mv;
		
	}
	
}
