package uniandes.isis2304.supermercado.interfazDemo;

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
import java.util.List;

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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.supermercados.negocio.SuperAndes;
import uniandes.isis2304.supermercados.negocio.VOBodega;
import uniandes.isis2304.supermercados.negocio.VOCarritoCompras;
import uniandes.isis2304.supermercados.negocio.VOCliente;
import uniandes.isis2304.supermercados.negocio.VOEstante;
import uniandes.isis2304.supermercados.negocio.VOProducto;
import uniandes.isis2304.supermercados.negocio.VOSucursal;
import uniandes.isis2304.supermercados.negocio.VOTipoProducto;


@SuppressWarnings("serial")

public class InterfazSupermercadosDemo extends JFrame implements ActionListener {
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazSupermercadosDemo.class.getName());
	
	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigDemo.json"; 
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;
    
    /**
     * Asociación a la clase principal del negocio.
     */
    private SuperAndes superandes;
    
	/* ****************************************************************
	 * 			Atributos de interfaz
	 *****************************************************************/
    /**
     * Objeto JSON con la configuración de interfaz de la app.
     */
    private JsonObject guiConfig;
    
    /**
     * Panel de despliegue de interacción para los requerimientos
     */
    private PanelDatos panelDatos;
    
    /**
     * Menú de la aplicación
     */
    private JMenuBar menuBar;
	
	public void demoAlbergan()
	{
		try 
		{
    		// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código
			boolean errorTipoProducto = false;
			VOTipoProducto tipoProducto = superandes.adicionarTipoProducto ("Vino tinto","PERECEDERO");
			if (tipoProducto == null)
			{
				errorTipoProducto= true;
			}
			int idTipoProducto= tipoProducto.getId();
			VOSucursal sucursal1 = superandes.adicionarSucursal("Bogotá", "Teusaquillo", "Calle Falsa 1234");
			int idSucursal=sucursal1.getId();
			VOEstante estante1 = superandes.adicionarEstante(idTipoProducto, idSucursal, 1000.0,1000.0 , 34);
			int idEstante = estante1.getId();
			VOProducto producto1 = superandes.adicionarProducto("1234", idTipoProducto, "Manzana", "Postobon", "Botella 1L", "ML", 100.0, 100.0, 20.0);
			int idProducto= Integer.parseInt(producto1.getCodigoBarras());
			superandes.adicionarAlbergan(idProducto, idEstante, 100);

			long alberganEliminados = superandes.eliminarAlbergan(idProducto, idEstante);


			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de Sirven\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorTipoProducto)
			{
				resultado += "*** Exception creando tipo de bebida !!\n";
				resultado += "*** Es probable que ese tipo de bebida ya existiera y hay restricción de UNICIDAD sobre el nombre del tipo de bebida\n";
				resultado += "*** Revise el log de parranderos para más detalles\n";
			}
			resultado += "\n\n************ Ejecutando la demo ************ \n";
			resultado += "\n\n************ Limpiando la base de datos ************ \n";
			resultado +=alberganEliminados + " Albergan eliminados\n";
			resultado += "\n Demo terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
		
	}
	
	public void demoAlmacenan()
	{
		
		try 
		{
    		// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código
			boolean errorTipoProducto = false;
			VOTipoProducto tipoProducto = superandes.adicionarTipoProducto ("Vino tinto","PERECEDERO");
			if (tipoProducto == null)
			{
				errorTipoProducto= true;
			}
			int idTipoProducto= tipoProducto.getId();
			VOSucursal sucursal1 = superandes.adicionarSucursal("Bogotá", "Teusaquillo", "Calle Falsa 123");
			int idSucursal=sucursal1.getId();
			VOBodega bodega1 = superandes.adicionarBodega(idTipoProducto, idSucursal, 1000.0,1000.0);
			int idBodega = bodega1.getId();
			VOProducto producto1 = superandes.adicionarProducto("1234", idTipoProducto, "Manzana", "Postobon", "Botella 1L", "ML", 100.0, 100.0, 20.0);
			int idProducto= Integer.parseInt(producto1.getCodigoBarras());
			superandes.adicionarAlbergan(idProducto, idBodega, 100);

			long alberganEliminados = superandes.eliminarAlmacenan(idProducto, idBodega);


			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de Sirven\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorTipoProducto)
			{
				resultado += "*** Exception creando tipo de bebida !!\n";
				resultado += "*** Es probable que ese tipo de bebida ya existiera y hay restricción de UNICIDAD sobre el nombre del tipo de bebida\n";
				resultado += "*** Revise el log de parranderos para más detalles\n";
			}
			resultado += "\n\n************ Ejecutando la demo ************ \n";
			resultado += "\n\n************ Limpiando la base de datos ************ \n";
			resultado +=alberganEliminados + " Albergan eliminados\n";
			resultado += "\n Demo terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
		
	}
	
	public void demoBodega()
	{	
		try 
		{

			VOTipoProducto tipoProducto = superandes.adicionarTipoProducto ("Cerveza","PERECEDERO");
			int idTipoProducto= tipoProducto.getId();
    		// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código
			
			VOSucursal sucursal1 = superandes.adicionarSucursal("Bogotá", "Teusaquillo", "Calle Falsa 123456");
			int idSucursal=sucursal1.getId();
			
			VOBodega bodega = superandes.adicionarBodega(idTipoProducto, idSucursal, 100.0, 100.0);
			int bodega1=bodega.getId();
			
			
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de Bares\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			resultado += "Adicionado la bodega: " + bodega1 + "\n";
			resultado += "\n\n************ Ejecutando la demo ************ \n";
			resultado += "\n\n************ Limpiando la base de datos ************ \n";
			resultado += "\n Demo terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
		
	}
	
	public void demoCarritoCompras()
	{
		
		try 
		{

			VOCliente cliente = superandes.adicionarCliente(1234, "Pepo Perez", "pepoperez@hotmail.com", "Bogota", "Calle Falsa 123");
			int idCliente= cliente.getDocIdentidad();
    		// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código
			
			VOSucursal sucursal1 = superandes.adicionarSucursal("Bogotá", "Teusaquillo", "Calle Falsa 1234567");
			int idSucursal=sucursal1.getId();
			
			long carritoCompras = superandes.solicitarCarritoCompras(idSucursal, idCliente, "NO", "NO", new Timestamp(System.currentTimeMillis()));
			
			
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de Bares\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			resultado += "Adicionado la bodega: " + carritoCompras + "\n";
			resultado += "\n\n************ Ejecutando la demo ************ \n";
			resultado += "\n\n************ Limpiando la base de datos ************ \n";
			resultado += "\n Demo terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
		
	}
	
	public void demoCliente()
	{
		
		try 
		{

			VOCliente cliente = superandes.adicionarCliente(12345, "Pepo Perez Lima", "pepoperez@hotmail.com", "Bogota", "Calle Falsa 123");
			int idCliente= cliente.getDocIdentidad();
    		// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código
			
			
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de Bares\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			resultado += "Adicionado cliente con Id: " + idCliente + "\n";
			resultado += "\n\n************ Ejecutando la demo ************ \n";
			resultado += "\n\n************ Limpiando la base de datos ************ \n";
			resultado += "\n Demo terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
		
	}
	
	public void demoEstante()
	{
		try 
		{

			VOTipoProducto tipoProducto = superandes.adicionarTipoProducto ("Queso","PERECEDERO");
			int idTipoProducto= tipoProducto.getId();
    		// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código
			
			VOSucursal sucursal1 = superandes.adicionarSucursal("Bogotá", "Teusaquillo", "Calle Falsa 1234567");
			int idSucursal=sucursal1.getId();
			
			VOEstante estante = superandes.adicionarEstante(idTipoProducto, idSucursal, 100.0, 100.0,34);
			int estante1=estante.getId();
			
			
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de Bares\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			resultado += "Adicionado la bodega: " + estante1 + "\n";
			resultado += "\n\n************ Ejecutando la demo ************ \n";
			resultado += "\n\n************ Limpiando la base de datos ************ \n";
			resultado += "\n Demo terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
		
	}
	
	public void demoFactura()
	{
		
		try 
		{

			VOCliente cliente = superandes.adicionarCliente(1234, "Pepo Perez", "pepoperez@hotmail.com", "Bogota", "Calle Falsa 123");
			int idCliente= cliente.getDocIdentidad();
    		// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código
			
			VOSucursal sucursal1 = superandes.adicionarSucursal("Bogotá", "Teusaquillo", "Calle Falsa 1234567");
			int idSucursal=sucursal1.getId();
			
			long carritoCompras = superandes.solicitarCarritoCompras(idSucursal, idCliente, "NO", "NO", new Timestamp(System.currentTimeMillis()));
			
			long factura= superandes.generarFactura(1234, 50, idCliente, 123456, new Timestamp(System.currentTimeMillis()));
			
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de Bares\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			resultado += "Adicionado la bodega: " + factura + "\n";
			resultado += "\n\n************ Ejecutando la demo ************ \n";
			resultado += "\n\n************ Limpiando la base de datos ************ \n";
			resultado += "\n Demo terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
		
	}
	
	public void demoInventario()
	{
		
	}
	
	public void demoPedido()
	{
		
	}
	
	

    /**
     * Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
     * @param e - La excepción recibida
     * @return La descripción de la excepción, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
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
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicación
	 * @param e - La excepción generada
	 * @return La cadena con la información de la excepción y detalles adicionales
	 */
	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
		return resultado;
	}

	/**
	 * Limpia el contenido de un archivo dado su nombre
	 * @param nombreArchivo - El nombre del archivo que se quiere borrar
	 * @return true si se pudo limpiar
	 */
	private boolean limpiarArchivo(String nombreArchivo) 
	{
		BufferedWriter bw;
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File (nombreArchivo)));
			bw.write ("");
			bw.close ();
			return true;
		} 
		catch (IOException e) 
		{
//			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Abre el archivo dado como parámetro con la aplicación por defecto del sistema
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 */
	private void mostrarArchivo (String nombreArchivo)
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

	/* ****************************************************************
	 * 			Métodos de la Interacción
	 *****************************************************************/
    /**
     * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
     * Invoca al método correspondiente según el evento recibido
     * @param pEvento - El evento del usuario
     */
    @Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = InterfazSupermercadosDemo.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
	}
    
	/* ****************************************************************
	 * 			Programa principal
	 *****************************************************************/
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Arreglo de argumentos que se recibe por línea de comandos
     */
    public static void main( String[] args )
    {
        try
        {
        	
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            InterfazSupermercadosDemo interfaz = new InterfazSupermercadosDemo( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }

    }
    
}
