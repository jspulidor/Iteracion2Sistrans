package uniandes.isis2304.supermercados.negocio;

public interface VOInventario 
{
	public int getIdSucursal();
	
	public int getIdProducto();
	
	public int getCantidad();
	
	public double getPrecioUnitario();
	
	public double getPrecioPorMedida();
	
	public int getNivelReorden();
	
	public String toString();
}
