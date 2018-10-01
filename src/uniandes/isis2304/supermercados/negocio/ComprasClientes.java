package uniandes.isis2304.supermercados.negocio;

public class ComprasClientes {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * Id del cliente que hizo la compra
	 */
	private int idCLiente;
	
	/**
	 * Id de la factura asociada a la compra
	 */
	private int idFactura;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	
	public ComprasClientes()
	{
		this.setIdCLiente(0);
		this.setIdFactura(0);
	}
	
	/**
	 * Constructor con parametros
	 */
	public ComprasClientes(int pIdCliente, int pIdFactura)
	{
		this.setIdCLiente(pIdCliente);
		this.setIdFactura(pIdFactura);
	}

	/**
	 * Retorna una cadena con la informacion de la compra
	 */
	@Override
	public String toString() {
		return "ComprasClientes [idCLiente=" + idCLiente + ", idFactura=" + idFactura + "]";
	}
	
	
	/* ****************************************************************
	 * 			Métodos Get y Set
	 *****************************************************************/
	
	public int getIdCLiente() {
		return idCLiente;
	}


	public void setIdCLiente(int idCLiente) {
		this.idCLiente = idCLiente;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	
}
