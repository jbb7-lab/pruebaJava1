package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Pregunta01_BustesVasquez {

	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlconex");
		
		EntityManager manager = fabrica.createEntityManager();
		
		CategoriaLibro cat = new CategoriaLibro();
		
		cat.setNombre("nueva categoria prueba");
		cat.setEstado("Activo");
		
		
		try {
			
			manager.getTransaction().begin();
			
			manager.persist(cat);
			
			manager.getTransaction().commit();
			
			System.out.println("REgistro OK");
			System.out.println("Codigo generado" + cat.getIdCategoria());
			System.out.println(cat);
			
			
		}catch(Exception e) {
			if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
			System.err.println("No se pudo realizar el registro");
            System.err.println("Error: " + e.getMessage());
            
            e.printStackTrace();
		}finally {

            if (manager.isOpen()) {
                manager.close();
            }

            if (fabrica.isOpen()) {
                fabrica.close();
            }
		
	
		}
		
	}
	
}
