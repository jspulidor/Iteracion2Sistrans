package uniandes.isis2304.supermercado.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import oracle.net.aso.v;
import uniandes.isis2304.supermercados.negocio.*;

public class PersistenciaSuperAndes 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaSuperAndes.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaSuperAndes instance;
	
	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, tipoProducto, producto, Sucural, bebedor, gustan, sirven y visitan
	 */
	private List <String> tablas;
	
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil sqlUtil;
	
	/**
	 * Atributo para el acceso a la tabla ALBERGAN de la base de datos
	 */
	private SQLAlbergan sqlAlbergan;

	/**
	 * Atributo para el acceso a la tabla ALMACENAN de la base de datos
	 */
	private SQLAlmacenan sqlAlmacenan;
	
	/**
	 * Atributo para el acceso a la tabla BODEGA de la base de datos
	 */
	private SQLBodega sqlBodega;
	
	/**
	 * Atributo para el acceso a la tabla CLIENTE de la base de datos
	 */
	private SQLCliente sqlCliente;
	
	/**
	 * Atributo para el acceso a la tabla COMPRASCLIENTES de la base de datos
	 */
	private SQLComprasClientes sqlComprasClientes;
	
	/**
	 * Atributo para el acceso a la tabla ESTANTE de la base de datos
	 */
	private SQLEstante sqlEstante;
	
	/**
	 * Atributo para el acceso a la tabla FACTURA de la base de datos
	 */
	private SQLFactura sqlFactura;
	
	/**
	 * Atributo para el acceso a la tabla INVENTARIO de la base de datos
	 */
	private SQLInventario sqlInventario;
	
	/**
	 * Atributo para el acceso a la tabla PEDIDO de la base de datos
	 */
	private SQLPedido sqlPedido;
	
	/**
	 * Atributo para el acceso a la tabla PRODUCTO de la base de datos
	 */
	private SQLProducto sqlProducto;
	
	/**
	 * Atributo para el acceso a la tabla PROMOCION de la base de datos
	 */
	private SQLPromocion sqlPromocion;
	
	/**
	 * Atributo para el acceso a la tabla PROMOCIONES de la base de datos
	 */
	private SQLPromociones sqlPromociones;
	
	/**
	 * Atributo para el acceso a la tabla PROVEEDOR de la base de datos
	 */
	private SQLProveedor sqlProveedor;
	
	/**
	 * Atributo para el acceso a la tabla PROVEEN de la base de datos
	 */
	private SQLProveen sqlProveen;
	
	/**
	 * Atributo para el acceso a la tabla SUCURSAL de la base de datos
	 */
	private SQLSucursal sqlSucursal;
	
	/**
	 * Atributo para el acceso a la tabla TIPOPRODUCTO de la base de datos
	 */
	private SQLTipoProducto sqlTipoProducto;
	
	/**
	 * Atributo para el acceso a la tabla VENTAS de la base de datos
	 */
	private SQLVentas sqlVentas;
	
	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaSuperAndes()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("SuperAndes");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("SuperAndes_sequence");
		tablas.add ("ALBERGAN");
		tablas.add ("ALMACENAN");
		tablas.add ("BODEGA");
		tablas.add ("CLIENTE");
		tablas.add ("COMPRASCLIENTES");
		tablas.add ("ESTANTE");
		tablas.add ("FACTURA");
		tablas.add("INVENTARIO");
		tablas.add("PEDIDO");
		tablas.add("PRODUCTO");
		tablas.add("PROMOCION");
		tablas.add("PROMOCIONES");
		tablas.add("PROVEEDOR");
		tablas.add("PROVEEN");
		tablas.add("SUCURSAL");
		tablas.add("TIPO_PRODUCTO");
		tablas.add("VENTAS");
	}
	
	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaSuperAndes(JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas(tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}
	
	/**
	 * @return Retorna el único objeto PersistenciaSuperAndes existente - Patrón SINGLETON
	 */
	public static PersistenciaSuperAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaSuperAndes();
		}
		return instance;
	}
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaSuperAndes existente - Patrón SINGLETON
	 */
	public static PersistenciaSuperAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaSuperAndes(tableConfig);
		}
		return instance;
	}
	
	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}

	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlAlbergan = new SQLAlbergan(this);
		sqlAlmacenan = new SQLAlmacenan(this);
		sqlBodega = new SQLBodega(this);
		sqlCliente = new SQLCliente(this);
		sqlComprasClientes = new SQLComprasClientes(this);
		sqlEstante = new SQLEstante(this);
		sqlFactura = new SQLFactura(this);	
		sqlInventario = new SQLInventario(this);
		sqlPedido = new SQLPedido(this);
		sqlProducto = new SQLProducto(this);
		sqlPromocion = new SQLPromocion(this);
		sqlPromociones = new SQLPromociones(this);
		sqlProveedor = new SQLProveedor(this);
		sqlProveen = new SQLProveen(this);
		sqlSucursal = new SQLSucursal(this);
		sqlTipoProducto = new SQLTipoProducto(this);
		sqlVentas = new SQLVentas(this);
		sqlUtil = new SQLUtil(this);
	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de SuperAndes
	 */
	public String darSeqSuperAndes()
	{
		return tablas.get(0);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Albergan de SuperAndes
	 */
	public String darTablaAlbergan()
	{
		return tablas.get(1);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Almacenan de SuperAndes
	 */
	public String darTablaAlmacenan()
	{
		return tablas.get(2);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bodega de SuperAndes
	 */
	public String darTablaBodega()
	{
		return tablas.get(4);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Cliente de SuperAndes
	 */
	public String darTablaClientes()
	{
		return tablas.get(5);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de ComprasCliente de SuperAndes
	 */
	public String darTablaComprasClientes()
	{
		return tablas.get(6);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Estante de SuperAndes
	 */
	public String darTablaEstante()
	{
		return tablas.get(7);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Factura de SuperAndes
	 */
	public String darTablaFactura()
	{
		return tablas.get(8);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Inventario de SuperAndes
	 */
	public String darTablaInventario()
	{
		return tablas.get(9);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Pedido de SuperAndes
	 */
	public String darTablaPedido()
	{
		return tablas.get(10);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Producto de SuperAndes
	 */
	public String darTablaProducto()
	{
		return tablas.get(11);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Promocion de SuperAndes
	 */
	public String darTablaPromocion()
	{
		return tablas.get(12);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Promociones de SuperAndes
	 */
	public String darTablaPromociones()
	{
		return tablas.get(13);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Proveedor de SuperAndes
	 */
	public String darTablaProveedor()
	{
		return tablas.get(14);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Proveen de SuperAndes
	 */
	public String darTablaProveen()
	{
		return tablas.get(15);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Sucursal de SuperAndes
	 */
	public String darTablaSucursal()
	{
		return tablas.get(16);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TipoProducto de SuperAndes
	 */
	public String darTablaTipoProducto()
	{
		return tablas.get(17);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Ventas de SuperAndes
	 */
	public String darTablaVentas()
	{
		return tablas.get(18);
	}
	
	/**
	 * Transacción para el generador de secuencia de SuperAndes
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de SuperAndes
	 */
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: "+ resp);
        return resp;
    }

	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Proveedores
	 * Adiciona entradas al log de la aplicación
	 * @param idProveedor - El NIT del proveedor
	 * @param nombre - El nombre del proveedor
	 * @param calificacionCalidad - La calificación de calidad que recibe el proveedor
	 * @return El objeto Proveedor adicionado. null si ocurre alguna Excepción
	 */
	public Proveedor adicionarProveedor(int idProveedor, String nombre, double calificacionCalidad)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlProveedor.adicionarProveedor(pm, idProveedor, nombre, calificacionCalidad);
            tx.commit();
            
            log.trace ("Inserción del proveedor: "+idProveedor+", "+nombre+", "+calificacionCalidad+": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Proveedor (idProveedor, nombre, calificacionCalidad);
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla TipoProducto
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo del producto
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepción
	 */
	public TipoProducto adicionarTipoProducto(String nombre, String categoria)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            int idTipoProducto = (int) nextval();
            long tuplasInsertadas = sqlTipoProducto.adicionarTipoProducto(pm, idTipoProducto, nombre, categoria);
            tx.commit();
            
            log.trace ("Inserción de tipo de bebida: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new TipoProducto(idTipoProducto, nombre, categoria);
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public List<TipoProducto> darTiposProductos(String nombre)
	{
		return sqlTipoProducto.darTiposProducto(pmf.getPersistenceManager());
	}
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Clientes
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del cliente
	 * @return El objeto Cliente adicionado. null si ocurre alguna Excepción
	 */
	public Cliente adicionarCliente(int idCliente, String nombre, String correo, String ciudad, String direccion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlCliente.adicionarCliente(pm, idCliente, nombre, correo, ciudad, direccion);
            tx.commit();

            log.trace ("Inserción del cliente: "+idCliente+", "+nombre+", "+correo+", "+ciudad+", "+direccion+": " + tuplasInsertadas + " tuplas insertadas");    
            return new Cliente (idCliente, nombre, correo, ciudad, direccion);
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Productos
	 * Adiciona entradas al log de la aplicación
	 * @param codigoDeBarras - El codigo de barras del producto
	 * @param idTipoProducto - El tipo de producto
	 * @param nombre - El nombre del producto
	 * @param marca - La marca del producto
	 * @param presentacion - La presentación del producto
	 * @param unidadDeMedida - La unidad en la cual está medido el producto
	 * @param cantidadPresentacion - La cantidad de producto que hay en la presentación
	 * @param pesoEmpaque - El peso del empaque 
	 * @param volumenEmpaque - El volumen del empaque
	 * @return El objeto Producto adicionado. null si ocurre alguna Excepción
	 */
	public Producto adicionarProducto(String codigoDeBarras, int idTipoProducto, String nombre, String marca, String presentacion, String unidadDeMedida, double cantidadPresentacion, double pesoEmpaque, double volumenEmpaque)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlProducto.adicionarProducto(pm, codigoDeBarras, idTipoProducto, nombre, marca, presentacion, unidadDeMedida, cantidadPresentacion, pesoEmpaque, volumenEmpaque);
            tx.commit();

            log.trace ("Inserción del proveedor: "+codigoDeBarras+", "+idTipoProducto+", "+nombre+", "+marca+", "+presentacion+", "+unidadDeMedida+", "+cantidadPresentacion+", "+pesoEmpaque+", "+volumenEmpaque+": " + tuplasInsertadas + " tuplas insertadas");    
            return new Producto(codigoDeBarras, idTipoProducto, nombre, marca, presentacion, cantidadPresentacion, unidadDeMedida, pesoEmpaque, volumenEmpaque);
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Sucursal
	 * Adiciona entradas al log de la aplicación
	 * @param ciudad - La ciudad de la sucursal
	 * @param sector - El sector de la sucursal
	 * @param direccion - La dirección de la sucursal
	 * @return El objeto Sucursal adicionado. null si ocurre alguna Excepción
	 */
	public Sucursal adicionarSucursal(String ciudad, String sector, String direccion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            int idSucursal = (int) nextval();
            long tuplasInsertadas = sqlSucursal.adicionarSucursal(pm, idSucursal, ciudad, direccion, sector);
            tx.commit();

            log.trace ("Inserción de Sucursal: "+idSucursal+", "+ciudad+", "+sector+", "+direccion+": " + tuplasInsertadas + " tuplas insertadas");

            return new Sucursal(idSucursal, ciudad, sector, direccion);
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Sucursal
	 * Adiciona entradas al log de la aplicación
	 * @param idTipoProducto - El tipo de producto que almaenará
	 * @param idSucursal - La sucursal en la cual está
	 * @param capacidadVolumen - La capacidad en volumen que podrá almacenar
	 * @param capacidadPeso - La capacidad en peso que podrá almacenar.
	 * @return El objeto Bodega adicionado. null si ocurre alguna Excepción
	 */
	public Bodega adicionarBodegaASucursal(int idTipoProducto, int idSucursal, double capacidadVolumen, double capacidadPeso)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            int idBodega = (int) nextval();
            long tuplasInsertadas = sqlBodega.adicionarBodega(pm, idBodega, idTipoProducto, idSucursal, capacidadVolumen, capacidadPeso);
            tx.commit();

            log.trace ("Inserción de Bodega: "+idBodega+", "+idTipoProducto+", "+idSucursal+", "+capacidadVolumen+", "+capacidadPeso+": " + tuplasInsertadas + " tuplas insertadas");

            return new Bodega(idBodega, idTipoProducto, idSucursal, capacidadVolumen, capacidadPeso);
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Sucursal
	 * Adiciona entradas al log de la aplicación
	 * @param idTipoProducto - El tipo de producto que albergará
	 * @param idSucursal - La sucursal en la cual estará
	 * @param capacidadVolumen - Capacidad en volumen que podrá albergar
	 * @param capacidadPeso - Capacidad en peso que podrá albergar
	 * @param nivelAbastecimiento - Nivel de abastecimiento del estante
	 * @return El objeto Estante adicionado. null si ocurre alguna Excepción
	 */
	public Estante adicionarEstanteASucursal(int idTipoProducto, int idSucursal, double capacidadVolumen, double capacidadPeso, int nivelAbastecimiento)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            int idEstante = (int) nextval();
            long tuplasInsertadas = sqlEstante.adicionarEstante(pm, idEstante, idTipoProducto, idSucursal, capacidadVolumen, capacidadPeso, nivelAbastecimiento);
            tx.commit();

            log.trace ("Inserción de Estante: " +idEstante+", "+idTipoProducto+", "+idSucursal+", "+capacidadVolumen+", "+capacidadPeso+", "+nivelAbastecimiento+": " + tuplasInsertadas + " tuplas insertadas");

            return new Estante(idEstante, idTipoProducto, idSucursal, capacidadVolumen, capacidadPeso, nivelAbastecimiento);
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}	
}
