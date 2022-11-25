package GUI;

import Conversor.Conversor;
import Logica.Entidad;
import Logica.Nivel;
import Logica.Posicion;
import Plantas.Planta;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelJardin extends JPanel {

  Gameplay gameplay = null;
  int seleccion = 0;
  private JLabel[][] label = new JLabel[9][6];
  Conversor conversor = Conversor.getConversor();
  Nivel nivel = Nivel.getNivel();
  //int soles = 0;
  int precioPlantaA;
  int precioPlantaB;

  public PanelJardin() {
    //soles = 100;
    this.setBounds(0, 0, 570, 380);
    setOpaque(false);
    EventosDelRaton raton = new EventosDelRaton();
    raton.setPanel(this); //dentro del controlador del panel ponemos este panel
    setLayout(null);
    addMouseListener(raton);
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
    }
  }

  // NIVEL YA NO LO OBTENGO DE PANEL ES GLOBAL LO EN TODOS
  // DONDE DICE MODIFICAR IRIA SETPLANTA
  public void setSeleccion(int selec) {
    seleccion = selec;
  }

  public int getSeleccion() {
    return seleccion;
  }

  /*public void setNivel(int i) {//aca hacemos el set del nivel
		nivel.iniciarJuego(i);
	}*/

  public JLabel[][] getLabels() {
    return label;
  }

  public void setGameplay(Gameplay lp) {
    gameplay = lp;
  }

  public Gameplay getGameplay() {
    return gameplay;
  }

  public void insert(int posX, int posY, Planta p) {
    gameplay.modificar(p);
  }

  public void restart() {
    nivel.iniciarJuego(1); //limpiar labels
  }

  public void colocarPlanta(Planta p) {
    gameplay.modificar(p);
  }

  public int getPrecioPlantaA() {
    return precioPlantaA;
  }

  public int getPrecioPlantaB() {
    return precioPlantaB;
  }

  public void terminarJuego() {
    int resp = JOptionPane.showConfirmDialog(
      null,
      "Desea intentarlo de nuevo?",
      "Perdiste",
      JOptionPane.YES_NO_OPTION,
      JOptionPane.QUESTION_MESSAGE
    );
    nivel.terminarJuego();
    if (resp == JOptionPane.YES_OPTION) {
      gameplay.restart();
    } else {
      MainFrame mainframe = new MainFrame();
      mainframe.setVisible(true);
    }
  }

  public void sacarEntidad(Entidad e) {
    gameplay.sacarEntidad(e);
  }

  public void sacarPlanta(Planta p) {
    gameplay.sacarPlanta(p);
  }

  public void actualizar(Entidad e) {
    gameplay.actualizar(e);
  }
}

class EventosDelRaton implements MouseListener {

  Nivel nivel = Nivel.getNivel();
  private PanelJardin panel;

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    int posX = (int) (Math.floor(e.getX() / 63));
    int posY = (int) (Math.floor((e.getY() / 63)));
    if (panel.getSeleccion() != 0) { //solo si ha seleccionado algo
      nivel.setPlanta(new Posicion(e.getX(), e.getY()), panel.getSeleccion());
      panel.setSeleccion(0);
    } else {
      panel.setSeleccion(0);
    }
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

  public void setPanel(PanelJardin p) {
    panel = p;
  }

  public PanelJardin getPanel() {
    return panel;
  }
}
