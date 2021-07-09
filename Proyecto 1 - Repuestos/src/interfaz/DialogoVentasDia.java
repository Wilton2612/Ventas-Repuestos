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

import logica.Caja;
import logica.Producto;


@SuppressWarnings("serial")
public class DialogoVentasDia extends JDialog implements ListSelectionListener
{
	private JList<Caja> listaProductos;

	
	private DefaultListModel<Caja> modeloProductos;
	
	
	private InterfazPrincipal principal;
	
	
	private JPanel panelNombre;
	
	
	private JLabel nombre;
	
	
	private JPanel panelCantidad;
	
	
	private JLabel cantidad;

	  
	private JTextField txtCantidad;
	
	
	private Caja ventasDia;
	
	
	
	
	
	
	public DialogoVentasDia(InterfazPrincipal principal)
	{ 
		this.principal = principal;
		setTitle( "VENTAS");
		setSize(900, 500);
		setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
		setLocationRelativeTo(null);
	
		JPanel centro = new JPanel(new GridLayout( 1, 2 ) );
		centro.setLayout(null);
		//centro.setBorder(new TitledBorder("CENTRO"));
		
		JPanel listaNombres = new JPanel(new BorderLayout());
		//listaNombres.setBorder(new TitledBorder("LISTA DE REPUESTOS"));
		modeloProductos = new DefaultListModel<Caja>();
		listaProductos = new JList<>(modeloProductos);
		listaProductos.setFont(new Font("Cambria",Font.ITALIC, 20));
		listaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaProductos .addListSelectionListener(this);

		JScrollPane panel = new JScrollPane(listaProductos);
		
		listaNombres.setBounds(190, 20, 300, 420);
		panel.setBounds(10, 20, 480, 390);
		
		
		listaNombres.add(panel);
		
		
		JPanel unidadesProducto = new JPanel( new GridLayout( 1, 2 ) );
		//unidadesProducto.setBorder(new TitledBorder("INFORMACION"));
		cantidad = new JLabel( "Venta: " );
        cantidad.setFont(new Font("Cambria",Font.ITALIC, 20));
		
        txtCantidad = new JTextField(2); // 2
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
	
	public void actualizarlistaVentas(ArrayList<Caja> datos)
	{
		
      
		modeloProductos.clear();
		for (Caja list : datos) 
		{
			modeloProductos.addElement(list);
		   
		}
	}
	
	
	/**
	 * Cambia el libro cuya información se muestra en el panel
	 * 
	 * @param nuevolibro El nuevo libro para el cual se debe mostrar la información
	 */
	public void actualizarVentas(Caja nuevaVenta)
	{
		ventasDia = nuevaVenta;
		if (ventasDia != null)
		{
			NumberFormat formatter = NumberFormat.getNumberInstance( );
	       
	        String moneyString = formatter.format(nuevaVenta.getVenta());
			txtCantidad.setText("$" + moneyString);
			
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
			Caja repuestoSeleccionado = listaProductos.getSelectedValue();
			if (repuestoSeleccionado != null)
				principal.mostrarVentasFecha(repuestoSeleccionado);
		}
		
		
	}
	
	
	
	
	
	
}