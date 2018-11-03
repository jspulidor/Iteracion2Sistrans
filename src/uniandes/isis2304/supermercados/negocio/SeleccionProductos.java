package uniandes.isis2304.supermercados.negocio;

public class SeleccionProductos implements VOSeleccionProductos
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	public int idProducto;
	
	public int idCarritoCompras;
	
	public int cantidad;

	/* ****************************************************************
	 * Constructor
	 *****************************************************************/
	public SeleccionProductos()
	{
		idProducto = 0;
		idCarritoCompras = 0;
		cantidad = 0;
	}
	
	public SeleccionProductos(int pIdProducto, int pIdCarritoCompras, int pCantidad)
	{
		idProducto = pIdProducto;
		idCarritoCompras = pIdCarritoCompras;
		cantidad = pCantidad;
	}
	
	/* ****************************************************************
	 * Métodos
	 *****************************************************************/
	@Override
	public int getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(int pIdProducto) {
		this.idProducto = pIdProducto;
	}

	@Override
	public int getIdCarritoCompras() {
		return idCarritoCompras;
	}
	
	public void setIdCarritoCompras(int pIdCarritoCompras) {
		this.idCarritoCompras = pIdCarritoCompras;
	}
	
	@Override
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int pCantidad) {
		this.cantidad = pCantidad;
	}
}
