package com.f1rst.ada.sistema.livraria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.f1rst.ada.sistema.livraria.entities.ClientesEntity;
import com.f1rst.ada.sistema.livraria.entities.FilmesEntity;
import com.f1rst.ada.sistema.livraria.entities.JogosEntity;
import com.f1rst.ada.sistema.livraria.entities.ProdutosEntity;
import com.f1rst.ada.sistema.livraria.entities.VendasEntity;
import com.f1rst.ada.sistema.livraria.repositories.ClientesRepository;
import com.f1rst.ada.sistema.livraria.repositories.ProdutosRepository;
import com.f1rst.ada.sistema.livraria.repositories.VendasRepository;
import com.f1rst.ada.sistema.livraria.services.EstoqueService;

@SpringBootApplication
public class SistemaLivrariaApplication implements CommandLineRunner {

//	implements CommandLineRunner
	@Autowired
	private ClientesRepository clientesRepository;
	@Autowired
	private EstoqueService estoqueService;
	@Autowired
	private ProdutosRepository produtosRepository;
	@Autowired
	private VendasRepository vendasRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaLivrariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ClientesEntity cliente1 = new ClientesEntity(1, "Samila", "0000-1X", "111.222.333-01", null, null);
		ClientesEntity cliente2 = new ClientesEntity(2, "Lucas", "0000-2X", "222.333.444-02", null, null);
		ClientesEntity cliente3 = new ClientesEntity(3, "Camila", "0000-3X", "333.444.555-03", null, null);

		clientesRepository.save(cliente1);
		clientesRepository.save(cliente2);
		clientesRepository.save(cliente3);


		FilmesEntity filmes1 = new FilmesEntity( "Estudio Teste", "Diretor Teste", "Genero Teste", "Produtor Teste");
		FilmesEntity filmes2 = new FilmesEntity( "Estudio Teste", "Diretor Teste", "Genero Teste", "Produtor Teste");
		FilmesEntity filmes3 = new FilmesEntity( "Estudio Teste", "Diretor Teste", "Genero Teste", "Produtor Teste");
		
		produtosRepository.save(filmes1);
		produtosRepository.save(filmes2);
		produtosRepository.save(filmes3);
		
		estoqueService.gerenciamentoEstoque(filmes1.getId(), 1);
		estoqueService.gerenciamentoEstoque(filmes2.getId(), 1);
		estoqueService.gerenciamentoEstoque(filmes3.getId(), 1);
		
		JogosEntity jogos1 = new JogosEntity( "Sony", "Genero Teste", "Estudio Teste");
		produtosRepository.save(jogos1);
		estoqueService.gerenciamentoEstoque(jogos1.getId(), 1);
		
		VendasEntity vendas1 = new VendasEntity(0, null, cliente3, 0, null, jogos1);
		vendasRepository.save(vendas1);
		estoqueService.gerenciamentoEstoque(jogos1.getId(), 2);
	}

}
