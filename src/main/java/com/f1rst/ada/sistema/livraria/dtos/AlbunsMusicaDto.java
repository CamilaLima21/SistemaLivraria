package com.f1rst.ada.sistema.livraria.dtos;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.AlbunsMusicaEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbunsMusicaDto extends ProdutosDto{

	private String banda;
	private String generos;
	private String selos;
	
	public AlbunsMusicaEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, AlbunsMusicaEntity.class);
	}
}
