package Estados;

import GUI.Gameplay;
import java.awt.Image;
import javax.swing.ImageIcon;

public class EstadoDia extends EstadoNivel {

  protected Image imagen;

  public EstadoDia() {
    imagen =
      new ImageIcon(Gameplay.class.getResource("/recursos/mainBG.png"))
        .getImage();
  }

  public Image getImagen() {
    return imagen;
  }

  public void setImage(Image i) {
    imagen = i;
  }
}
