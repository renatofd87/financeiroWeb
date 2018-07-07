package com.financeiro.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.dto.Categoria;
import com.financeiro.entities.CategoriaEntity;
import com.financeiro.repository.CategoriasRepository;
import com.financeiro.util.Constantes;

@Service
public class CategoriaService {

	@Autowired
	private CategoriasRepository categorias;
	
	
	public void salvar(Categoria categoriaDTO) {
		// Escrever regras de negócio...
		System.out.println("categoriaDTO "+categoriaDTO);
		this.categorias.save(toCategoriaEntity(categoriaDTO));
	}
	
	public List<Categoria> buscarTudo(){
		List<CategoriaEntity> listaCategoria = categorias.findAll();
		List<Categoria> categoriasDTO = new ArrayList<>();
		
		for(CategoriaEntity categ:listaCategoria){
			categoriasDTO.add(toCategoriaDTO(categ));
		}
		
		return categoriasDTO;
	}

	private Categoria toCategoriaDTO(CategoriaEntity categ) {
		Categoria categoriaDTO = new Categoria();
		SimpleDateFormat format = new SimpleDateFormat(Constantes.CONFIG_DATA_DIA_MES_ANO);
		
		if(categ != null){
			categoriaDTO.setDescricao(categ.getDescricao());
			categoriaDTO.setIdcategoria(categ.getIdcategoria());
			categoriaDTO.setNomecategoria(categ.getNomecategoria());
			if(categ.getDataCriacao() != null){
				categoriaDTO.setDatacriacao(format.format(categ.getDataCriacao()));
			}
		}
		
		return categoriaDTO;
	}
	
	private CategoriaEntity toCategoriaEntity(Categoria categDTO) {
		CategoriaEntity categoriaEntity = new CategoriaEntity();
		SimpleDateFormat format = new SimpleDateFormat(Constantes.CONFIG_DATA_DIA_MES_ANO);
		
		if(categDTO != null){
			categoriaEntity.setDescricao(categDTO.getDescricao());
			categoriaEntity.setNomecategoria(categDTO.getNomecategoria());
			if(categDTO.getDatacriacao() != null){
				try {
					categoriaEntity.setDataCriacao(format.parse(categDTO.getDatacriacao()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				categoriaEntity.setDataCriacao(null);
			}
		}
		System.out.println("RETORNO "+categoriaEntity);
		return categoriaEntity;
	}
	
	public Categoria buscarPorID(Long idCategoria) {
		Categoria categoria= new Categoria();
		
		if(idCategoria != null){
			categoria = toCategoriaDTO(categorias.findOne(idCategoria));
		}
		
		return categoria;
	}
	
	public void deletarCategoria(Long idCategoria) {
		if(idCategoria != null){
			System.out.println("CHEGOU DELETAR CATEGORIA");
			CategoriaEntity categoriaEntity = new CategoriaEntity();
			
			categoriaEntity = categorias.findOne(idCategoria);
			
			if(categoriaEntity != null && categoriaEntity.getIdcategoria() != null){
				categorias.delete(categoriaEntity);
			}
			
		}
		
	}
}
