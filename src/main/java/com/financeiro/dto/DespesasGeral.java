package com.financeiro.dto;

import java.math.BigDecimal;
import java.util.List;

public class DespesasGeral {

	private String despesaspendentes;
	private String despesaspagas;
	private String total;
	private List<Despesa> listadespesas;
	public String getDespesaspendentes() {
		return despesaspendentes;
	}
	public void setDespesaspendentes(String despesaspendentes) {
		this.despesaspendentes = despesaspendentes;
	}
	public String getDespesaspagas() {
		return despesaspagas;
	}
	public void setDespesaspagas(String despesaspagas) {
		this.despesaspagas = despesaspagas;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<Despesa> getListadespesas() {
		return listadespesas;
	}
	public void setListadespesas(List<Despesa> listadespesas) {
		this.listadespesas = listadespesas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((despesaspagas == null) ? 0 : despesaspagas.hashCode());
		result = prime * result + ((despesaspendentes == null) ? 0 : despesaspendentes.hashCode());
		result = prime * result + ((listadespesas == null) ? 0 : listadespesas.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		DespesasGeral other = (DespesasGeral) obj;
		if (despesaspagas == null) {
			if (other.despesaspagas != null)
				return false;
		} else if (!despesaspagas.equals(other.despesaspagas))
			return false;
		if (despesaspendentes == null) {
			if (other.despesaspendentes != null)
				return false;
		} else if (!despesaspendentes.equals(other.despesaspendentes))
			return false;
		if (listadespesas == null) {
			if (other.listadespesas != null)
				return false;
		} else if (!listadespesas.equals(other.listadespesas))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DespesasGeral [despesaspendentes=" + despesaspendentes + ", despesaspagas=" + despesaspagas + ", total="
				+ total + ", listadespesas=" + listadespesas + "]";
	}
	
}
