package Estados;

import Zombies.Zombie;

/**
 * Esta Clase describe el funcionamiento de los estados del zombie
 * 
 *
 */
public abstract class EstadoZombie {

  protected Zombie zombie;
  /**
   * Este metodo se redefine dependiendo del estado del zombie
   */
  public abstract void accionar();
}
