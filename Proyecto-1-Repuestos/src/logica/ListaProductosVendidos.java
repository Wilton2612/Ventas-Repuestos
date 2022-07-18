package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csvreader.CsvWriter;



public class ListaProductosVendidos 
{
	private List<ProductosVendidos> productos;
	
	private ArrayList<Caja> ventas;
	
	private Map<String, Caja> historial;
	

	public ListaProductosVendidos() throws FileNotFoundException, IOException 
	{
		cargarRepuestosVendidos("./data/Productos_vendidos.csv");
		cargarVentasDia("./data/Ventas_dia.csv");
		historial = new HashMap<>();
	}
	
	/**
	 * Este metodo se encarga de registrar en el csv todos los repuestos vendidos
	 * 
	 */
	public void registrarProductosVendidos()
	{
		String salidaArchivo = "./data/Productos_vendidos.csv"; // Nombre del archivo
        
        boolean rutaExiste = new File(salidaArchivo).exists();
        
        if (rutaExiste) {
    		File archivoNoActualizado = new File(salidaArchivo);
    		archivoNoActualizado.delete();
           	
    	}
        
        try {
        	
                FileWriter fichero = null;
                PrintWriter pw = null;
                
           	 fichero = new  FileWriter(salidaArchivo);
           	
           	 pw = new PrintWriter(fichero);
           	 
           	
           	 String linea1 = "nombre"+";"+"codigo"+";"+"cantidad"+";"+"marca"+";"+"valor unidad"+";"+"valor total"+";"+"fecha"+";"+"numero de venta";
             pw.println(linea1);
               // Recorremos la lista y lo insertamos en el archivo
               for(ProductosVendidos product : productos) {
               	
               	String linea = product.getNombre()+";"+product.getCodigo()+";"+product.getCantidad()+";"+product.getMarca()+";"+product.getValorUnidad()+";"+product.getValorTotal()+";"+product.getFecha()+";"+product.getNumeroVenta();
               	pw.println(linea);

                   
               }

               fichero.close(); // Cierra el archivo

           } catch(IOException e) {
               e.printStackTrace();
           }
		
		
	}
	
	
	// Carga los repuestos que actualmente se vendieron
	public void cargarRepuestosVendidos(String rutaArchivo) throws FileNotFoundException, IOException
	{
		
		productos = new ArrayList<ProductosVendidos>();
		
		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
									  // las columnas
		linea = br.readLine();
	
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			
			// Separar los valores que estaban en una línea
			String[] partes = linea.split(";");
			String nombre = partes[0].toLowerCase();				
			String codigo = partes[1].toLowerCase();
			int cantidad = Integer.parseInt(partes[2]);
			String marca = partes[3].toLowerCase();
			double valorUnidad = Double.parseDouble(partes[4]);
			double valorTotal = Double.parseDouble(partes[5]);
			String fecha = partes[6].toLowerCase();
			double numeroVenta = Double.parseDouble(partes[7]);
			
			
			ProductosVendidos product = new ProductosVendidos(nombre, codigo, cantidad, marca, valorUnidad, valorTotal, fecha, numeroVenta);
			productos.add(product);
			
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
		
	}
	
	
	
	/**
	 * 
	 * 
	 * @return lista con todos los productos registrados como vendidos
	 */
	public ArrayList<ProductosVendidos> mostrarListaRepuestosRegistrados()
	{
		ArrayList<ProductosVendidos> listaMayor = new ArrayList<ProductosVendidos>();
		for (ProductosVendidos unidad : productos)
		{
		
			listaMayor.add(unidad);
			
		}
		
		return listaMayor;	
	}
	
	
	/**
	 * Este metodo instancia el objeto para luego agregarlo a la lista
	 * 
	 * @param nombre
	 * @param codigo
	 * @param cantidad
	 * @param marca
	 * @param valorUnidad
	 * @param valorTotal
	 * @param fecha
	 */
	public void registrarProductoVendido(String nombre, String codigo, int cantidad, String marca, double valorUnidad, double valorTotal, String fecha, double numeroVenta)
	{
		ProductosVendidos productosRegistrados = new ProductosVendidos( nombre, codigo, cantidad,  marca, valorUnidad,  valorTotal,fecha, numeroVenta);
		productos.add(productosRegistrados);
		
	}
	
	
	
	
	/**
	 * Este metodo se encarga de registrar en el csv las ventas de un dia
	 * 
	 */
	public void registrarVentasDia()
	{
		String salidaArchivo = "./data/Ventas_dia.csv"; // Nombre del archivo
        
        boolean rutaExiste = new File(salidaArchivo).exists();
        
        if (rutaExiste) {
    		File archivoNoActualizado = new File(salidaArchivo);
    		archivoNoActualizado.delete();
           	
    	}
        
        try {
        	
                FileWriter fichero = null;
                PrintWriter pw = null;
                
           	 fichero = new  FileWriter(salidaArchivo);
           	
           	 pw = new PrintWriter(fichero);
           	 
           	
           	 String linea1 = "fecha"+";"+"ventas";
             pw.println(linea1);
               // Recorremos la lista y lo insertamos en el archivo
               for(Caja product : ventas) {
               	
               	String linea = product.getFecha()+";"+product.getVenta();
               	pw.println(linea);

                   
               }

               fichero.close(); // Cierra el archivo

           } catch(IOException e) {
               e.printStackTrace();
           }
		
		
	}
	
	
	// Carga las ventas de un dia
	public void cargarVentasDia(String rutaArchivo) throws FileNotFoundException, IOException
	{
		
		ventas = new ArrayList<Caja>();
		
		
		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
									  // las columnas
		linea = br.readLine();
	
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			
			// Separar los valores que estaban en una línea
			String[] partes = linea.split(";");
			String fecha = partes[0].toLowerCase();				
			double venta = Double.parseDouble(partes[1]);
	
			
			
			
			Caja product = new Caja(fecha, venta);
			ventas.add(product);
			
			
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
		
	}
	
	
	/**
	 * Pasa los datos que estan almacenados en una lista 
	 * a un Hash Map
	 * 
	 * @returne estructura Hash Map
	 */
	public Map<String, Caja>  pasarDatosEstructura()
	{
		//Map<String, Caja> historial = new HashMap<>();
		
		historial.clear();
		
		for (Caja caja : ventas) 
		{
			historial.put(caja.getFecha(), caja);
			
		}
		return historial;
		
		
		
	}
	

	/**
	 * Este metodo se encarga de agrupar las ventas por fechas
	 * 
	 */
	public void sumaVentasPorFecha()
	{
		ventas.clear();
		Map<String, Caja> historialVentas = pasarDatosEstructura();
		for (ProductosVendidos productosVendidos : productos) {
			
			//Caja vendido = historialVentas.get(productosVendidos.getFecha());
			Caja vendido;
			boolean si = historialVentas.containsKey(productosVendidos.getFecha());
			if (!si)
			{
				
				vendido = new Caja(productosVendidos.getFecha(), productosVendidos.getValorTotal());
				historialVentas.put(productosVendidos.getFecha(), vendido);
				
			}
				
			else 
			{
				
				//vendido = historialVentas.get(productosVendidos.getFecha());
				
				//vendido = new Caja(productosVendidos.getFecha(), (vendido.getVenta()+productosVendidos.getValorTotal()));
				//historialVentas.put(productosVendidos.getFecha(), vendido);
				
				
				
				vendido = historialVentas.get(productosVendidos.getFecha());
				
				
				double aritmetica = (vendido.getVenta()+productosVendidos.getValorTotal());
				
				//double acumulado = Math.abs(aritmetica+vendido.getVenta());
				//vendido.deleteVenta();
				
				vendido.setVenta(aritmetica);
				
			
			}
		
			 
			
		}
	
		limpiarYEmpacar(historialVentas.values());
		historialVentas.clear();
		
		
		

	}
	
	
	
	/**
	 * Pasa los datos del Hash Table a la lista
	 * 
	 * @param mapa
	 */
	public void limpiarYEmpacar(Collection<Caja> mapa)
	{
		
		Collection<Caja> co = mapa;
		
		for (Caja caja : co) 
		{
			ventas.add(caja);
			
		}
		
		
		
	}
	
   
	/**
	 * 
	 * 
	 * @return lista de ventas por fecha
	 */
	public ArrayList<Caja> listaVentasPorFecha()
	{
		
		ArrayList<Caja> listaMayor = new ArrayList<Caja>();
		
		for (Caja unidad : ventas)
		{
				listaMayor.add(unidad);
					
		}
		return listaMayor;	
	}

}