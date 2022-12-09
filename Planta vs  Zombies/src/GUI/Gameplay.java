package GUI;

import Conversor.Conversor;
import Logica.Nivel;
import Entidades.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Gameplay extends JLayeredPane implements ActionListener {

	private Conversor conversor = Conversor.getConversor();
	private Nivel nivel = Nivel.getNivel();
	private PanelJardin panelJardin;
	private JLabel lblMadera;
	private JLabel lblSol;
	private JLabel lblCantSoles;
	private JLabel lblOleadas;
	private JButton btnGirasol;
	private JButton btnNuez;
	private JButton btnPlantaA;
	private JButton btnPlantaB;
	private JLabel lblGame;
	JProgressBar bpOleadas;
	//JSlider bpOleadas;
	//private JLabel lblGameN;
	
	

	private boolean [][] hayPlanta = new boolean[9][6];
  
	public Gameplay(int i) {
		
	    int ancho = 58;
	    int alto = 23;
	    int ubicacionY = 405;
	    
	    setBackground(new Color(0, 204, 0));
	    setVisible(true);
	    setLayout(null);
	    
	    lblMadera = new JLabel();
	    lblMadera.setIcon(new ImageIcon(Gameplay.class.getResource("/recursos/madera.jpg")));
	    lblMadera.setBounds(-13, 379, 581, 71);
	    add(lblMadera);
	    
	    lblSol = new JLabel();
	    ImageIcon reStartIcon = new ImageIcon(Gameplay.class.getResource("/recursos/suns.png"));
	    Image reStart = reStartIcon.getImage();
	    reStart = reStart.getScaledInstance(70, 30, java.awt.Image.SCALE_SMOOTH);
	    reStartIcon = new ImageIcon(reStart);
	    lblSol.setIcon(reStartIcon);
	    lblSol.setBounds(462, 400, 70, 31);
	    add(lblSol, Integer.valueOf(1));
	    
	    lblCantSoles = new JLabel(String.valueOf(nivel.getSoles()));
	    lblCantSoles.setBounds(490, 405, 46, 14);
	    add(lblCantSoles, Integer.valueOf(2));
	    
	   lblOleadas = new JLabel("Oleadas: ");
	    //ImageIcon cartelIcon = new ImageIcon(Gameplay.class.getResource("/recursos/oleadas1.jfif"));
	    //Image cartel = cartelIcon.getImage();
	   // cartel= cartel.getScaledInstance(50, 70, java.awt.Image.SCALE_SMOOTH);
	    //cartelIcon = new ImageIcon(cartel);
	   // lblOleadas.setIcon(cartelIcon);
	    Font myFont = new Font ( "Chiller", Font.PLAIN, 25);
	    lblOleadas.setFont (myFont);
	    lblOleadas.setForeground(Color. yellow);
	    lblOleadas.setBounds(320, 385, 150, 60);
	    add(lblOleadas, Integer.valueOf(1));
	
	    
	    
	    //add( new BarraDeCarga(),BorderLayout.CENTER );
	    
	    panelJardin = new PanelJardin();
	    panelJardin.setGameplay(this);
	    panelJardin.setBounds(-1, 1, 570, 380);
	    panelJardin.setOpaque(false);
	    add(panelJardin, Integer.valueOf(1));
	
	    //Nivel.getNivel().setPanelJardin(panelJardin);
	    
	    //creacion y configuracion de los botones y el Fondo
	    	    
	    btnGirasol = new JButton();
	    ImageIcon iconGirasol = new ImageIcon(this.getClass().getResource("/recursos/sunflowerCard.png"));
	    Image imgGirasol = iconGirasol.getImage();
	    imgGirasol = imgGirasol.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
	    iconGirasol = new ImageIcon(imgGirasol);
	    btnGirasol.setIcon(iconGirasol);
	    //btnGirasol.setOpaque(false);
	    //btnGirasol.setContentAreaFilled(false);
	    //btnGirasol.setBorderPainted(false);
	    btnGirasol.setBounds(10, ubicacionY, ancho, alto);
	    add(btnGirasol, Integer.valueOf(1));
	    btnGirasol.addActionListener(this);
	
	    btnNuez = new JButton();
	    ImageIcon iconNuez = new ImageIcon(this.getClass().getResource("/recursos/wallnutCard.png"));
	    Image imgNuez = iconNuez.getImage();
	    imgNuez = imgNuez.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
	    iconNuez = new ImageIcon(imgNuez);
	    btnNuez.setIcon(iconNuez);
	    btnNuez.setBounds(80, ubicacionY, ancho, alto);
	    add(btnNuez, Integer.valueOf(1));
	    btnNuez.addActionListener(this);
	    
	    btnPlantaA = new JButton();
	    ImageIcon iconPlantaA;
	    btnPlantaA.setBounds(150, ubicacionY, ancho, alto);
	    
	    btnPlantaB = new JButton();
	    ImageIcon iconPlantaB;
	    btnPlantaB.setBounds(220, ubicacionY, ancho, alto);
	    
	    ImageIcon imagenFondo;
	    
	    if (i <= 2) {
	      iconPlantaA = new ImageIcon(this.getClass().getResource("/recursos/peashooterCard.png"));
	      iconPlantaB = new ImageIcon(this.getClass().getResource("/recursos/repeaterCard.png"));
	      imagenFondo = new ImageIcon(this.getClass().getResource("/recursos/mainBG.png"));
	    } else {
	      
	      iconPlantaA = new ImageIcon(this.getClass().getResource("/recursos/PuffShroomCard.jpeg"));
	      iconPlantaB = new ImageIcon(this.getClass().getResource("/recursos/FumeShroomCard.jpeg"));
	      imagenFondo = new ImageIcon(Gameplay.class.getResource("/recursos/mainBG_N.png"));
	    }
	    
	    /*lblGameN = new JLabel();
	    lblGameN.setIcon(new ImageIcon(Gameplay.class.getResource("/recursos/mainBG_N.png")));
	    lblGameN.setBounds(-3, -8, 575, 394);
	    lblGameN.setVisible(false);
	    add(lblGameN, Integer.valueOf(0));
	    lblGameN.setVisible(true);*/
	    
	    
	
	    Image imgPlantaA = iconPlantaA.getImage();
	    imgPlantaA = imgPlantaA.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
	    iconPlantaA = new ImageIcon(imgPlantaA);
	    btnPlantaA.setIcon(iconPlantaA); 
	    add(btnPlantaA, Integer.valueOf(1));
	    btnPlantaA.addActionListener(this);
	    
	    Image imgPlantaB = iconPlantaB.getImage();
	    imgPlantaB = imgPlantaB.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
	    iconPlantaB = new ImageIcon(imgPlantaB);
	    btnPlantaB.setIcon(iconPlantaB);
	    add(btnPlantaB, Integer.valueOf(1));
	    btnPlantaB.addActionListener(this);
	    
	    lblGame = new JLabel();
	    lblGame.setIcon(imagenFondo);
	    lblGame.setBounds(-3, -8, 575, 394);
	    lblGame.setVisible(true);
	    add(lblGame, Integer.valueOf(0));
	    
	    
	
	    for (int x = 0; x < 9; x++) {
	        for (int y = 0; y < 6; y++) {
	        	hayPlanta [x][y] = false;
	        }
	    }
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGirasol) {
			panelJardin.setSeleccion(1);
	    }

	    if (e.getSource() == btnNuez) {
	    	panelJardin.setSeleccion(2);
	    }
	    
		if (e.getSource() == btnPlantaA) {
			panelJardin.setSeleccion(3);
		}

	    if (e.getSource() == btnPlantaB) {
	    	panelJardin.setSeleccion(4);
	    }
	}
	
	public void controlarCompraDePlantas() {
		int [] precios = nivel.getPrecios();
	  		
		if (precios[0] <= Integer.parseInt(lblCantSoles.getText())) {
			  btnGirasol.setEnabled(true);
		}else btnGirasol.setEnabled(false);		
		  
		if (precios[1] <= Integer.parseInt(lblCantSoles.getText())) {
			btnNuez.setEnabled(true);
		}else btnNuez.setEnabled(false);
		
		if (precios[2] <= Integer.parseInt(lblCantSoles.getText())) {
			btnPlantaA.setEnabled(true);
		}else btnPlantaA.setEnabled(false);
		  
		if (precios[3] <= Integer.parseInt(lblCantSoles.getText())) {
			btnPlantaB.setEnabled(true);
		}else btnPlantaB.setEnabled(false); 
	}
	
	public void actualizarSoles(int cantidad) {
	    lblCantSoles.setText(String.valueOf(cantidad));
	    controlarCompraDePlantas();
	}
	
	public void actualizarOleadas(int cantidad) {
		if (cantidad == 1) {
			lblOleadas.setForeground(Color.green);
			lblOleadas.setText("¡Ultima oleada!");
		
		}else 
			lblOleadas.setText("Oleadas: " + cantidad);
	}
	
  
	public boolean hayPlanta(int x, int y) {
	    int nuevoX = conversor.convertirFila(x);
	    int nuevoY = conversor.convertirFila(y);
	    //label[x][y].setIcon(eg.getLabel().getIcon());
	    return hayPlanta[nuevoX][nuevoY];
	}

	public void agregarPlanta(EntidadGrafica eg) {
	    int x = conversor.convertirFila(eg.getPosicion().getX());
	    int y = conversor.convertirFila(eg.getPosicion().getY());
	    //label[x][y].setIcon(eg.getLabel().getIcon());
	    hayPlanta[x][y] = true;
	    agregarEntidad(eg);
	}
  
  /*public void actualizarPlanta(EntidadGrafica eg) {
	  	Posicion posicion = eg.getPosicion();
	    int x = conversor.convertirFila(posicion.getX());
	    int y = conversor.convertirFila(posicion.getY());
	    label[x][y].setIcon(eg.getLabel().getIcon());
	}*/
	public void sacarPlanta(EntidadGrafica eg) {
	    int y = conversor.convertirFila(eg.getPosicion().getY());
	    int x = conversor.convertirFila(eg.getPosicion().getX());
	    hayPlanta[x][y] = false;
	    sacarEntidad(eg);
	}

	public void agregarEntidad(EntidadGrafica eg) { //agrega la entidad al panel
	    JLabel labelAgregado = eg.getLabel();
	    labelAgregado.setVisible(true);
	    this.add(labelAgregado, Integer.valueOf(6));
	}

  /*public void actualizarEntidad(EntidadGrafica eg) {
	    Posicion posicion = eg.getPosicion();
	   // int alto = eg.getAlto();
	   // int ancho = eg.getAncho();
	    eg.getLabel().setLocation(posicion.getX(), posicion.getY());
	   //eg.getLabel().setBounds(posicion.getX(), posicion.getY() - 20, ancho, alto);//esto corregir que cada uno tenga sus setBounds
  }*/
	
	public void sacarEntidad(EntidadGrafica eg) { //saca la entidad de dentro del panel
	    JLabel labelSacar = eg.getLabel();
	    labelSacar.setVisible(false);
	    this.remove(labelSacar);
	}
	
	public PanelJardin getJardin() {
		return panelJardin;
	}
	
	public void limpiarJArdin() {
		panelJardin.restart();
	}
  
}


