package com.financeiro.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.financeiro.util.Constantes;

public class Conta {

	private Long idConta;
	
	@NotBlank(message = Constantes.MSG_ERRO_NOME_VAZIO)
	private String nomeConta;
	
	@NotNull(message = Constantes.MSG_ERRO_SALDO_VAZIO)
	private BigDecimal saldo;
	
	private String descricao;
	
	@NotBlank(message = Constantes.MSG_ERRO_DATA_VAZIO)
	private String dataCriacao;
	
	private String saldoFormatado;
	
	@NotNull(message = Constantes.MSG_ERRO_TIPO_CONTA)
	private TipoConta tipoConta;

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getSaldoFormatado() {
		return saldoFormatado;
	}

	public void setSaldoFormatado(String saldoFormatado) {
		this.saldoFormatado = saldoFormatado;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (idConta == null) {
			if (other.idConta != null)
				return false;
		} else if (!idConta.equals(other.idConta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conta [idConta=" + idConta + ", nomeConta=" + nomeConta + ", saldo=" + saldo + ", descricao="
				+ descricao + ", dataCriacao=" + dataCriacao + ", saldoFormatado=" + saldoFormatado + ", tipoConta="
				+ tipoConta + "]";
	}

	
}
