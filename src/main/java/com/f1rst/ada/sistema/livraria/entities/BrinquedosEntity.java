package com.f1rst.ada.sistema.livraria.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.dtos.BrinquedosDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "TB_BRINQUEDOS")
public class BrinquedosEntity extends ProdutosEntity{

//	private int id_brinquedos;
	
	private String tipo;
	
	public BrinquedosDto toDto() {
		ModelMapper mapper = new ModelMapper();
		BrinquedosDto dto = mapper.map(this, BrinquedosDto.class);
		return dto;
	}
}
