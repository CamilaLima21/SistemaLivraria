package com.f1rst.ada.sistema.livraria.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.dtos.ProdutosDto;
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
@Table(name = "TB_PRODUTOS")
//@Inheritance(strategy = InheritanceType.JOINED)
//@PrimaryKeyJoinColumn(name="id")
public class ProdutosEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private Float preco;
	private int qtd;
	
//	@JsonIgnore
//	@ManyToMany 																			// Muitos Produtos para muitas Vendas
//	@JoinTable(
//			name = "TB_VENDAS",
//			joinColumns = @JoinColumn(name = "id"),
//			inverseJoinColumns = @JoinColumn(name = "id_venda")			
//	)
//	private List<VendasEntity> listvendas;
	
	@JsonIgnore
	@OneToMany(mappedBy = "produtos") 
	List<VendasEntity> vendas;
	
	public ProdutosDto toDto() {
		ModelMapper mapper = new ModelMapper();
		ProdutosDto dto = mapper.map(this, ProdutosDto.class);
		return dto;
	}
	
	
}
