package uniandes.isis2304.supermercados.negocio;

import java.sql.Time;
import java.sql.Timestamp;

import oracle.net.nt.NTAdapter.NetworkAdapterType;

public class CarritoCompras implements VOCarritoCompras
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	public int id;
	
	public int idSucursal;
	
	public int idCliente;
	
	public String Disponibilidad;
	
	public String Abandonado;
	
	/* ****************************************************************
	 * 			Constructor
	 *****************************************************************/
	public CarritoCompras()
	{
		id = 0;
		idSucursal = 0;
		idCliente = 0;
		Disponibilidad = "SI";
		Abandonado = "NO";
	}
	
	public CarritoCompras(int pId, int pIdSucursal, int pIdCliente, String pDisponibilidad, String pAbandonado)
	{
		this.id = pId;
		this.idSucursal = pIdSucursal;
		this.idCliente = pIdCliente;
		this.Disponibilidad = pDisponibilidad;
		this.Abandonado = pAbandonado;
	}
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	@Override
	public int getId() {
		return id;
	}
	
	public void setId(int pId) {
		this.id = pId;
	}

	@Override
	public int getIdSucursal() {
		return idSucursal;
	}
	
	public void setIdSucursal(int pIdSucural) {
		this.idSucursal = pIdSucural;
	}
	
	@Override
	public int getIdCliente() 
	{
		return idCliente;
	}
	
	public void setIdCliente(int pIdCliente) {
		this.idCliente = pIdCliente;
	}

	@Override
	public String getDisponiblidad() {
		return Disponibilidad;
	}
	
	public void setDisponibilidad(String pDisponibilidad) {
		this.Disponibilidad = pDisponibilidad;
	}

	@Override
	public String getAbandonado() {
		return Abandonado;
	}
	
	public void setAbandonado(String pAbandonado) {
		this.Abandonado = pAbandonado;
	}
}
