package com.Act2.Act2.model;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="tbl_inventario")
@DynamicInsert

public class Inventario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numero")
	private Integer numero;
	
	@Column(name="fecha_vencimiento")
	private LocalDate fV;
	
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	@Column(name="costo_ingreso")
	private Double costoIngreso;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="lote")
	private String lote;
	
	@Column(name="cod_estado")
	private String codEstado;
	
	public String textoEstado() {
		switch (codEstado) {
		case "A": { return "Activo";}
		case "T": { return "En transito";}
		case "B": { return "Bloqueado";}
		case "V": { return "Vencido";}		
		default:	return "N.A";
		}
	}

}
