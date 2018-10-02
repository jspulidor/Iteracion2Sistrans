package uniandes.isis2304.supermercados.negocio;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.supermercado.persistencia.PersistenciaSuperAndes;


public class SuperAndes 
{
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(SuperAndes.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaSuperAndes psa;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public SuperAndes ()
	{
		psa = PersistenciaSuperAndes.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public SuperAndes (JsonObject tableConfig)
	{
		this.psa = PersistenciaSuperAndes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		psa.cerrarUnidadPersistencia ();
	}
	

	/* ****************************************************************
	 * 			Métodos para administración
	 *****************************************************************/

	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarSuperAndes ()
	{
        log.info ("Limpiando la BD de Parranderos");
        long [] borrrados = psa.limpiarSuperAndes();	
        log.info ("Limpiando la BD de Parranderos: Listo!");
        return borrrados;
	}

}
