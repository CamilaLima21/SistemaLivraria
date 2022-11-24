package com.f1rst.ada.sistema.livraria.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f1rst.ada.sistema.livraria.dtos.ClientesDto;
import com.f1rst.ada.sistema.livraria.services.ClientesService;

@RequestMapping("clientes")
@RestController
public class ClientesController {

	@Autowired
	private ClientesService clientesService;
	
	@GetMapping("")
	public ResponseEntity<List<ClientesDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(clientesService.getAll());
	} 
	
	@GetMapping(value = "{id}")
	public ResponseEntity<ClientesDto> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(clientesService.getOne(id));
	}
	
	@PostMapping("")
	public ResponseEntity<ClientesDto> save(@Valid @RequestBody ClientesDto clientes) {
		return ResponseEntity.status(HttpStatus.OK).body(clientesService.save(clientes.toEntity()));
	}
//	
//	@PatchMapping(value = "{id}")
//	public ResponseEntity<ClientesDto> update(@PathVariable Integer id, @RequestBody ClientesDto clientes) {
//		return ResponseEntity.status(HttpStatus.OK).body(clientesService.update(id, clientes.toEntity()));
//	}
//	
//	@DeleteMapping(value = "{id}")
//	public ResponseEntity<Void> delete(@PathVariable Integer id) {
//		return ResponseEntity.ok().build();
//	}
}
