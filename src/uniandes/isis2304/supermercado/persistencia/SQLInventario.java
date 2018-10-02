package uniandes.isis2304.supermercado.persistencia;

import javax.jdo.PersistenceManager;

class SQLInventario 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaSuperAndes psa;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLInventario(PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los INVENTARIO de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos INVENTARIO
	 */
	
	public List<Inventario> darInventario(PersistenceManager pm)
	{
		Query sql = pm.newQuery(SQL, "SELECT * FROM")
	}





}
