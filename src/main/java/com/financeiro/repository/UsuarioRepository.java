package com.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	UsuarioEntity findByUsuario(String usuario);

}
