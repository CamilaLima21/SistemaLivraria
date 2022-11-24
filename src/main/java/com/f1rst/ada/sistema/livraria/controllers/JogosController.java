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

import com.f1rst.ada.sistema.livraria.dtos.JogosDto;
import com.f1rst.ada.sistema.livraria.services.JogosService;

@RequestMapping("jogos")
@RestController
public class JogosController {

	@Autowired
	private JogosService jogosService;
	
	@GetMapping("")
	public ResponseEntity<List<JogosDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(jogosService.getAll());
	} 
	
	@GetMapping(value = "{id}")
	public ResponseEntity<JogosDto> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(jogosService.getOne(id));
	}
	
	@PostMapping("")
	public ResponseEntity<JogosDto> save(@Valid @RequestBody JogosDto jogos) {
		return ResponseEntity.status(HttpStatus.OK).body(jogosService.save(jogos.toEntity()));
	}
//	
//	@PatchMapping(value = "{id}")
//	public ResponseEntity<JogosDto> update(@PathVariable Integer id, @RequestBody JogosDto jogos) {
//		return ResponseEntity.status(HttpStatus.OK).body(jogosService.update(id, jogos.toEntity()));
//	}
//	
//	@DeleteMapping(value = "{id}")
//	public ResponseEntity<Void> delete(@PathVariable Integer id) {
//		return ResponseEntity.ok().build();
//	}
}
