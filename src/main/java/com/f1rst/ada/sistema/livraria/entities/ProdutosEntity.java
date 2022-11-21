package com.f1rst.ada.sistema.livraria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.dtos.ProdutosDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PRODUTOS")
public class ProdutosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private double preco;
	
	public ProdutosDto toDto() {
		ModelMapper mapper = new ModelMapper();
		ProdutosDto dto = mapper.map(this, ProdutosDto.class);
		return dto;
	}
	
}
