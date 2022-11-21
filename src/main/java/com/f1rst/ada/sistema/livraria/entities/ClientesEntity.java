package com.f1rst.ada.sistema.livraria.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.dtos.ClientesDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CLIENTES")
public class ClientesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String rg;
	private String cpf;
	private Date dataNasc;
	
	public ClientesDto toDto() {
		ModelMapper mapper = new ModelMapper();
		ClientesDto dto = mapper.map(this, ClientesDto.class);
		return dto;
	}
}
