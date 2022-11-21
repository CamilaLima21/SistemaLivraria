package com.f1rst.ada.sistema.livraria.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.dtos.FilmesDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "TB_FILMES")
public class FilmesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private double preco;
	private String estudio;
	private String diretores;
	private String generos;
	private String produtores;
	
	public FilmesDto toDto() {
		ModelMapper mapper = new ModelMapper();
		FilmesDto dto = mapper.map(this, FilmesDto.class);
		return dto;
	}
}