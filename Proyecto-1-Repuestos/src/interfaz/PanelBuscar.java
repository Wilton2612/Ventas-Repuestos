package interfaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelBuscar extends JPanel implements ActionListener
{
	
	private final static  String BUSCAR = "BUSCAR";
	
	private InterfazPrincipal principal;
	
	private JTextField buscar1;
	
	private JButton boton;
	
	
	public PanelBuscar(InterfazPrincipal interfazPrincipal)
	{
		principal = interfazPrincipal;
		
		setLayout(new GridLayout(1, 1));
		//setBorder(new TitledBorder("BUSCAR REPUESTO"  ));
		//setFont(new Font("Cambria",Font.ITALIC, 20));
		setLayout(null);
		
	
		
		buscar1 = new JTextField( );
		buscar1.setFont(new Font("Cambria",Font.ITALIC, 20));
		
		buscar1.setBounds(100, 20, 500, 30);
		
	    boton = new JButton("Buscar");
	    boton.setFont(new Font("Cambria",Font.ITALIC, 20));
	    
		boton.setActionCommand( BUSCAR );
		boton.addActionListener( this );
		
		boton.setBounds(700, 20, 150, 30);
		
		
		//tall.add(txtDerecha, BorderLayout.EAST);
		//tall.add(txtIzquierda, BorderLayout.WEST);
		//tall.add(boton, BorderLayout.CENTER);
		
		add(buscar1 );
		add( boton );
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		String comando = e.getActionCommand( );
		if( comando.equals(BUSCAR ) )
        {
			String nombreProducto = buscar1.getText();
			principal.buscarProducto(nombreProducto);
			
			
        }
		
		
	}

}