package Estados;

import Zombies.Zombie;

public class EstadoZombieAtacando extends EstadoZombie{
	
	
	public EstadoZombieAtacando(Zombie z) {
		this.z = z;
		z.setImagen(z.getImagenAtacando());
	}
	
	public void accionar() {
	}

}