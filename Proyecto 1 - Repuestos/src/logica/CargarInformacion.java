package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csvreader.CsvWriter;



public class CargarInformacion 
{
	private  ArrayList<Producto> repuestos;
	@SuppressWarnings("unused")
	private  ArrayList<ProductosVendidos> repuestosVendidos;
	
	
	/*
	// Carga los repuestos que actualmente se venden
	
		public  ListaProductos cargarRepuestos() throws FileNotFoundException, IOException
		{
		
			repuestos = new ArrayList<Producto>();
			
			// Abrir el archivo y leerlo línea por línea usando un BufferedReader
			BufferedReader br = new BufferedReader(new FileReader("./data/Formato_repuestos.csv"));
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
				
				Producto productos = new Producto(nombre, codigo, cantidad, marca, valorUnidad, valorTotal, estado);
				repuestos.add(productos);
				
				linea = br.readLine(); // Leer la siguiente línea
			}

			br.close();
			ListaProductos datos = new ListaProductos(repuestos);
			return datos;	
		}
		*/
		
		
		/*
		// Carga los repuestos que actualmente se vendieron
		
			public ListaProductosVendidos cargarRepuestosVendidos() throws FileNotFoundException, IOException
			{
				
				repuestosVendidos = new ArrayList<ProductosVendidos>();
				
				// Abrir el archivo y leerlo línea por línea usando un BufferedReader
				BufferedReader br = new BufferedReader(new FileReader("./data/Productos_vendidos.csv"));
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
					
					
					ProductosVendidos productos = new ProductosVendidos(nombre, codigo, cantidad, marca, valorUnidad, valorTotal, fecha, numeroVenta);
					repuestosVendidos.add(productos);
					
					linea = br.readLine(); // Leer la siguiente línea
				}

				br.close();
				ListaProductosVendidos datos = new ListaProductosVendidos(repuestosVendidos);
				return datos;	
			}
			*/
			
			
			
			
			
			
			/*
			/**
			 * Este metodo cambia el estado del producto, si esta eliminado escribe
			 * en la columna estado no,de lo contrario escribe si. 
			 * 
			 * Ademas, la cantidad de unidades de un producto. Por ejemplo, 
			 * cuando se vende x cantida de un producto elimina del csv las unidades
			 * vendidas. Asimismo, cuando se agrega un producto que ya existe el atributo
			 * que cambia es la cantidad, asi pues, este metodo cumple con este requerimiento. 
			 * 
			 * @param codigoProducto
			 * @param estado
			 * @return
			
			public void modificarEstadoProducto() 
			{
				String salidaArchivo = "./data/Formato_repuestos.csv";
				boolean existe  = new File(salidaArchivo).exists();
				
				// si existe el archivo lo borra 
				if (existe) {
					File archivoNoActualizado = new File(salidaArchivo);
					archivoNoActualizado.delete();
				}
				
				try {
					
					CsvWriter nuevoCsv = new CsvWriter( new FileWriter(salidaArchivo, true), ',');
					
					// se escriben las columnas que tiene el csv
					nuevoCsv.write("nombre");
					nuevoCsv.write("codigo");
					nuevoCsv.write("cantidad");
					nuevoCsv.write("marca");
					nuevoCsv.write("valor unidad");
					nuevoCsv.write("valor total");
					nuevoCsv.write("estado");
					
					nuevoCsv.endRecord();
					
					// se escriben los valores de cada columna que tiene el csv
					for (Producto iterable : repuestos) {
						
						nuevoCsv.write(iterable.darNombre());
						nuevoCsv.write(iterable.darCodigo());
						nuevoCsv.write(Integer.toString(iterable.darCantidad()));
						nuevoCsv.write(iterable.darMarca());
						nuevoCsv.write(Double.toString(iterable.darValorUnidad()));
						nuevoCsv.write(Double.toString(iterable.darValorTotal()));
						nuevoCsv.write(iterable.darEstado());
						
						nuevoCsv.endRecord();
					}
					
					nuevoCsv.endRecord();
					
					
					
					
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
				
			}
			
			
			
			
			
			/**
			 * Este metodo se encarga de registrar en el csv todos los repuestos vendidos
			 * 
			 
			 
			public void registrarProductosVendidos()
			{
				String salidaArchivo = "./data/Productos_vendidos.csv";
				boolean existe  = new File(salidaArchivo).exists();
				
				// si existe el archivo lo borra 
				if (existe) {
					File archivoNoActualizado = new File(salidaArchivo);
					archivoNoActualizado.delete();
				}
				
				try {
					
					CsvWriter nuevoCsv = new CsvWriter( new FileWriter(salidaArchivo, true), ',');
					
					// se escriben las columnas que tiene el csv
					nuevoCsv.write("nombre");
					nuevoCsv.write("codigo");
					nuevoCsv.write("cantidad");
					nuevoCsv.write("marca");
					nuevoCsv.write("valor unidad");
					nuevoCsv.write("valor total");
					nuevoCsv.write("fecha");
					nuevoCsv.write("numero de venta");
					
					nuevoCsv.endRecord();
					
					
					// se escriben los valores de cada columna que tiene el csv
					for (ProductosVendidos iterable : repuestosVendidos) {
						
						nuevoCsv.write(iterable.getNombre());
						nuevoCsv.write(iterable.getCodigo());
						nuevoCsv.write(Integer.toString(iterable.getCantidad()));
						nuevoCsv.write(iterable.getMarca());
						nuevoCsv.write(Double.toString(iterable.getValorUnidad()));
						nuevoCsv.write(Double.toString(iterable.getValorTotal()));
						nuevoCsv.write(iterable.getFecha());
						nuevoCsv.write(Double.toString(iterable.getNumeroVenta()));
						
						nuevoCsv.endRecord();
					}
					
					nuevoCsv.endRecord();
					
					
					
					
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
				
				
			}
			*/
			
	

}
