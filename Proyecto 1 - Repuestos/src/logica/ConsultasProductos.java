package logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unused")
public class ConsultasProductos 
{
	//ATRIBUTOS
	private ListaProductos listProducts;
	
	
	//private CargarInformacion actualizacion;
	
	
	private Producto repuesto;
	
	
	private ListaProductosVendidos listProductsVendidos;
	
	
	private Caja caja;
	
	
	private double numeroPedido;
	
	
	public ConsultasProductos(ListaProductos pListProducts, ListaProductosVendidos pListProductsVendidos)
	{
		
		listProducts = pListProducts;
		listProductsVendidos = pListProductsVendidos;
		
		//ventasDia = new ArrayList<Caja>();
		
	}
	
	
	
	public boolean eliminarProducto(String codigoProducto) throws FileNotFoundException, IOException 
	{
		boolean respuesta = false;
		
		boolean si = listProducts.cambiarEstadoProducto(codigoProducto, "no");
		
		if (si) 
		{
			// Modifica el csv
			listProducts.modificarEstadoProducto();
			
			// carga de nuevo el csv
			listProducts.cargarRepuestos("./data/Formato_repuestos.csv");
			respuesta = true;
			
		}
		
		return respuesta;
			
	}
	
	public ArrayList<String> BuscarProducto(String nombreProducto)
	{
		ArrayList<String> datosProducto = new ArrayList<String>();
		String respuesta  = listProducts.darCodigoProducto(nombreProducto);
		
		if (respuesta != null) 
		{
			datosProducto.add(0, nombreProducto);
			datosProducto.add(1,listProducts.darCodigoProducto(nombreProducto));
			String codigo = listProducts.darCodigoProducto(nombreProducto);
			datosProducto.add(2,Integer.toString(listProducts.darCantidadProducto(codigo)));
			datosProducto.add(3,listProducts.darMarcaProducto(codigo));
			datosProducto.add(4, Double.toString(listProducts.darPrecioProducto(codigo)));
			
		}
		
		return datosProducto;
	}
	
	
	
	public boolean venderProducto(String codigoProducto, int cantidadVender, boolean nuevoPedido) throws FileNotFoundException, IOException
	{
		
		boolean answer = false;
		LocalDate date = LocalDate.now();  // obtenemos la fecha en que se vendio el repuesto
		
	
		// se obtienen los diferentes atributos para realizar las operaciones correspondientes
		String nombre = listProducts.darNombreProducto(codigoProducto);
		String marca = listProducts.darMarcaProducto(codigoProducto);
		double valorUnidad = listProducts.darPrecioProducto(codigoProducto);
		double valorTotal = listProducts.darPrecioTotalProducto(codigoProducto);
		int cantidad = listProducts.darCantidadProducto(codigoProducto);
		int nuevaCantidad = Math.abs(cantidad - cantidadVender);
		
		double total = valorUnidad*cantidadVender;
		//actualiza la cantidad de unidades en la estructura donde se guarda la informacion de los productos
		boolean si = listProducts.venderProducto(codigoProducto, nuevaCantidad);
		if (si) 
		{
			//actualiza la cantidad de unidades en el csv
			listProducts.modificarEstadoProducto();
			
		
			// carga de nuevo el csv
			//listProducts.cargarRepuestos("./data/Formato_repuestos.csv");
			
			
			if (nuevoPedido)
			{
				Random numeroAleatorio = new Random();
				numeroPedido = 1+numeroAleatorio.nextInt(10000000);
				
				
				
				
				//se registra en la estructura los productos vendidos
				listProductsVendidos.registrarProductoVendido(nombre, codigoProducto, cantidadVender, marca, valorUnidad, total, date.toString(), numeroPedido);
				
				//se actualiza el csv productos_vendidos el producto comprado
				listProductsVendidos.registrarProductosVendidos();
				
				
				// carga de nuevo el csv
				listProducts.cargarRepuestos("./data/Formato_repuestos.csv");
				
				// carga de nuevo el csv de productos vendidos
				listProductsVendidos.cargarRepuestosVendidos("./data/Productos_vendidos.csv");
				
				
				// se agrupan las ventas por fechas
				listProductsVendidos.sumaVentasPorFecha();
				
				// registra en el csv Ventas_dia.csv la actuliazacion del presente dia 
				listProductsVendidos.registrarVentasDia();
				
				//Carga de nuevo el csv para actualizar los datos en la estructura
				listProductsVendidos.cargarVentasDia("./data/Ventas_dia.csv");
				
			}
			
			else
			{
				//se registra en la estructura los productos comprado
				listProductsVendidos.registrarProductoVendido(nombre, codigoProducto, cantidadVender, marca, valorUnidad, total,date.toString(), numeroPedido);
				
				//se actualiza el csv productos_vendidos el producto comprado
				listProductsVendidos.registrarProductosVendidos();
				
				
				// carga de nuevo el csv
				listProducts.cargarRepuestos("./data/Formato_repuestos.csv");
				
				// carga de nuevo el csv de productos vendidos
				listProductsVendidos.cargarRepuestosVendidos("./data/Productos_vendidos.csv");
				
				// se agrupan las ventas por fechas
				listProductsVendidos.sumaVentasPorFecha();
				
				// registra en el csv Ventas_dia.csv la actuliazacion del presente dia 
				listProductsVendidos.registrarVentasDia();
				
				//Carga de nuevo el csv para actualizar los datos en la estructura
				listProductsVendidos.cargarVentasDia("./data/Ventas_dia.csv");
				
				
				
				
				
				
			}
			answer = true;
		}
		return answer;
	}
	
	
	/*
	public ArrayList<Caja> listaVentas()
	{
		ArrayList<Caja> listaFechas = listProductsVendidos.listaVentasPorFecha();
		return listaFechas;
		
		
	}
	*/
	
	
	
	
	/**
	 * 
	 * 
	 * @param codigoProducto
	 * @param nuevaCantidad
	 * @return true si agrego el producto, false de lo contrario
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public boolean agregarExisteProducto(String codigoProducto, int nuevaCantidad) throws FileNotFoundException, IOException
	{
		boolean answer = false;
		int cantidad = listProducts.darCantidadProducto(codigoProducto);
		int totalUnidades = Math.abs(cantidad + nuevaCantidad);
		
		// Se actualiza la cantidad de unidades en la estructura
		boolean si = listProducts.venderProducto(codigoProducto, totalUnidades);
		
		if (si) 
		{
			//actualiza la cantidad de unidades en el csv
			listProducts.modificarEstadoProducto();
			
			// carga de nuevo el csv
			listProducts.cargarRepuestos("./data/Formato_repuestos.csv");
			answer = true;
		}
		
	
		return answer;
	}
	
	
	
	/**
	 * 
	 * @param nombre
	 * @param codigo
	 * @param cantidad
	 * @param marca
	 * @param valorUnidad
	 * @return true si agrego el producto, false de lo contrario
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public boolean agregarNoExisteProducto(String nombre, String codigo, int cantidad, String marca, double valorUnidad) throws FileNotFoundException, IOException
	{
		double porcentaje = valorUnidad * 0.4;
		double valorUnidadReal = (valorUnidad + porcentaje);
		double valorTotal = cantidad * valorUnidadReal;
		
		boolean si = false;
		boolean answer = listProducts.buscarProductoPorCodigo(codigo);
		if (!answer) {
			// se instancia un producto nuevo
			repuesto = new Producto(nombre, codigo, cantidad, marca, valorUnidadReal, valorTotal, "si");
			
			// se invoca el siguiente metodo para que este lo agregue a la lista
			listProducts.agregarRepuestoNuevo(repuesto);
			
			// se agrega un producto nuevo al csv
			listProducts.modificarEstadoProducto();
			
			
			// carga de nuevo el csv
			listProducts.cargarRepuestos("./data/Formato_repuestos.csv");
			si = true;
		}
		
		
		return si;
	}
	
}