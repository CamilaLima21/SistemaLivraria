package com.f1rst.ada.sistema.livraria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.ada.sistema.livraria.dtos.LivrosDto;
import com.f1rst.ada.sistema.livraria.entities.LivrosEntity;
import com.f1rst.ada.sistema.livraria.repositories.LivrosRepository;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;
	
	public List<LivrosDto> getAll(){
		List<LivrosEntity> lista = livrosRepository.findAll();
		List<LivrosDto> listaDto = new ArrayList<>();
		
		for(LivrosEntity livrosEntity : lista) {
			listaDto.add(livrosEntity.toDto());
		}
		return listaDto;
	}
	
	public LivrosDto getOne(int id) {
		Optional<LivrosEntity> optional = livrosRepository.findById(id);
		LivrosEntity livros = optional.orElse(new LivrosEntity());
		return livros.toDto();
	}
	
	public LivrosDto save(LivrosEntity livros) {
		return livrosRepository.save(livros).toDto();
	}
	
	public LivrosDto update(int id, LivrosEntity livros) {
		Optional<LivrosEntity> optional = livrosRepository.findById(id);
		
		if(optional.isPresent()) {
			LivrosEntity livrosBD = optional.get();
			livrosBD.setNome(livros.getNome());
			livrosBD.setPreco(livros.getPreco());
			livrosBD.setAutor(livros.getAutor());
			livrosBD.setEditora(livros.getEditora());
			return livrosRepository.save(livrosBD).toDto();
		}
		else {
			return new LivrosEntity().toDto();
		}
	}
	
	public void delete(int id) {
		livrosRepository.deleteById(id);
	}
}
