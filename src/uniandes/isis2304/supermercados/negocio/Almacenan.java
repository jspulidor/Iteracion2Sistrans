package uniandes.isis2304.supermercados.negocio;

public class Almacenan 
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private int idProducto;
	
	private int idBodega;
	
	private int cantidadProducto;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	public Almacenan()
	{
		this.idProducto = 0;
		this.idBodega = 0;
		this.cantidadProducto = 0;
	}
	
	public Almacenan(int pIdProducto, int pIdBodega, int pCantidadProductos)
	{
		this.idProducto = pIdProducto;
		this.idBodega = pIdBodega;
		this.cantidadProducto = pCantidadProductos;
	}

	public int getIdProducto()
	{
		return idProducto;
	}
	
	public void setIdProducto(int pIdProducto)
	{
		this.idProducto = pIdProducto;
	}
	
	public int getIdBodega()
	{
		return idBodega;
	}
	
	public void setIdBodega(int pIdBodega)
	{	
		this.idBodega = pIdBodega;
	}
	
	public int getCantidadProductos()
	{
		return cantidadProducto;
	}
	
	public void setCantidadProductos(int pCantidadProductos)
	{
		this.cantidadProducto = pCantidadProductos;
	}
	
	public String toString()
	{
		return "Almacenan [idProducto =" +idProducto+ ", idBodega =" +idBodega+ ", cantidad =" +cantidadProducto+ "]";
	}

}
