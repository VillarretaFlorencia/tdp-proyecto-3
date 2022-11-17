package GUI;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;
import java.awt.Color;


public class Gameplay extends JLayeredPane implements ActionListener{
	private PanelJardin panelJardin;
	private JButton btnPlanta1;
	private JButton btnPlanta2;
	private JButton btnPlanta3;
	private JButton btnPlanta4;
	JLabel[][] label = new JLabel[9][6];
	private JLabel lblGameN;
	private int numeroNivel = 0;
	public Gameplay( int i) {
		numeroNivel = i;
		System.out.println("-------------- valor i: "+i);
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
			System.out.println("Entro en if--------------");
			add(lblGame,Integer.valueOf(0));
			lblGame.setVisible(true);
		}else {
			System.out.println("Entro en else--------------");
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
		
		btnPlanta1 = new JButton("Planta1");
		ImageIcon iconLanzaG;
		if(i <= 2) {
			iconLanzaG = new ImageIcon(this.getClass().getResource("/recursos/repeaterCard.png"));
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
		
		JLabel cantSoles = new JLabel(String.valueOf(panelJardin.getSoles()));
		cantSoles.setBounds(490, 415, 46, 14);
		add(cantSoles,Integer.valueOf(2));
		
		
		
		
		for(int x = 0;x < 9; x++) {
			for(int y = 0; y < 6; y++) {
				label[x][y] =  new JLabel("");
				label[x][y].setBounds((63*x)+0, (63*y)-10, 70, 87);
				//label[x][y].setIcon(new ImageIcon(Gameplay.class.getResource("/recursos/peashooter.gif")));
				label[x][y].setVisible(true);
				add(label[x][y],Integer.valueOf(1));
			}
		}
		
	}
	
	public void modificar(int x, int y, int seleccion) {
		switch (seleccion) {
			case 1: if(numeroNivel <=2) {
						label[x][y].setIcon(new ImageIcon(Gameplay.class.getResource("/recursos/peashooter.gif")));
					}else {
						label[x][y].setIcon(new ImageIcon(Gameplay.class.getResource("/recursos/PuffShroom.gif")));
					}
					break;
			
			case 2:
				label[x][y].setIcon(new ImageIcon(Gameplay.class.getResource("/recursos/sunflower.gif")));
				break;
			case 3:
				label[x][y].setIcon(new ImageIcon(Gameplay.class.getResource("/recursos/walnut_full_life.gif")));
				break;
			case 4:
				if(numeroNivel <=2) {
					label[x][y].setIcon(new ImageIcon(Gameplay.class.getResource("/recursos/repeater.gif")));
				}else {
					label[x][y].setIcon(new ImageIcon(Gameplay.class.getResource("/recursos/FumeShroom.gif")));
				}
				break;
		}
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
			System.out.println("CREANDO PLANTA 1");
			panelJardin.setSeleccion(1);
		}
		
		if(e.getSource()==btnPlanta2) {
			System.out.println("CREANDO PLANTA 2");
			panelJardin.setSeleccion(2);
		}
		
		if(e.getSource()==btnPlanta3) {
			System.out.println("CREANDO PLANTA 3");
			panelJardin.setSeleccion(3);
		}
		
		if(e.getSource()==btnPlanta4) {
			System.out.println("CREANDO PLANTA 4");
			panelJardin.setSeleccion(4);
		}
	}
}
