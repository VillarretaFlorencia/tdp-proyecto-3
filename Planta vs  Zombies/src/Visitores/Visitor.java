package Visitores;

import Zombies.Zombie;
import Plantas.Planta;

public abstract class Visitor {

	public abstract void visit (Zombie z);
	public abstract void visit (Planta p);
}
