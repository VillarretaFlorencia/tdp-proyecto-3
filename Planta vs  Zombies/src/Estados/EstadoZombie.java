package Estados;

import Zombies.Zombie;

public abstract class EstadoZombie{
	
	protected String imagen;
	
	public abstract void accionar(Zombie z);
}
