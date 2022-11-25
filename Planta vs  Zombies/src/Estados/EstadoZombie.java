package Estados;

import Zombies.Zombie;

public abstract class EstadoZombie {

  protected Zombie zombie;

  public abstract void accionar();
}
