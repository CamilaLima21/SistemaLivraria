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

import com.f1rst.ada.sistema.livraria.dtos.ProdutosDto;
import com.f1rst.ada.sistema.livraria.services.ProdutosService;

@RequestMapping("produtos")
@RestController
public class ProdutosController {

	@Autowired
	private ProdutosService produtosService;
	
	@GetMapping("")
	public ResponseEntity<List<ProdutosDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(produtosService.getAll());
	} 
	
	@GetMapping(value = "{id}")
	public ResponseEntity<ProdutosDto> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(produtosService.getOne(id));
	}
	
	@PostMapping("")
	public ResponseEntity<ProdutosDto> save(@Valid @RequestBody ProdutosDto produtos) {
		return ResponseEntity.status(HttpStatus.OK).body(produtosService.save(produtos.toEntity()));
	}
	
	@PatchMapping(value = "{id}")
	public ResponseEntity<ProdutosDto> update(@PathVariable Integer id, @RequestBody ProdutosDto produtos) {
		return ResponseEntity.status(HttpStatus.OK).body(produtosService.update(id, produtos.toEntity()));
	}
//	
//	@DeleteMapping(value = "{id}")
//	public ResponseEntity<Void> delete(@PathVariable Integer id) {
//		return ResponseEntity.ok().build();
//	}
}
