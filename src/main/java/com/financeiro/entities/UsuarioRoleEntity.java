package com.financeiro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.financeiro.util.Constantes;

@Entity
@Table(name = Constantes.TABLE_USUARIO_ROLES)
public class UsuarioRoleEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuariorole;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = Constantes.COLUNA_IDUSUARIOROLE, nullable = false, insertable = false, updatable = false)
	private UsuarioEntity usuario;
	
	private String role;

	public UsuarioRoleEntity() {
	}

	public UsuarioRoleEntity(UsuarioEntity usuario, String role) {
		this.usuario = usuario;
		this.role = role;
	}
	
	public Integer getIdusuariorole() {
		return idusuariorole;
	}

	public void setIdusuariorole(Integer idusuariorole) {
		this.idusuariorole = idusuariorole;
	}

	public UsuarioEntity getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	@Column(name = "role", nullable = false, length = 45)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idusuariorole == null) ? 0 : idusuariorole.hashCode());
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
		UsuarioRoleEntity other = (UsuarioRoleEntity) obj;
		if (idusuariorole == null) {
			if (other.idusuariorole != null)
				return false;
		} else if (!idusuariorole.equals(other.idusuariorole))
			return false;
		return true;
	}

	
	
	

}