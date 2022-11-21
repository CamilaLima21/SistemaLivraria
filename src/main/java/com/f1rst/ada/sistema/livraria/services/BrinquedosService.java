package com.f1rst.ada.sistema.livraria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.ada.sistema.livraria.dtos.BrinquedosDto;
import com.f1rst.ada.sistema.livraria.entities.BrinquedosEntity;
import com.f1rst.ada.sistema.livraria.repositories.BrinquedosRepository;

@Service
public class BrinquedosService {

	@Autowired
	private BrinquedosRepository brinquedosRepository;
	
	public List<BrinquedosDto> getAll(){
		List<BrinquedosEntity> lista = brinquedosRepository.findAll();
		List<BrinquedosDto> listaDto = new ArrayList<>();
		
		for(BrinquedosEntity brinquedosEntity : lista) {
			listaDto.add(brinquedosEntity.toDto());
		}
		return listaDto;
	}
	
	public BrinquedosDto getOne(int id) {
		Optional<BrinquedosEntity> optional = brinquedosRepository.findById(id);
		BrinquedosEntity brinquedos = optional.orElse(new BrinquedosEntity());
		return brinquedos.toDto();
	}
	
	public BrinquedosDto save(BrinquedosEntity brinquedos) {
		return brinquedosRepository.save(brinquedos).toDto();
	}
	
	public BrinquedosDto update(int id, BrinquedosEntity brinquedos) {
		Optional<BrinquedosEntity> optional = brinquedosRepository.findById(id);
		
		if(optional.isPresent()) {
			BrinquedosEntity brinquedosBD = optional.get();
			brinquedosBD.setNome(brinquedos.getNome());
			brinquedosBD.setPreco(brinquedos.getPreco());
			brinquedosBD.setTipo(brinquedos.getTipo());
			return brinquedosRepository.save(brinquedosBD).toDto();
		}
		else {
			return new BrinquedosEntity().toDto();
		}
	}
	
	public void delete(int id) {
		brinquedosRepository.deleteById(id);
	}
}
