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

import com.f1rst.ada.sistema.livraria.dtos.FilmesDto;
import com.f1rst.ada.sistema.livraria.services.FilmesService;

@RequestMapping("filmes")
@RestController
public class FilmesController {

	@Autowired
	private FilmesService filmesService;
	
	@GetMapping("")
	public ResponseEntity<List<FilmesDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(filmesService.getAll());
	} 
	
	@GetMapping(value = "{id}")
	public ResponseEntity<FilmesDto> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(filmesService.getOne(id));
	}
	
	@PostMapping("")
	public ResponseEntity<FilmesDto> save(@Valid @RequestBody FilmesDto filmes) {
		return ResponseEntity.status(HttpStatus.OK).body(filmesService.save(filmes.toEntity()));
	}
	
	@PatchMapping(value = "{id}")
	public ResponseEntity<FilmesDto> update(@PathVariable Integer id, @RequestBody FilmesDto filmes) {
		return ResponseEntity.status(HttpStatus.OK).body(filmesService.update(id, filmes.toEntity()));
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		return ResponseEntity.ok().build();
	}
}
