package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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







@SuppressWarnings("serial")
public class DialogoProductosEscasos extends JDialog implements ListSelectionListener
{
	
	private JList<Producto> listaProductos;

	
	private DefaultListModel<Producto> modeloProductos;
	
	
	private InterfazPrincipal principal;
	
	
	private JPanel panelNombre;
	
	
	private JLabel nombre;
	
	
	private JPanel panelCantidad;
	
	
	private JLabel cantidad;

	  
	private JTextField txtCantidad;
	
	
	private Producto repuesto;
	
	public DialogoProductosEscasos(InterfazPrincipal principal)
	{ 
		this.principal = principal;
		//lista = new ArrayList<List<String>>();
		setTitle( "LISTA DE REPUESTOS CON MENOS UNIDADES" );
		setSize(900, 500);
		setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
		setLocationRelativeTo(null);
		//setFont(new Font("Cambria",Font.ITALIC, 20));
		
		JPanel centro = new JPanel(new GridLayout( 1, 2 ) );
		centro.setLayout(null);
		
		//centro.setBorder(new TitledBorder("CENTRO"));
		
		JPanel listaNombres = new JPanel(new BorderLayout());
		
		
		//listaNombres.setLayout(null);
		//listaNombres.setBorder(new TitledBorder("LISTA DE REPUESTOS"));
		modeloProductos = new DefaultListModel<Producto>();
		listaProductos = new JList<>(modeloProductos);
		listaProductos.setFont(new Font("Cambria",Font.ITALIC, 20));
		listaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaProductos .addListSelectionListener(this);

		
		
		
		JScrollPane panel = new JScrollPane(listaProductos);
		
		
		listaNombres.setBounds(190, 20, 300, 420);
		panel.setBounds(10, 20, 480, 390);
		
		
		listaNombres.add(panel);
		//listaNombres.setLayout(null);
		
		JPanel unidadesProducto = new JPanel( new GridLayout( 1, 2 ) );
		//unidadesProducto.setBorder(new TitledBorder("INFORMACION"));
		cantidad = new JLabel( "Unidades: " );
        cantidad.setFont(new Font("Cambria",Font.ITALIC, 20));
		
        txtCantidad = new JTextField( 2 ); // 2
        txtCantidad.setEditable( false );
        txtCantidad.setBorder(null);
        txtCantidad.setFont(new Font("Cambria",Font.ITALIC,20));
		
        
        unidadesProducto.setBounds(520, 180, 200, 100);
        
        
        
        unidadesProducto.add( cantidad );
        unidadesProducto.add( txtCantidad );
        
        
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
	
	public void actualizarlistaRepuestosEscasos(ArrayList<Producto> datos)
	{
		
      
		modeloProductos.clear();
		for (Producto list : datos) 
		{
			modeloProductos.addElement(list);
		   
		}
	}
	
	
	/**
	 * Cambia el libro cuya información se muestra en el panel
	 * 
	 * @param nuevolibro El nuevo libro para el cual se debe mostrar la información
	 */
	public void actualizarProductoEscaso(Producto nuevoRepuesto)
	{
		repuesto = nuevoRepuesto;
		if (repuesto != null)
		{
			txtCantidad.setText(Integer.toString(nuevoRepuesto.darCantidad()));
			
		}
		else
		{
			txtCantidad.setText("");
			
		}
	}






	@Override
	public void valueChanged(ListSelectionEvent e) 
	{
		if (!e.getValueIsAdjusting())
		{
			Producto repuestoSeleccionado = listaProductos.getSelectedValue();
			if (repuestoSeleccionado != null)
				principal.mostrarCantidadProductoEscaso(repuestoSeleccionado);
		}
		
		
	}
	
			
}
	
	
	

