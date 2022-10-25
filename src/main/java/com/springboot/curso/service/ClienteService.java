package com.springboot.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.curso.dto.ClienteDto;
import com.springboot.curso.entity.Cliente;
import com.springboot.curso.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional(readOnly = true)
	public List<ClienteDto> findAll() {
		return clienteRepository.findAll().stream().map(e -> new ClienteDto(e.getId(), e.getNombre(), e.getApellidos(),
				e.getEmail(), e.getTelefono(), e.getCreateAt())).toList();
	}
	
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

}
