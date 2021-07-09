package logica;

public class ProductosVendidos 
{
	//ATRIBUTOS 
    @SuppressWarnings("unused")
	private String nombre;
    @SuppressWarnings("unused")
	private String codigo;
    @SuppressWarnings("unused")
	private int cantidad;
    @SuppressWarnings("unused")
	private String marca;
    @SuppressWarnings("unused")
	private double valorUnidad;
    @SuppressWarnings("unused")
	private double valorTotal;
    private String fecha;
    @SuppressWarnings("unused")
	private double numeroVenta;
    
	public ProductosVendidos(String nombre, String codigo, int cantidad, String marca, double valorUnidad, double valorTotal, String fecha, double numeroVenta) 
	{
		this.nombre = nombre;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.marca = marca;
		this.valorUnidad = valorUnidad;
		this.valorTotal = valorTotal;
		this.fecha = fecha;
		this.numeroVenta = numeroVenta;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the valorUnidad
	 */
	public double getValorUnidad() {
		return valorUnidad;
	}

	/**
	 * @param valorUnidad the valorUnidad to set
	 */
	public void setValorUnidad(double valorUnidad) {
		this.valorUnidad = valorUnidad;
	}

	/**
	 * @return the valorTotal
	 */
	public double getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

	/**
	 * @return the numero de venta
	 */
	public double getNumeroVenta() {
		return numeroVenta;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setNumeroVenta(double numeroVenta) {
		this.numeroVenta = numeroVenta;
	}
	
	@Override
	public String toString()
	{
		return nombre;
	}

}