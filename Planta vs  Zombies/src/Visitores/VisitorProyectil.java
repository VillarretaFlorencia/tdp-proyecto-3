package Visitores;

import Plantas.Planta;
import Zombies.Zombie;

public class VisitorProyectil extends Visitor{
	
	Proyectil proyectil;

	public VisitorZombie (Proyectil p) {
		proyectil = p;
	}
	
	public void visit (Zombie z) {
		p.setActivo (false);
		z.accept();
	}

	
	
	
}
