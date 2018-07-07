package com.financeiro.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.financeiro.util.Constantes;

@Entity
@Table(name = Constantes.TABLE_CONTAS)
public class ContaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idconta;
	
	private String nomeconta;
	
	private BigDecimal saldo;
	
	private String descricao;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name = Constantes.NOME_COLUNA_DATA_CRIACAO)
	private Date dataCriacao;
	
	@OneToOne
	@JoinColumn(name = "idtipoconta")
	private TipoContaEntity tipoConta;

	public Long getIdconta() {
		return idconta;
	}

	public void setIdconta(Long idconta) {
		this.idconta = idconta;
	}

	public String getNomeconta() {
		return nomeconta;
	}

	public void setNomeconta(String nomeconta) {
		this.nomeconta = nomeconta;
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

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public TipoContaEntity getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaEntity tipoConta) {
		this.tipoConta = tipoConta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idconta == null) ? 0 : idconta.hashCode());
		result = prime * result + ((tipoConta == null) ? 0 : tipoConta.hashCode());
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
		ContaEntity other = (ContaEntity) obj;
		if (idconta == null) {
			if (other.idconta != null)
				return false;
		} else if (!idconta.equals(other.idconta))
			return false;
		if (tipoConta == null) {
			if (other.tipoConta != null)
				return false;
		} else if (!tipoConta.equals(other.tipoConta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContaEntity [idconta=" + idconta + ", nomeconta=" + nomeconta + ", saldo=" + saldo + ", descricao="
				+ descricao + ", dataCriacao=" + dataCriacao + ", tipoConta=" + tipoConta + "]";
	}
	
}
