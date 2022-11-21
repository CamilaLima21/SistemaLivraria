package com.f1rst.ada.sistema.livraria.dtos;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.AlbunsMusicaEntity;
import com.f1rst.ada.sistema.livraria.entities.BrinquedosEntity;
import com.f1rst.ada.sistema.livraria.entities.EstoqueEntity;
import com.f1rst.ada.sistema.livraria.entities.FilmesEntity;
import com.f1rst.ada.sistema.livraria.entities.JogosEntity;
import com.f1rst.ada.sistema.livraria.entities.LivrosEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDto {

//	private AlbunsMusicaEntity albunsMusicas;
//	private BrinquedosEntity brinquedos;
//	private JogosEntity jogos;
//	private LivrosEntity livros;
//	private FilmesEntity filmes;
	
	private int id;
	private int qtdProdutos;
	
	public EstoqueEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, EstoqueEntity.class);
	}
}
