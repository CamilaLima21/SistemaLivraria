package com.f1rst.ada.sistema.livraria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.ada.sistema.livraria.dtos.EstoqueDto;
import com.f1rst.ada.sistema.livraria.entities.EstoqueEntity;
import com.f1rst.ada.sistema.livraria.entities.ProdutosEntity;
import com.f1rst.ada.sistema.livraria.repositories.EstoqueRepository;
import com.f1rst.ada.sistema.livraria.repositories.ProdutosRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
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
	
	public void gerenciamentoEstoque(int id, int tipoTransacao) {
		Optional<ProdutosEntity> optional = produtosRepository.findById(id);
		EstoqueEntity estoqueEntity = new EstoqueEntity();
		if(optional.isPresent()) {
			if(tipoTransacao == 1) {
				ProdutosEntity produtosBD = optional.get();
				estoqueEntity.setQtdProdutos(estoqueEntity.getQtdProdutos() + produtosBD.getQtd());
				estoqueEntity.setTipoMovimentacao("1 - Entrada Estoque");
				estoqueRepository.save(estoqueEntity).toDto();
			}
			else
				if(tipoTransacao == 2) {
					ProdutosEntity produtosBD = optional.get();
					estoqueEntity.setQtdProdutos(estoqueEntity.getQtdProdutos() - produtosBD.getQtd());
					estoqueEntity.setTipoMovimentacao("2 - Saída Estoque");
					estoqueRepository.save(estoqueEntity).toDto();
				}
		}
	}
}
