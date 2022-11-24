package com.f1rst.ada.sistema.livraria.dtos;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.f1rst.ada.sistema.livraria.entities.EstoqueEntity;
import com.f1rst.ada.sistema.livraria.repositories.FilmesRepository;
import com.f1rst.ada.sistema.livraria.repositories.LivrosRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDto extends ProdutosDto{

//	private AlbunsMusicaDto albunsMusicas;
//	private BrinquedosDto brinquedos;
//	private JogosDto jogos;
//	private LivrosDto livros;
//	private FilmesDto filmes;
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
	private FilmesRepository filmesRepository;
	
//	private int id;
	private int qtdProdutos;
	
	public EstoqueEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, EstoqueEntity.class);
	}
}
