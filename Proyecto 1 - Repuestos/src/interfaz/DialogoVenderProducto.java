package interfaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class DialogoVenderProducto extends JDialog implements ActionListener
{
	
	private final static  String SI = "SI";
	
	
	private final static  String NO = "NO";
	
	
	private InterfazPrincipal principal;
	
	
	private JButton vender;
	
	
	private JTextField unidades;
	

    private JButton si;
    
    
    private JButton no;
    
    
    private ButtonGroup group;
    
    
    private String pCodigo;
	
	
	public DialogoVenderProducto(InterfazPrincipal principal)
	{
		this.principal = principal;
		setTitle( "VENDER REPUESTO" );
		setSize(600, 400);
		setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
		setLocationRelativeTo(null);
		
		JPanel centro = new JPanel(new GridLayout( 2, 1 ) );
		//centro.setBorder(new TitledBorder("central"));
	
		
		JPanel parteIzquierda = new JPanel(new GridLayout(2,1));
		
		//parteIzquierda.setLayout(null);
		JLabel descripcion = new JLabel("Ingrese las unidades para vender");
		descripcion.setFont(new Font("Cambria",Font.ITALIC, 20));
		
		descripcion.setBounds(140, -40, 500, 200);
		
		unidades = new JTextField( );
		unidades.setEditable(true);
		unidades.setBorder(null);
		
		unidades.setBounds(230, 100, 100, 40);
		
		
		parteIzquierda.setLayout(null);
		
		JPanel parteDerecha = new JPanel(new GridLayout(2,1));
	
		JLabel descripcion2 = new JLabel( "                 SI para un nuevo pedido, NO para lo contrario." );
		descripcion2.setFont(new Font("Cambria",Font.ITALIC, 20));
		
		
		
		
		JPanel siYNo = new JPanel(new GridLayout(1,2));
		siYNo.setLayout(null);
		
		si = new JButton("SI");
		si.setFont(new Font("Cambria",Font.ITALIC, 20));
		si.setActionCommand( SI );
		si.addActionListener( this );
		
		no = new JButton("NO");
		no.setFont(new Font("Cambria",Font.ITALIC, 20));
		no.setActionCommand( NO );
		no.addActionListener( this );
		
		
		si.setBounds(160, 10, 100, 40);
		
		
		no.setBounds(300, 10, 100, 40);
		
		
		
		siYNo.add(si);
		siYNo.add(no);
		
	

		
		
		
		
		
		
		//parteIzquierda.setBorder(new TitledBorder("izquierda"));
		//parteDerecha.setBorder(new TitledBorder("derecha"));
		//siYNo.setBorder(new TitledBorder("botones"));
	
		parteIzquierda.add(descripcion, BorderLayout.NORTH);
		parteIzquierda.add(unidades, BorderLayout.SOUTH);
		
		
		
		parteDerecha.add( descripcion2, BorderLayout.NORTH);
		parteDerecha.add(siYNo, BorderLayout.SOUTH);
		
		
	
		/*
		botonRegistrar.add(txtDerecha, BorderLayout.EAST);
		botonRegistrar.add(txtIzquierda, BorderLayout.WEST);
		botonRegistrar.add(vender, BorderLayout.CENTER);
		*/
		centro.add(parteIzquierda, BorderLayout.WEST);
		centro.add(parteDerecha, BorderLayout.EAST);
		
		
		add(centro, BorderLayout.CENTER);
		//add(botonRegistrar, BorderLayout.SOUTH);
	}
	
	public void metodoAyuda(String pCodigo)
	{
		
		this.pCodigo = pCodigo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String cantida = unidades.getText();
		String tamaño = e.getActionCommand();
		
		if (tamaño.equals(SI))
		{
			if (cantida.equals(""))
			{
				JOptionPane.showMessageDialog( this, "Digite las unidades a vender", "VENDER REPUESTO", JOptionPane.ERROR_MESSAGE );
			}
				
			
			else
			{
				try {
					principal.validarRequisitosVenderRepuestosSI(cantida, this.pCodigo);
					dispose( );
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
		
			}
				
		}
		else if (tamaño.equals(NO))
		{
			if (cantida.equals(""))
			{
				JOptionPane.showMessageDialog( this, "Digite las unidades a vender", "VENDER REPUESTO", JOptionPane.ERROR_MESSAGE );
			}	
			
			else
			{
				
				try {
					principal.validarRequisitosVenderRepuestosNO(cantida, this.pCodigo);
					dispose( );
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
			
		}
				
	}
	

	
}
