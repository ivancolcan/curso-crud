package com.springboot.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.curso.dto.ClienteDto;
import com.springboot.curso.entity.Cliente;
import com.springboot.curso.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<ClienteDto> findAll() {
		return clienteService.findAll();
	}

	@GetMapping("/{id}")
	public Cliente findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Cliente update(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@DeleteMapping("/{id}")
	public Cliente delete(@PathVariable Long id) {
		Cliente cliente = clienteService.findById(id);
		clienteService.delete(id);
		return cliente;
	}

}
