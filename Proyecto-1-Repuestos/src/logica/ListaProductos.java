package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvWriter;

@SuppressWarnings("unused")
public class ListaProductos 
{
	private List<Producto> productos;
	
	public ListaProductos() throws FileNotFoundException, IOException 
	{
		cargarRepuestos("./data/Formato_repuestos.csv");
		//productos = new ArrayList<Producto>();
	}
	
	
	/**
	 * Este metodo cambia el estado del producto, si esta eliminado escribe
	 * en la columna estado no,de lo contrario escribe si. 
	 * 
	 * Ademas, la cantidad de unidades de un producto. Por ejemplo, 
	 * cuando se vende x cantida de un producto elimina del csv las unidades
	 * vendidas. Asimismo, cuando se agrega un producto que ya existe el atributo
	 * que cambia es la cantidad, asi pues, este metodo cumple con este requerimiento. 
	 * 
	 * 
	 */
	public  void modificarEstadoProducto() 
	{
        String salidaArchivo = "./data/Formato_repuestos.csv"; // Nombre del archivo
        
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
           	 
           	
           	 String linea1 = "nombre"+";"+"codigo"+";"+"cantidad"+";"+"marca"+";"+"valor unidad"+";"+"valor total"+";"+"estado";
             pw.println(linea1);
               // Recorremos la lista y lo insertamos en el archivo
               for(Producto product : productos) {
               	
               	String linea = product.darNombre()+";"+product.darCodigo()+";"+product.darCantidad()+";"+product.darMarca()+";"+product.darValorUnidad()+";"+product.darValorTotal()+";"+product.darEstado();
               	pw.println(linea);

                   
               }

               fichero.close(); // Cierra el archivo

           } catch(IOException e) {
               e.printStackTrace();
           }
        
        /*
        	catch( NumberFormatException e )
        	{
            throw new Exception( "Archivo no encontrado vuelva a cargar el programa." );
        	}
        	
        	*/
	}
        
        
        
        
        
        
  

	
	
	
	/**
	 * Carga el archivo CSV que tiene la informacion de los repuestos vendidos
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void cargarRepuestos(String archivo) throws FileNotFoundException, IOException 
	{

		productos = new ArrayList<Producto>();
		
		//"./data/Formato_repuestos.csv"
		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(archivo));
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
			String estado = partes[6].toLowerCase();
			
			Producto product = new Producto(nombre, codigo, cantidad, marca, valorUnidad, valorTotal, estado);
			productos.add(product);
			
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
		
	}
	
	
	
	/**
	 * 
	 * @param codigoProducto
	 * @return retorna false si el producto no existe, true de lo contrario
	 */
	public boolean buscarProductoPorCodigo(String codigoProducto)
	{
		boolean si = false;
		for (Producto unidad : productos)
		{
			
			if (unidad.darCodigo().equals(codigoProducto) && unidad.darEstado().equals("si"))
			{
				si = true;
			}
			
		}
		return si;	
	}
	
	
	/**
	 * 
	 * @param nombreProducto
	 * @return retorna false si el producto no existe, true de lo contrario
	 */
	public boolean buscarProductoPorNombre(String nombre)
	{
		boolean si = false;
		for (Producto unidad : productos)
		{
			
			if (unidad.darNombre().equals(nombre) && unidad.darEstado().equals("si"))
			{
				si = true;
			}
			
		}
		return si;	
	}
	
	/**
	 * 
	 * @param codigoProducto
	 * @return retorna el nombre del producto
	 */
	public String darNombreProducto(String codigoProducto)
	{
		String respuesta = null;
		for (Producto unidad : productos)
		{
		
			if (unidad.darCodigo().equals(codigoProducto) && unidad.darEstado().equals("si"))
			{
				respuesta = unidad.darNombre();
			}
			
		}
		return respuesta;	
	}
	
	/**
	 * 
	 * 
	 * @param nombreProducto
	 * @return retorna el nombre del producto
	 */
	public String darCodigoProducto(String nombreProducto)
	{
		String respuesta = null;
		for (Producto unidad : productos)
		{
		
			if (unidad.darNombre().equals(nombreProducto) && unidad.darEstado().equals("si"))
			{
				respuesta = unidad.darCodigo();
			}
			
		}
		return respuesta;	
	}
	
	
	
	/**
	 * 
	 * @param codigoProducto
	 * @return retorna la cantidad de productos
	 */
	public int darCantidadProducto(String codigoProducto)
	{
		int respuesta = 0;
		for (Producto unidad : productos)
		{
		
			if (unidad.darCodigo().equals(codigoProducto) && unidad.darEstado().equals("si"))
			{
				respuesta = unidad.darCantidad();
			}
			
		}
		return respuesta;	
	}
	
	
	/**
	 * busca un producto por el codigo
	 * 
	 * @param codigoProducto
	 * @return retorna la marca de un producto
	 */
	public String darMarcaProducto(String codigoProducto)
	{
		String respuesta = null;
		for (Producto unidad : productos)
		{
		
			if (unidad.darCodigo().equals(codigoProducto) && unidad.darEstado().equals("si"))
			{
				respuesta = unidad.darMarca();
			}
			
		}
		return respuesta;	
	}
	
	/**
	 * para un determinado producto retorna el valor de la unidad de este
	 * 
	 * @param codigoProducto
	 * @return retorna el precio de la unidad
	 */
	public double darPrecioProducto(String codigoProducto)
	{
		double respuesta = 0f;
		for (Producto unidad : productos)
		{
		
			if (unidad.darCodigo().equals(codigoProducto) && unidad.darEstado().equals("si"))
			{
				respuesta = unidad.darValorUnidad();
			}
			
		}
		return respuesta;	
	}
	
	/**
	 * para un determinado producto retorna el valor total de las unidades de este
	 * 
	 * @param codigoProducto
	 * @return retorna el precio total
	 */
	public double darPrecioTotalProducto(String codigoProducto)
	{
		double respuesta = 0f;
		for (Producto unidad : productos)
		{
		
			if (unidad.darCodigo().equals(codigoProducto) && unidad.darEstado().equals("si"))
			{
				respuesta = unidad.darValorTotal();
			}
			
		}
		return respuesta;	
	}
	
	/**
	 * se ingresa por parametro el codigo de un producto y retorna el estado de este
	 * 
	 * @param codigoProducto
	 * @return false si el producto ha sido eliminado, true de lo contrario
	 */
	public String darEstadoProducto(String codigoProducto)
	{
		String respuesta = "";
		for (Producto unidad : productos)
		{
		
			if (unidad.darCodigo().equals(codigoProducto))
			{
				respuesta = unidad.darEstado();
			}
			
		}
		return respuesta;	
	}
	
	public boolean cambiarEstadoProducto(String codigoProducto, String estado)
	{
		boolean respuesta = false;
		for (Producto unidad : productos)
		{
		
			if (unidad.darCodigo().equals(codigoProducto))
			{
				unidad.cambiarEstado(estado);
				respuesta = true;
			}
			
		}
		return respuesta;	
	}
	
	
	public boolean venderProducto(String codigoProducto, int nuevaCantidad)
	{
		boolean respuesta = false;
		for (Producto unidad : productos)
		{
			if (unidad.darCodigo().equals(codigoProducto))
			{
				unidad.cambiarCantidad(nuevaCantidad);
				respuesta = true;
			}
			
		}
		return respuesta;	
	}
	
	
	
	/**
	 * 
	 * 
	 * @return lista de productos que tienen menos o igual a 5 unidades
	 */
	public ArrayList<Producto> darListaProductosEscasos()
	{
		
		ArrayList<Producto> listaMayor = new ArrayList<Producto>();
		
		
		for (Producto unidad : productos)
		{
		
			if ((unidad.darCantidad() <= 5) && (unidad.darEstado().equals("si")))
			{
				
				listaMayor.add(unidad);
				
			}
			
		}
		return listaMayor;	
	}
	
	/**
	 * 
	 * 
	 * @return lista de productos que tienen mas de 5 unidades
	 */
	public ArrayList<Producto> darListaProductosNoEscasos()
	{
		ArrayList<Producto> listaMayor = new ArrayList<Producto>();
		
		for (Producto unidad : productos)
		{
		
			if ((unidad.darCantidad() > 5) && (unidad.darEstado().equals("si")))
			{
				
				listaMayor.add(unidad);
				
			}
			
		}
		return listaMayor;	
	}
	
	
	
	public void agregarRepuestoNuevo(Producto nuevoProducto)
	{
		productos.add(nuevoProducto);
		
		
		
	}

}