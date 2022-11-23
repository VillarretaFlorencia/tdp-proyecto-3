package Estados;

import Zombies.Zombie;

public class EstadoZombieAtacando extends EstadoZombie{
	protected Zombie z;
	
	public EstadoZombieAtacando() {
		z.setImagen(z.getImagenAtacando());
	}
	
	public void accionar(Zombie z) {
	}
}