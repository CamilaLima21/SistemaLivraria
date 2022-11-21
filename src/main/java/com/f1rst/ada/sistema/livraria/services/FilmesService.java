package com.f1rst.ada.sistema.livraria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.ada.sistema.livraria.dtos.FilmesDto;
import com.f1rst.ada.sistema.livraria.entities.FilmesEntity;
import com.f1rst.ada.sistema.livraria.repositories.FilmesRepository;

@Service
public class FilmesService {

	@Autowired
	private FilmesRepository filmesRepository;
	
	public List<FilmesDto> getAll(){
		List<FilmesEntity> lista = filmesRepository.findAll();
		List<FilmesDto> listaDto = new ArrayList<>();
		
		for(FilmesEntity jogosEntity : lista) {
			listaDto.add(jogosEntity.toDto());
		}
		return listaDto;
	}
	
	public FilmesDto getOne(int id) {
		Optional<FilmesEntity> optional = filmesRepository.findById(id);
		FilmesEntity filmes = optional.orElse(new FilmesEntity());
		return filmes.toDto();
	}
	
	public FilmesDto save(FilmesEntity filmes) {
		return filmesRepository.save(filmes).toDto();
	}
	
	public FilmesDto update(int id, FilmesEntity filmes) {
		Optional<FilmesEntity> optional = filmesRepository.findById(id);
		
		if(optional.isPresent()) {
			FilmesEntity filmesBD = optional.get();
			filmesBD.setNome(filmes.getNome());
			filmesBD.setPreco(filmes.getPreco());
			filmesBD.setEstudio(filmes.getEstudio());
			filmesBD.setGeneros(filmes.getGeneros());
			filmesBD.setProdutores(filmes.getProdutores());
			return filmesRepository.save(filmesBD).toDto();
		}
		else {
			return new FilmesEntity().toDto();
		}
	}
	
	public void delete(int id) {
		filmesRepository.deleteById(id);
	}
}
