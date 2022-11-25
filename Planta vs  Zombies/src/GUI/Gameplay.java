package GUI;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;

import Conversor.Conversor;
import Logica.Entidad;
import Logica.Nivel;
import Logica.Posicion;
import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;

import java.awt.Color;

/*NOTA:
 * FALTA QUE EL CONTADOR DE SOLES SE ACTUALIZE PREGUNTAR COMO HACERLO*/
public class Gameplay extends JLayeredPane implements ActionListener{
	private PanelJardin panelJardin;
	private Nivel nivel = Nivel.getNivel();
	private JButton btnPlanta1;
	private JButton btnPlanta2;
	private JButton btnPlanta3;
	private JButton btnPlanta4;
	JLabel[][] label = new JLabel[9][6];
	private JLabel lblGameN;
	JLabel cantSoles;
	private int numeroNivel = 0;
	Conversor conversor = Conversor.getConversor();

	
	public Gameplay( int i) {
		numeroNivel = i;
		//System.out.println("-------------- valor i: "+i);
		setBackground(new Color(0, 204, 0));
		JLabel lblGame = new JLabel("");
		lblGame.setBounds(-3, -8, 575, 394);
		
		
		ImageIcon imagenInicio  = new ImageIcon(this.getClass().getResource("/recursos/mainBG.png"));
		Image start= imagenInicio.getImage();
		setBounds(0,0,570,450);
		start = start.getScaledInstance(570, 380,  java.awt.Image.SCALE_SMOOTH);
		imagenInicio = new ImageIcon(start);
		
		
		lblGameN = new JLabel("");
		lblGameN.setIcon(new ImageIcon(Gameplay.class.getResource("/recursos/mainBG_N.png")));
		lblGameN.setBounds(-3, -8, 575, 394);
		lblGame.setVisible(false);
		lblGameN.setVisible(false);
		lblGame.setIcon(imagenInicio);
		lblGameN.setVisible(true);
		setVisible(true);
		setLayout(null);
		if(i <= 2) {
			//System.out.println("Entro en if--------------");
			add(lblGame,Integer.valueOf(0));
			lblGame.setVisible(true);
		}else {
			//System.out.println("Entro en else--------------");
			lblGameN.setVisible(true);
			add(lblGameN,Integer.valueOf(0));
		}
		
		JLabel suns = new JLabel("");
		ImageIcon reStartIcon = new ImageIcon(Gameplay.class.getResource("/recursos/suns.png"));
		Image reStart = reStartIcon.getImage();
		reStart = reStart.getScaledInstance(70, 30, java.awt.Image.SCALE_SMOOTH);
		reStartIcon = new ImageIcon(reStart);
		suns.setIcon(reStartIcon);
		suns.setBounds(462, 408, 70, 31);
		//suns.setOpaque(false);
		//btnRestart.setContentAreaFilled(false);
		//btnRestart.setBorderPainted(false);
		add(suns,Integer.valueOf(1));
		
		panelJardin = new PanelJardin();
		panelJardin.setGameplay(this);
		panelJardin.setBounds(-1, 1, 570, 380);
		panelJardin.setOpaque(false);
		add(panelJardin,Integer.valueOf(1));
		
		
		
		Nivel.getNivel().setPanelJardin(panelJardin);
		
		
		btnPlanta1 = new JButton("Planta1");
		ImageIcon iconLanzaG;
		if(i <= 2) {
			iconLanzaG = new ImageIcon(this.getClass().getResource("/recursos/peashooterCard.png"));
		}else {
			iconLanzaG = new ImageIcon(this.getClass().getResource("/recursos/PuffShroomCard.jpeg"));
		}
		Image imgLanzaG = iconLanzaG.getImage();
		imgLanzaG = imgLanzaG.getScaledInstance(57, 23, java.awt.Image.SCALE_SMOOTH);
		iconLanzaG = new ImageIcon(imgLanzaG);
		btnPlanta1.setIcon(iconLanzaG);
		btnPlanta1.setBounds(8, 416, 57, 23);
		btnPlanta1.setOpaque(false);
		btnPlanta1.setContentAreaFilled(false);
		btnPlanta1.setBorderPainted(false);
		add(btnPlanta1,Integer.valueOf(1));
		btnPlanta1.addActionListener(this);
		
		btnPlanta2 = new JButton("Planta2");
		ImageIcon iconLanzaGDoble;
		iconLanzaGDoble= new ImageIcon(this.getClass().getResource("/recursos/sunflowerCard.png"));
		Image imgLanzaGDoble = iconLanzaGDoble.getImage();
		imgLanzaGDoble = imgLanzaGDoble.getScaledInstance(57, 23, java.awt.Image.SCALE_SMOOTH);
		iconLanzaGDoble = new ImageIcon(imgLanzaGDoble);
		btnPlanta2.setIcon(iconLanzaGDoble);
		btnPlanta2.setOpaque(false);
		btnPlanta2.setContentAreaFilled(false);
		btnPlanta2.setBorderPainted(false);
		btnPlanta2.setBounds(142, 416, 57, 23);
		add(btnPlanta2,Integer.valueOf(1));
		btnPlanta2.addActionListener(this);
		
		btnPlanta3 = new JButton("Planta3");
		ImageIcon iconGirasol = new ImageIcon(this.getClass().getResource("/recursos/wallnutCard.png"));
		Image imgGirasol = iconGirasol.getImage();
		imgGirasol = imgGirasol.getScaledInstance(57, 23, java.awt.Image.SCALE_SMOOTH);
		iconGirasol = new ImageIcon(imgGirasol);
		btnPlanta3.setIcon(iconGirasol);
		btnPlanta3.setBounds(211, 416, 57, 23);
		btnPlanta3.setOpaque(false);
		btnPlanta3.setContentAreaFilled(false);
		btnPlanta3.setBorderPainted(false);
		add(btnPlanta3,Integer.valueOf(1));
		btnPlanta3.addActionListener(this);
		
		btnPlanta4 = new JButton("Planta4");
		ImageIcon iconNuez;
		
		if(i <= 2) {
			iconNuez = new ImageIcon(this.getClass().getResource("/recursos/repeaterCard.png"));
		}else {
			iconNuez= new ImageIcon(this.getClass().getResource("/recursos/FumeShroomCard.jpeg"));
		}
		Image imgNuez = iconNuez.getImage();
		imgNuez = imgNuez.getScaledInstance(57, 23, java.awt.Image.SCALE_SMOOTH);
		iconNuez = new ImageIcon(imgNuez);
		btnPlanta4.setIcon(iconNuez);
		btnPlanta4.setBounds(75, 416, 57, 23);
		btnPlanta4.setOpaque(false);
		btnPlanta4.setContentAreaFilled(false);
		btnPlanta4.setBorderPainted(false);
		add(btnPlanta4,Integer.valueOf(1));
		btnPlanta4.addActionListener(this);
		
		JLabel madera = new JLabel("");
		madera.setIcon(new ImageIcon(Gameplay.class.getResource("/recursos/madera.jpg")));
		madera.setBounds(-13, 379, 581, 71);
		add(madera);
		
		cantSoles = new JLabel(String.valueOf(nivel.getSoles()));
		cantSoles.setBounds(490, 415, 46, 14);
		add(cantSoles,Integer.valueOf(2));
		
		
		
		
		for(int x = 0;x < 9; x++) {
			for(int y = 0; y < 6; y++) {
				label[x][y] =  new JLabel("");
				label[x][y].setBounds((conversor.convertirPantalla(x)), (conversor.convertirPantalla(y))-10, 70, 72);
				//label[x][y].setIcon(new ImageIcon(Gameplay.class.getResource("/recursos/peashooter.gif")));
				label[x][y].setVisible(true);
				add(label[x][y],Integer.valueOf(1));
			}
		}
		
		
			
		
		
	}

	
	
	public void modificar(Planta p) {
		int x = conversor.convertirFila(p.getPosicion().getX()); 
		int y = conversor.convertirFila(p.getPosicion().getY()); 
		//System.out.println("Path: "+String.valueOf(p.getImagen()));
		label[x][y].setIcon(p.getEntidadGrafica().getLabel().getIcon());
		//label[x][y].setIcon(new ImageIcon(Gameplay.class.getResource(String.valueOf(p.getImagen())))); <<<<<<<<<<<<<<<<<<CHECKEAR
		//label[x][y].setVisible(true);
		
	}

	
	public void agregarEntidad(Entidad e) {//agrega la entidad al panel
		JLabel labelAgregado = e.getEntidadGrafica().getLabel();		
		labelAgregado.setVisible(true);
		this.add(labelAgregado,Integer.valueOf(6));
	}
	
	public void sacarEntidad(Entidad e) {//saca la entidad de dentro del panel
		JLabel labelSacar = e.getEntidadGrafica().getLabel();
		labelSacar.setVisible(false);
		this.remove(labelSacar);
	}
	
	
	
	public void actualizarSoles(int cantidad) {
		cantSoles.setText(String.valueOf(cantidad));
	}
	
	
	public void restart() {
		panelJardin.restart();
		for(int x = 0; x < label.length; x++) {
			for(int y = 0; y < label[0].length; y++) {
				label[x][y].setIcon(null);
			}
		}
	}
	
	public PanelJardin getJardin() {
		return panelJardin;
	}



	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnPlanta1) {
			//System.out.println("CREANDO PLANTA 1");
			panelJardin.setSeleccion(1);
		}
		
		if(e.getSource()==btnPlanta2) {
			//System.out.println("CREANDO PLANTA 2");
			panelJardin.setSeleccion(2);
		}
		
		if(e.getSource()==btnPlanta3) {
			//System.out.println("CREANDO PLANTA 3");
			panelJardin.setSeleccion(3);
		}
		
		if(e.getSource()==btnPlanta4) {
			//System.out.println("CREANDO PLANTA 4");
			panelJardin.setSeleccion(4);
		}
	}

	
	

	public void sacarPlanta(Planta p) {
		int y = conversor.convertirFila(p.getPosicion().getY());
		int x = conversor.convertirFila(p.getPosicion().getX());
		label[x][y].setVisible(false);
		label[x][y] = null;
	}

	public void actualizar(Entidad e) {
		Posicion posicion = e.getPosicion();
		int alto = e.getEntidadGrafica().getAlto();
		int ancho = e.getEntidadGrafica().getAncho();
		e.getEntidadGrafica().getLabel().setLocation(posicion.getX(),posicion.getY());
		e.getEntidadGrafica().getLabel().setBounds(posicion.getX(),posicion.getY(), ancho, alto);
		
	}
}

class Pair<K,V>{
	K key; V value;
	Pair(K k, V v){
		key = k;
		value = v;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}
