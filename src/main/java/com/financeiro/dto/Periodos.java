package com.financeiro.dto;

public enum Periodos {

	MENSAL("Mensal"), DIARIO("Diário"), SEMANAL("Semanal"), ANUAL("Anual"), PERSONALISADO("Personalisado");

	private String descricao;

	Periodos(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
