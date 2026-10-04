package jpa;

import java.util.List;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class Pregunta02_BustesVasquez {

	public static void main(String []args ) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlconex");
		
		EntityManager manager = fabrica.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			
			CategoriaLibro catRecuperada = manager.find(CategoriaLibro.class,1);
			
			if(catRecuperada == null) {
				throw new RuntimeException("No se encontro la categoria con ID 1");
			}
			
			Libro nuevoLib = new Libro();
			
			nuevoLib.setTitulo("Aprendiendo a programar");
			nuevoLib.setAutor("Charles");
			nuevoLib.setEjemplaresDisponibles(10);
			nuevoLib.setCategoriaLibro(catRecuperada);
			
			manager.persist(nuevoLib);
			System.out.println("LIBRO REGISTRADO CORRECTAMENTE CON ID" + nuevoLib.getIdLibro());
			
			
			Libro libroRecuperado = manager.find(Libro.class, nuevoLib.getIdLibro());
			
			int cantidadPrestada = 3;
			
			MovimientoBiblioteca movimiento = new MovimientoBiblioteca();
			movimiento.setLibro(libroRecuperado);
			movimiento.setTipoMovimiento("PRESTAMO");
			movimiento.setCantidad(cantidadPrestada);
			movimiento.setFechaMovimiento(LocalDateTime.now());
			
			manager.persist(movimiento);
			System.out.println("Movimiento de PRESTAMO registrado correctamente");
			
			int nuevaDisponibilidad = libroRecuperado.getEjemplaresDisponibles() - cantidadPrestada;
            libroRecuperado.setEjemplaresDisponibles(nuevaDisponibilidad);

            manager.merge(libroRecuperado); 
            System.out.println(" Disponibilidad actualizada a: " + nuevaDisponibilidad);

            manager.getTransaction().commit();
            System.out.println("Transacción ejecutada con éxito ");

            int idCategoriaBuscar = 1;
            int minDisponibles = 5;

            String jpql = "SELECT l FROM Libro l "
                    + "WHERE l.categorialibro.idCategoria = :p_categoria "
                    + "AND l.ejemplaresdisponibles >= :p_disponibles "
                    + "ORDER BY l.titulo ASC";

            TypedQuery<Libro> query = manager.createQuery(jpql, Libro.class);
            query.setParameter("p_categoria", idCategoriaBuscar);
            query.setParameter("p_disponibles", minDisponibles);

            List<Libro> listaLibros = query.getResultList();

            System.out.println(" LISTADO DE LIBROS ");
            System.out.println(" Categoria ID = " + idCategoriaBuscar + "  Ejemplares >= " + minDisponibles);

            for (Libro l : listaLibros) {
                System.out.println("Código    : " + l.getIdLibro());
                System.out.println("Título    : " + l.getTitulo());
                System.out.println("Autor     : " + l.getAutor());
                System.out.println("Categoría : " + l.getCategoriaLibro().getNombre());
                System.out.println("Disponib. : " + l.getEjemplaresDisponibles());
                System.out.println("-----------------------------------------------------------------------------");
            }

        } catch (Exception e) {

            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }

            System.err.println("Ocurrió un error durante la operación de persistencia:");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();

        } finally {

            if (manager.isOpen()) {
                manager.close();
            }

            if (fabrica.isOpen()) {
                fabrica.close();
            }
            
            System.out.println("Recursos cerrados correctamente.");
			
			
		}
	}
	
}
