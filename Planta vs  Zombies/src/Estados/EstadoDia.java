package Estados;

import java.awt.Image;

import javax.swing.ImageIcon;

import GUI.Gameplay;

public class EstadoDia extends Estado{
	protected Image imagen;
	
	public EstadoDia() {
		imagen = new ImageIcon(Gameplay.class.getResource("/recursos/mainBG.png")).getImage();
	}
	
	public Image getImage() {
		return imagen;
	}
	public void setImage(Image i) {
		imagen = i;
	}

}
