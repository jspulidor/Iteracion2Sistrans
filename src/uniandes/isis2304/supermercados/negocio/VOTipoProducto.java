package uniandes.isis2304.supermercados.negocio;

public interface VOTipoProducto {
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	public int getId();
	public String getNombre();
	public String getCategoria();
	public String toString();
	public boolean equals(Object tipo);
}
