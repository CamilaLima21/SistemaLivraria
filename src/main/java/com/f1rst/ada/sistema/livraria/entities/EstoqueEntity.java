package com.f1rst.ada.sistema.livraria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.f1rst.ada.sistema.livraria.dtos.EstoqueDto;
import com.f1rst.ada.sistema.livraria.repositories.LivrosRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ESTOQUE")
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class EstoqueEntity extends ProdutosEntity {

//	private AlbunsMusicaEntity albunsMusicas;
//	private BrinquedosEntity brinquedos;
//	private JogosEntity jogos;
//	private LivrosEntity livros;
//	private FilmesEntity filmes;
	private String tipoMovimentacao;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
	private int qtdProdutos;
	
//	@Autowired
//	private LivrosRepository livrosRepository;
	
	public EstoqueDto toDto() {
		ModelMapper mapper = new ModelMapper();
		EstoqueDto dto = mapper.map(this, EstoqueDto.class);
		return dto;
	}
	
	
}
