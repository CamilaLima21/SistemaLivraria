package com.f1rst.ada.sistema.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f1rst.ada.sistema.livraria.entities.ProdutosEntity;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosEntity, Integer>{

}
