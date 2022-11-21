package com.f1rst.ada.sistema.livraria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.ada.sistema.livraria.dtos.AlbunsMusicaDto;
import com.f1rst.ada.sistema.livraria.entities.AlbunsMusicaEntity;
import com.f1rst.ada.sistema.livraria.repositories.AlbunsMusicaRepository;

@Service
public class AlbunsMusicaService {

	@Autowired
	private AlbunsMusicaRepository albunsMusicaRepository;
	
	public List<AlbunsMusicaDto> getAll(){
		List<AlbunsMusicaEntity> lista = albunsMusicaRepository.findAll();
		List<AlbunsMusicaDto> listaDto = new ArrayList<>();
		
		for(AlbunsMusicaEntity albunsMusicaEntity : lista) {
			listaDto.add(albunsMusicaEntity.toDto());
		}
		return listaDto;
	}
	
	public AlbunsMusicaDto getOne(int id) {
		Optional<AlbunsMusicaEntity> optional = albunsMusicaRepository.findById(id);
		AlbunsMusicaEntity albunsMusica = optional.orElse(new AlbunsMusicaEntity());
		return albunsMusica.toDto();
	}
	
	public AlbunsMusicaDto save(AlbunsMusicaEntity albunsMusica) {
		return albunsMusicaRepository.save(albunsMusica).toDto();
	}
	
	public AlbunsMusicaDto update(int id, AlbunsMusicaEntity albunsMusica) {
		Optional<AlbunsMusicaEntity> optional = albunsMusicaRepository.findById(id);
		
		if(optional.isPresent()) {
			AlbunsMusicaEntity albunsMusicaBD = optional.get();
			albunsMusicaBD.setNome(albunsMusica.getNome());
			albunsMusicaBD.setPreco(albunsMusica.getPreco());
			albunsMusicaBD.setBanda(albunsMusica.getBanda());
			albunsMusicaBD.setGeneros(albunsMusica.getGeneros());
			albunsMusicaBD.setSelos(albunsMusica.getSelos());
			return albunsMusicaRepository.save(albunsMusicaBD).toDto();
		}
		else {
			return new AlbunsMusicaEntity().toDto();
		}
	}
	
	public void delete(int id) {
		albunsMusicaRepository.deleteById(id);
	}
}
