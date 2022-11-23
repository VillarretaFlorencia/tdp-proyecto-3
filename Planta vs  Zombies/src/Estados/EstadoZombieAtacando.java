package Estados;

import Zombies.Zombie;

public class EstadoZombieAtacando extends EstadoZombie{
	protected Zombie z;
	
	public EstadoZombieAtacando() {
		z.setImagen(z.getImagenAtacando());
	}
	
	public void accionar(Zombie z) {
		//mover al zombie
		//posicion.setX(posicion.getX()-velocidad);
	}
}