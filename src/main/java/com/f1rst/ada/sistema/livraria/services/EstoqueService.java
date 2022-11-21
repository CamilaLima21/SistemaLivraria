package com.f1rst.ada.sistema.livraria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.ada.sistema.livraria.dtos.EstoqueDto;
import com.f1rst.ada.sistema.livraria.entities.EstoqueEntity;
import com.f1rst.ada.sistema.livraria.repositories.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepository;
	
	public List<EstoqueDto> getAll(){
		List<EstoqueEntity> lista = estoqueRepository.findAll();
		List<EstoqueDto> listaDto = new ArrayList<>();
		
		for(EstoqueEntity estoqueEntity : lista) {
			listaDto.add(estoqueEntity.toDto());
		}
		return listaDto;
	}
	
	public EstoqueDto getOne(int id) {
		Optional<EstoqueEntity> optional = estoqueRepository.findById(id);
		EstoqueEntity estoque = optional.orElse(new EstoqueEntity());
		return estoque.toDto();
	}
	
	public EstoqueDto save(EstoqueEntity estoque) {
		return estoqueRepository.save(estoque).toDto();
	}
	
	public EstoqueDto update(int id, EstoqueEntity estoque) {
		Optional<EstoqueEntity> optional = estoqueRepository.findById(id);
		
		if(optional.isPresent()) {
			EstoqueEntity estoqueBD = optional.get();
//			estoqueBD.setAlbunsMusicas(estoque.getAlbunsMusicas());
//			estoqueBD.setBrinquedos(estoque.getBrinquedos());
//			estoqueBD.setFilmes(estoque.getFilmes());
//			estoqueBD.setJogos(estoque.getJogos());
//			estoqueBD.setLivros(estoque.getLivros());
			estoqueBD.setQtdProdutos(estoque.getQtdProdutos());
			return estoqueRepository.save(estoqueBD).toDto();
		}
		else {
			return new EstoqueEntity().toDto();
		}
	}
	
	public void delete(int id) {
		estoqueRepository.deleteById(id);
	}
}
