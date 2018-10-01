package uniandes.isis2304.supermercados.negocio;

/**
 * Clase para modelar la relación ALBERGAN del negocio de SuperAndes:
 * Cada objeto de esta clase representa el hecho que un estante alberga uno o más productos del mismo tipo.
 * Se modela mediante los identificadores del estante y del producto.
 * Debe existir un estante con el identificador dado
 * Debe existir un producto con el identificador dado 
 */


public class Albergan {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * Id del estante
	 */
	private int idEstante;
	
	/**
	 * Id del producto albergado en el estante
	 */
	private int idProducto;
	
	/**
	 * Cantidad de unidades del producto almacenadas en el estante
	 */
	private int cantidadProducto;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto
	 */
	public Albergan()
	{
		this.setIdEstante(0);
		this.setIdProducto(0);
		this.setCantidadProducto(0);
	}
	
	/**
	 * Constructor con parametros
	 * @param pIdEstante
	 * @param pIdProducto
	 * @param pCantidadProducto
	 */
	public Albergan( int pIdEstante, int pIdProducto, int pCantidadProducto )
	{
		this.setIdEstante(pIdEstante);
		this.setIdProducto(pIdProducto);
		this.setCantidadProducto(pCantidadProducto);
	}	
	
	/**
	 * Retorna una cadena con la informacion del objeto
	 */
	@Override
	public String toString() {
		return "Albergan [idEstante=" + idEstante + ", idProducto=" + idProducto + ", cantidadProducto="
				+ cantidadProducto + "]";
	}

	
	
	
	/* ****************************************************************
	 * 			Métodos Get y Set
	 *****************************************************************/
	
	public int getIdEstante() {
		return idEstante;
	}

	public void setIdEstante(int idEstante) {
		this.idEstante = idEstante;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
}
