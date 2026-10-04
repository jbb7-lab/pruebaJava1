package jpa;

import javax.persistence.*;


@Entity
@Table(name = "Libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_libro")
	private Integer idLibro;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "autor")
	private String autor;
	
    @Column(name ="ejemplares_disponibles")
    private Integer ejemplaresdisponibles;
	
	
	@ManyToOne()
	@JoinColumn(name = "id_categoria")
	private CategoriaLibro categorialibro;
	
	public Libro() {
	}
	
	public Integer getIdLibro() {
		return idLibro;
	}
	
	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Integer getEjemplaresDisponibles() {
		return ejemplaresdisponibles;
	}
	
	public void setEjemplaresDisponibles(Integer ejemplaresDisponibles) {
		this.ejemplaresdisponibles = ejemplaresDisponibles;
	}
    
	public CategoriaLibro getCategoriaLibro() {
		return categorialibro;
	}
	
	public void setCategoriaLibro(CategoriaLibro categoriaLibro) {
		this.categorialibro = categoriaLibro;
	}
}


