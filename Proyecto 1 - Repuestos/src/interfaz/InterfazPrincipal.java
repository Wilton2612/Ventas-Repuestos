package interfaz;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import logica.Caja;
import logica.ConsultasProductos;
import logica.ListaProductos;
import logica.ListaProductosVendidos;
import logica.Producto;
import logica.ProductosVendidos;









@SuppressWarnings("serial")
public class InterfazPrincipal extends JFrame
{
	
	//private CargarInformacion cargaCsv;
	
	
	private DialogoVentasDia ventas;
	
	
	private DialogoVenderProducto dialogoVender;
	
	
	private DialogoRegistro registro;
	
	
	private ListaProductosVendidos productosVendidos;
	
	
	private DialogoAgregarProducto dialogoAgregar;
	
	
	private DialogoProductosEscasos productosEscasos;
	
	
	private DialogoProductoNoEscasos productosNoEscasos;
	
	
	private ConsultasProductos consultas;
	
	
	private ListaProductos productos;
	
	
    private PanelBotones panelBotones;

    
    private PanelBuscar panelBuscar;

   
    private PanelFuncionalidades panelFuncionalidades;

    
    private PanelMostrarDatos panelMostrarDatos;
	
    
    private ArrayList<String> datos;
    
	public InterfazPrincipal() throws IOException
	{
		//cargarCsv();
		setTitle( "Sistema Ventas" );
        setSize( 1000, 600 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//setLayout(new BorderLayout());
        //setResizable( false );
        setLayout(null);
        
        
        //CLASES DE LA LOGICA
        productos = new ListaProductos();
        
        productosVendidos = new ListaProductosVendidos();
        
        consultas = new ConsultasProductos (productos, productosVendidos);
        
        
        //CLASES DE LA INTERFAZ
        dialogoAgregar= new DialogoAgregarProducto( this );
        
        registro = new DialogoRegistro( this );
        
        ventas = new DialogoVentasDia( this );
        
        productosNoEscasos = new DialogoProductoNoEscasos( this );
        
        productosEscasos = new DialogoProductosEscasos( this );
        
        dialogoVender = new DialogoVenderProducto( this );
        
        panelBotones= new PanelBotones( this );
        
        panelBuscar = new PanelBuscar(this);
        
        panelFuncionalidades = new PanelFuncionalidades(this);
        
        panelMostrarDatos = new PanelMostrarDatos(this );
        
        
        

        JPanel centro = new JPanel(new GridLayout( 1, 2 ) );
        //centro.setBorder(new TitledBorder("centroo"));
        centro.setLayout(null);
        
		
        //UBICACION DE LOS PANELES EN EL JFrame
    	panelBotones.setBounds(20, 410, 950, 170);
        
        panelBuscar.setBounds(20, 5, 950, 60);
        
        centro.setBounds(80, 80, 800, 330);
		
		panelMostrarDatos.setBounds(100, 20, 300, 300);
		
		panelFuncionalidades.setBounds(460, 20, 270, 300);
		
		
		
        centro.add(panelMostrarDatos);
        centro.add(panelFuncionalidades);
        
        
       
        add(panelBotones, BorderLayout.SOUTH);
        add(panelBuscar, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        
        
        setLocationRelativeTo(null);
        //setResizable( false );
        UIManager.put("OptionPane.messageFont", new Font("Cambria",Font.ITALIC, 20));
	}
	
	
	/**
	 * Valida las restricciones para buscar un repuesto
	 * 
	 * @param nombreProducto
	 */
	public void buscarProducto(String nombreProducto)
	{
		if (nombreProducto.equals(""))
		{
			
			JOptionPane.showMessageDialog( this, "Escriba el nombre del repuesto", "BUSCAR REPUESTO", JOptionPane.ERROR_MESSAGE );
		}
		else
		{
			String  co = productos.darCodigoProducto(nombreProducto);
			if(co == null)
			{
				noHayDatos(nombreProducto);
				
				JOptionPane.showMessageDialog( this, "No tenemos ese repuesto", "BUSCAR REPUESTO", JOptionPane.ERROR_MESSAGE );
				
			}
			else
			{
				mostrarDatos(nombreProducto);
			}
			
			
		}
		
		
	}
	
	/**
	 * extrae los valores del producto buscado y los envia al panel
	 * mostrarDatos y dialogoAgregar.
	 * 
	 */
	public void mostrarDatos(String nombreProducto)
	{
		datos = consultas.BuscarProducto(nombreProducto);
		String nombre = datos.get(0);
		String codigo = datos.get(1);
		String cantida = datos.get(2);
		String marca = datos.get(3);
		String precio = datos.get(4);
		panelMostrarDatos.actualizarCampos(nombre,codigo, cantida, marca, precio);
		dialogoAgregar.DatosDialogoAgregar(nombre,codigo, "", marca, precio, true);
		
	}
	
	
	
	
	/**
	 * Cuando no se encuentra un producto envia valores 
	 * 
	 * @param nombreProducto
	 */
	public void noHayDatos(String nombreProducto)
	{
		
		try {
			String nombre = "";
			String codigo = "";
			String cantida = "";
			String marca = "";
			String precio = "";
			panelMostrarDatos.actualizarCampos(nombre,codigo, cantida, marca, precio);
			dialogoAgregar.NoDatosDialogoAgregar(nombre,codigo, cantida, marca, precio, false);
			
			
		} catch (NullPointerException e) {
			
			
			JOptionPane.showMessageDialog( this, "El salario debe ser un número.", "ERROR", JOptionPane.ERROR_MESSAGE );
        
		}
		
		
	}
	

	
	
	/**
	 * Cuando un producto existente es agregado se actualiza la cantidad 
	 * de unidades tanto en la estrutura donde esta almacenada, el csv y 
	 * en el panelMostrarDatos.
	 * 
	 * @param codigo
	 * @param unidades
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws NumberFormatException 
	 */
	public void AgregarProductoExistente(String codigo, String unidades) throws NumberFormatException, FileNotFoundException, IOException
	{
		//Actualiza las unidades tanto en la estructura y csv
		consultas.agregarExisteProducto(codigo, Integer.parseInt(unidades));
		int cantidad = productos.darCantidadProducto(codigo);
		
		//Actualiza las unidades en panelMostrarDatos
		panelMostrarDatos.actualizarCampoCantidad(Integer.toString(cantidad));
		
		
	}
	
	
	/**
	 * Cuando un producto NO existe y es agregado se actualiza la cantidad 
	 * de unidades tanto en la estrutura donde esta almacenada, el csv 
	 * en el panelMostrarDatos.
	 * 
	 * @param nombre
	 * @param codigo
	 * @param unidades
	 * @param marca
	 * @param precio
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws NumberFormatException 
	 */
	public void AgregarProductoNoExistente(String nombre, String codigo, String unidades, String marca, String precio ) throws NumberFormatException, FileNotFoundException, IOException
	{
		//Actualiza las unidades tanto en la estructura y csv
		consultas.agregarNoExisteProducto(nombre, codigo, Integer.parseInt(unidades), marca, Double.parseDouble(precio));

		
		//Actualiza las unidades en panelMostrarDatos
		panelMostrarDatos.actualizarCampos(nombre, codigo, unidades, marca, Double.toString(productos.darPrecioProducto(codigo)));
			
			
		
		
		
		
		
	}
	
	
	/**
	 * 
	 * este metodo sirve de ayuda para pasar del panel mostrarDatos 
	 * al panel Funcionalidades
	 * @param codigoProducto
	 */
	public void metodoAyudaEliminarProducto(String codigoProducto )
	{
		panelFuncionalidades.metodoAyuda(codigoProducto);
		dialogoVender.metodoAyuda(codigoProducto);
		
	}
	
	
	/**
	 * Se elimina el producto la vista del vendedor, y al mismo tiempo se borra
	 * del csv y la lista
	 * 
	 * @param codigoProducto
	 * @throws IOException
	 */
	public void eliminarProducto(String codigoProducto) throws IOException
	{
		
		boolean si = consultas.eliminarProducto(codigoProducto);
		//datos = consultas.BuscarProducto(productos.darNombreProducto(codigoProducto));
		if (si) {
			noHayDatos(productos.darNombreProducto(codigoProducto));
		}
		
		else
		{
			
			JOptionPane.showMessageDialog( this, "busque el repuesto", "ELIMINAR REPUESTO", JOptionPane.ERROR_MESSAGE );
	
		}
		
	}
	
	
	
	
	
	/**
	 * Se realiza los procedimientos correspondientes para vender un producto
	 * 
	 * @param pCodigo
	 * @param parseInt
	 * @param nuevoPedido
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void venderRepuesto(String pCodigo, int parseInt, boolean nuevoPedido) throws FileNotFoundException, IOException 
	{
		//Actualiza las unidades tanto en la estructura y csv
		consultas.venderProducto(pCodigo, parseInt, nuevoPedido);
		int cantidad = productos.darCantidadProducto(pCodigo);
		
		//Actualiza las unidades en panelMostrarDatos
		panelMostrarDatos.actualizarCampoCantidad(Integer.toString(cantidad));
		
		
		
		
		
		
	}
	
	
	

	
	/**
	 * Muestra la ventana de los productos con menos unidades
	 */
	public void mostrarDialogoMenosUnidades()
	{
		
		
		try {
			
			//productosEscasos = new DialogoProductosEscasos( this );
			productosEscasos.setVisible( true );
			ArrayList<Producto> listaRepuestos = productos.darListaProductosEscasos();
			productosEscasos.actualizarlistaRepuestosEscasos(listaRepuestos);
			mostrarCantidadProductoEscaso(listaRepuestos.get(0));
			
			
			
		} catch (IndexOutOfBoundsException e) {
			
		
			JOptionPane.showMessageDialog( this, "No hay repuestos escasos.", "REPUESTOS ESCASOS", JOptionPane.ERROR_MESSAGE );

        
		}
	}
	
	

	/**
	 * Cambia el repuesto para el cual se debe mostrar la informacion en el 
	 * DialogoProductosEscasos
	 * 
	 * @param repuesto El Produco para el que se debe mostrar la informacion
	 */
	public void mostrarCantidadProductoEscaso(Producto repuesto)
	{
		productosEscasos.actualizarProductoEscaso(repuesto);
	}
	
	
	
	/**
	 * Muestra la ventana de los productos con mas unidades
	 */
	public void mostrarDialogoMasUnidades()
	{
		
		
		try {
			//productosNoEscasos = new DialogoProductoNoEscasos( this );
			productosNoEscasos.setVisible( true );
			ArrayList<Producto> listaRepuestos = productos.darListaProductosNoEscasos();
			productosNoEscasos.actualizarlistaRepuestosNoEscasos(listaRepuestos);
			mostrarCantidadProductoNoEscaso(listaRepuestos.get(0));
		    
			
			
			
		} catch (IndexOutOfBoundsException e) {
			
			
			JOptionPane.showMessageDialog( this, "No hay repuestos con mas de 5 unidades.", "REPUESTOS NO ESCASOS", JOptionPane.ERROR_MESSAGE );

	    
		}
		
	}
	
	

	/**
	 * Cambia el repuesto para el cual se debe mostrar la informacion en el 
	 * DialogoProductoNoEscasos
	 * 
	 * @param repuesto El Produco para el que se debe mostrar la informacion
	 */
	public void mostrarCantidadProductoNoEscaso(Producto repuesto)
	{
		productosNoEscasos.actualizarProductoNoEscaso(repuesto);
	}
	
	
	
	/**
	 * Muestra la ventana de las ventas por dia
	 */
	public void mostrarDialogoVentasDia()
	{
	
		try {
			
			//factura = new DialogoFactura( this );
			ventas.setVisible( true );
			ArrayList<Caja> listaVentas= productosVendidos.listaVentasPorFecha();
			ventas.actualizarlistaVentas(listaVentas);
			mostrarVentasFecha(listaVentas.get(0));
			
		
		} catch (IndexOutOfBoundsException e) {
			
			
			JOptionPane.showMessageDialog( this, "No hay historial de ventas.", "VENTAS", JOptionPane.ERROR_MESSAGE );

	    
		}
	
	}
	
	
	/**
	 * Cambia la fecha para el cual se debe mostrar la informacion en el 
	 * DialogoVentasDia
	 * 
	 * @param  ventaDia La Caja para el que se debe mostrar la informacion
	 */
	public void mostrarVentasFecha(Caja ventaDia)
	{
		ventas.actualizarVentas(ventaDia);
	}
	
	
	
	
	/**
	 * Muestra la ventana de los productos vendidos
	 */
	public void mostrarDialogoRegistro()
	{
		try {
			

			//productosNoEscasos = new DialogoProductoNoEscasos( this );
			registro.setVisible( true );
			ArrayList<ProductosVendidos> listaRepuestosVendidos = productosVendidos.mostrarListaRepuestosRegistrados();
			registro.actualizarlistaRepuestosVendidos(listaRepuestosVendidos);
			mostrarProductosVendidos(listaRepuestosVendidos.get(0));
			
		
		} catch (IndexOutOfBoundsException e) {
			
			
			JOptionPane.showMessageDialog( this, "No hay repuestos vendidos.", "REPUESTOS VENDIDOS", JOptionPane.ERROR_MESSAGE );

	    
		}
		
		
	}
	
	

	/**
	 * Cambia el repuesto para el cual se debe mostrar la informacion en el 
	 * DialogoRegistro
	 * 
	 * @param repuesto El ProducosVendidos para el que se debe mostrar la informacion
	 */
	public void mostrarProductosVendidos(ProductosVendidos repuesto)
	{
		registro.actualizarProductoVendidos(repuesto);
	}
	
	

	

	/**
	 * Muestra la ventana para agregar un producto
	 */
	public void mostrarDialogoAgregarProducto()
	{
		//dialogoAgregar= new DialogoAgregarProducto( this );
		dialogoAgregar.setVisible( true );

	}
	
	
	
	/**
	 * valida que el numero sea un entero
	 * 
	 * @param cadena
	 * @return
	 */
	public static boolean isNumericInt(String cadena) 
	 {
	        boolean resultado;

	        try {
	            Integer.parseInt(cadena);
	            resultado = true;
	        } catch (NumberFormatException excepcion) {
	            resultado = false;
	        }

	        return resultado;
	  }
	
	
	
	
	/**
	 * Vefirica las restricciones cuando se agrega un producto que ya existe.
	 * 
	 * @param pNo
	 * @param nombre
	 * @param codigo
	 * @param cantidad
	 * @param marca
	 * @param precio
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void validarRequisitosAgregarRepuestoExistente(String codigo, String cantidad) throws FileNotFoundException, IOException
	{
		
		try {
			
			int unidad = Integer.parseInt(cantidad);
		
			if (unidad <= 0)
			{
				
				JOptionPane.showMessageDialog( this, "La cantidad debe ser mayor a cero", "AGREGAR REPUESTO", JOptionPane.ERROR_MESSAGE );

			}
		
			else
			{
				AgregarProductoExistente(codigo, cantidad);
			}
				
		} 
		
		catch( NumberFormatException e2)
        {
			//e2.printStackTrace();
			
			JOptionPane.showMessageDialog( this, "Las unidades deben ser un numero entero.", "AGREGAR REPUESTO", JOptionPane.ERROR_MESSAGE );
        }
		
	}
	
	
	/**
	 * Vefirica las restricciones cuando se agrega un producto nuevo.
	 * 
	 * @param pNo
	 * @param nombre
	 * @param codigo
	 * @param cantidad
	 * @param marca
	 * @param precio
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void validarRequisitosAgregarRepuestoNoExistente(String nombre, String codigo, String cantidad, String marca, String precio) throws FileNotFoundException, IOException
	{
		
		try {
			
			int unidad = Integer.parseInt(cantidad);
			//double valor = Double.parseDouble(precio);
			
			if (productos.buscarProductoPorNombre(nombre)) {
				
				
				JOptionPane.showMessageDialog( this, "Ya existe un repuesto con ese nombre.", "AGREGAR REPUESTO", JOptionPane.ERROR_MESSAGE );
				
			}
			
			else if (productos.buscarProductoPorCodigo(codigo)) {
				
				JOptionPane.showMessageDialog( this, "Ya existe un repuesto con ese codigo.", "AGREGAR REPUESTO", JOptionPane.ERROR_MESSAGE );
			}
			
			else if (!isNumericInt(codigo))
			{
				JOptionPane.showMessageDialog( this, "El codigo no puede contener letras", "AGREGAR REPUESTO", JOptionPane.ERROR_MESSAGE );	
			}
			
			else if (unidad <= 0)
			{
				JOptionPane.showMessageDialog( this, "La cantidad debe ser mayor a cero", "AGREGAR REPUESTO", JOptionPane.ERROR_MESSAGE );

			}
			
			else if (Double.parseDouble(precio)<= 0)
			{
				JOptionPane.showMessageDialog( this, "El precio debe ser mayor a cero", "AGREGAR REPUESTO", JOptionPane.ERROR_MESSAGE );

			}
			
			else
			{
			
				AgregarProductoNoExistente(nombre, codigo, cantidad, marca, precio);
				
			}
				
		} 
		
		catch( NumberFormatException e2)
        {
			//e2.printStackTrace();
			JOptionPane.showMessageDialog( this, "Las unidades y precio deben ser numeros enteros.", "AGREGAR REPUESTO", JOptionPane.ERROR_MESSAGE );
        }
		
	}
	
	
	
	
	
	
	/**
	 * Muestra la ventana para vender un producto
	 */
	public void mostrarDialogoVenderProducto()
	{
		
		//dialogoVender = new DialogoVenderProducto( this );
		dialogoVender.setVisible( true );
	}
	
	
	/**
	 * validad las restricciones para un pedido nuevo
	 * 
	 * @param cantidad
	 * @param codigo
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void validarRequisitosVenderRepuestosSI(String cantidad, String codigo) throws FileNotFoundException, IOException
	{
		try {
			
			int unidades = Integer.parseInt(cantidad);
			if (unidades <= 0)
			{
				JOptionPane.showMessageDialog( this, "Las cantidad de productos a vender debe ser mayor a cero.", "VENDER REPUESTO", JOptionPane.ERROR_MESSAGE );
			}
			
			else if (productos.darCantidadProducto(codigo) < unidades)
			{
				JOptionPane.showMessageDialog( this, "No hay las suficientes unidades para vender.", "VENDER REPUESTO", JOptionPane.ERROR_MESSAGE );
	
			}
			
			else
			{
				venderRepuesto(codigo, Integer.parseInt(cantidad), true);
				
				
			}
			
		} catch( NumberFormatException e2)
        {
            JOptionPane.showMessageDialog( this, "Las unidades deben ser numeros", "AGREGAR REPUESTO", JOptionPane.ERROR_MESSAGE );
        }
		
		
		
	}
	
	
	
	/**
	 * validad las restricciones para cuando no es nuevo pedido
	 * 
	 * @param cantidad
	 * @param codigo
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void validarRequisitosVenderRepuestosNO(String cantidad, String codigo) throws FileNotFoundException, IOException
	{
		try {
			
			int unidades = Integer.parseInt(cantidad);
			
			if (unidades <= 0)
			{
				JOptionPane.showMessageDialog( this, "Las cantidad de productos a vender debe ser mayor a cero.", "VENDER REPUESTO", JOptionPane.ERROR_MESSAGE );
			}
			
			else if (productos.darCantidadProducto(codigo) < unidades)
			{
				JOptionPane.showMessageDialog( this, "No hay las suficientes unidades para vender.", "VENDER REPUESTO", JOptionPane.ERROR_MESSAGE );
	
			}
			

			else
			{
				venderRepuesto(codigo, unidades, false);
				
				
				
			}
			
		} catch( NumberFormatException e2)
        {
            JOptionPane.showMessageDialog( this, "Las unidades deben ser numeros", "AGREGAR REPUESTO", JOptionPane.ERROR_MESSAGE );
        }
		
		
		
	}
	
	

	public static void main( String[] pArgs )
    {
        try
        {
        	
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazPrincipal interfaz = new InterfazPrincipal( );
            interfaz.setVisible( true );
            
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
