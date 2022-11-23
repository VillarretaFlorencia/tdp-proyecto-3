package Estados;

import Zombies.Zombie;

public class EstadoZombieNormal extends EstadoZombie{
	protected Zombie z;
	
	public EstadoZombieNormal(Zombie z) {
		z.setImagen(z.getImagenNormal());
	}
	
	public void accionar() {
		//mover al zombie
		z.getPosicion().setX(z.getPosicion().getX()-z.getVelocidad());
	}
	
}
