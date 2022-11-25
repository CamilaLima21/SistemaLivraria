package com.f1rst.ada.sistema.livraria.dtos;

import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.ProdutosEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosDto {

	private int id;
	
	private String nome;
	private Float preco;
	private int qtd;
	@JsonIgnore
	@ManyToOne
	private EstoqueDto estoque;
	
	
	public ProdutosEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ProdutosEntity.class);
	}
}
