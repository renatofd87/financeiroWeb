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

import com.financeiro.dto.Categoria;
import com.financeiro.service.CategoriaService;
import com.financeiro.util.Constantes;
import com.financeiro.util.MyFormValidator;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping
	public ModelAndView pesquisa() {
		System.out.println("CHEGOU NO PESQUISA");
		ModelAndView mv = new ModelAndView("/categoria/ListagemCategorias");
		
		mv.addObject("categorias", categoriaService.buscarTudo());
		
		return mv;
	}
	
	@RequestMapping(Constantes.URL_NOVO)
	public ModelAndView novo(Categoria categoria) {
		ModelAndView mv = new ModelAndView("/categoria/CadastroCategoria");
		
		mv.addObject("categoria", categoria);
		
		return mv;
	}
	
	@RequestMapping(value = Constantes.URL_NOVO, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		 if (result.hasErrors()) {
			return novo(categoria);
		}
		
		categoriaService.salvar(categoria);
		attributes.addFlashAttribute(Constantes.VAR_MENSAGEM, "Categoria Salva com Sucesso !!");
		
		return new ModelAndView("redirect:/categoria/novo");
	}
	
	@RequestMapping(Constantes.PARAM_CODIGO)
	public ModelAndView visualizar(@PathVariable(Constantes.VAR_CODIGO) Long idcategoria) {
		ModelAndView mv = new ModelAndView("/categoria/CadastroCategoria");
		
		Categoria categoria = categoriaService.buscarPorID(idcategoria);
		
		mv.addObject("categoria", categoria);
		
		return mv;
		
	}
	
	@RequestMapping("/delete/{idcategoria}")
	public ModelAndView deletarDespesa(@PathVariable("idcategoria") Long idcategoria) {
		System.out.println("VAI DELETAR "+idcategoria);
		ModelAndView mv = new ModelAndView("/categoria/ListagemCategorias");
		
			categoriaService.deletarCategoria(idcategoria);
			
			mv.addObject("categorias", categoriaService.buscarTudo());
			
		return mv;
		
	}
	
}
