package logica;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import interfaz.InterfazPrincipal;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author xcheko51x
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    	Date objDate = new Date();
    	
    	
    	String dia = Integer.toString(objDate.getDay());
    	String mes = Integer.toString(objDate.getMonth());
    	String año = Integer.toString(objDate.getYear());
		String fecha = Integer.toString(objDate.getDay())+"/"+Integer.toString(objDate.getMonth())+"/"+Integer.toString(objDate.getYear());
		System.out.println(fecha);
		System.out.println(dia);
		System.out.println(mes);
		System.out.println(año);
		System.out.println(objDate);
		
		LocalDate h = LocalDate.now();
		
		System.out.println("La fecha actual es: " + h);
		
			
		
    }

    
}
