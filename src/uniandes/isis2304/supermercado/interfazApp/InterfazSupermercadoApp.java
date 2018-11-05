package uniandes.isis2304.supermercado.interfazApp;

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Desktop;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.BufferedWriter;

import java.io.File;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.lang.reflect.Method;

import java.sql.Timestamp;

import javax.jdo.JDODataStoreException;

import javax.swing.ImageIcon;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JMenu;

import javax.swing.JMenuBar;

import javax.swing.JMenuItem;

import javax.swing.JOptionPane;

import javax.swing.UIManager;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

import com.google.gson.Gson;

import com.google.gson.JsonArray;

import com.google.gson.JsonElement;

import com.google.gson.JsonObject;

import com.google.gson.stream.JsonReader;

import uniandes.isis2304.supermercados.negocio.SuperAndes;

import uniandes.isis2304.supermercados.negocio.VOBodega;

import uniandes.isis2304.supermercados.negocio.VOCliente;

import uniandes.isis2304.supermercados.negocio.VOEstante;

import uniandes.isis2304.supermercados.negocio.VOProducto;

import uniandes.isis2304.supermercados.negocio.VOProveedor;

import uniandes.isis2304.supermercados.negocio.VOSucursal;

import uniandes.isis2304.supermercados.negocio.VOTipoProducto;

@SuppressWarnings("serial")

public class InterfazSupermercadoApp extends JFrame implements ActionListener 
{

	/*
	 * ****************************************************************
	 * 
	 * Constantes
	 * 
	 *****************************************************************/

	/**
	 * 
	 * Logger para escribir la traza de la ejecuci�n
	 * 
	 */

	private static Logger log = Logger.getLogger(InterfazSupermercadoApp.class.getName());

	/**
	 * 
	 * Ruta al archivo de configuraci�n de la interfaz
	 * 
	 */

	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp.json";

	/**
	 * 
	 * Ruta al archivo de configuraci�n de los nombres de tablas de la base de datos
	 * 
	 */

	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD.json";

	/*
	 * ****************************************************************
	 * 
	 * Atributos
	 * 
	 *****************************************************************/

	/**
	 * 
	 * Objeto JSON con los nombres de las tablas de la base de datos que se quieren
	 * utilizar
	 * 
	 */

	private JsonObject tableConfig;

	/**
	 * 
	 * Asociaci�n a la clase principal del negocio.
	 * 
	 */

	private SuperAndes superAndes;

	/*
	 * ****************************************************************
	 * 
	 * Atributos de interfaz
	 * 
	 *****************************************************************/

	/**
	 * 
	 * Objeto JSON con la configuraci�n de interfaz de la app.
	 * 
	 */

	private JsonObject guiConfig;

	/**
	 * 
	 * Panel de despliegue de interacci�n para los requerimientos
	 * 
	 */

	private PanelDatos panelDatos;

	/**
	 * 
	 * Men� de la aplicaci�n
	 * 
	 */

	private JMenuBar menuBar;

	/*
	 * ****************************************************************
	 * 
	 * M�todos
	 * 
	 *****************************************************************/

	/**
	 * 
	 * Construye la ventana principal de la aplicaci�n. <br>
	 * 
	 * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
	 * 
	 */

	public InterfazSupermercadoApp()

	{

		// Carga la configuraci�n de la interfaz desde un archivo JSON

		guiConfig = openConfig("Interfaz", CONFIG_INTERFAZ);

		// Configura la apariencia del frame que contiene la interfaz gr�fica

		configurarFrame();

		if (guiConfig != null)

		{

			crearMenu(guiConfig.getAsJsonArray("menuBar"));

		}

		tableConfig = openConfig("Tablas BD", CONFIG_TABLAS);

		superAndes = new SuperAndes(tableConfig);

		String path = guiConfig.get("bannerPath").getAsString();

		panelDatos = new PanelDatos();

		setLayout(new BorderLayout());

		add(new JLabel(new ImageIcon(path)), BorderLayout.NORTH);

		add(panelDatos, BorderLayout.CENTER);

	}

	/*
	 * ****************************************************************
	 * 
	 * M�todos de configuraci�n de la interfaz
	 * 
	 *****************************************************************/

	/**
	 * 
	 * Lee datos de configuraci�n para la aplicaci�, a partir de un archivo JSON o
	 * con valores por defecto si hay errores.
	 * 
	 * @param tipo       - El tipo de configuraci�n deseada
	 * 
	 * @param archConfig - Archivo Json que contiene la configuraci�n
	 * 
	 * @return Un objeto JSON con la configuraci�n del tipo especificado
	 * 
	 *         NULL si hay un error en el archivo.
	 * 
	 */

	private JsonObject openConfig(String tipo, String archConfig)

	{

		JsonObject config = null;

		try

		{

			Gson gson = new Gson();

			FileReader file = new FileReader(archConfig);

			JsonReader reader = new JsonReader(file);

			config = gson.fromJson(reader, JsonObject.class);

			log.info("Se encontr� un archivo de configuraci�n v�lido: " + tipo);

		}

		catch (Exception e)

		{

// e.printStackTrace ();

			log.info("NO se encontr� un archivo de configuraci�n v�lido");

			JOptionPane.showMessageDialog(null,
					"No se encontr� un archivo de configuraci�n de interfaz v�lido: " + tipo, "Parranderos App",
					JOptionPane.ERROR_MESSAGE);

		}

		return config;

	}

	/**
	 * 
	 * M�todo para configurar el frame principal de la aplicaci�n
	 * 
	 */

	private void configurarFrame()

	{

		int alto = 0;

		int ancho = 0;

		String titulo = "";

		if (guiConfig == null)

		{

			log.info("Se aplica configuraci�n por defecto");

			titulo = "SuperAndes APP Default";

			alto = 300;

			ancho = 500;

		}

		else

		{

			log.info("Se aplica configuraci�n indicada en el archivo de configuraci�n");

			titulo = guiConfig.get("title").getAsString();

			alto = guiConfig.get("frameH").getAsInt();

			ancho = guiConfig.get("frameW").getAsInt();

		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocation(50, 50);

		setResizable(true);

		setBackground(Color.WHITE);

		setTitle(titulo);

		setSize(ancho, alto);

	}

	/**
	 * 
	 * M�todo para crear el men� de la aplicaci�n con base em el objeto JSON le�do
	 * 
	 * Genera una barra de men� y los men�s con sus respectivas opciones
	 * 
	 * @param jsonMenu - Arreglo Json con los men�s deseados
	 * 
	 */

	private void crearMenu(JsonArray jsonMenu)

	{

		// Creaci�n de la barra de men�s

		menuBar = new JMenuBar();

		for (JsonElement men : jsonMenu)

		{

			// Creaci�n de cada uno de los men�s

			JsonObject jom = men.getAsJsonObject();

			String menuTitle = jom.get("menuTitle").getAsString();

			JsonArray opciones = jom.getAsJsonArray("options");

			JMenu menu = new JMenu(menuTitle);

			for (JsonElement op : opciones)

			{

				// Creaci�n de cada una de las opciones del men�

				JsonObject jo = op.getAsJsonObject();

				String lb = jo.get("label").getAsString();

				String event = jo.get("event").getAsString();

				JMenuItem mItem = new JMenuItem(lb);

				mItem.addActionListener(this);

				mItem.setActionCommand(event);

				menu.add(mItem);

			}

			menuBar.add(menu);

		}

		setJMenuBar(menuBar);

	}

	/*
	 * ****************************************************************
	 * 
	 * CRUD de Cliente
	 * 
	 *****************************************************************/

	public void adicionarCliente()

	{

		try

		{

			String idS = JOptionPane.showInputDialog(this, "Cual es el numero de identificaci�n del cliente?",
					"Adicionar Cliente", JOptionPane.QUESTION_MESSAGE);

			String nombre = JOptionPane.showInputDialog(this, "Cual es el nombre del cliente?", "Adicionar Cliente",
					JOptionPane.QUESTION_MESSAGE);

			String correo = JOptionPane.showInputDialog(this, "Cual es el correo del cliente?", "Adicionar Cliente",
					JOptionPane.QUESTION_MESSAGE);

			String ciudad = JOptionPane.showInputDialog(this, "Cual es la ciudad de residencia del cliente?",
					"Adicionar Cliente", JOptionPane.QUESTION_MESSAGE);

			String direccion = JOptionPane.showInputDialog(this, "Cual es la ciudad de residencia del cliente?",
					"Adicionar Cliente", JOptionPane.QUESTION_MESSAGE);

			if (idS != null && nombre != null && correo != null && ciudad != null && direccion != null)

			{

				int idCliente = Integer.parseInt(idS);

				VOCliente tb = superAndes.adicionarCliente(idCliente, nombre, correo, ciudad, direccion);

				if (tb == null)

				{

					throw new Exception("No se pudo crear un cliente con la informaci�n dada ");

				}

				String resultado = "En adicionarCliente\n\n";

				resultado += "Cliente adicionado exitosamente: " + tb;

				resultado += "\n Operaci�n terminada";

				panelDatos.actualizarInterfaz(resultado);

			}

			else

			{

				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");

			}

		}

		catch (Exception e)

		{

// e.printStackTrace();

			String resultado = generarMensajeError(e);

			panelDatos.actualizarInterfaz(resultado);

		}

	}

	public void comprar()

	{

		try

		{

			String idClienteP = JOptionPane.showInputDialog(this, "Cual es el numero de identificaci�n del cliente?",
					"Comprar", JOptionPane.QUESTION_MESSAGE);

			String idSucursalP = JOptionPane.showInputDialog(this,
					"Cual es el id de la sucursal donde va a hacer la compra?", "Comprar",
					JOptionPane.QUESTION_MESSAGE);

			if (idClienteP != null && idSucursalP != null)

			{

				int idCliente = Integer.parseInt(idClienteP);

				int idSucursal = Integer.parseInt(idSucursalP);

				Timestamp fecha = new Timestamp(System.currentTimeMillis());

				long tb = superAndes.solicitarCarritoCompras(idCliente, idSucursal, "NO", "NO", fecha);

				if (tb == -1)

				{

					throw new Exception("No se pudo solicitar un carrito de compras");

				}

				String resultado = "En comprar\n\n";

				resultado += "Solicitando carrito de compras: " + tb;

				resultado += "\n Operaci�n terminada";

				panelDatos.actualizarInterfaz(resultado);

			}

			else

			{

				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");

			}

		}

		catch (Exception e)

		{

// e.printStackTrace();

			String resultado = generarMensajeError(e);

			panelDatos.actualizarInterfaz(resultado);

		}

	}

	public void adicionarProductosAlCarrito()

	{

		try

		{

			String idClienteP = JOptionPane.showInputDialog(this, "Cual es el id del cliente?", "Adicionar Productos",
					JOptionPane.QUESTION_MESSAGE);

			String idProductoP = JOptionPane.showInputDialog(this,
					"Cual es el id del producto que quiere a�adir al carrito?", "Adicionar Productos",
					JOptionPane.QUESTION_MESSAGE);

			String cantidadProductoP = JOptionPane.showInputDialog(this,
					"Qu� cantidad del producto quiere a�adir al carrito?", "Adicionar Productos",
					JOptionPane.QUESTION_MESSAGE);

			String idEstanteP = JOptionPane.showInputDialog(this,
					"Cual es el id del estante del que cogi� el producto?", "Adicionar Productos",
					JOptionPane.QUESTION_MESSAGE);

			if (idClienteP != null && idProductoP != null && cantidadProductoP != null && idEstanteP != null)

			{

				int idCliente = Integer.parseInt(idClienteP);

				int idProducto = Integer.parseInt(idProductoP);

				int cantidadProducto = Integer.parseInt(cantidadProductoP);

				int idEstante = Integer.parseInt(idEstanteP);

				long tb = superAndes.adicionarProductosACarrito(idProducto, idCliente, cantidadProducto, idEstante);

				if (tb == -1)

				{

					throw new Exception("No se pudo a�adir un producto al carrito ");

				}

				String resultado = "En adicionarProductosAlCarrito\n\n";

				resultado += "Producto adicionado exitosamente: " + tb;

				resultado += "\n Operaci�n terminada";

				panelDatos.actualizarInterfaz(resultado);

			}

			else

			{

				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");

			}

		}

		catch (Exception e)

		{

// e.printStackTrace();

			String resultado = generarMensajeError(e);

			panelDatos.actualizarInterfaz(resultado);

		}

	}

	public void devolverProductosDelCarrito()

	{

		try

		{

			String idClienteP = JOptionPane.showInputDialog(this, "Cual es el id del Cliente?", "Devolver Producto",
					JOptionPane.QUESTION_MESSAGE);

			String idProductoP = JOptionPane.showInputDialog(this, "Cual es el id del producto que quiere devolver?",
					"DevolverProducto", JOptionPane.QUESTION_MESSAGE);

			String idEstanteP = JOptionPane.showInputDialog(this, "Cual es el id del estante?", "DevolverProducto",
					JOptionPane.QUESTION_MESSAGE);

			String cantidadP = JOptionPane.showInputDialog(this, "Cual es la cantidad de producto que quiere devolver?",
					"DevolverProducto", JOptionPane.QUESTION_MESSAGE);

			if (idClienteP != null && idProductoP != null && idEstanteP != null && cantidadP != null)

			{

				int idCliente = Integer.parseInt(idClienteP);

				int idProducto = Integer.parseInt(idProductoP);

				int idEstante = Integer.parseInt(idEstanteP);

				int cantidad = Integer.parseInt(cantidadP);

				long tb = superAndes.devolverProductosDelCarrito(idProducto, idCliente, idEstante, cantidad);

				if (tb == -1)

				{

					throw new Exception("No se pudieron devolver los productos ");

				}

				String resultado = "En devolverProductosDelCarrito\n\n";

				resultado += "Producto devuelto exitosamente: " + tb;

				resultado += "\n Operaci�n terminada";

				panelDatos.actualizarInterfaz(resultado);

			}

			else

			{

				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");

			}

		}

		catch (Exception e)

		{

// e.printStackTrace();

			String resultado = generarMensajeError(e);

			panelDatos.actualizarInterfaz(resultado);

		}

	}

	public void abandonarCarrito()

	{

		try

		{

			String idS = JOptionPane.showInputDialog(this, "Cual es el numero de identificaci�n del cliente?",
					"Adicionar Cliente", JOptionPane.QUESTION_MESSAGE);

			String nombre = JOptionPane.showInputDialog(this, "Cual es el nombre del cliente?", "Adicionar Cliente",
					JOptionPane.QUESTION_MESSAGE);

			String correo = JOptionPane.showInputDialog(this, "Cual es el correo del cliente?", "Adicionar Cliente",
					JOptionPane.QUESTION_MESSAGE);

			String ciudad = JOptionPane.showInputDialog(this, "Cual es la ciudad de residencia del cliente?",
					"Adicionar Cliente", JOptionPane.QUESTION_MESSAGE);

			String direccion = JOptionPane.showInputDialog(this, "Cual es la ciudad de residencia del cliente?",
					"Adicionar Cliente", JOptionPane.QUESTION_MESSAGE);

			if (idS != null && nombre != null && correo != null && ciudad != null && direccion != null)

			{

				int idCliente = Integer.parseInt(idS);

				VOCliente tb = superAndes.adicionarCliente(idCliente, nombre, correo, ciudad, direccion);

				if (tb == null)

				{

					throw new Exception("No se pudo crear un cliente con la informaci�n dada ");

				}

				String resultado = "En adicionarCliente\n\n";

				resultado += "Cliente adicionado exitosamente: " + tb;

				resultado += "\n Operaci�n terminada";

				panelDatos.actualizarInterfaz(resultado);

			}

			else

			{

				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");

			}

		}

		catch (Exception e)

		{

// e.printStackTrace();

			String resultado = generarMensajeError(e);

			panelDatos.actualizarInterfaz(resultado);

		}

	}

	public void hacerCheckOut()

	{

	}

	/*
	 * ****************************************************************
	 * 
	 * CRUD de Sucursal
	 * 
	 *****************************************************************/

	public void adicionarSucursal()

	{

		try

		{

			String ciudad = JOptionPane.showInputDialog(this, "En qu� ciudad se encuentra la sucursal?",
					"Adicionar Sucursal", JOptionPane.QUESTION_MESSAGE);

			String sector = JOptionPane.showInputDialog(this, "En qu� sector se encuentra la bodega?",
					"Adicionar Sucursal", JOptionPane.QUESTION_MESSAGE);

			String direccion = JOptionPane.showInputDialog(this, "Cual es la direcci�n de la sucursal?",
					"Adicionar Sucursal", JOptionPane.QUESTION_MESSAGE);

			if (ciudad != null && sector != null && direccion != null)

			{

				VOSucursal tb = superAndes.adicionarSucursal(ciudad, sector, direccion);

				if (tb == null)

				{

					throw new Exception("No se pudo crear una sucursal con la informaci�n dada ");

				}

				String resultado = "En adicionarSucursal\n\n";

				resultado += "Sucursal adicionada exitosamente: " + tb;

				resultado += "\n Operaci�n terminada";

				panelDatos.actualizarInterfaz(resultado);

			}

			else

			{

				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");

			}

		}

		catch (Exception e)

		{

// e.printStackTrace();

			String resultado = generarMensajeError(e);

			panelDatos.actualizarInterfaz(resultado);

		}

	}

	public void recolectarProductosAbandonados()

	{

		try

		{

			String idProductoP = JOptionPane.showInputDialog(this, "Ingrese el id del producto que quiere recolectar",
					"Recolectar Productos Abandonados", JOptionPane.QUESTION_MESSAGE);

			String idEstanteP = JOptionPane.showInputDialog(this, "Ingrese el id del estante",
					"Recolectar Productos Abandonados", JOptionPane.QUESTION_MESSAGE);

			String cantidadP = JOptionPane.showInputDialog(this, "Ingrese la cantidad",
					"Recolectar Productos Abandonados", JOptionPane.QUESTION_MESSAGE);

			if (idProductoP != null && idEstanteP!= null && cantidadP != null)

			{
				
				int idProducto = Integer.parseInt(idProductoP);
				int idEstante = Integer.parseInt(idEstanteP);
				int cantidad = Integer.parseInt(cantidadP);
				long tb = superAndes.recolectarProductosAbandonados(idProducto, idEstante, cantidad);

				if (tb == -1)

				{

					throw new Exception("No se pudieron recolectar los productos indicados ");

				}

				String resultado = "En adicionarSucursal\n\n";

				resultado += "Recoleccion exitosa: " + tb;

				resultado += "\n Operaci�n terminada";

				panelDatos.actualizarInterfaz(resultado);

			}

			else

			{

				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");

			}

		}

		catch (Exception e)

		{

			// e.printStackTrace();

			String resultado = generarMensajeError(e);

			panelDatos.actualizarInterfaz(resultado);

		}

	}

	/*
	 * ****************************************************************
	 * 
	 * CRUD de Bodega
	 * 
	 *****************************************************************/

	public void adicionarBodega()

	{

		try

		{

			String sucursalS = JOptionPane.showInputDialog(this, "A qu� sucursal quiere agregar la bodega?",
					"Adicionar Bodega", JOptionPane.QUESTION_MESSAGE);

			String tipoProductoS = JOptionPane.showInputDialog(this, "Qu� tipo de producto almacena en la bodega?",
					"Adicionar Bodega", JOptionPane.QUESTION_MESSAGE);

			String capacidadVolumenS = JOptionPane.showInputDialog(this, "Capacidad en cm^3 de la bodega",
					"Adicionar Bodega", JOptionPane.QUESTION_MESSAGE);

			String capacidadPesoS = JOptionPane.showInputDialog(this, "Capacidad en gr de la bodega",
					"Adicionar Bodega", JOptionPane.QUESTION_MESSAGE);

			if (sucursalS != null && tipoProductoS != null && capacidadVolumenS != null && capacidadPesoS != null)

			{

				int sucursal = Integer.parseInt(sucursalS);

				int tipoProducto = Integer.parseInt(tipoProductoS);

				Double capacidadVolumen = Double.parseDouble(capacidadVolumenS);

				Double capacidadPeso = Double.parseDouble(capacidadVolumenS);

				VOBodega tb = superAndes.adicionarBodega(tipoProducto, sucursal, capacidadVolumen, capacidadPeso);

				if (tb == null)

				{

					throw new Exception("No se pudo crear una bodega con la informaci�n dada ");

				}

				String resultado = "En adicionarBodega\n\n";

				resultado += "Bodega adicionada exitosamente: " + tb;

				resultado += "\n Operaci�n terminada";

				panelDatos.actualizarInterfaz(resultado);

			}

			else

			{

				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");

			}

		}

		catch (Exception e)

		{

// e.printStackTrace();

			String resultado = generarMensajeError(e);

			panelDatos.actualizarInterfaz(resultado);

		}

	}

	/*
	 * ****************************************************************
	 * 
	 * CRUD de Estante
	 * 
	 *****************************************************************/

	public void adicionarEstante()

	{

		try

		{

			String sucursalS = JOptionPane.showInputDialog(this, "A qu� sucursal quiere agregar el estante?",
					"Adicionar Estante", JOptionPane.QUESTION_MESSAGE);

			String tipoProductoS = JOptionPane.showInputDialog(this, "Qu� tipo de producto almacena el estante?",
					"Adicionar Estante", JOptionPane.QUESTION_MESSAGE);

			String capacidadVolumenS = JOptionPane.showInputDialog(this, "Capacidad en cm^3 del estante",
					"Adicionar Estante", JOptionPane.QUESTION_MESSAGE);

			String capacidadPesoS = JOptionPane.showInputDialog(this, "Capacidad en gr del estante",
					"Adicionar Estante", JOptionPane.QUESTION_MESSAGE);

			String nivelAbastecimientoS = JOptionPane.showInputDialog(this,
					"Cual es el nivel de abastecimiento del examen?", "Adicionar Estante",
					JOptionPane.QUESTION_MESSAGE);

			if (sucursalS != null && tipoProductoS != null && capacidadVolumenS != null && capacidadPesoS != null
					&& nivelAbastecimientoS != null)

			{

				int sucursal = Integer.parseInt(sucursalS);

				int tipoProducto = Integer.parseInt(tipoProductoS);

				Double capacidadVolumen = Double.parseDouble(capacidadVolumenS);

				Double capacidadPeso = Double.parseDouble(capacidadVolumenS);

				int nivelAbastecimiento = Integer.parseInt(nivelAbastecimientoS);

				VOEstante tb = superAndes.adicionarEstante(tipoProducto, sucursal, capacidadVolumen, capacidadPeso,
						nivelAbastecimiento);

				if (tb == null)

				{

					throw new Exception("No se pudo crear un estante con la informaci�n dada ");

				}

				String resultado = "En adicionarEstante\n\n";

				resultado += "Estante adicionado exitosamente: " + tb;

				resultado += "\n Operaci�n terminada";

				panelDatos.actualizarInterfaz(resultado);

			}

			else

			{

				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");

			}

		}

		catch (Exception e)

		{

// e.printStackTrace();

			String resultado = generarMensajeError(e);

			panelDatos.actualizarInterfaz(resultado);

		}

	}

	/*
	 * ****************************************************************
	 * 
	 * CRUD de tipoProducto
	 * 
	 *****************************************************************/

	/**
	 * 
	 * Adiciona un tipo de bebida con la informaci�n dada por el usuario
	 * 
	 * Se crea una nueva tupla de tipoBebida en la base de datos, si un tipo de
	 * bebida con ese nombre no exist�a
	 * 
	 */

	public void adicionarTipoProducto()

	{

		try

		{

			String nombreTipo = JOptionPane.showInputDialog(this, "Nombre del tipo de producto?",
					"Adicionar tipo de producto", JOptionPane.QUESTION_MESSAGE);

			String categoria = JOptionPane.showInputDialog(this, "Cual es la categoria del producto?",
					"Adicionar tipo de producto", JOptionPane.QUESTION_MESSAGE);

			if (nombreTipo != null && categoria != null)

			{

				VOTipoProducto tb = superAndes.adicionarTipoProducto(nombreTipo, categoria);

				if (tb == null)

				{

					throw new Exception("No se pudo crear un tipo de producto con nombre: " + nombreTipo);

				}

				String resultado = "En adicionarTipoProducto\n\n";

				resultado += "Tipo de producto adicionado exitosamente: " + tb;

				resultado += "\n Operaci�n terminada";

				panelDatos.actualizarInterfaz(resultado);

			}

			else

			{

				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");

			}

		}

		catch (Exception e)

		{

// e.printStackTrace();

			String resultado = generarMensajeError(e);

			panelDatos.actualizarInterfaz(resultado);

		}

	}

	/*
	 * ****************************************************************
	 * 
	 * CRUD de Proveedores
	 * 
	 *****************************************************************/

	public void adicionarProveedor()

	{

		try

		{

			String nitS = JOptionPane.showInputDialog(this, "Cual es el NIT del proveedor?", "Adicionar Proveedor",
					JOptionPane.QUESTION_MESSAGE);

			String nombre = JOptionPane.showInputDialog(this, "Cual es el nombre del proveedor?", "Adicionar Proveedor",
					JOptionPane.QUESTION_MESSAGE);

			String calificacionCalidadS = JOptionPane.showInputDialog(this,
					"Cual es la calificacion de calidad del proveedor?", "Adicionar Proveedor",
					JOptionPane.QUESTION_MESSAGE);

			if (nitS != null && nombre != null && calificacionCalidadS != null)

			{

				int nit = Integer.parseInt(nitS);

				Double calificacionCalidad = Double.parseDouble(calificacionCalidadS);

				VOProveedor tb = superAndes.adicionarProveedor(nit, nombre, calificacionCalidad);

				if (tb == null)

				{

					throw new Exception("No se pudo crear un proveedor con la informaci�n dada ");

				}

				String resultado = "En adicionarProveedor\n\n";

				resultado += "Proveedor adicionado exitosamente: " + tb;

				resultado += "\n Operaci�n terminada";

				panelDatos.actualizarInterfaz(resultado);

			}

			else

			{

				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");

			}

		}

		catch (Exception e)

		{

// e.printStackTrace();

			String resultado = generarMensajeError(e);

			panelDatos.actualizarInterfaz(resultado);

		}

	}

	/*
	 * ****************************************************************
	 * 
	 * CRUD de Producto
	 * 
	 *****************************************************************/

	public void adicionarProducto()

	{

		try

		{

			String codigoBarras = JOptionPane.showInputDialog(this, "Cual es el codigo de Barras del Producto?",
					"Adicionar Producto", JOptionPane.QUESTION_MESSAGE);

			String tipoProductoS = JOptionPane.showInputDialog(this, "Cual es el id del tipo del producto?",
					"Adicionar Producto", JOptionPane.QUESTION_MESSAGE);

			String nombre = JOptionPane.showInputDialog(this, "Cual es el nombre del producto?", "Adicionar Producto",
					JOptionPane.QUESTION_MESSAGE);

			String marca = JOptionPane.showInputDialog(this, "Cual es la marca del producto?", "Adicionar Producto",
					JOptionPane.QUESTION_MESSAGE);

			String presentacion = JOptionPane.showInputDialog(this, "Cual es la presentacion?", "Adicionar Producto",
					JOptionPane.QUESTION_MESSAGE);

			String unidadMedida = JOptionPane.showInputDialog(this, "Cual es la unidad de medida del producto?",
					"Adicionar Producto", JOptionPane.QUESTION_MESSAGE);

			String cantidadPresentacionS = JOptionPane.showInputDialog(this,
					"Cual es la cantidad de producto en la presentacion?", "Adicionar Productor",
					JOptionPane.QUESTION_MESSAGE);

			String pesoEmpaqueS = JOptionPane.showInputDialog(this,
					"Cual es el peso en gr del producto junto con su empaque?", "Adicionar Producto",
					JOptionPane.QUESTION_MESSAGE);

			String volumenEmpaqueS = JOptionPane.showInputDialog(this,
					"Cual es el volumen en cm^3 del producto con empaque?", "Adicionar Producto",
					JOptionPane.QUESTION_MESSAGE);

			if (codigoBarras != null && tipoProductoS != null && nombre != null && marca != null && presentacion != null
					&& unidadMedida != null && cantidadPresentacionS != null && pesoEmpaqueS != null
					&& volumenEmpaqueS != null)

			{

				int tipoProducto = Integer.parseInt(tipoProductoS);

				Double cantidadPresentacion = Double.parseDouble(cantidadPresentacionS);

				Double pesoEmpaque = Double.parseDouble(pesoEmpaqueS);

				Double volumenEmpaque = Double.parseDouble(volumenEmpaqueS);

				VOProducto tb = superAndes.adicionarProducto(codigoBarras, tipoProducto, nombre, marca, presentacion,
						unidadMedida, cantidadPresentacion, pesoEmpaque, volumenEmpaque);

				if (tb == null)

				{

					throw new Exception("No se pudo crear un producto con la informaci�n dada ");

				}

				String resultado = "En adicionarProducto\n\n";

				resultado += "Producto adicionado exitosamente: " + tb;

				resultado += "\n Operaci�n terminada";

				panelDatos.actualizarInterfaz(resultado);

			}

			else

			{

				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");

			}

		}

		catch (Exception e)

		{

// e.printStackTrace();

			String resultado = generarMensajeError(e);

			panelDatos.actualizarInterfaz(resultado);

		}

	}

	/*
	 * ****************************************************************
	 * 
	 * M�todos administrativos
	 * 
	 *****************************************************************/

	/**
	 * 
	 * Muestra el log de Parranderos
	 * 
	 */

	public void mostrarLogParranderos()

	{

		mostrarArchivo("parranderos.log");

	}

	/**
	 * 
	 * Muestra el log de datanucleus
	 * 
	 */

	public void mostrarLogDatanuecleus()

	{

		mostrarArchivo("datanucleus.log");

	}

	/**
	 * 
	 * Limpia el contenido del log de parranderos
	 * 
	 * Muestra en el panel de datos la traza de la ejecuci�n
	 * 
	 */

	public void limpiarLogParranderos()

	{

// Ejecuci�n de la operaci�n y recolecci�n de los resultados

		boolean resp = limpiarArchivo("parranderos.log");

// Generaci�n de la cadena de caracteres con la traza de la ejecuci�n de la demo

		String resultado = "\n\n************ Limpiando el log de parranderos ************ \n";

		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");

		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);

	}

	/**
	 * 
	 * Limpia el contenido del log de datanucleus
	 * 
	 * Muestra en el panel de datos la traza de la ejecuci�n
	 * 
	 */

	public void limpiarLogDatanucleus()

	{

// Ejecuci�n de la operaci�n y recolecci�n de los resultados

		boolean resp = limpiarArchivo("datanucleus.log");

// Generaci�n de la cadena de caracteres con la traza de la ejecuci�n de la demo

		String resultado = "\n\n************ Limpiando el log de datanucleus ************ \n";

		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");

		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);

	}

	/*
	 * ****************************************************************
	 * 
	 * M�todos privados para la presentaci�n de resultados y otras operaciones
	 * 
	 *****************************************************************/

	/**
	 * 
	 * Genera una cadena de caracteres con la descripci�n de la excepcion e,
	 * haciendo �nfasis en las excepcionsde JDO
	 * 
	 * @param e - La excepci�n recibida
	 * 
	 * @return La descripci�n de la excepci�n, cuando es
	 *         javax.jdo.JDODataStoreException, "" de lo contrario
	 * 
	 */

	private String darDetalleException(Exception e)

	{

		String resp = "";

		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))

		{

			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;

			return je.getNestedExceptions()[0].getMessage();

		}

		return resp;

	}

	/**
	 * 
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicaci�n
	 * 
	 * @param e - La excepci�n generada
	 * 
	 * @return La cadena con la informaci�n de la excepci�n y detalles adicionales
	 * 
	 */

	private String generarMensajeError(Exception e)

	{

		String resultado = "************ Error en la ejecuci�n\n";

		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);

		resultado += "\n\nRevise datanucleus.log y parranderos.log para m�s detalles";

		return resultado;

	}

	/**
	 * 
	 * Limpia el contenido de un archivo dado su nombre
	 * 
	 * @param nombreArchivo - El nombre del archivo que se quiere borrar
	 * 
	 * @return true si se pudo limpiar
	 * 
	 */

	private boolean limpiarArchivo(String nombreArchivo)

	{

		BufferedWriter bw;

		try

		{

			bw = new BufferedWriter(new FileWriter(new File(nombreArchivo)));

			bw.write("");

			bw.close();

			return true;

		}

		catch (IOException e)

		{

// e.printStackTrace();

			return false;

		}

	}

	/**
	 * 
	 * Abre el archivo dado como par�metro con la aplicaci�n por defecto del sistema
	 * 
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 * 
	 */

	private void mostrarArchivo(String nombreArchivo)

	{

		try

		{

			Desktop.getDesktop().open(new File(nombreArchivo));

		}

		catch (IOException e)

		{

// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	/*
	 * ****************************************************************
	 * 
	 * M�todos de la Interacci�n
	 * 
	 *****************************************************************/

	/**
	 * 
	 * M�todo para la ejecuci�n de los eventos que enlazan el men� con los m�todos
	 * de negocio
	 * 
	 * Invoca al m�todo correspondiente seg�n el evento recibido
	 * 
	 * @param pEvento - El evento del usuario
	 * 
	 */

	@Override

	public void actionPerformed(ActionEvent pEvento)

	{

		String evento = pEvento.getActionCommand();

		try

		{

			Method req = InterfazSupermercadoApp.class.getMethod(evento);

			req.invoke(this);

		}

		catch (Exception e)

		{

			e.printStackTrace();

		}

	}

	/*
	 * ****************************************************************
	 * 
	 * Programa principal
	 * 
	 *****************************************************************/

	/**
	 * 
	 * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz
	 * 
	 * @param args Arreglo de argumentos que se recibe por l�nea de comandos
	 * 
	 */

	public static void main(String[] args)

	{

		try

		{

			String log4jConfPath = "./src/main/resources/log4j.properties";

			PropertyConfigurator.configure(log4jConfPath);

			// Unifica la interfaz para Mac y para Windows.

			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

			InterfazSupermercadoApp interfaz = new InterfazSupermercadoApp();

			interfaz.setVisible(true);

		}

		catch (Exception e)

		{

			e.printStackTrace();

		}

	}
}
