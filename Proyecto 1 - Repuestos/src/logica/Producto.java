package logica;

import java.awt.Font;

public class Producto 
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
    private String estado;


    public Producto(String nombre, String codigo, int cantidad, String marca, double valorUnidad, double valorTotal, String estado)
    {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.marca = marca;
        this.valorUnidad = valorUnidad;
        this.valorTotal = valorTotal;
        this.estado = estado;
    }
    
    
   public String darNombre()
   {
	   return nombre;
   }
   

   public void cambiarNombre(String nuevoNombre)
   {
	   nombre = nuevoNombre;
   }
   
   
   
   public String darCodigo()
   {
	   return codigo;
   }
   
   public void cambiarCodigo(String nuevoCodigo)
   {
	   codigo = nuevoCodigo;
   }
   
   
   
   
   public int darCantidad()
   {
	   return cantidad;
   }
   
   public void cambiarCantidad(int nuevaCantidad)
   {
	  cantidad = nuevaCantidad;
   }
   
   public String darMarca()
   {
	   return marca;
   }
   
   public void cambiarMarca(String nuevaMarca)
   {
	   marca = nuevaMarca;
   }
   
   
   public double darValorUnidad()
   {
	   return valorUnidad;
   }
   
   public void cambiarValorUnidad(float nuevoValorUnidad)
   {
	   valorUnidad = nuevoValorUnidad;
   }
   
   
   
   public double darValorTotal()
   {
	   return valorTotal;
   }
   
   
   public void cambiarValorTotal(float nuevoValorTotal)
   {
	   valorTotal = nuevoValorTotal;
   }
   
  
   public String darEstado()
   {
	   
	   return estado;
   }
   
   public void cambiarEstado(String nuevoEstado)
   {
	   
	  estado = nuevoEstado;
   }
   
   
   @Override
	public String toString()
	{
		return nombre;
		//new Font("Cambria",Font.ITALIC, 20)
	}
  
    
}