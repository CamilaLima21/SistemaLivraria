package com.f1rst.ada.sistema.livraria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.dtos.EstoqueDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ESTOQUE")
public class EstoqueEntity {

//	private AlbunsMusicaEntity albunsMusicas;
//	private BrinquedosEntity brinquedos;
//	private JogosEntity jogos;
//	private LivrosEntity livros;
//	private FilmesEntity filmes;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int qtdProdutos;
	
	public EstoqueDto toDto() {
		ModelMapper mapper = new ModelMapper();
		EstoqueDto dto = mapper.map(this, EstoqueDto.class);
		return dto;
	}
}
