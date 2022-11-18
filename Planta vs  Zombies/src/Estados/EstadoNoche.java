package Estados;

import java.awt.Image;

import javax.swing.ImageIcon;

import GUI.Gameplay;

public class EstadoNoche extends Estado{
	protected Image imagen;
	
	public EstadoNoche() {
		
		imagen = new ImageIcon(Gameplay.class.getResource("/recursos/mainBG_N.png")).getImage();
	}
	
	public Image getImage() {
		return imagen;
	}
	public void setImage(Image i) {
		imagen = i;
	}
}
