package GUI;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;


public class Gameplay extends JLayeredPane implements ActionListener{
	private JButton btnRestart;
	private PanelJardin panelJardin;
	private JButton btnPlanta1;
	private JButton btnPlanta2;
	private JButton btnPlanta3;
	private JButton btnPlanta4;
	public Gameplay() {
		JLabel lblGame = new JLabel("");
		lblGame.setBounds(0, 0, 600, 341);
		setBounds(0,0,570,335);
		ImageIcon imagenInicio = new ImageIcon(this.getClass().getResource("/recursos/mainBG.png"));
		Image start = imagenInicio.getImage();
		start = start.getScaledInstance(570, 335,  java.awt.Image.SCALE_SMOOTH);
		imagenInicio = new ImageIcon(start);
		lblGame.setIcon(imagenInicio);
		lblGame.setVisible(true);
		setVisible(true);
		setLayout(null);
		add(lblGame,Integer.valueOf(0));
		
		btnRestart = new JButton("Restart");
		btnRestart.setBounds(481, 0, 89, 23);
		btnRestart.setOpaque(false);
		btnRestart.setContentAreaFilled(false);
		btnRestart.setBorderPainted(false);
		add(btnRestart,Integer.valueOf(1));
		
		panelJardin = new PanelJardin();
		panelJardin.setBounds(23, 48, 526, 293);
		add(panelJardin,Integer.valueOf(1));
		
		btnPlanta1 = new JButton("Planta1");
		ImageIcon iconLanzaG = new ImageIcon(this.getClass().getResource("/recursos/peashooterCard.png"));
		Image imgLanzaG = iconLanzaG.getImage();
		imgLanzaG = imgLanzaG.getScaledInstance(57, 23, java.awt.Image.SCALE_SMOOTH);
		iconLanzaG = new ImageIcon(imgLanzaG);
		btnPlanta1.setIcon(iconLanzaG);
		btnPlanta1.setBounds(64, 14, 57, 23);
		btnPlanta1.setOpaque(false);
		btnPlanta1.setContentAreaFilled(false);
		btnPlanta1.setBorderPainted(false);
		add(btnPlanta1,Integer.valueOf(1));
		btnPlanta1.addActionListener(this);
		
		btnPlanta2 = new JButton("Planta2");
		ImageIcon iconLanzaGDoble = new ImageIcon(this.getClass().getResource("/recursos/sunflowerCard.png"));
		Image imgLanzaGDoble = iconLanzaGDoble.getImage();
		imgLanzaGDoble = imgLanzaGDoble.getScaledInstance(57, 23, java.awt.Image.SCALE_SMOOTH);
		iconLanzaGDoble = new ImageIcon(imgLanzaGDoble);
		btnPlanta2.setIcon(iconLanzaGDoble);
		btnPlanta2.setBounds(64, 14, 57, 23);
		btnPlanta2.setOpaque(false);
		btnPlanta2.setContentAreaFilled(false);
		btnPlanta2.setBorderPainted(false);
		btnPlanta2.setBounds(131, 14, 57, 23);
		add(btnPlanta2,Integer.valueOf(1));
		btnPlanta2.addActionListener(this);
		
		btnPlanta3 = new JButton("Planta3");
		ImageIcon iconGirasol = new ImageIcon(this.getClass().getResource("/recursos/wallnutCard.png"));
		Image imgGirasol = iconGirasol.getImage();
		imgGirasol = imgGirasol.getScaledInstance(57, 23, java.awt.Image.SCALE_SMOOTH);
		iconGirasol = new ImageIcon(imgGirasol);
		btnPlanta3.setIcon(iconGirasol);
		btnPlanta3.setBounds(64, 14, 57, 23);
		btnPlanta3.setOpaque(false);
		btnPlanta3.setContentAreaFilled(false);
		btnPlanta3.setBorderPainted(false);
		btnPlanta3.setBounds(192, 14, 57, 23);
		add(btnPlanta3,Integer.valueOf(1));
		btnPlanta3.addActionListener(this);
		
		btnPlanta4 = new JButton("Planta4");
		ImageIcon iconNuez = new ImageIcon(this.getClass().getResource("/recursos/repeaterCard.png"));
		Image imgNuez = iconNuez.getImage();
		imgNuez = imgNuez.getScaledInstance(57, 23, java.awt.Image.SCALE_SMOOTH);
		iconNuez = new ImageIcon(imgNuez);
		btnPlanta4.setIcon(iconNuez);
		btnPlanta4.setBounds(64, 14, 57, 23);
		btnPlanta4.setOpaque(false);
		btnPlanta4.setContentAreaFilled(false);
		btnPlanta4.setBorderPainted(false);
		btnPlanta4.setBounds(258, 14, 57, 23);
		add(btnPlanta4,Integer.valueOf(1));
		btnPlanta4.addActionListener(this);
		
		
		
		
	}
	
	public void restart() {
		panelJardin.restart();
	}
	
	public JButton getRestartButton() {
		return btnRestart;
	}

	@Override
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
