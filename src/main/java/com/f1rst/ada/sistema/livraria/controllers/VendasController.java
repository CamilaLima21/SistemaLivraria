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

import com.f1rst.ada.sistema.livraria.dtos.VendasDto;
import com.f1rst.ada.sistema.livraria.services.VendasService;

@RequestMapping("vendas")
@RestController
public class VendasController {

	@Autowired
	private VendasService vendasService;
	
	@GetMapping("")
	public ResponseEntity<List<VendasDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(vendasService.getAll());
	} 
	
	@GetMapping(value = "{id}")
	public ResponseEntity<VendasDto> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(vendasService.getOne(id));
	}
	
	@PostMapping("")
	public ResponseEntity<VendasDto> save(@Valid @RequestBody VendasDto vendas) {
		return ResponseEntity.status(HttpStatus.OK).body(vendasService.save(vendas.toEntity()));
	}
	
//	@PatchMapping(value = "{id}")
//	public ResponseEntity<VendasDto> update(@PathVariable Integer id, @RequestBody VendasDto vendas) {
//		return ResponseEntity.status(HttpStatus.OK).body(vendasService.update(id, vendas.toEntity()));
//	}
//	
//	@DeleteMapping(value = "{id}")
//	public ResponseEntity<Void> delete(@PathVariable Integer id) {
//		return ResponseEntity.ok().build();
//	}
}
