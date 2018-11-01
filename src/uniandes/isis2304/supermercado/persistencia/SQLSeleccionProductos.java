package uniandes.isis2304.supermercado.persistencia;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLSeleccionProductos 
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
	public SQLSeleccionProductos(PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar una SELECCIONPRODUCTOS a la base de datos de SuperAndes
	 * @param id - Identificador de la seleccion
	 * @param idVisitaMercado - Identificador de la visita
	 * @return EL número de tuplas insertadas
	 */	
	public long adicionarCarritoCompras(PersistenceManager pm, int id, int idVisitaMercado)
	{
		Query sql = pm.newQuery(SQL, "INSERT INTO "+psa.darTablaSeleccionProductos()+ "(id, idVisitaMercado) values (?, ?)");
		sql.setParameters(id, idVisitaMercado);
		return (long) sql.executeUnique();
	}
}
