package com.f1rst.ada.sistema.livraria.dtos;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.LivrosEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivrosDto {

	private int id;
	private String nome;
	private double preco;
	private String generos;
	private String autor;
	private String editora;
	
	public LivrosEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, LivrosEntity.class);
	}
}
