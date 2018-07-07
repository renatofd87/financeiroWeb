package com.financeiro.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.dto.TipoConta;
import com.financeiro.entities.TipoContaEntity;
import com.financeiro.repository.TipoContaRepository;
import com.financeiro.util.Constantes;

@Service
public class TipoContaService {

	@Autowired
	private TipoContaRepository tipoContaRepo;
	
	
	public void salvar(TipoConta categoriaDTO) {
		// Escrever regras de negócio...
		this.tipoContaRepo.save(toTipoContaEntity(categoriaDTO));
	}
	
	public List<TipoConta> buscarTudo(){
		List<TipoContaEntity> listaTipoConta = tipoContaRepo.findAll();
		List<TipoConta> tipoContaDTO = new ArrayList<>();
		
		for(TipoContaEntity categ:listaTipoConta){
			tipoContaDTO.add(toTipoContaDTO(categ));
		}
		
		return tipoContaDTO;
	}

	private TipoConta toTipoContaDTO(TipoContaEntity tipoContaEntity) {
		TipoConta tipoContaDTO = new TipoConta();
		SimpleDateFormat format = new SimpleDateFormat(Constantes.CONFIG_DATA_DIA_MES_ANO);
		
		if(tipoContaDTO != null){
			tipoContaDTO.setIdTipoConta(tipoContaEntity.getIdTipoConta());
			tipoContaDTO.setDescricao(tipoContaEntity.getDescricao());
			tipoContaDTO.setIdTipoConta(tipoContaEntity.getIdTipoConta());
			tipoContaDTO.setTipoConta(tipoContaEntity.getTipoConta());
			if(tipoContaEntity.getDataCriacao() != null){
				tipoContaDTO.setDataCriacao(format.format(tipoContaEntity.getDataCriacao()));
			}
		}
		
		return tipoContaDTO;
	}
	
	private TipoContaEntity toTipoContaEntity(TipoConta tipoContaDTO) {
		TipoContaEntity categoriaEntity = new TipoContaEntity();
		SimpleDateFormat format = new SimpleDateFormat(Constantes.CONFIG_DATA_DIA_MES_ANO);
		
		if(tipoContaDTO != null){
			categoriaEntity.setIdTipoConta(tipoContaDTO.getIdTipoConta());
			categoriaEntity.setDescricao(tipoContaDTO.getDescricao());
			categoriaEntity.setTipoConta(tipoContaDTO.getTipoConta());
			if(tipoContaDTO.getDataCriacao() != null){
				try {
					categoriaEntity.setDataCriacao(format.parse(tipoContaDTO.getDataCriacao()));
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
	
	public TipoConta buscarPorID(Long idTipoConta) {
		TipoConta tipoConta = new TipoConta();
		
		if(idTipoConta != null){
			tipoConta = toTipoContaDTO(tipoContaRepo.findOne(idTipoConta));
		}
		
		return tipoConta;
	}
	
	public void deletarTipoConta(Long idTipoConta) {
		if(idTipoConta != null){
			TipoContaEntity tipoContaEntity = new TipoContaEntity();
			
			tipoContaEntity = tipoContaRepo.findOne(idTipoConta);
			
			if(tipoContaEntity != null && tipoContaEntity.getIdTipoConta() != null){
				tipoContaRepo.delete(tipoContaEntity);
			}
			
		}
		
	}
}
