package com.financeiro.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.financeiro.util.Constantes;

public class Despesa {

	private Long iddespesa;
	
	@NotBlank(message = Constantes.MSG_ERRO_DATA_VAZIO)
	private String datadespesa;
	
	@NotBlank(message = Constantes.MSG_ERRO_DESCRICAO_VAZIO)
	private String descricao;
	
	@NotNull(message = Constantes.MSG_ERRO_VALOR_VAZIO)
	private BigDecimal valordespesa;
	
	private Conta conta;
	
	private String observacao;
	
	private Categoria categoria;
	
	private String valordespesaformatado;

	private boolean fixa;
	
	private int qtd;
	
	private boolean repetir;
	
	private String periodo;
	
	private boolean pago;

	private int despesaspendentes;
	
	private int despesaspagas;
	
	private int total;
	
	private Long iddespesapai;

	public Long getIddespesa() {
		return iddespesa;
	}

	public void setIddespesa(Long iddespesa) {
		this.iddespesa = iddespesa;
	}

	public String getDatadespesa() {
		return datadespesa;
	}

	public void setDatadespesa(String datadespesa) {
		this.datadespesa = datadespesa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValordespesa() {
		return valordespesa;
	}

	public void setValordespesa(BigDecimal valordespesa) {
		this.valordespesa = valordespesa;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getValordespesaformatado() {
		return valordespesaformatado;
	}

	public void setValordespesaformatado(String valordespesaformatado) {
		this.valordespesaformatado = valordespesaformatado;
	}

	public boolean isFixa() {
		return fixa;
	}

	public void setFixa(boolean fixa) {
		this.fixa = fixa;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public boolean isRepetir() {
		return repetir;
	}

	public void setRepetir(boolean repetir) {
		this.repetir = repetir;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public int getDespesaspendentes() {
		return despesaspendentes;
	}

	public void setDespesaspendentes(int despesaspendentes) {
		this.despesaspendentes = despesaspendentes;
	}

	public int getDespesaspagas() {
		return despesaspagas;
	}

	public void setDespesaspagas(int despesaspagas) {
		this.despesaspagas = despesaspagas;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Long getIddespesapai() {
		return iddespesapai;
	}

	public void setIddespesapai(Long iddespesapai) {
		this.iddespesapai = iddespesapai;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iddespesa == null) ? 0 : iddespesa.hashCode());
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
		Despesa other = (Despesa) obj;
		if (iddespesa == null) {
			if (other.iddespesa != null)
				return false;
		} else if (!iddespesa.equals(other.iddespesa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Despesa [iddespesa=" + iddespesa + ", datadespesa=" + datadespesa + ", descricao=" + descricao
				+ ", valordespesa=" + valordespesa + ", conta=" + conta + ", observacao=" + observacao + ", categoria="
				+ categoria + ", valordespesaformatado=" + valordespesaformatado + ", fixa=" + fixa + ", qtd=" + qtd
				+ ", repetir=" + repetir + ", periodo=" + periodo + ", pago=" + pago + ", despesaspendentes="
				+ despesaspendentes + ", despesaspagas=" + despesaspagas + ", total=" + total + ", iddespesapai="
				+ iddespesapai + "]";
	}

}
