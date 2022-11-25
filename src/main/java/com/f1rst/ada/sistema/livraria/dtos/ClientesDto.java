package com.f1rst.ada.sistema.livraria.dtos;

import java.util.Date;
import java.util.List;

import javax.persistence.OneToMany;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.ClientesEntity;
import com.f1rst.ada.sistema.livraria.entities.VendasEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDto {

	private int id_clientes;
	
	private String nome;
	private String rg;
	private String cpf;
	private Date dataNasc;
	
	@JsonIgnore
	@OneToMany(mappedBy = "clientes") 			
	private List<VendasEntity> vendas;
	
	public ClientesEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ClientesEntity.class);
	}
}
