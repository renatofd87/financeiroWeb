package com.financeiro.dto;

import org.hibernate.validator.constraints.NotBlank;

import com.financeiro.util.Constantes;

public class TipoConta {
	
	private Long idTipoConta;
	
	@NotBlank(message = Constantes.MSG_ERRO_TIPO_CONTA)
	private String tipoConta;
	
	@NotBlank(message = Constantes.MSG_ERRO_DATA_VAZIO)
	private String dataCriacao;
	
	private String descricao;

	public Long getIdTipoConta() {
		return idTipoConta;
	}

	public void setIdTipoConta(Long idTipoConta) {
		this.idTipoConta = idTipoConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoConta == null) ? 0 : idTipoConta.hashCode());
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
		TipoConta other = (TipoConta) obj;
		if (idTipoConta == null) {
			if (other.idTipoConta != null)
				return false;
		} else if (!idTipoConta.equals(other.idTipoConta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoConta [idTipoConta=" + idTipoConta + ", tipoConta=" + tipoConta + ", dataCriacao=" + dataCriacao
				+ ", descricao=" + descricao + "]";
	}

}
