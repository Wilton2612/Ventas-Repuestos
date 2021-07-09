

package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logica.Producto;
import logica.ProductosVendidos;

public class DialogoRegistro extends JDialog implements ListSelectionListener
{
	
	private JList<ProductosVendidos> listaProductos;

	
	private DefaultListModel<ProductosVendidos> modeloProductos;
	
	
	private InterfazPrincipal principal;
	
	
	private JLabel nombre;
	
	private JTextField txtNombre;
	
	
	private JLabel codigo;

	private JTextField txtCodigo;
	

	private JLabel cantidad;
	
	private JTextField txtCantidad;
	
	
	private JLabel marca;
	
	private JTextField txtMarca;
	
	
	private JLabel precioUnitario;

    private JTextField txtPrecioUnitario;
    
    
    private JLabel precioTotal;

    private JTextField txtPrecioTotal;
    
    
    private JLabel fecha;

    private JTextField txtFecha;
    
    
    private JLabel numeroVenta ;

    private JTextField txtNumeroVenta;
    
    
	private ProductosVendidos repuestoVendidos;
	

	public DialogoRegistro(InterfazPrincipal principal)
	{ 
		this.principal = principal;
		setTitle( "HISTORIAL DE REPUESTOS VENDIDOS" );
		setSize(900, 500);
		setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
		setLocationRelativeTo(null);
		
		JPanel centro = new JPanel(new GridLayout( 1, 2 ) );
		centro.setLayout(null);
		//centro.setBorder(new TitledBorder("CENTRO"));
		
		JPanel listaNombres = new JPanel(new BorderLayout());
		//listaNombres.setBorder(new TitledBorder("LISTA DE REPUESTOS"));
		modeloProductos = new DefaultListModel<ProductosVendidos>();
		listaProductos = new JList<>(modeloProductos);
		listaProductos.setFont(new Font("Cambria",Font.ITALIC, 20));
		listaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaProductos .addListSelectionListener(this);

		JScrollPane panel = new JScrollPane(listaProductos);
		
		listaNombres.setBounds(120, 20, 300, 420);
		panel.setBounds(10, 20, 480, 390);
		
		listaNombres.add(panel);
		
		
		JPanel unidadesProducto = new JPanel( new GridLayout( 8, 2 ) );
		//unidadesProducto.setBorder(new TitledBorder("INFORMACION"));
		
		nombre = new JLabel( "Nombre: " );
        nombre.setFont(new Font("Cambria",Font.ITALIC, 20));
        
        codigo = new JLabel( "Codigo: " );
        codigo.setFont(new Font("Cambria",Font.ITALIC, 20));
        
        
        cantidad = new JLabel( "Unidades: " );
        cantidad.setFont(new Font("Cambria",Font.ITALIC, 20));
        
        
        marca = new JLabel( "Marca: " );
        marca.setFont(new Font("Cambria",Font.ITALIC, 20));
        
        
        precioUnitario= new JLabel( "Valor unidad: " );
        precioUnitario.setFont(new Font("Cambria",Font.ITALIC, 20));
        
        
        precioTotal = new JLabel( "Valor total: " );
        precioTotal.setFont(new Font("Cambria",Font.ITALIC, 20));
        
        
        fecha = new JLabel( "Fecha: " );
        fecha.setFont(new Font("Cambria",Font.ITALIC, 20));
        
        
        numeroVenta= new JLabel( "Numero venta: " );
        numeroVenta.setFont(new Font("Cambria",Font.ITALIC, 20));
		
        
        
       
        txtNombre = new JTextField( 15 ); // 2
        txtNombre.setEditable( false );
        txtNombre.setBorder(null);
        txtNombre.setFont(new Font("Cambria",Font.ITALIC,20));
        
        
        txtCodigo = new JTextField( 15 ); // 2
        txtCodigo.setEditable( false );
        txtCodigo.setBorder(null);
        txtCodigo.setFont(new Font("Cambria",Font.ITALIC,20));
        
        
        
        txtCantidad = new JTextField( 15 ); // 2
        txtCantidad.setEditable( false );
        txtCantidad.setBorder(null);
        txtCantidad.setFont(new Font("Cambria",Font.ITALIC,20));
        
        
        
        txtMarca = new JTextField( 15 ); // 2
        txtMarca.setEditable( false );
        txtMarca.setBorder(null);
        txtMarca.setFont(new Font("Cambria",Font.ITALIC,20));
        
        
        
        txtPrecioUnitario = new JTextField( 15); // 2
        txtPrecioUnitario.setEditable( false );
        txtPrecioUnitario.setBorder(null);
        txtPrecioUnitario.setFont(new Font("Cambria",Font.ITALIC,20));
        
        
        
        txtPrecioTotal = new JTextField( 15 ); // 2
        txtPrecioTotal.setEditable( false );
        txtPrecioTotal.setBorder(null);
        txtPrecioTotal.setFont(new Font("Cambria",Font.ITALIC,20));
        
        
        txtFecha = new JTextField( 15 ); // 2
        txtFecha.setEditable( false );
        txtFecha.setBorder(null);
        txtFecha.setFont(new Font("Cambria",Font.ITALIC,20));
        
        
        txtNumeroVenta = new JTextField( 15 ); // 2
        txtNumeroVenta.setEditable( false );
        txtNumeroVenta.setBorder(null);
        txtNumeroVenta.setFont(new Font("Cambria",Font.ITALIC,20));
		
       
        unidadesProducto.setBounds(480, 80, 400, 300);
        
        
        unidadesProducto.add( nombre);
        unidadesProducto.add( txtNombre );
        
        unidadesProducto.add( codigo );
        unidadesProducto.add( txtCodigo );
        
        
        unidadesProducto.add( cantidad );
        unidadesProducto.add( txtCantidad );
        
        
        unidadesProducto.add(marca );
        unidadesProducto.add( txtMarca );
        
        
        unidadesProducto.add( precioUnitario );
        unidadesProducto.add( txtPrecioUnitario );
        
        
        unidadesProducto.add(precioTotal );
        unidadesProducto.add( txtPrecioTotal );
        
        
        unidadesProducto.add( fecha);
        unidadesProducto.add( txtFecha );
        
        unidadesProducto.add( numeroVenta );
        unidadesProducto.add( txtNumeroVenta );
        
        
        centro.add(listaNombres);
        centro.add(unidadesProducto);
        add(centro, BorderLayout.CENTER);
		
	}
	
	
	
	
	/**
	 * Trae la lista que contiene los repuestos que estan 
	 * por acabarse
	 * 
	 * @param lista de repuestos con igual o menor a 5 unidades
	 */
	
	public void actualizarlistaRepuestosVendidos(ArrayList<ProductosVendidos> datos)
	{
		
      
		modeloProductos.clear();
		for (ProductosVendidos list : datos) 
		{
			modeloProductos.addElement(list);
		   
		}
	}
	
	
	/**
	 * Cambia el libro cuya información se muestra en el panel
	 * 
	 * @param nuevolibro El nuevo libro para el cual se debe mostrar la información
	 */
	public void actualizarProductoVendidos(ProductosVendidos nuevoRepuesto)
	{
		repuestoVendidos = nuevoRepuesto;
		if (repuestoVendidos != null)
		{
			NumberFormat formatter = NumberFormat.getNumberInstance( );
			
			//NumberFormat formatterNumVenta = NumberFormat.getIntegerInstance();
			
			
			txtNombre.setText(nuevoRepuesto.getNombre());
			
			txtCodigo.setText(nuevoRepuesto.getCodigo());
			
			txtCantidad.setText(Integer.toString(nuevoRepuesto.getCantidad()));
			
			txtMarca.setText(nuevoRepuesto.getMarca());
			
			String moneyStringUnitario = formatter.format(nuevoRepuesto.getValorUnidad() );
			txtPrecioUnitario.setText("$" + moneyStringUnitario);
			
			String moneyStringTotal = formatter.format(nuevoRepuesto.getValorTotal() );
			txtPrecioTotal.setText("$" + moneyStringTotal);
			
			txtFecha.setText(nuevoRepuesto.getFecha());
			
			//String moneyStringNumVenta = formatterNumVenta.format(nuevoRepuesto.getNumeroVenta() );
			
			//txtNumeroVenta.setText(moneyStringNumVenta);
			
			txtNumeroVenta.setText(Double.toString(nuevoRepuesto.getNumeroVenta()));
			
			
			
			
		}
		else
		{
			txtNombre.setText(nuevoRepuesto.getNombre());
			
			txtCodigo.setText("");
			
			txtCantidad.setText("");
			
			txtMarca.setText("");
			
			txtPrecioUnitario.setText("");
			
			txtPrecioTotal.setText("");
			
			txtFecha.setText("");
			
			txtNumeroVenta.setText("");
			
			
		}
	}






	@Override
	public void valueChanged(ListSelectionEvent e) 
	{
		if (!e.getValueIsAdjusting())
		{
			ProductosVendidos repuestoSeleccionado = listaProductos.getSelectedValue();
			if (repuestoSeleccionado != null)
				principal.mostrarProductosVendidos(repuestoSeleccionado);
		}
		
		
	}
	
	

}