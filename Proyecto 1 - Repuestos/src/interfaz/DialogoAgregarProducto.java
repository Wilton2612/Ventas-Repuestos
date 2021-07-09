package interfaz;


import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class DialogoAgregarProducto extends JDialog implements ActionListener
{
	private final static String AGREGAR = "AGREGAR";
	
	/*
	private final static  String SI = "SI";
	
	
	private final static  String NO = "NO";
	*/
	
	private InterfazPrincipal principal;
	
	
	private JButton registrar;
	
	
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
    
    
    private boolean pNo;
    
    
    /*
    private ButtonGroup group;
    
    
    private JRadioButton si;
    
    
    private JRadioButton no;
    */
    
   
	
	public DialogoAgregarProducto (InterfazPrincipal pPrincipal)
	{
		principal = pPrincipal;
		setTitle( "REGISTRAR NUEVOS PRODUCTOS");
		setSize(650, 400);
		setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
		setLocationRelativeTo(null);
		
		
		JPanel centro = new JPanel(new GridLayout( 1,1 ) );
		centro.setLayout(null);
		//centro.setBorder(new TitledBorder("centro"));
		
		
		JPanel parteDerecha = new JPanel(new GridLayout(5,2));
		
		nombre = new JLabel( "Nombre: " );
		nombre.setFont(new Font("Cambria",Font.ITALIC, 20));
        codigo = new JLabel( "Codigo: " );
        codigo.setFont(new Font("Cambria",Font.ITALIC, 20));
        cantidad = new JLabel( "Unidades: " );
        cantidad.setFont(new Font("Cambria",Font.ITALIC, 20));
        marca = new JLabel( "Marca: " );
        marca.setFont(new Font("Cambria",Font.ITALIC, 20));
        precio = new JLabel( "Precio Unidad: " );
        precio.setFont(new Font("Cambria",Font.ITALIC, 20));
       

        txtNombre = new JTextField( 15 ); // 15
        //txtNombre.setEditable( true );
        //txtNombre.setBorder(null);
        txtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtNombre.setFont(new Font("Cambria",Font.ITALIC,20));
        
        
        txtCodigo = new JTextField( 15 ); // 15
        //txtCodigo.setEditable( true );
       // txtCodigo.setBorder(null);
        txtCodigo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtCodigo.setFont(new Font("Cambria",Font.ITALIC,20));
        
        txtCantidad = new JTextField( 2 ); // 2
        //txtCantidad.setEditable( true );
        txtCantidad.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        //txtCantidad.setBorder(null);
        txtCantidad.setFont(new Font("Cambria",Font.ITALIC,20));
        
        txtMarca = new JTextField( 10 ); // 10
        //txtMarca.setEditable( true );
        //txtMarca.setBorder(null);
        txtMarca.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtMarca.setFont(new Font("Cambria",Font.ITALIC,20));
        
        txtPrecio = new JTextField( 10 ); // 10
        //txtPrecio.setEditable( true );
       // txtPrecio.setBorder(null);
        txtPrecio.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtPrecio.setFont(new Font("Cambria",Font.ITALIC,20));

        parteDerecha.setBounds(70, 40, 500, 250);
        
		//parteIzquierda.setBorder(new TitledBorder(""));
		//parteDerecha.setBorder(new TitledBorder("REPUESTO PARA AGREGAR"));
		
		//parteDerecha.setBounds(100, 200, 100, 200);
		
		
		
		
		parteDerecha.add( nombre );
		parteDerecha.add( txtNombre );
		parteDerecha.add( codigo );
		parteDerecha.add( txtCodigo );
		parteDerecha.add( cantidad );
		parteDerecha.add( txtCantidad );
		parteDerecha.add( marca );
		parteDerecha.add( txtMarca );
		parteDerecha.add( precio );
		parteDerecha.add( txtPrecio );
		
		
		
		
		
		JPanel botonRegistrar = new JPanel(new BorderLayout());
		//botonRegistrar.setLayout(null);
		//botonRegistrar.setBorder(new TitledBorder("boton"));
		//botonRegistrar.setLayout(null);
		
		
		
		registrar = new JButton("Agregar");
		registrar.setFont(new Font("Cambria",Font.ITALIC, 20));
		registrar.setActionCommand( AGREGAR );
		registrar.addActionListener( this );
		
		
		
		JTextField txtDerecha = new JTextField(20 ); // 15
		txtDerecha.setEditable( false );
		txtDerecha.setBorder(null);
		
		JTextField txtIzquierda = new JTextField( 20 ); // 15
		txtIzquierda.setEditable( false );
		txtIzquierda.setBorder(null);
		
		//registrar.setBounds(300, 100, 100, 40);
		
		//botonRegistrar.setLayout(null);
		
		
		
		
		botonRegistrar.add(txtDerecha, BorderLayout.EAST);
		botonRegistrar.add(txtIzquierda, BorderLayout.WEST);
		botonRegistrar.add(registrar, BorderLayout.CENTER);
		centro.add(parteDerecha, BorderLayout.NORTH);
		//centro.add(parteIzquierda, BorderLayout.SOUTH);
		
		add(centro, BorderLayout.CENTER);
		add(botonRegistrar, BorderLayout.SOUTH);
		UIManager.put("OptionPane.messageFont", new Font("Cambria",Font.ITALIC, 20));
		
	}
	
	public void DatosDialogoAgregar(String nombre, String codigo, String cantidad, String marca, String precio, boolean si )
	{
		NumberFormat formatter = NumberFormat.getNumberInstance( );
		
		txtNombre.setText( nombre );
		txtNombre.setEditable( false );
        txtCodigo.setText( codigo );
        txtCodigo.setEditable( false );
        //txtCantidad.removeNotify();
        txtCantidad.setText( cantidad );
        txtCantidad.setEditable( true );
        txtMarca.setText( marca );
        txtMarca.setEditable( false );
        double change = Double.parseDouble(precio);
        String moneyString = formatter.format(change );
        txtPrecio.setText( "$" + moneyString);
        txtPrecio.setEditable( false );
        
        pNo = si;
       	
	}
	
	
	public void NoDatosDialogoAgregar(String nombre, String codigo, String cantidad, String marca, String precio, boolean no )
	{
		
		txtNombre.setText( nombre );
		txtNombre.setEditable( true );
        txtCodigo.setText( codigo );
        txtCodigo.setEditable( true );
        txtCantidad.setText( cantidad );
        txtCantidad.setEditable( true );
        txtMarca.setText( marca );
        txtMarca.setEditable( true );
        txtPrecio.setText( precio);
        txtPrecio.setEditable( true );
		
		pNo = no;
	}
	
	
	


	@Override
	public void actionPerformed(ActionEvent e) throws NumberFormatException
	{
			
		
		String nombreEntrada = txtNombre.getText();
		String codigoEntrada = txtCodigo.getText();
		String cantidadEntrada = txtCantidad.getText();
		String marcaEntrada = txtMarca.getText();
		String precioEntrada = txtPrecio.getText();
		String tamaño = e.getActionCommand();
	
		if (tamaño.equals(AGREGAR))
		{
			if(nombreEntrada.equals("") || codigoEntrada.equals("") || cantidadEntrada.equals("") || marcaEntrada.equals("" ) || precioEntrada.equals(""))
			{
				JOptionPane.showMessageDialog( this, "Llene todos los campos", "AGREGAR REPUESTO", JOptionPane.ERROR_MESSAGE );
		
			}
			
			else
			{
				
				if (pNo) 
				{
					
					try {
						principal.validarRequisitosAgregarRepuestoExistente(codigoEntrada, cantidadEntrada  );
						dispose( );
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				else 
				{
					try {
						principal.validarRequisitosAgregarRepuestoNoExistente(nombreEntrada, codigoEntrada, cantidadEntrada, marcaEntrada, precioEntrada  );
						dispose( );
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
					
			}	
		}
		
	}
		
		
		
		

}