package uniandes.isis2304.supermercado.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.supermercados.negocio.Estante;
import uniandes.isis2304.supermercados.negocio.TipoProducto;

class SQLEstante {


	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	
	private final static String SQL =PersistenciaSuperAndes.SQL;
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private PersistenciaSuperAndes ps;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor de la clase
	 */
	public SQLEstante(PersistenciaSuperAndes pPs)
	{
		this.ps=pPs;
	}
	
	/**
	 * Método que adiciona una bodega a la base de datos de SuperAndes
	 */
	public long adicionarEstante(PersistenceManager pm, int idEstante, int tipoProducto, int sucursal, Double capacidadVolumen, Double capacidadPeso, int nivelAbastecimiento)
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaEstante () + "(id_estante, tipo_producto, sucursal, capacidad_volumen, capacidad_peso, nivel_abastecimiento) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idEstante, tipoProducto, sucursal, capacidadVolumen, capacidadPeso, nivelAbastecimiento);
        return (long) q.executeUnique();     
	}
	
}
