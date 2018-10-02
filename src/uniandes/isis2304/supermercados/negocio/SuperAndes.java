package uniandes.isis2304.supermercados.negocio;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.parranderos.negocio.TipoBebida;
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

	public VOCliente adicionarCliente(int idCliente, String nombre, String correo, String ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

	public VOSucursal adicionarSucursal(String ciudad, String sector, String direccion) {
		// TODO Auto-generated method stub
		return null;
	}

	public VOEstante adicionarBodega(int tipoProducto, int sucursal, Double capacidadVolumen, Double capacidadPeso) {
		// TODO Auto-generated method stub
		return null;
	}

	public VOEstante adicionarEstante(int tipoProducto, int sucursal, Double capacidadVolumen, Double capacidadPeso,
			int nivelAbastecimiento) {
		// TODO Auto-generated method stub
		return null;
	}

	public TipoProducto adicionarTipoProducto(String nombreTipo) {
		
        log.info ("Adicionando Tipo de bebida: " + nombreTipo);
        TipoProducto tipoBebida = psa.adicionarTipoPropucto(nombreTipo);		
        log.info ("Adicionando Tipo de bebida: " + tipoBebida);
        return tipoBebida;
		
	}

	public VOProveedor adicionarProveedor(int nit, String nombre, Double calificacionCalidad) {
		// TODO Auto-generated method stub
		return null;
	}

	public VOProducto adicionarProducto(String codigoBarras, int tipoProducto, String nombre, String marca,
			String presentacion, String unidadMedida, Double cantidadPresentacion, Double pesoEmpaque,
			Double volumenEmpaque) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
