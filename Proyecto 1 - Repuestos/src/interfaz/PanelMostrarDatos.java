package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;



public class PanelMostrarDatos extends JPanel
{
	 
    private InterfazPrincipal principal;

    
    private JLabel nombre;

   
    private JLabel codigo;

    
    private JLabel cantidad;

    
    private JLabel marca;

    
    private JLabel precio;

    
    
    private JTextField txtNombre;

    
    private JTextField txtCodigo;

    
    private JTextField txtCantidad;

    
    private JTextField txtMarca;

    
    private JTextField txtPrecio;

   
    public PanelMostrarDatos( InterfazPrincipal Principal )
    {
        this.principal = Principal;

        setLayout( new BorderLayout( ) );
        //setBorder(new TitledBorder("DATOS DEL REPUESTO"  ));
       // setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "DATOS DEL REPUESTO" ) ) );

        nombre = new JLabel( "Nombre: " );
        nombre.setFont(new Font("Cambria",Font.ITALIC, 20));
        codigo = new JLabel( "Codigo: " );
        codigo.setFont(new Font("Cambria",Font.ITALIC, 20));
        cantidad = new JLabel( "Unidades: " );
        cantidad.setFont(new Font("Cambria",Font.ITALIC, 20));
        marca = new JLabel( "Marca: " );
        marca.setFont(new Font("Cambria",Font.ITALIC, 20));
        precio= new JLabel( "Precio Unidad: " );
        precio.setFont(new Font("Cambria",Font.ITALIC,20));
       

        txtNombre = new JTextField( 15 ); // 15
        txtNombre.setEditable( false );
        txtNombre.setBorder(null);
        txtNombre.setFont(new Font("Cambria",Font.ITALIC,20));
        
        txtCodigo = new JTextField( 15 ); // 15
        txtCodigo.setEditable( false );
        txtCodigo.setBorder(null);
        txtCodigo.setFont(new Font("Cambria",Font.ITALIC,20));
        
        txtCantidad = new JTextField( 2 ); // 2
        txtCantidad.setEditable( false );
        txtCantidad.setBorder(null);
        txtCantidad.setFont(new Font("Cambria",Font.ITALIC,20));
        
        txtMarca = new JTextField( 10 ); // 10
        txtMarca.setEditable( false );
        txtMarca.setBorder(null);
        txtMarca.setFont(new Font("Cambria",Font.ITALIC,20));
        
        txtPrecio = new JTextField( 10 ); // 10
        txtPrecio.setEditable( false );
        txtPrecio.setBorder(null);
        txtPrecio.setFont(new Font("Cambria",Font.ITALIC,20));


        JPanel panelDatos = new JPanel( new GridLayout( 5, 2 ) );
        panelDatos.add( nombre );
        panelDatos.add( txtNombre );
        panelDatos.add( codigo );
        panelDatos.add( txtCodigo );
        panelDatos.add( cantidad );
        panelDatos.add( txtCantidad );
        panelDatos.add( marca );
        panelDatos.add( txtMarca );
        panelDatos.add( precio );
        panelDatos.add( txtPrecio );
        
        add( panelDatos);
 
    }
    
    
    
    
    
    public void actualizarCampos( String nombre, String codigo, String cantidad, String marca, String precio)
    {
    	NumberFormat formatter = NumberFormat.getNumberInstance( );
        txtNombre.setText( nombre );
        txtCodigo.setText( codigo );
        txtCantidad.setText( cantidad );
        txtMarca.setText( marca );
        
        if (!precio.equals("")) {
        	double change = Double.parseDouble(precio);
            String moneyString = formatter.format(change );
            txtPrecio.setText( "$" + moneyString);
		}
        
        else
        {
        	 txtPrecio.setText( precio);
        	
        }
       
        
        principal.metodoAyudaEliminarProducto(codigo);

    }
    
    
    public void actualizarCampoCantidad( String cantidad)
    {
        
        txtCantidad.setText( cantidad );
    }
    
  
}
