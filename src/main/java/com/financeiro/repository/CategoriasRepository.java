package com.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.entities.CategoriaEntity;

public interface CategoriasRepository extends JpaRepository<CategoriaEntity, Long> {

}
