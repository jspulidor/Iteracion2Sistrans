package uniandes.isis2304.supermercados.negocio;

import java.sql.Timestamp;

public class VisitaMercado implements VOVisitaMercado
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	public int id;
	
	public int idCarritoCompras;
	
	public int idCliente;
	
	public Timestamp fechaVisita;
	
	/* ****************************************************************
	 * 			Constructor
	 *****************************************************************/
	public VisitaMercado()
	{
		id = 0;
		idCarritoCompras = 0;
		idCliente = 0;
		fechaVisita = new Timestamp(0);
	}
	
	public VisitaMercado(int pId, int pIdCarritoCompras, int pIdCliente, Timestamp pFechaVisita)
	{
		this.id = pId;
		this.idCarritoCompras = pIdCarritoCompras;
		this.idCliente = pIdCliente;
		this.fechaVisita = pFechaVisita;
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
	public int getIdCarritoCompras() {
		return idCarritoCompras;
	}

	public void setIdCarritoCompras(int pIdCarritoCompras) {
		this.idCarritoCompras = pIdCarritoCompras;
	}
	
	@Override
	public int getIdCliente() {
		return idCliente;
	}

	@Override
	public Timestamp getFechaVisita() {
		return fechaVisita;
	}
	
	public void setFechaVisita(Timestamp pFechaVisita) {
		this.fechaVisita = pFechaVisita;
	}
}
