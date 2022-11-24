package Estados;

import Zombies.Zombie;

public class EstadoZombieAtacando extends EstadoZombie{
	
	
	public EstadoZombieAtacando(Zombie z) {
		zombie = z;
		String imagen = zombie.getImagenAtacando();
		zombie.setImagen(imagen);
		zombie.getEntidadGrafica().cambiarImagen(imagen);
		
	}
	
	public void accionar() {
	}

}