package com.financeiro.dto;

import java.math.BigDecimal;
import java.util.List;

public class ContaGeral {
	
	private String saldoatualformatado;
	private BigDecimal saldoatual;
	private List<Conta> contas;
	public String getSaldoatualformatado() {
		return saldoatualformatado;
	}
	public void setSaldoatualformatado(String saldoatualformatado) {
		this.saldoatualformatado = saldoatualformatado;
	}
	public BigDecimal getSaldoatual() {
		return saldoatual;
	}
	public void setSaldoatual(BigDecimal saldoatual) {
		this.saldoatual = saldoatual;
	}
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contas == null) ? 0 : contas.hashCode());
		result = prime * result + ((saldoatual == null) ? 0 : saldoatual.hashCode());
		result = prime * result + ((saldoatualformatado == null) ? 0 : saldoatualformatado.hashCode());
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
		ContaGeral other = (ContaGeral) obj;
		if (contas == null) {
			if (other.contas != null)
				return false;
		} else if (!contas.equals(other.contas))
			return false;
		if (saldoatual == null) {
			if (other.saldoatual != null)
				return false;
		} else if (!saldoatual.equals(other.saldoatual))
			return false;
		if (saldoatualformatado == null) {
			if (other.saldoatualformatado != null)
				return false;
		} else if (!saldoatualformatado.equals(other.saldoatualformatado))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ContaGeral [saldoatualformatado=" + saldoatualformatado + ", saldoatual=" + saldoatual + ", contas="
				+ contas + "]";
	}
	
}
