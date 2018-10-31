package uniandes.isis2304.supermercados.negocio;

public class SeleccionProductos implements VOSeleccionProductos
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	public int idProducto;
	
	public int idVisitaMercado;

	/* ****************************************************************
	 * Constructor
	 *****************************************************************/
	public SeleccionProductos()
	{
		idProducto = 0;
		idVisitaMercado = 0;
	}
	
	public SeleccionProductos(int pIdProducto, int pIdVisitaMercado)
	{
		idProducto = pIdProducto;
		idVisitaMercado = pIdVisitaMercado;
	}
	
	/* ****************************************************************
	 * Métodos
	 *****************************************************************/
	@Override
	public int getIdProducto() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setIdProducto(int pIdProducto) {
		this.idProducto = pIdProducto;
	}

	@Override
	public int getIdVisitaMercado() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setIdVisitaMercado(int pIdVisitaMercado) {
		this.idVisitaMercado = pIdVisitaMercado;
	}
}
