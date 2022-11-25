package com.f1rst.ada.sistema.livraria.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.ada.sistema.livraria.dtos.AlbunsMusicaDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "TB_MUSICAS")
public class AlbunsMusicaEntity extends ProdutosEntity{

//	private int id_albuns_musica;
	
	private String banda;
	private String generos;
	private String selos;
	
	
	public AlbunsMusicaDto toDto() {
		ModelMapper mapper = new ModelMapper();
		AlbunsMusicaDto dto = mapper.map(this, AlbunsMusicaDto.class);
		return dto;
	}
}
