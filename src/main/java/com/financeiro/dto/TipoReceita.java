package com.financeiro.dto;

public class TipoReceita {
	
	private Long idTipoReceita;
	
	private String tipoReceita;
	
	private String datacriacao;
	
	private String descricao;

	public Long getIdTipoReceita() {
		return idTipoReceita;
	}

	public void setIdTipoReceita(Long idTipoReceita) {
		this.idTipoReceita = idTipoReceita;
	}

	public String getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public String getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(String datacriacao) {
		this.datacriacao = datacriacao;
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
		result = prime * result + ((idTipoReceita == null) ? 0 : idTipoReceita.hashCode());
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
		TipoReceita other = (TipoReceita) obj;
		if (idTipoReceita == null) {
			if (other.idTipoReceita != null)
				return false;
		} else if (!idTipoReceita.equals(other.idTipoReceita))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoReceita [idTipoReceita=" + idTipoReceita + ", tipoReceita=" + tipoReceita + ", datacriacao="
				+ datacriacao + ", descricao=" + descricao + "]";
	}
	
}
