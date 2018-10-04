package uniandes.isis2304.supermercado.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.supermercados.negocio.Bodega;
import uniandes.isis2304.supermercados.negocio.TipoProducto;

class SQLBodega {

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
	public SQLBodega(PersistenciaSuperAndes pPs)
	{
		this.ps=pPs;
	}
	
	/**
	 * Método que adiciona una bodega a la base de datos de SuperAndes
	 */
	public long adicionarBodega(PersistenceManager pm, int idBodega, int tipoProducto, int sucursal, Double capacidadVolumen, Double capacidadPeso)
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaBodega () + "(id_bodega, tipo_producto, sucursal, capacidad_volumen, capacidad_peso, indice_ocupacion) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idBodega, tipoProducto, sucursal, capacidadVolumen, capacidadPeso);
        return (long) q.executeUnique();     
	}
	
}
