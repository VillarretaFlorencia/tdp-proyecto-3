package GUI;

import Conversor.Conversor;
import Logica.Nivel;
import Posicion.Posicion;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class PanelJardin extends JPanel {

  Gameplay gameplay = null;
  int seleccion = 0;
 // private JLabel[][] label = new JLabel[9][6];
  Conversor conversor = Conversor.getConversor();
  Nivel nivel = Nivel.getNivel();
  //int soles = 0;
  //int precioPlantaA;
  //int precioPlantaB;

  public PanelJardin() {
    //soles = 100;
    this.setBounds(0, 0, 570, 380);
    setOpaque(false);
    EventosDelRaton raton = new EventosDelRaton();
    raton.setPanel(this); //dentro del controlador del panel ponemos este panel
    setLayout(null);
    addMouseListener(raton);
    /*
    for (int x = 0; x < 9; x++) {
      for (int y = 0; y < 6; y++) {
        label[x][y] = new JLabel("poggers"); //el string es para ver si aparecian > no funciono
        //label[x][y].setBounds((63*x)+21, (63*y)+22, 27, 47);
        label[x][y].setBounds(
            (conversor.convertirPantalla(x)),
            (conversor.convertirPantalla(y)) - 10,
            70,
            72
          );
      }
    }*/
  }

  // NIVEL YA NO LO OBTENGO DE PANEL ES GLOBAL LO EN TODOS
  // DONDE DICE MODIFICAR IRIA SETPLANTA
  public void setSeleccion(int selec) {
    seleccion = selec;
  }

  public int getSeleccion() {
    return seleccion;
  }

  /*public JLabel[][] getLabels() {
    return label;
  }*/

  public void setGameplay(Gameplay lp) {
    gameplay = lp;
  }

  public Gameplay getGameplay() {
    return gameplay;
  }

  public void restart() {
    nivel.iniciarJuego(1); //limpiar labels
  }


  
}

class EventosDelRaton implements MouseListener {

  Nivel nivel = Nivel.getNivel();
  private PanelJardin panelJardin;

  Conversor conversor = Conversor.getConversor();

  @Override
  public void mouseClicked(MouseEvent e) {
    if (panelJardin.getSeleccion() != 0) { //solo si ha seleccionado algo
    	int x = conversor.convertirXY(e.getX());
    	int y = conversor.convertirXY(e.getY());
      if (!panelJardin.getGameplay().hayPlanta(x,y)) {
    	nivel.setPlanta(new Posicion(x, y), panelJardin.getSeleccion());
      }
      panelJardin.setSeleccion(0);
    }
      
  }
  
  public void setPanel(PanelJardin p) {
	    panelJardin = p;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  

  /*public PanelJardin getPanel() {
    return panel;
  }*/
}
