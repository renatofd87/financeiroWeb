package com.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.entities.ContaEntity;

public interface ContasRepository extends JpaRepository<ContaEntity, Long> {

}
