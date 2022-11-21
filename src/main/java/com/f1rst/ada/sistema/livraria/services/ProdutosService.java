package com.f1rst.ada.sistema.livraria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.ada.sistema.livraria.dtos.ProdutosDto;
import com.f1rst.ada.sistema.livraria.entities.ProdutosEntity;
import com.f1rst.ada.sistema.livraria.repositories.ProdutosRepository;

@Service
public class ProdutosService {

	@Autowired
	private ProdutosRepository produtosRepository;
	
	public List<ProdutosDto> getAll(){
		List<ProdutosEntity> lista = produtosRepository.findAll();
		List<ProdutosDto> listaDto = new ArrayList<>();
		
		for(ProdutosEntity produtosEntity : lista) {
			listaDto.add(produtosEntity.toDto());
		}
		return listaDto;
	}
	
	public ProdutosDto getOne(int id) {
		Optional<ProdutosEntity> optional = produtosRepository.findById(id);
		ProdutosEntity produtos = optional.orElse(new ProdutosEntity());
		return produtos.toDto();
	}
	
	public ProdutosDto save(ProdutosEntity produtos) {
		return produtosRepository.save(produtos).toDto();
	}
	
	public ProdutosDto update(int id, ProdutosEntity produtos) {
		Optional<ProdutosEntity> optional = produtosRepository.findById(id);
		
		if(optional.isPresent()) {
			ProdutosEntity produtosBD = optional.get();
			produtosBD.setNome(produtos.getNome());
			produtosBD.setPreco(produtos.getPreco());
			return produtosRepository.save(produtosBD).toDto();
		}
		else {
			return new ProdutosEntity().toDto();
		}
	}
	
	public void delete(int id) {
		produtosRepository.deleteById(id);
	}
}
