package com.financeiro.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financeiro.entities.UsuarioEntity;
import com.financeiro.entities.UsuarioRoleEntity;
import com.financeiro.repository.UsuarioRepository;
import com.financeiro.util.Constantes;


@Service(Constantes.PARAM_USER_DETAIL_SERVICE)
public class UsuarioDetailService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException
		 {

		UsuarioEntity user = usuarioRepository.findByUsuario(username);
		Set<UsuarioRoleEntity> roles = new HashSet<>();
		
		if(user != null){
			roles = user.getUsuariorole();
		}
		List<GrantedAuthority> authorities =
                                      buildUserAuthority(roles);

		return buildUserForAuthentication(user, authorities);

	}

	private User buildUserForAuthentication(UsuarioEntity user,
		List<GrantedAuthority> authorities) {
		return new User(user.getUsuario(), user.getSenha(),
			user.isEnable(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UsuarioRoleEntity> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UsuarioRoleEntity userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}


}