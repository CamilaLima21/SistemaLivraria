package com.f1rst.ada.sistema.livraria.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.dtos.ClientesDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClientes;
	private String nome;
	private String rg;
	private String cpf;
	private Date dataNasc;
	
	@JsonIgnore
	@OneToMany(mappedBy = "clientes") 			
	private List<VendasEntity> vendas;
	
	
	
	public ClientesDto toDto() {
		ModelMapper mapper = new ModelMapper();
		ClientesDto dto = mapper.map(this, ClientesDto.class);
		return dto;
	}
}
