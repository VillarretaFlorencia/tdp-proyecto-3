package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cronometro.Cronometro;
import Logica.Entidad;
import Logica.*;


public class GUI extends JFrame {
	private Nivel  nivel;
	private JPanel contentPane;
	private Cronometro miCronometro;
	private Thread hiloCronometro;
	private JPanel grilla;
	private JPanel plantasPane;
	private JLabel solesDisponibles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		nivel = new Nivel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//panel que contendra las plantas y los soles disponibles
		plantasPane = new JPanel(new BorderLayout());
		plantasPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(plantasPane, BorderLayout.NORTH);
		
		solesDisponibles = new JLabel("Soles: 0");// poner imagen de sol, inicia en 0 los disponibles
		plantasPane.add(solesDisponibles, BorderLayout.EAST); 
		
		//pedir lista e plantaas y ponerlas en el contenedor como se hace con la grilla
		
		this.miCronometro = new Cronometro(this);
		hiloCronometro = new Thread(this.miCronometro);
		hiloCronometro.start();
		
		updateGrilla();
	}
	
	public void updateGrilla(){
		grilla = new JPanel();
		grilla.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		for(int y=0; y < nivel.getColumnas(); y++) {
			for(int x= 0; x < nivel.getFilas(); x++) {
				Entidad e = nivel.getEntidad(x, y);
				JLabel label =  new JLabel ();
				// if (e =! null){}
				String imagen = e.getEstado().getImagen();
				ImageIcon grafico = new ImageIcon(imagen);
				label.setIcon(grafico);
				grilla.add(label);
				
				label.addComponentListener(new ComponentAdapter() {
					public void componentResized(ComponentEvent e) {
						reDimensionar(label,grafico);
						label.setIcon(grafico);
					}
				});
			    
				
			}
		}		
		setPane(grilla);
	}
	
	private void reDimensionar(JLabel label , ImageIcon  grafico){
		Image image= grafico.getImage();
		if(image!=null) {
			Image newing = image.getScaledInstance(label.getWidth(),label.getHeight() ,java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newing);
			
		}
		
	}
	
	public JPanel getPane() {
		return grilla;
	}

	public void setPane(JPanel c) { //setGrilla
		contentPane.setLayout(new BorderLayout(0, 0));
		grilla = c;
		contentPane.add(c);
	}
	
	public Nivel getNivel() {return nivel;} 
	
}
