package logica;

public class Caja 
{
	//ATRIBUTOS 
	
	@SuppressWarnings("unused")
	private String fecha; 
    
    @SuppressWarnings("unused")
	private double venta;
   
    
	public Caja( String fecha, double pVenta)
	{
		
		this.fecha = fecha;
		this.venta = pVenta;
		
	}


	/**
	 * @return the nombre
	 */
	public String getFecha() {
		return fecha;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setFecha(String nombre) {
		this.fecha = nombre;
	}


	/**
	 * @return the cantidad
	 */
	public double getVenta() {
		return venta;
	}


	/**
	 * @param cantidad the cantidad to set
	 */
	public void setVenta(double cantidad) {
		this.venta = cantidad;
	}

	/**
	 *  Establece la venta en cero
	 */
	public void deleteVenta()
	{
		venta = 0;
	
	}
	
	@Override
	public String toString()
	{
		return fecha;
	}
    
    

}

