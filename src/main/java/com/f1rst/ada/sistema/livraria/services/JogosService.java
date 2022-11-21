package com.f1rst.ada.sistema.livraria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.ada.sistema.livraria.dtos.JogosDto;
import com.f1rst.ada.sistema.livraria.entities.JogosEntity;
import com.f1rst.ada.sistema.livraria.repositories.JogosRepository;

@Service
public class JogosService {

	@Autowired
	private JogosRepository jogosRepository;
	
	public List<JogosDto> getAll(){
		List<JogosEntity> lista = jogosRepository.findAll();
		List<JogosDto> listaDto = new ArrayList<>();
		
		for(JogosEntity jogosEntity : lista) {
			listaDto.add(jogosEntity.toDto());
		}
		return listaDto;
	}
	
	public JogosDto getOne(int id) {
		Optional<JogosEntity> optional = jogosRepository.findById(id);
		JogosEntity jogos = optional.orElse(new JogosEntity());
		return jogos.toDto();
	}
	
	public JogosDto save(JogosEntity jogos) {
		return jogosRepository.save(jogos).toDto();
	}
	
	public JogosDto update(int id, JogosEntity jogos) {
		Optional<JogosEntity> optional = jogosRepository.findById(id);
		
		if(optional.isPresent()) {
			JogosEntity jogosBD = optional.get();
			jogosBD.setNome(jogos.getNome());
			jogosBD.setPreco(jogos.getPreco());
			jogosBD.setDistribuidora(jogos.getDistribuidora());
			jogosBD.setGeneros(jogos.getGeneros());
			jogosBD.setEstudio(jogos.getEstudio());
			return jogosRepository.save(jogosBD).toDto();
		}
		else {
			return new JogosEntity().toDto();
		}
	}
	
	public void delete(int id) {
		jogosRepository.deleteById(id);
	}
}
