package Visitores;

import Plantas.Planta;
import Zombies.Zombie;

public class VisitorZombie extends Visitor{
	
	Zombie zombie;

	public VisitorZombie (Zombie z) {
		zombie = z;
	}
	
	public void visit (Proyectil p) {
		int daniar = p.getDanio();
		if (p.getVida()>daniar)
			z.recibirDanio (daniar);
		else
			z.morir();
	}

	
	public void visit(Planta p) {
		zombie.comer();
	}
	
}
