package uniandes.isis2304.supermercados.negocio;

public class Ventas implements VOVentas
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private int idFactura;
	
	private int idProducto;
	
	private int cantidadProducto;

	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/
	
	public Ventas()
	{
		this.idFactura = 0;
		this.idProducto = 0;
		this.cantidadProducto = 0;
	}
	
	public Ventas(int pIdFactura, int pIdProducto, int pCantidadProducto)
	{
		this.idFactura = pIdFactura;
		this.idProducto = pIdProducto;
		this.cantidadProducto = pCantidadProducto;
	}
	
	public int getIdFactura()
	{
		return idFactura;
	}
	
	public void setIdFactura(int pIdFactura)
	{
		this.idFactura = pIdFactura;
	}
	
	public int getIdProducto()
	{
		return idProducto;
	}
	
	public void setIdProducto(int pIdProducto)
	{
		this.idProducto = pIdProducto;
	}
	
	public int getCantidadProducto()
	{
		return cantidadProducto;
	}

	public void setCantidadProducto(int pCantidadProducto)
	{
		this.cantidadProducto = pCantidadProducto;
	}
	
	public String toString()
	{
		return "Ventas [idFactura =" +idFactura+ ", idProducto =" +idProducto+ ",cantidad =" +cantidadProducto+ "]";
	}

}
