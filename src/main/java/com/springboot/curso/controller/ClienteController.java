package com.springboot.curso.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.findById(id));
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
	
	@PostMapping("{id}/upload")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente create(@PathVariable Long id, @RequestParam MultipartFile file) throws IOException {
		Cliente cliente = clienteService.findById(id);
		
		String fileName = "clientes_"+id+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		
		Path pathFile = Paths.get("uploads").resolve(fileName).toAbsolutePath();
		
		Files.copy(file.getInputStream(), pathFile, StandardCopyOption.REPLACE_EXISTING);
		
		cliente.setImagen(fileName);
		
		return clienteService.save(cliente);
	}
	
	@GetMapping("img/{name:.+}")
	public ResponseEntity<Resource> getImg(@PathVariable String name) throws IOException {
		Path pathFile = Paths.get("uploads").resolve(name).toAbsolutePath();
		
		Resource recurso = new UrlResource(pathFile.toUri());
		
		//if (recurso.exists() && recurso.isReadable()) {
		
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attechment;filename=\""+recurso.getFilename()+"\"");
		
		return new ResponseEntity<Resource>(recurso, header, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public Cliente delete(@PathVariable Long id) throws IOException {
		Cliente cliente = clienteService.findById(id);
		clienteService.delete(id);
		
		Path pathFile = Paths.get("uploads").resolve(cliente.getImagen()).toAbsolutePath();
		Files.deleteIfExists(pathFile);
		
		return cliente;
	}

}
