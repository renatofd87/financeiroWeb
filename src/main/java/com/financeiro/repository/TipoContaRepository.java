package com.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.entities.TipoContaEntity;

public interface TipoContaRepository extends JpaRepository<TipoContaEntity, Long> {

}
