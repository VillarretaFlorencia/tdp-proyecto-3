package Estados;

import Logica.Posicion;
import Zombies.Zombie;

public class EstadoZombieNormal extends EstadoZombie{
	
	
	public EstadoZombieNormal(Zombie z) {
		zombie = z;
		String imagen = zombie.getImagenNormal();
		zombie.setImagen(imagen);
		zombie.getEntidadGrafica().setImagen(imagen);
		
	}
	
	public void accionar() {
		//mover al zombie
		Posicion posicion = zombie.getPosicion();
		posicion.setX(posicion.getX() - zombie.getVelocidad()); 
		zombie.getEntidadGrafica().mover(posicion.getX(),posicion.getY());
	}
	
}
