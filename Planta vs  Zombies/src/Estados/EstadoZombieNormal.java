package Estados;

import Zombies.Zombie;

public class EstadoZombieNormal extends EstadoZombie{
	protected Zombie z;
	
	public EstadoZombieNormal() {
		z.setImagen(z.getImagenNormal());
	}
	
	public void accionar(Zombie z) {
		//mover al zombie
		//posicion.setX(posicion.getX()-velocidad);
	}
	
}
