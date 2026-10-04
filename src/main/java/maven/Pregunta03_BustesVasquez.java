package maven;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pregunta03_BustesVasquez {

	private static final Logger logger = LoggerFactory.getLogger(Pregunta03_BustesVasquez.class);

    public static void main(String[] args) {

        logger.info("  INICIANDO PRUEBA FUNCIONAL DE DEPENDENCIAS ADICIONALES  ");
       

        String tituloLibro = "   algebra lineal avanzada   ";
        
        String tituloLimpio = StringUtils.trimToEmpty(tituloLibro);
        String tituloCapitalizado = StringUtils.capitalize(tituloLimpio);
        boolean esVacio = StringUtils.isBlank(tituloLibro);

        logger.info("Prueba de Apache Commons Lang 3:");
        logger.info("Texto original    : ", tituloLibro);
        logger.info("Texto formateado  : ", tituloCapitalizado);
        logger.info("¿Está en blanco?  : ", esVacio);

        logger.info("Prueba de Logback (Logging):");
        
        try {
            int totalEjemplares = 15;
            int prestados = 5;
            int disponibles = totalEjemplares - prestados;
            
            logger.info("Cálculo de stock completado. Disponibles: ", disponibles);
            
        } catch (Exception e) {
            logger.error("Error durante el proceso: ", e);
        }

        logger.info("PRUEBA COMPLETADA EXITOSAMENTE");
    }
}
