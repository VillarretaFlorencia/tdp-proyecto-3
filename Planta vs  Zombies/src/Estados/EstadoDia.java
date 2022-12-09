package Estados;

import GUI.Gameplay;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * Esta clase Define el comportamiento del nivel en los niveles de dia
 * 
 *
 */
public class EstadoDia extends EstadoNivel {

  protected Image imagen;

  public EstadoDia() {
	  imagen = new ImageIcon(Gameplay.class.getResource("/recursos/mainBG.png")).getImage();
  }
  /**
   * Obtiene la imagen del nivel
   * @return Image
   */
  public Image getImagen() {
	  return imagen;
  }
  /**
   * Establece la imagen que se usara en el nivel de dia
   * @param Imagen
   */
  public void setImage(Image i) {
	  imagen = i;
  }
}
