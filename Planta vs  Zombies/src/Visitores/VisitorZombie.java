package Visitores;

import Plantas.Planta;
import Zombies.Zombie;

public class VisitorZombie extends Visitor{
	
	Zombie zombie;

	public VisitorZombie (Zombie z) {
		zombie = z;
	}
	
	public void visit (Zombie z) {}

	
	public void visit(Planta p) {
		zombie.comer();
	}
	
}
