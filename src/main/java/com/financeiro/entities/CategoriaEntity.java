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
@Table(name = Constantes.TABLE_CATEGORIAS)
public class CategoriaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcategoria;
	
	private String nomecategoria;
	
	private String descricao;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name = Constantes.NOME_COLUNA_DATA_CRIACAO)
	private Date dataCriacao;

	public Long getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Long idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getNomecategoria() {
		return nomecategoria;
	}

	public void setNomecategoria(String nomecategoria) {
		this.nomecategoria = nomecategoria;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcategoria == null) ? 0 : idcategoria.hashCode());
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
		CategoriaEntity other = (CategoriaEntity) obj;
		if (idcategoria == null) {
			if (other.idcategoria != null)
				return false;
		} else if (!idcategoria.equals(other.idcategoria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoriaEntity [idcategoria=" + idcategoria + ", nomecategoria=" + nomecategoria + ", descricao="
				+ descricao + ", dataCriacao=" + dataCriacao + "]";
	}

}
