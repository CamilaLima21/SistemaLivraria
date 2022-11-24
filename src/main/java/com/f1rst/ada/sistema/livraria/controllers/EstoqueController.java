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

import com.f1rst.ada.sistema.livraria.dtos.EstoqueDto;
import com.f1rst.ada.sistema.livraria.services.EstoqueService;

@RequestMapping("estoque")
@RestController
public class EstoqueController {

	@Autowired
	private EstoqueService estoqueService;
	
	@GetMapping("")
	public ResponseEntity<List<EstoqueDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(estoqueService.getAll());
	} 
	
	@GetMapping(value = "{id}")
	public ResponseEntity<EstoqueDto> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(estoqueService.getOne(id));
	}
	
	@PostMapping("")
	public ResponseEntity<EstoqueDto> save(@Valid @RequestBody EstoqueDto estoque) {
		return ResponseEntity.status(HttpStatus.OK).body(estoqueService.save(estoque.toEntity()));
	}
//	
//	@PatchMapping(value = "{id}")
//	public ResponseEntity<EstoqueDto> update(@PathVariable Integer id, @RequestBody EstoqueDto estoque) {
//		return ResponseEntity.status(HttpStatus.OK).body(estoqueService.update(id, estoque.toEntity()));
//	}
//	
//	@DeleteMapping(value = "{id}")
//	public ResponseEntity<Void> delete(@PathVariable Integer id) {
//		return ResponseEntity.ok().build();
//	}
}
