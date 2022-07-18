package interfaz;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelFuncionalidades extends JPanel implements ActionListener
{

    
    private final static String VENDER  = "Vender Producto";   

    private final static String AGREGAR = "Agregar Producto";
    
    private final static String ELIMINAR = "Eliminar Producto";
    
	private InterfazPrincipal principal;
	
	private JButton vender;
	
	private JButton agregar ;
	
	private JButton eliminar;
	
	private String codigo;
	
	
	public PanelFuncionalidades(InterfazPrincipal principal)
	{
		this.principal = principal;
		//setBorder(  new TitledBorder( "FUNCIONALIDADES DEL VENDEDOR" ) );

        setLayout( new GridLayout( 3, 1 ) );
        setLayout(null);
        

        vender = new JButton( "Vender Repuesto" );
        vender.setFont(new Font("Cambria",Font.ITALIC, 20));
        vender.setActionCommand( VENDER );
        vender.addActionListener( this );
        
        vender.setBounds(40, 40, 190, 40);

        agregar = new JButton( "Agregar Producto" );
        agregar.setFont(new Font("Cambria",Font.ITALIC, 20));
        agregar.setActionCommand( AGREGAR );
        agregar.addActionListener( this );

        agregar.setBounds(40, 130, 190, 40);
        
        eliminar = new JButton( "Eliminar Producto" );
        eliminar.setFont(new Font("Cambria",Font.ITALIC, 20));
        eliminar.setActionCommand( ELIMINAR);
        eliminar.addActionListener( this );
        
        eliminar.setBounds(40, 230, 190, 40);

        add( vender );
        add(agregar );
        add( eliminar);
		
	}
	
	
	public void metodoAyuda(String pCodigo)
	{
		
		codigo = pCodigo;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand( );
		if( VENDER.equals( comando ) )
        {
           principal.mostrarDialogoVenderProducto();
        }
        else if( AGREGAR.equals( comando ) )
        {
        	 principal.mostrarDialogoAgregarProducto();
        }
        else if( ELIMINAR.equals( comando ) )
        {
        	String [] botones = { "Eliminar", "Cancelar" };
        	 
        
        	int variable = JOptionPane.showOptionDialog (null, "ESTAS SEGURO DE ELIMINAR ESTE REPUESTO?", "ELIMINAR REPUESTO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
           
        	if (variable == 0) {
        		try {
        			principal.eliminarProducto(codigo);
        		} catch (IOException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
			}
        	
        	
        	
        }

		
	}

}