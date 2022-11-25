package com.f1rst.ada.sistema.livraria.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.dtos.EstoqueDto;
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
@Table(name = "TB_ESTOQUE")
public class EstoqueEntity extends ProdutosEntity {

//	private int id;
	
	private int qtdProdutos;
	private String tipoMovimentacao;
	
	@JsonIgnore
	@OneToMany
	private List<ProdutosEntity> produtos;
	
	
	public EstoqueDto toDto() {
		ModelMapper mapper = new ModelMapper();
		EstoqueDto dto = mapper.map(this, EstoqueDto.class);
		return dto;
	}
	
	
}
