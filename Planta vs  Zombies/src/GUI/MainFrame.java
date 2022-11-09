package GUI;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//usaremos CardLayout
public class MainFrame extends JFrame{
	//identificadores
	final static String START = "Ventana Start";
	final static String GAMEPLAY = "Ventana Gameplay";
	
	
	startScreen panelInicio = new startScreen();
	Gameplay panelGameplay = new Gameplay();
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0,0));
		this.setBounds(0, 0, 570, 360);
		this.setResizable(false);
		//anadimos las ventanas al frame
		getContentPane().add(panelInicio,START);//agregamos la ventana con el identificador
		getContentPane().add(panelGameplay,GAMEPLAY);
		
		//agregamos el action listener del start
		panelInicio.getStart().addActionListener(new ActionListener() {//tomamos el boton del start
			public void actionPerformed(ActionEvent e) {//al momento de presionar el boton
				CardLayout c1 = (CardLayout)(getContentPane().getLayout());//se cambia toma el panel
				c1.show(getContentPane(),GAMEPLAY); // y lo cambiamos en el contentPane
				
			}
			
		});
		
		//agregamos el listener del boton de restart del gameplay
		panelGameplay.getRestartButton().addActionListener(new ActionListener() {//tomamos el boton del start
			public void actionPerformed(ActionEvent e) {//al momento de presionar el boton
				CardLayout c1 = (CardLayout)(getContentPane().getLayout());//se cambia toma el panel
				c1.show(getContentPane(),START); // y lo cambiamos en el contentPane
				
			}
			
		});
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame mainframe = new MainFrame();
					mainframe.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
