package com.f1rst.ada.sistema.livraria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.dtos.LivrosDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "TB_LIVROS")
public class LivrosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private double preco;
	private String generos;
	private String autor;
	private String editora;
	
	public LivrosDto toDto() {
		ModelMapper mapper = new ModelMapper();
		LivrosDto dto = mapper.map(this, LivrosDto.class);
		return dto;
	}
}
