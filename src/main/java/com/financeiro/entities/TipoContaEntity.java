package com.financeiro.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.financeiro.util.Constantes;

@Entity
@Table(name = Constantes.TABLE_TIPO_CONTA)
public class TipoContaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Constantes.NOME_COLUNA_ID_TIPO_CONTA)
	private Long idTipoConta;
	
	@Column(name = Constantes.NOME_COLUNA_TIPO_CONTA)
	private String tipoConta;
	
	@Column(name = Constantes.NOME_COLUNA_DATA_CRIACAO)
	@Temporal(value=TemporalType.DATE)
	private Date dataCriacao;
	
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

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
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
		TipoContaEntity other = (TipoContaEntity) obj;
		if (idTipoConta == null) {
			if (other.idTipoConta != null)
				return false;
		} else if (!idTipoConta.equals(other.idTipoConta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoContaEntity [idTipoConta=" + idTipoConta + ", tipoConta=" + tipoConta + ", dataCriacao="
				+ dataCriacao + ", descricao=" + descricao + "]";
	}

}
