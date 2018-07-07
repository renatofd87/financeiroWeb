package com.financeiro.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.financeiro.util.Constantes;

@Entity
@Table(name = Constantes.TABLE_USUARIOS)
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;
	
	@NotBlank(message = Constantes.MSG_ERRO_NOME_VAZIO)
	private String nomeusuario;
	
	@NotBlank(message = Constantes.MSG_ERRO_USUARIO_VAZIO)
	private String usuario;
	
	@NotNull(message = Constantes.MSG_ERRO_SENHA_VAZIO)
	private String senha;
	
	private boolean enable;
	
	@ElementCollection
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Constantes.COLUNA_IDUSUARIOROLE)
	private Set<UsuarioRoleEntity> usuariorole = new HashSet<UsuarioRoleEntity>(0);

	public UsuarioEntity(Long idusuario, String nomeusuario, String usuario, String senha, boolean enable) {
		super();
		this.idusuario = idusuario;
		this.nomeusuario = nomeusuario;
		this.usuario = usuario;
		this.senha = senha;
		this.enable = enable;
	}

	public UsuarioEntity(Long idusuario, String nomeusuario, String usuario, String senha, boolean enable,
			Set<UsuarioRoleEntity> usuariorole) {
		super();
		this.idusuario = idusuario;
		this.nomeusuario = nomeusuario;
		this.usuario = usuario;
		this.senha = senha;
		this.enable = enable;
		this.usuariorole = usuariorole;
	}

	public UsuarioEntity() {
		super();
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNomeusuario() {
		return nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	
	public Set<UsuarioRoleEntity> getUsuariorole() {
		return usuariorole;
	}
	
	public void setUsuariorole(Set<UsuarioRoleEntity> usuariorole) {
		this.usuariorole = usuariorole;
	}

	@Override
	public String toString() {
		return "UsuarioEntity [idusuario=" + idusuario + ", nomeusuario=" + nomeusuario + ", usuario=" + usuario
				+ ", senha=" + senha + ", enable=" + enable + ", usuariorole=" + usuariorole + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idusuario == null) ? 0 : idusuario.hashCode());
		result = prime * result + ((nomeusuario == null) ? 0 : nomeusuario.hashCode());
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
		UsuarioEntity other = (UsuarioEntity) obj;
		if (idusuario == null) {
			if (other.idusuario != null)
				return false;
		} else if (!idusuario.equals(other.idusuario))
			return false;
		if (nomeusuario == null) {
			if (other.nomeusuario != null)
				return false;
		} else if (!nomeusuario.equals(other.nomeusuario))
			return false;
		return true;
	}
	
}
