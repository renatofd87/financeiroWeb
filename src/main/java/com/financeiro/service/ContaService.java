package com.financeiro.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.dto.Conta;
import com.financeiro.dto.ContaGeral;
import com.financeiro.dto.TipoConta;
import com.financeiro.entities.ContaEntity;
import com.financeiro.entities.TipoContaEntity;
import com.financeiro.repository.ContasRepository;
import com.financeiro.util.Constantes;
import com.financeiro.util.Moeda;

@Service
public class ContaService {

	@Autowired
	private ContasRepository contas;
	
	
	public void salvar(Conta conta, String usuario) {
		
		this.contas.save(toContaEntity(conta));
	}
	
	public List<Conta> buscarTudo(){
		List<ContaEntity> listaConta = contas.findAll();
		
		List<Conta> contasDTO = new ArrayList<>();
		
		for(ContaEntity categ:listaConta){
			contasDTO.add(toContaDTO(categ));
		}
		
		return contasDTO;
	}
	
	public ContaGeral listagemContas(){
		List<ContaEntity> listaConta = contas.findAll();
		ContaGeral geral = new ContaGeral();
		
		List<Conta> contas = new ArrayList<>();
		BigDecimal saldoAtual = BigDecimal.ZERO;
		
		for(ContaEntity conta:listaConta){
			saldoAtual = saldoAtual.add(conta.getSaldo());
			contas.add(toContaDTO(conta));
		}
		
		geral.setContas(contas);
		geral.setSaldoatualformatado(Moeda.mascaraDinheiro(saldoAtual, Moeda.DINHEIRO_REAL));
		geral.setSaldoatual(saldoAtual);
		
		return geral;
	}

	private Conta toContaDTO(ContaEntity contaEntity) {
		Conta conta = new Conta();
		SimpleDateFormat format = new SimpleDateFormat(Constantes.CONFIG_DATA_DIA_MES_ANO);
		
		if(contaEntity != null){
			conta.setDescricao(contaEntity.getDescricao());
			conta.setIdConta(contaEntity.getIdconta());
			conta.setNomeConta(contaEntity.getNomeconta());
			conta.setSaldo(contaEntity.getSaldo());
			conta.setSaldoFormatado(Moeda.mascaraDinheiro(contaEntity.getSaldo(), Moeda.DINHEIRO_REAL));
			conta.setDataCriacao(format.format(contaEntity.getDataCriacao()));
			
			TipoConta tipoConta = new TipoConta();
			tipoConta.setDataCriacao(format.format(contaEntity.getTipoConta().getDataCriacao()));
			tipoConta.setDescricao(contaEntity.getTipoConta().getDescricao());
			tipoConta.setIdTipoConta(contaEntity.getTipoConta().getIdTipoConta());
			tipoConta.setTipoConta(contaEntity.getTipoConta().getTipoConta());
			
			conta.setTipoConta(tipoConta);
		}
		
		return conta;
	}
	
	private ContaEntity toContaEntity(Conta conta) {
		ContaEntity contaEntity = new ContaEntity();
		SimpleDateFormat format = new SimpleDateFormat(Constantes.CONFIG_DATA_DIA_MES_ANO);
		
		if(conta != null){
			contaEntity.setDescricao(conta.getDescricao());
			contaEntity.setIdconta(conta.getIdConta());
			contaEntity.setNomeconta(conta.getNomeConta());
			contaEntity.setSaldo(conta.getSaldo());
			if(conta.getDataCriacao() != null){
				try {
					contaEntity.setDataCriacao(format.parse(conta.getDataCriacao()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				contaEntity.setDataCriacao(null);
			}
			
			TipoContaEntity tipoContaEntity = new TipoContaEntity();
			if(conta.getTipoConta().getDataCriacao() != null){
				try {
					tipoContaEntity.setDataCriacao(format.parse(conta.getTipoConta().getDataCriacao()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				tipoContaEntity.setDataCriacao(null);
			}
			
			tipoContaEntity.setDescricao(conta.getTipoConta().getDescricao());
			tipoContaEntity.setIdTipoConta(conta.getTipoConta().getIdTipoConta());
			tipoContaEntity.setTipoConta(conta.getTipoConta().getTipoConta());
			
			contaEntity.setTipoConta(tipoContaEntity);
		}
		
		return contaEntity;
	}
	
	public Conta buscarPorID(Long idconta) {
		Conta contaDTO = new Conta();
		
		if(idconta != null){
			contaDTO = toContaDTO(contas.findOne(idconta));
		}
		
		return contaDTO;
	}

	public void deletarConta(Long idconta) {
		if(idconta != null){
			ContaEntity contaEntity = new ContaEntity();
			
			contaEntity = contas.findOne(idconta);
			
			if(contaEntity != null && contaEntity.getIdconta() != null){
				contas.delete(contaEntity);
			}
			
		}
		
	}
}
