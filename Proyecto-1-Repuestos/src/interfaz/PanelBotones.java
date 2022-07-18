package interfaz;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;




public class PanelBotones extends JPanel implements ActionListener
{
	//ATRIBUTOS 
	
	
    private final static String LISTA_ESCASOS = "Productos escasos";
    
    private final static String LISTA_NO_ESCASOS  = "Productos no escasos";   

    private final static String FACTURA = "Factura";
    
    private final static String REGISTRO_PRODUCTOS = "Productos vendidos";
    
    private InterfazPrincipal panelPrincipal;
	
	private JButton productosEscasos;
	 
    private JButton productosNoEscasos;

    private JButton factura;
    
    private JButton registroProductos;
	
    
    
	public PanelBotones(InterfazPrincipal panelPrincipal)
	{
		this.panelPrincipal = panelPrincipal;
		//setLayout( new GridLayout( 1, 4 ) );
		//setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 )  ) );
		//setBorder(new TitledBorder( "ACCIONES" ));
        setLayout( new GridLayout( 1, 4 ) );
        setLayout(null);
        
        productosEscasos = new JButton( );
        //productosEscasos.setFont(new Font("Cambria",Font.ITALIC, 15));
        productosEscasos.setActionCommand( LISTA_ESCASOS );
        productosEscasos.setToolTipText("Productos con menos unidades");
        productosEscasos.setIcon(new ImageIcon("./data/icons/menos_productos.png"));
        productosEscasos.addActionListener( this );   
        productosEscasos.setBounds(50, 20, 150, 100);

        
        productosNoEscasos = new JButton(  );
        //productosNoEscasos.setFont(new Font("Cambria",Font.ITALIC, 15));
        productosNoEscasos.setActionCommand( LISTA_NO_ESCASOS );
        productosNoEscasos.setToolTipText("Productos con mas unidades");
        productosNoEscasos.setIcon(new ImageIcon("./data/icons/mas_productos.png"));
        productosNoEscasos.addActionListener( this );
        productosNoEscasos.setBounds(290, 20, 150, 100);

        
        factura = new JButton( );
        //factura.setFont(new Font("Cambria",Font.ITALIC, 15));
        factura.setActionCommand( FACTURA );
        factura.setToolTipText("Registro de ventas por dia");
        factura.setIcon(new ImageIcon("./data/icons/ventas_dia.png"));
        factura.addActionListener( this );
        factura.setBounds(530, 20, 150, 100);
        
        
        registroProductos = new JButton(  );
        //registroProductos.setFont(new Font("Cambria",Font.ITALIC, 15));
        registroProductos.setActionCommand( REGISTRO_PRODUCTOS );
        factura.setToolTipText("Productos vendidos");
        registroProductos.setIcon(new ImageIcon("./data/icons/registro_venta.png"));
        registroProductos.addActionListener( this );
        registroProductos.setBounds(760, 20, 150, 100);

        this.add( productosEscasos );
        this.add( productosNoEscasos );
        this.add( factura );
        this.add( registroProductos );
        
		
		
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent pEvento) 
	{
		String comando = pEvento.getActionCommand( );
		if( LISTA_ESCASOS.equals( comando ) )
        {
            panelPrincipal.mostrarDialogoMenosUnidades();
     
        }
        else if( LISTA_NO_ESCASOS.equals( comando ) )
        {
        	panelPrincipal.mostrarDialogoMasUnidades();
        }
        else if( FACTURA.equals( comando ) )
        {
            panelPrincipal.mostrarDialogoVentasDia();
        }
        else if( REGISTRO_PRODUCTOS.equals( comando ) )
        {
        	panelPrincipal.mostrarDialogoRegistro();
            
        }
		
		
	}
}

