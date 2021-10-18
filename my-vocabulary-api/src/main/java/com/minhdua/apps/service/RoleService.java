package com.minhdua.apps.service;

import com.minhdua.apps.document.Role;
import com.minhdua.apps.dto.RoleDto;
import com.minhdua.apps.repository.RoleReactiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class RoleService extends BaseService<Role, RoleDto, RoleReactiveRepository> {

	@Autowired
	RoleReactiveRepository repository;

	public Mono<Role> findByFullName(String fullName) {
		return repository.findByFullName(fullName);
	}

	public Mono<Role> findByShortName(String shortName) {
		return repository.findByShortName(shortName);
	}
}