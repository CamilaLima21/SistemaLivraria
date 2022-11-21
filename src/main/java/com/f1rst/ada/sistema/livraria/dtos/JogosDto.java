package com.f1rst.ada.sistema.livraria.dtos;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.JogosEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JogosDto {

	private int id;
	private String nome;
	private double preco;
	private String distribuidora;
	private String generos;
	private String estudio;
	
	public JogosEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, JogosEntity.class);
	}
}
