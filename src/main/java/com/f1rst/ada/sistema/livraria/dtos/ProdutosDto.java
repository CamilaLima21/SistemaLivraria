package com.f1rst.ada.sistema.livraria.dtos;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.ProdutosEntity;

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
	private double preco;
	
	public ProdutosEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ProdutosEntity.class);
	}
}
