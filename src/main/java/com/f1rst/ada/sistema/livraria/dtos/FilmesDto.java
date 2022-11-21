package com.f1rst.ada.sistema.livraria.dtos;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.FilmesEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmesDto {

	private int id;
	private String nome;
	private double preco;
	private String estudio;
	private String diretores;
	private String generos;
	private String produtores;
	
	public FilmesEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, FilmesEntity.class);
	}
}
