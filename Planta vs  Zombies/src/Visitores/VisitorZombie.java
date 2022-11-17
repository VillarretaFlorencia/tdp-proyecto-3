package Visitores;

import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;

public class VisitorZombie extends Visitor{
	
	Zombie zombie;

	public VisitorZombie (Zombie z) {
		zombie = z;
	}
	
	public void visit (Proyectil p) {
		int daniar = p.getDanio();
		if (zombie.getVida()>daniar)
			zombie.recibirDanio (daniar);
		else
			zombie.morir();
	}

	
	public void visit(Planta p) {
		zombie.comer();
	}

	@Override
	public void visit(Zombie z) {
		// TODO Auto-generated method stub
		
	}
	
}
