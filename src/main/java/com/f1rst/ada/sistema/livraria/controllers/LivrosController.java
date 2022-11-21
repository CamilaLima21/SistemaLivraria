package com.f1rst.ada.sistema.livraria.controllers;

import javax.validation.Valid;
import java.util.List;

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

import com.f1rst.ada.sistema.livraria.dtos.LivrosDto;
import com.f1rst.ada.sistema.livraria.services.LivrosService;

@RequestMapping("livros")
@RestController
public class LivrosController {

	@Autowired
	private LivrosService livrosService;
	
	@GetMapping("")
	public ResponseEntity<List<LivrosDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(livrosService.getAll());
	} 
	
	@GetMapping(value = "{id}")
	public ResponseEntity<LivrosDto> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(livrosService.getOne(id));
	}
	
	@PostMapping("")
	public ResponseEntity<LivrosDto> save(@Valid @RequestBody LivrosDto livros) {
		return ResponseEntity.status(HttpStatus.OK).body(livrosService.save(livros.toEntity()));
	}
	
	@PatchMapping(value = "{id}")
	public ResponseEntity<LivrosDto> update(@PathVariable Integer id, @RequestBody LivrosDto livros) {
		return ResponseEntity.status(HttpStatus.OK).body(livrosService.update(id, livros.toEntity()));
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		return ResponseEntity.ok().build();
	}
}
