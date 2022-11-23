package Estados;

import Zombies.Zombie;

public abstract class EstadoZombie{
	protected Zombie z;
	
	protected String imagen;
	
	public abstract void accionar();
}
