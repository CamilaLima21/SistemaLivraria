package com.f1rst.ada.sistema.livraria.dtos;

import java.util.Date;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.ClientesEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDto {

	private int id;
	private String nome;
	private String rg;
	private String cpf;
	private Date dataNasc;
	
	public ClientesEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ClientesEntity.class);
	}
}
