package uniandes.isis2304.supermercados.negocio;

public class Inventario implements VOInventario
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private int idSucursal;
	
	private int idProducto;
	
	private int cantidad;
	
	private double precioUnitario;
	
	private double precioPorMedida;
	
	private int nivelReorden;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	public Inventario()
	{
		this.idSucursal = 0;
		this.idProducto = 0;
		this.cantidad = 0;
		this.precioUnitario = 0.0;
		this.precioPorMedida = 0.0;
		this.nivelReorden = 0;
	}

	public Inventario(int pIdSucursal, int pIdProducto, int pCantidad, double pPrecioUnitario, double pPrecioPorMedida, int pNivelReorden)
	{
		this.idSucursal = pIdSucursal;
		this.idProducto = pIdProducto;
		this.cantidad = pCantidad;
		this.precioUnitario = pPrecioUnitario;
		this.precioPorMedida = pPrecioPorMedida;
		this.nivelReorden = pNivelReorden;
	}
	
	public int getIdSucursal()
	{
		return idSucursal;
	}
	
	public void setIdSucursal(int pIdSucursal)
	{
		this.idSucursal = pIdSucursal;
	}
	
	public int getIdProducto()
	{
		return idProducto;
	}
	
	public void setIdProducto(int pIdProducto)
	{
		this.idProducto = pIdProducto;
	}
	
	public int getCantidad()
	{
		return cantidad;
	}
	
	public void setCantidad(int pCantidad)
	{
		this.cantidad = pCantidad;
	}

	public double getPrecioUnitario()
	{
		return precioUnitario;
	}
	
	public void setPrecioUnitario(double pPrecioUnitario)
	{
		this.precioUnitario = pPrecioUnitario;
	}
	
	public double getPrecioPorMedida()
	{
		return precioPorMedida;
	}
	
	public void setPrecioPorMedida(double pPrecioPorMedida)
	{
		this.precioPorMedida = pPrecioPorMedida;
	}
	
	public int getNivelReorden()
	{
		return nivelReorden;
	}

	public void setNivelReorden(int pNivelReorden)
	{
		this.nivelReorden = pNivelReorden;
	}
	
	public String toString()
	{
		return "Inventario [idSucursal =" +idSucursal+ ", idProducto =" +idProducto+ ", cantidad =" +cantidad+ ", precioUnitario =" +precioUnitario+ ", precioPorMedida =" +precioPorMedida+ ", nivelReorden =" +nivelReorden+ "]";
	}

}
