package Estados;

import Zombies.Zombie;
/**
 * Esta clase describe parte del comportamiento del zombie mientras ataca
 * 
 *
 */
public class EstadoZombieAtacando extends EstadoZombie {

  public EstadoZombieAtacando(Zombie z) {
    zombie = z;
    zombie.setImagen(zombie.getImagenAtacando());
    zombie.getEntidadGrafica().setImagen(zombie.getImagen());
  }

  public void accionar() {}
}
