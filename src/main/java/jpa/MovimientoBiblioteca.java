package jpa;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="MovimientoBiblioteca")

public class MovimientoBiblioteca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movimiento")
	private Integer idMovimiento;
	
	@ManyToOne
	@JoinColumn(name= "id_libro")
	private Libro libro;
	
	
	@Column(name = "tipo_movimiento")
	private String tipoMovimiento;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "fecha_movimiento")
	private LocalDateTime fechaMovimiento;
	
	public MovimientoBiblioteca() {
	}
	
	public Integer getIdMovimiento() {
		return idMovimiento;
	}
	
	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	
	public Libro getLibro() {
		return libro;
	}
	
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer Cantidad) {
		this.cantidad = Cantidad;
	}
	
	public LocalDateTime getFechaMovimiento() {
		return fechaMovimiento;
	}
	
	public void setFechaMovimiento(LocalDateTime fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	
}
