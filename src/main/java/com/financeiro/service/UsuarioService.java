package com.financeiro.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;

import com.financeiro.entities.UsuarioEntity;
import com.financeiro.repository.UsuarioRepository;

public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public UsuarioEntity getAllUsuarios(){
		return usuarioRepository.findAll().get(BigInteger.ZERO.intValue()); 
	}
	
}
