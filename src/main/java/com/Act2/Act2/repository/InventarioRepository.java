package com.Act2.Act2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Act2.Act2.model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
	List<Inventario> findByOrderByNumeroDesc();
}
