package uniandes.isis2304.supermercados.negocio;

public class Promociones implements VOPromociones
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	public int idProducto;
	
	public int idPromocion;

	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/
	
	public Promociones()
	{
		this.idProducto = 0;
		this.idPromocion = 0;
	}
	
	public Promociones(int pIdProducto, int pIdPromocion)
	{
		this.idProducto = pIdProducto;
		this.idPromocion = pIdPromocion;
	}
	
	public int getIdProducto( )
	{
		return idProducto;
	}
	
	public void setIdProducto(int pIdProducto)
	{
		this.idProducto = pIdProducto;
	}
	
	public int getIdPromocion()
	{
		return idPromocion;
	}
	
	public void setIdProocion(int pIdPromocion)
	{
		this.idPromocion = pIdPromocion;
	}
	
	public String toString()
	{
		return "Promociones [idPromocion =" +idPromocion+ ", idProducto =" +idProducto+ "]";
	}















}
