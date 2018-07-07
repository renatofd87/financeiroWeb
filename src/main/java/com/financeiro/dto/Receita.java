package com.financeiro.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.financeiro.util.Constantes;

public class Receita {

	private Long idReceita;
	
	@NotBlank(message = Constantes.MSG_ERRO_NOME_VAZIO)
	private String nomeReceita;
	
	@NotNull(message = "O Campo Valor não foi Preenchido")
	private BigDecimal valor;
	
	private String descricao;
	
	@NotBlank(message = Constantes.MSG_ERRO_DATA_VAZIO)
	private String dataCriacao;
	
	private String valorFormatado;
	
	@NotNull(message = "O campo Tipo Receita não foi Preechido")
	private TipoReceita tipoReceita;
	
	@NotNull(message = "O campo Conta não foi Preechido")
	private Conta conta;

	public Long getIdReceita() {
		return idReceita;
	}

	public void setIdReceita(Long idReceita) {
		this.idReceita = idReceita;
	}

	public String getNomeReceita() {
		return nomeReceita;
	}

	public void setNomeReceita(String nomeReceita) {
		this.nomeReceita = nomeReceita;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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

	public String getValorFormatado() {
		return valorFormatado;
	}

	public void setValorFormatado(String valorFormatado) {
		this.valorFormatado = valorFormatado;
	}

	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idReceita == null) ? 0 : idReceita.hashCode());
		result = prime * result + ((nomeReceita == null) ? 0 : nomeReceita.hashCode());
		result = prime * result + ((tipoReceita == null) ? 0 : tipoReceita.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		result = prime * result + ((valorFormatado == null) ? 0 : valorFormatado.hashCode());
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
		Receita other = (Receita) obj;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idReceita == null) {
			if (other.idReceita != null)
				return false;
		} else if (!idReceita.equals(other.idReceita))
			return false;
		if (nomeReceita == null) {
			if (other.nomeReceita != null)
				return false;
		} else if (!nomeReceita.equals(other.nomeReceita))
			return false;
		if (tipoReceita == null) {
			if (other.tipoReceita != null)
				return false;
		} else if (!tipoReceita.equals(other.tipoReceita))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (valorFormatado == null) {
			if (other.valorFormatado != null)
				return false;
		} else if (!valorFormatado.equals(other.valorFormatado))
			return false;
		return true;
	}
	
	
}
