package com.f1rst.ada.sistema.livraria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.ada.sistema.livraria.dtos.VendasDto;
import com.f1rst.ada.sistema.livraria.entities.VendasEntity;
import com.f1rst.ada.sistema.livraria.repositories.ClientesRepository;
import com.f1rst.ada.sistema.livraria.repositories.ProdutosRepository;
import com.f1rst.ada.sistema.livraria.repositories.VendasRepository;

@Service
public class VendasService {

	@Autowired
	private VendasRepository vendasRepository;
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@Autowired
	private EstoqueService estoqueService;
	
	public List<VendasDto> getAll(){
		List<VendasEntity> lista = vendasRepository.findAll();
		List<VendasDto> listaDto = new ArrayList<>();
		
		for(VendasEntity vendasEntity : lista) {
			listaDto.add(vendasEntity.toDto());
		}
		return listaDto;
	}
	
	public VendasDto getOne(int id) {
		Optional<VendasEntity> optional = vendasRepository.findById(id);
		VendasEntity vendas = optional.orElse(new VendasEntity());
		return vendas.toDto();
	}
	
	public VendasDto save(VendasEntity vendas) {
		clientesRepository.save(vendas.getClientes()).toDto();
		produtosRepository.save(vendas.getProdutos()).toDto();
		estoqueService.gerenciamentoEstoque(vendas.getProdutos().getId(), 2);
		return vendasRepository.save(vendas).toDto();
	}
	
	public VendasDto update(int id, VendasEntity vendas) {
		Optional<VendasEntity> optional = vendasRepository.findById(id);
		
		if(optional.isPresent()) {
			VendasEntity vendasBD = optional.get();
			vendasBD.setId_venda(vendas.getId_venda());
			vendasBD.setClientes(vendas.getClientes());
			vendasBD.setProdutos(vendas.getProdutos());
			vendasBD.setQtdProduto(vendas.getQtdProduto());
			vendasBD.setValorTotal(vendas.getValorTotal());
			return vendasRepository.save(vendasBD).toDto();
		}
		else {
			return new VendasEntity().toDto();
		}
	}
	
	public void delete(int id) {
		vendasRepository.deleteById(id);
	}
}
