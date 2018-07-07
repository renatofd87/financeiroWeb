package com.financeiro.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.financeiro.util.Constantes;

@Entity
@Table(name = Constantes.TABLE_DESPESAS)
public class DespesaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddespesa;
	
	@Temporal(value=TemporalType.DATE)
	private Date datadespesa;
	
	private String descricao;
	
	private BigDecimal valordespesa;
	
	@OneToOne
	@JoinColumn(name = Constantes.COLUNA_IDCONTA)
	private ContaEntity conta;
	
	private String observacao;
	
	@OneToOne
	@JoinColumn(name = Constantes.COLUNA_IDCATEGORIA)
	private CategoriaEntity categoria;
	
	@Transient
	private String url;
	
	private boolean fixa;
	
	private int qtd;
	
	private boolean repetir;
	
	private String periodo;
	
	private boolean pago;
	
	@OneToOne
	@JoinColumn(name = "idusuario")
	private UsuarioEntity usuario;
	
	private int iddespesapai;

	public Long getIddespesa() {
		return iddespesa;
	}

	public void setIddespesa(Long iddespesa) {
		this.iddespesa = iddespesa;
	}

	public Date getDatadespesa() {
		return datadespesa;
	}

	public void setDatadespesa(Date datadespesa) {
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

	public ContaEntity getConta() {
		return conta;
	}

	public void setConta(ContaEntity conta) {
		this.conta = conta;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public int getIddespesapai() {
		return iddespesapai;
	}

	public void setIddespesapai(int iddespesapai) {
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
		DespesaEntity other = (DespesaEntity) obj;
		if (iddespesa == null) {
			if (other.iddespesa != null)
				return false;
		} else if (!iddespesa.equals(other.iddespesa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DespesaEntity [iddespesa=" + iddespesa + ", datadespesa=" + datadespesa + ", descricao=" + descricao
				+ ", valordespesa=" + valordespesa + ", conta=" + conta + ", observacao=" + observacao + ", categoria="
				+ categoria + ", url=" + url + ", fixa=" + fixa + ", qtd=" + qtd + ", repetir=" + repetir + ", periodo="
				+ periodo + ", pago=" + pago + ", usuario=" + usuario + ", iddespesapai=" + iddespesapai + "]";
	}

	
}
