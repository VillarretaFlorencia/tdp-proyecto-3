package Estados;

import java.awt.Image;

import javax.swing.ImageIcon;

import GUI.Gameplay;

public class EstadoZombieNormal extends EstadoZombie{
	
	public EstadoZombieNormal(int i) {
		String ruta = "";
		switch (i) {
		case 0: ruta = "/recursos/Zombie.gif"; break;
		case 1: ruta = "/recursos/Newspaper.gif"; break;
		case 2: ruta = "/recursos/ConeheadZombie.gif"; break;
		case 3: ruta = "/recursos/BucketheadZombie.gif"; break;
		case 4: ruta = "/recursos/DoorZombie.gif"; break;
		case 5: ruta = "/recursos/Zombie.gif"; break;
		case 6: ruta = "/recursos/FlagZombie.gif"; break;
		}
		
		imagen = ruta;
	}
	
	public void accionar(Zombie z) {
		//mover al zombie
		//posicion.setX(posicion.getX()-velocidad);
	}
	
}
