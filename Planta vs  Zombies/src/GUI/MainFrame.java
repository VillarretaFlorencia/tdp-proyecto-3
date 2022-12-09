package GUI;

import Logica.Nivel;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//usaremos CardLayout
public class MainFrame extends JFrame {

	private boolean gane;
  //identificadores
  static final String START = "Ventana Start";
  static final String GAMEPLAY = "Ventana Gameplay";
  static final String SELECTOR = "ventana selector de nivel";
  static final String GAMEOVER = "Ventana final del juego";
  static final String WINGAME = "Ventana de ganar el nivel";

  startScreen panelInicio = new startScreen();
  Gameplay panelGameplay = new Gameplay(1); //provisorio
  LvlSelector panelSelector = new LvlSelector();
  finalscreen panelGameOver = new finalscreen();
  WinScreen panelWin = new WinScreen();
  

  Nivel nivel = Nivel.getNivel();

  public MainFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(new CardLayout(0, 0));
    this.setBounds(0, 0, 583, 489);
    this.setResizable(false);
    setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/recursos/icono.jpg")));
    //anadimos las ventanas al frame
    getContentPane().add(panelInicio, START); //agregamos la ventana con el identificador
    getContentPane().add(panelSelector, SELECTOR);
    getContentPane().add(panelGameOver,GAMEOVER);
    getContentPane().add(panelWin, WINGAME);

    //agregamos el action listener del start
    panelInicio
      .getStart()
      .addActionListener(
        new ActionListener() { //tomamos el boton del start
          public void actionPerformed(ActionEvent e) { //al momento de presionar el boton
            CardLayout c1 = (CardLayout) (getContentPane().getLayout()); //se cambia toma el panel
            c1.show(getContentPane(), SELECTOR); // y lo cambiamos en el contentPane
          }
        }
      );

    panelSelector
      .getSelect1()
      .addActionListener(
        new ActionListener() { //tomamos el boton del start
          public void actionPerformed(ActionEvent e) { //al momento de presionar el boton
            CardLayout c1 = (CardLayout) (getContentPane().getLayout()); //se cambia toma el panel
            panelGameplay = new Gameplay(1);
            getContentPane().add(panelGameplay, GAMEPLAY);
            c1.show(getContentPane(), GAMEPLAY); // y lo cambiamos en el contentPane
            jugar(1);
          }
        }
      );

    panelSelector
      .getSelect2()
      .addActionListener(
        new ActionListener() { //tomamos el boton del start
          public void actionPerformed(ActionEvent e) { //al momento de presionar el boton
            CardLayout c1 = (CardLayout) (getContentPane().getLayout()); //se cambia toma el panel
            panelGameplay = new Gameplay(2);
            getContentPane().add(panelGameplay, GAMEPLAY);
            c1.show(getContentPane(), GAMEPLAY); // y lo cambiamos en el contentPane
            jugar(2);
          }
        }
      );

    panelSelector
      .getSelect3()
      .addActionListener(
        new ActionListener() { //tomamos el boton del start
          public void actionPerformed(ActionEvent e) { //al momento de presionar el boton
            CardLayout c1 = (CardLayout) (getContentPane().getLayout()); //se cambia toma el panel
            panelGameplay = new Gameplay(3);
            getContentPane().add(panelGameplay, GAMEPLAY);
            c1.show(getContentPane(), GAMEPLAY); // y lo cambiamos en el contentPane
            jugar(3);
          }
        }
      );

    panelSelector
      .getSelect4()
      .addActionListener(
        new ActionListener() { //tomamos el boton del start
          public void actionPerformed(ActionEvent e) { //al momento de presionar el boton
            CardLayout c1 = (CardLayout) (getContentPane().getLayout()); //se cambia toma el panel
            panelGameplay = new Gameplay(4);
            getContentPane().add(panelGameplay, GAMEPLAY);
            c1.show(getContentPane(), GAMEPLAY); // y lo cambiamos en el contentPane
            jugar(4);
          }
        }
      );
  }
  
  private void jugar(int nroNivel) {
	    //nivel.setPanelJardin(panelGameplay.getJardin());
	    nivel.setGameplay(panelGameplay);
	    nivel.setMainframe (this);
	    nivel.iniciarJuego(nroNivel);
	  }
  
  public void terminarJuego(){
	  if (gane) {
		  win();
	  }
	  else {
		  gameover();
	  }
	  panelGameplay.limpiarJArdin();
  }
  
  public void setJuegoGanado(boolean gane) {
	  this.gane = gane;
  }

  private void gameover() {
	  CardLayout c1 = (CardLayout) (getContentPane().getLayout()); //se cambia toma el panel
      c1.show(getContentPane(), GAMEOVER); // y lo cambiamos en el contentPane
  }
  
  private void win() {
	  System.out.println("ENTRE A WIN");
	  CardLayout c1 = (CardLayout) (getContentPane().getLayout()); //se cambia toma el panel
      c1.show(getContentPane(), WINGAME); // y lo cambiamos en el contentPane
  }
  
  public static void main(String[] args) {
	    EventQueue.invokeLater(
	      new Runnable() {
	        public void run() {
	          try {
	            MainFrame mainframe = new MainFrame();
	            mainframe.setVisible(true);
	          } catch (Exception e) {
	            e.printStackTrace();
	          }
	        }
	      }
	    );
	  }
}
