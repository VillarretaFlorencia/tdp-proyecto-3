package GUI;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;


public class Gameplay extends JLayeredPane implements ActionListener{
	private JButton btnRestart;
	private PanelJardin panel;
	private JButton btnPlanta1;
	private JButton btnPlanta2;
	private JButton btnPlanta3;
	private JButton btnPlanta4;
	private int seleccion; // esta es la seleccion de la planta que quiere plantar
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
		add(btnRestart,Integer.valueOf(1));
		
		panel = new PanelJardin();
		panel.setBounds(23, 48, 526, 293);
		add(panel,Integer.valueOf(1));
		
		btnPlanta1 = new JButton("Planta1");
		btnPlanta1.setBounds(64, 14, 57, 23);
		add(btnPlanta1,Integer.valueOf(1));
		btnPlanta1.addActionListener(this);
		
		btnPlanta2 = new JButton("Planta2");
		btnPlanta2.setBounds(131, 14, 57, 23);
		add(btnPlanta2,Integer.valueOf(1));
		btnPlanta2.addActionListener(this);
		
		btnPlanta3 = new JButton("Planta3");
		btnPlanta3.setBounds(192, 14, 57, 23);
		add(btnPlanta3,Integer.valueOf(1));
		btnPlanta3.addActionListener(this);
		
		btnPlanta4 = new JButton("Planta4");
		btnPlanta4.setBounds(258, 14, 57, 23);
		add(btnPlanta4,Integer.valueOf(1));
		btnPlanta4.addActionListener(this);
		
		
		
		
	}
	
	public JButton getRestartButton() {
		return btnRestart;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnPlanta1) {
			System.out.println("CREANDO PLANTA 1");
			seleccion = 1;
		}
		
		if(e.getSource()==btnPlanta2) {
			System.out.println("CREANDO PLANTA 2");
			seleccion = 2;
		}
		
		if(e.getSource()==btnPlanta3) {
			System.out.println("CREANDO PLANTA 3");
			seleccion = 3;
		}
		
		if(e.getSource()==btnPlanta4) {
			System.out.println("CREANDO PLANTA 4");
			seleccion = 4;
		}
	}
}
