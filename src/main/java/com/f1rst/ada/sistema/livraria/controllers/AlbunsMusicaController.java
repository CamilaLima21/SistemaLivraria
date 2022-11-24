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

import com.f1rst.ada.sistema.livraria.dtos.AlbunsMusicaDto;
import com.f1rst.ada.sistema.livraria.services.AlbunsMusicaService;

@RequestMapping("albunsMusica")
@RestController
public class AlbunsMusicaController {

	@Autowired
	private AlbunsMusicaService albunsMusicaService;
	
	@GetMapping("")
	public ResponseEntity<List<AlbunsMusicaDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(albunsMusicaService.getAll());
	} 
	
	@GetMapping(value = "{id}")
	public ResponseEntity<AlbunsMusicaDto> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(albunsMusicaService.getOne(id));
	}
	
	@PostMapping("")
	public ResponseEntity<AlbunsMusicaDto> save(@Valid @RequestBody AlbunsMusicaDto albunsMusica) {
		return ResponseEntity.status(HttpStatus.OK).body(albunsMusicaService.save(albunsMusica.toEntity()));
	}
	
//	@PatchMapping(value = "{id}")
//	public ResponseEntity<AlbunsMusicaDto> update(@PathVariable Integer id, @RequestBody AlbunsMusicaDto albunsMusica) {
//		return ResponseEntity.status(HttpStatus.OK).body(albunsMusicaService.update(id, albunsMusica.toEntity()));
//	}
//	
//	@DeleteMapping(value = "{id}")
//	public ResponseEntity<Void> delete(@PathVariable Integer id) {
//		return ResponseEntity.ok().build();
//	}
}
