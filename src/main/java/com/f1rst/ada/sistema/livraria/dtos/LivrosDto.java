package com.f1rst.ada.sistema.livraria.dtos;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.LivrosEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivrosDto extends ProdutosDto{

//	private int id_livros;
	
	private String generos;
	private String autor;
	private String editora;
	
	public LivrosEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, LivrosEntity.class);
	}
}
