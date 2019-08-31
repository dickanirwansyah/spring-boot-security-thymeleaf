package com.riset.springsecurity.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.riset.springsecurity.entity.Users;
import com.riset.springsecurity.repository.UsersRepository;

@Service
@Transactional
public class CustomeUsersDetailService implements UserDetailsService{

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = usersRepository.findUsersByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("email : "+username+" not found !"));
		return new User(users.getEmail(), users.getPassword(), getAuthorities(users));
	}
	
	private static Collection<? extends GrantedAuthority> getAuthorities(Users users){
		String[] roles = users.getRoles().stream().map((role) -> 
				role.getName()).toArray(String[]::new);
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roles);
		return authorities;
	}
}
