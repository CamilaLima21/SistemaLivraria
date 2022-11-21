package com.f1rst.ada.sistema.livraria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class AlbunsMusicaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private double preco;
	private String banda;
	private String generos;
	private String selos;
	
	public AlbunsMusicaDto toDto() {
		ModelMapper mapper = new ModelMapper();
		AlbunsMusicaDto dto = mapper.map(this, AlbunsMusicaDto.class);
		return dto;
	}
}
