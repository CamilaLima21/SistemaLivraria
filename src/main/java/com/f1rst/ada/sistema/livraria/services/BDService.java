package com.f1rst.ada.sistema.livraria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.ada.sistema.livraria.entities.ClientesEntity;
import com.f1rst.ada.sistema.livraria.entities.ProdutosEntity;
import com.f1rst.ada.sistema.livraria.entities.VendasEntity;
import com.f1rst.ada.sistema.livraria.repositories.ClientesRepository;
import com.f1rst.ada.sistema.livraria.repositories.ProdutosRepository;
import com.f1rst.ada.sistema.livraria.repositories.VendasRepository;

@Service
public class BDService {

	@Autowired
	private ClientesRepository clientesRepository;
	@Autowired
	private ProdutosRepository produtosRepository;
	@Autowired
	private VendasRepository vendasRepository;
	
public void inserirVendas() {
		

		List<ClientesEntity> clientes = clientesRepository.findAll();

		List<ProdutosEntity> produtos = produtosRepository.findAll();
		
		VendasEntity venda = new VendasEntity();
		venda.setValorTotal(Float.valueOf(120));		

		venda.setClientes(clientes.get(0));;

		venda.setProdutos(produtos.get(0));
		
		VendasEntity vendaSalva = vendasRepository.save(venda);
		
		List<VendasEntity> listaVendas = new ArrayList<>();
		listaVendas.add(vendaSalva);
		

		for (int i = 0; i < produtos.size(); i++) {
			produtos.get(i).setVendas(listaVendas);

			produtosRepository.save(produtos.get(i));
		}
	}
	
}
