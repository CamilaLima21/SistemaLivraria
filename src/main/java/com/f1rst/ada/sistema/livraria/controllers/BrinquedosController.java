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

import com.f1rst.ada.sistema.livraria.dtos.BrinquedosDto;
import com.f1rst.ada.sistema.livraria.services.BrinquedosService;

@RequestMapping("brinquedos")
@RestController
public class BrinquedosController {

	@Autowired
	private BrinquedosService brinquedosService;
	
	@GetMapping("")
	public ResponseEntity<List<BrinquedosDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(brinquedosService.getAll());
	} 
	
	@GetMapping(value = "{id}")
	public ResponseEntity<BrinquedosDto> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(brinquedosService.getOne(id));
	}
	
	@PostMapping("")
	public ResponseEntity<BrinquedosDto> save(@Valid @RequestBody BrinquedosDto brinquedos) {
		return ResponseEntity.status(HttpStatus.OK).body(brinquedosService.save(brinquedos.toEntity()));
	}
	
	@PatchMapping(value = "{id}")
	public ResponseEntity<BrinquedosDto> update(@PathVariable Integer id, @RequestBody BrinquedosDto brinquedos) {
		return ResponseEntity.status(HttpStatus.OK).body(brinquedosService.update(id, brinquedos.toEntity()));
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		return ResponseEntity.ok().build();
	}
}
