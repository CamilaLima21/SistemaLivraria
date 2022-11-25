package com.f1rst.ada.sistema.livraria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.dtos.ProdutosDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@PrimaryKeyJoinColumn(name="id")
public class ProdutosEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private Float preco;
	private int qtd;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_estoque")
	private EstoqueEntity estoque;
	
	public ProdutosDto toDto() {
		ModelMapper mapper = new ModelMapper();
		ProdutosDto dto = mapper.map(this, ProdutosDto.class);
		return dto;
	}
	
	
}
