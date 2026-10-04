package jpa;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity 
@Table (name= "CategoriaLibro")

public class CategoriaLibro {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_categoria")
	 private Integer idCategoria;
	 
	 @Column(name = "nom_categoria")
	 private String nombre;
	 
	 @Column(name = "estado")
	 private String estado;
	 
	 public CategoriaLibro() {	 
	 }
	 
	 public Integer getIdCategoria() {
		 return idCategoria;
	 }
	 
	 public void setIdCategoria(Integer idCategoria) {
		 this.idCategoria = idCategoria;
	 }
	 
	 public String getNombre() {
		 return nombre;
	 }
	 
	 public void setNombre(String nombre) {
		 this.nombre = nombre;
	 }
	 
	 public String getEstado() {
		 return estado;
	 }
	 
	 public void setEstado(String estado) {
		 this.estado = estado;
	 }
}
