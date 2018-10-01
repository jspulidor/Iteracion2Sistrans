package uniandes.isis2304.supermercados.negocio;

public interface VOProducto {
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	
	public String getNombre();
	public String getMarca();
	public String getPresentacion();
	public Double getCantidadPresentacion();
	public String getUnidadMedida();
	public String getCodigoBarras();
	public int getTipo();
	public Double getPesoEmpaque();
	public Double getVolumenEmpaque();
	public String toString();
	

}
