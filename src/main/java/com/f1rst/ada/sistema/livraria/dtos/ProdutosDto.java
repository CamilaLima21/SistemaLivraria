package com.f1rst.ada.sistema.livraria.dtos;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.ProdutosEntity;
import com.f1rst.ada.sistema.livraria.entities.VendasEntity;

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
	private Float preco;
	private int qtd;
	
//	private List<VendasDto> vendas;
	
	public ProdutosEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ProdutosEntity.class);
	}
}
