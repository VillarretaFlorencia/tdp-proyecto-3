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
	final static String SELECTOR = "ventana selector de nivel";
	
	startScreen panelInicio = new startScreen();
	Gameplay panelGameplay = new Gameplay();
	LvlSelector panelSelector = new LvlSelector();
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0,0));
		this.setBounds(0, 0, 583, 489);
		this.setResizable(false);
		//anadimos las ventanas al frame
		getContentPane().add(panelInicio,START);//agregamos la ventana con el identificador
		getContentPane().add(panelGameplay,GAMEPLAY);
		getContentPane().add(panelSelector,SELECTOR);
		
		
		//agregamos el action listener del start
		panelInicio.getStart().addActionListener(new ActionListener() {//tomamos el boton del start
			public void actionPerformed(ActionEvent e) {//al momento de presionar el boton
				CardLayout c1 = (CardLayout)(getContentPane().getLayout());//se cambia toma el panel
				c1.show(getContentPane(),SELECTOR); // y lo cambiamos en el contentPane
				
			}
			
		});
		
		//agregamos el listener del boton de restart del gameplay
		panelGameplay.getRestartButton().addActionListener(new ActionListener() {//tomamos el boton del start
			public void actionPerformed(ActionEvent e) {//al momento de presionar el boton
				CardLayout c1 = (CardLayout)(getContentPane().getLayout());//se cambia toma el panel
				c1.show(getContentPane(),START); // y lo cambiamos en el contentPane
				panelGameplay.restart();
			}
			
		});
		
		panelSelector.getSelect1().addActionListener(new ActionListener() {//tomamos el boton del start
			public void actionPerformed(ActionEvent e) {//al momento de presionar el boton
				CardLayout c1 = (CardLayout)(getContentPane().getLayout());//se cambia toma el panel
				c1.show(getContentPane(),GAMEPLAY); // y lo cambiamos en el contentPane
				panelGameplay.getJardin().setNivel(1);
				//panelGameplay.restart();
			}
			
		});
		
		panelSelector.getSelect2().addActionListener(new ActionListener() {//tomamos el boton del start
			public void actionPerformed(ActionEvent e) {//al momento de presionar el boton
				CardLayout c1 = (CardLayout)(getContentPane().getLayout());//se cambia toma el panel
				c1.show(getContentPane(),GAMEPLAY); // y lo cambiamos en el contentPane
				panelGameplay.getJardin().setNivel(2);
				//panelGameplay.restart();
			}
			
		});
		
		panelSelector.getSelect3().addActionListener(new ActionListener() {//tomamos el boton del start
			public void actionPerformed(ActionEvent e) {//al momento de presionar el boton
				CardLayout c1 = (CardLayout)(getContentPane().getLayout());//se cambia toma el panel
				c1.show(getContentPane(),GAMEPLAY); // y lo cambiamos en el contentPane
				panelGameplay.getJardin().setNivel(3);
				//panelGameplay.restart();
			}
			
		});
		
		panelSelector.getSelect4().addActionListener(new ActionListener() {//tomamos el boton del start
			public void actionPerformed(ActionEvent e) {//al momento de presionar el boton
				CardLayout c1 = (CardLayout)(getContentPane().getLayout());//se cambia toma el panel
				c1.show(getContentPane(),GAMEPLAY); // y lo cambiamos en el contentPane
				panelGameplay.getJardin().setNivel(4);
				//panelGameplay.restart();
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
