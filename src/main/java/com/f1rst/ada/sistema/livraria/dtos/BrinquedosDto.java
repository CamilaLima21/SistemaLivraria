package com.f1rst.ada.sistema.livraria.dtos;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.BrinquedosEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrinquedosDto extends ProdutosDto{

	private String tipo;
	
	public BrinquedosEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, BrinquedosEntity.class);
	}
}
