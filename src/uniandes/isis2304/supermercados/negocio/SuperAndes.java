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
	
	
	public Cliente adicionarCliente(int idCliente, String nombre, String correo, String ciudad, String direccion) {
		
        log.info ("Adicionando cliente con nombre : " + nombre);
        Cliente cliente = psa.adicionarCliente(idCliente,nombre, correo, ciudad, direccion);		
        log.info ("Adicionando cliente con nombre : " + nombre);
        return cliente;
		
	}

	public VOSucursal adicionarSucursal(String ciudad, String sector, String direccion) {
        log.info ("Adicionando sucursal con direccion : " + direccion);
        Sucursal sucursal = psa.adicionarSucursal(ciudad, sector, direccion);		
        log.info ("Adicionando sucursal con direccion : " + direccion);
        return sucursal;
	}

	public Bodega adicionarBodega(int tipoProducto, int sucursal, Double capacidadVolumen, Double capacidadPeso) {
        log.info ("Adicionando bodega" );
        Bodega bodega = psa.adicionarBodegaASucursal(tipoProducto, sucursal, capacidadVolumen, capacidadPeso);		
        log.info ("Adicionando bodega");
        return bodega;
	}

	public Estante adicionarEstante(int tipoProducto, int sucursal, Double capacidadVolumen, Double capacidadPeso,
			int nivelAbastecimiento) {
        log.info ("Adicionando estante" );
        Estante estante = psa.adicionarEstanteASucursal(tipoProducto, sucursal, capacidadVolumen, capacidadPeso, nivelAbastecimiento);		
        log.info ("Adicionando estante");
        return estante;
	}

	public TipoProducto adicionarTipoProducto(String nombreTipo, String categoria) {
		
        log.info ("Adicionando Tipo de producto: " + nombreTipo);
        TipoProducto tipoProducto = psa.adicionarTipoProducto(nombreTipo, categoria);		
        log.info ("Adicionando Tipo de producto: " + nombreTipo);
        return tipoProducto;
		
	}

	public Proveedor adicionarProveedor(int nit, String nombre, Double calificacionCalidad) {
        log.info ("Adicionando Proveedor" );
        Proveedor proveedor = psa.adicionarProveedor(nit,nombre,calificacionCalidad);		
        log.info ("Adicionando proveedor");
        return proveedor;
	}

	public Producto adicionarProducto(String codigoBarras, int tipoProducto, String nombre, String marca,
			String presentacion, String unidadMedida, Double cantidadPresentacion, Double pesoEmpaque,
			Double volumenEmpaque) {
        log.info ("Adicionando Producto" );
        Producto producto = psa.adicionarProducto(codigoBarras,tipoProducto,nombre,marca,presentacion,unidadMedida,cantidadPresentacion,pesoEmpaque,volumenEmpaque);		
        log.info ("Adicionando Producto");
        return producto;
	}
	


}
