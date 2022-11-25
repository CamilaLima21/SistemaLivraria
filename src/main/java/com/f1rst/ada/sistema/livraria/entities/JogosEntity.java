package com.f1rst.ada.sistema.livraria.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.dtos.JogosDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "TB_JOGOS")
public class JogosEntity extends ProdutosEntity  {

//	private int id_jogos;
	
	private String distribuidora;
	private String generos;
	private String estudio;
	
	
	
	public JogosDto toDto() {
		ModelMapper mapper = new ModelMapper();
		JogosDto dto = mapper.map(this, JogosDto.class);
		return dto;
	}
	
}
