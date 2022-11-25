package Estados;

import GUI.Gameplay;
import java.awt.Image;
import javax.swing.ImageIcon;

public class EstadoNoche extends EstadoNivel {

  protected Image imagen;

  public EstadoNoche() {
    imagen =
      new ImageIcon(Gameplay.class.getResource("/recursos/mainBG_N.png"))
        .getImage();
  }

  public Image getImagen() {
    return imagen;
  }

  public void setImage(Image i) {
    imagen = i;
  }
}
