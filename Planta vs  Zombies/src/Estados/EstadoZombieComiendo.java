package Estados;

import java.awt.Image;

import javax.swing.ImageIcon;

import GUI.Gameplay;

public class EstadoZombieComiendo {
	Image imagen;
	public EstadoZombieComiendo(int i) {
		String ruta="";
		switch (i) {
		case 0: ruta = "/recursos/ZombieAttack.gif"; break;
		case 1: ruta = "/recursos/NewspaperAttack.gif"; break;
		case 2: ruta = "/recursos/ConeheadZombieAttack.gif"; break;
		case 3: ruta = "/recursos/BucketheadZombieAttack.gif"; break;
		case 4: ruta = "/recursos/DoorZombieAttack.gif"; break;
		case 5: ruta = "/recursos/ZombieAttack.gif"; break;
		case 6: ruta = "/recursos/FlagZombieAttack.gif"; break;
		}
		
		imagen = new ImageIcon(Gameplay.class.getResource(ruta)).getImage();
	}
}
