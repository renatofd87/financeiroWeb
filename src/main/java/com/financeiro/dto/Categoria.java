package com.financeiro.dto;

import org.hibernate.validator.constraints.NotBlank;

import com.financeiro.util.Constantes;

public class Categoria {

	private Long idcategoria;
	
	@NotBlank(message = Constantes.MSG_ERRO_NOME_VAZIO)
	private String nomecategoria;
	
	private String descricao;
	
	@NotBlank(message = Constantes.MSG_ERRO_DATA_VAZIO)
	private String datacriacao;

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

	public String getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(String datacriacao) {
		this.datacriacao = datacriacao;
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
		Categoria other = (Categoria) obj;
		if (idcategoria == null) {
			if (other.idcategoria != null)
				return false;
		} else if (!idcategoria.equals(other.idcategoria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [idcategoria=" + idcategoria + ", nomecategoria=" + nomecategoria + ", descricao=" + descricao
				+ ", datacriacao=" + datacriacao + "]";
	}

}
