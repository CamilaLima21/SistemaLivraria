package com.f1rst.ada.sistema.livraria.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.dtos.VendasDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_VENDAS")
public class VendasEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idVenda;
	
	private Date dtVenda;
	
////	@ManyToOne
////	@JoinColumn(name= "CLIENTE_ID")
//	private ClientesEntity cliente;
	
	private int qtdProduto;
	
	@Column(name = "VALOR_TOTAL")
	private Float valorTotal;
	
//	@ManyToMany(mappedBy = "vendas")
//	private List<ProdutosEntity> produtos;
	
	public VendasDto toDto() {
		ModelMapper mapper = new ModelMapper();
		VendasDto dto = mapper.map(this, VendasDto.class);
		return dto;
	}
	
}
