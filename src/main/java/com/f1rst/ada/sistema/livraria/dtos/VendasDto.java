package com.f1rst.ada.sistema.livraria.dtos;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.entities.ClientesEntity;
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
public class VendasDto {

	private int idVenda;
	private Date dtVenda;
	private ClientesEntity clientes;
	private int qtdProduto;
	private Float valorTotal;
//	private ProdutosDto produtos;
	
	private ProdutosDto produtos;
	
	public VendasEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, VendasEntity.class);
	}
}
