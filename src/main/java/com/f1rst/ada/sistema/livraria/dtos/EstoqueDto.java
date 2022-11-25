package com.f1rst.ada.sistema.livraria.dtos;

import java.util.List;

import javax.persistence.OneToMany;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.EstoqueEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDto extends ProdutosDto {

//	private int id;
	
	private int qtdProdutos;
	private String tipoMovimentacao;
	
	@JsonIgnore
	@OneToMany
	private List<ProdutosDto> produtos;
	
	public EstoqueEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, EstoqueEntity.class);
	}
}
