package Visitores;

import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;

public class VisitorProyectil extends Visitor{
	Proyectil proyectil;

	public VisitorProyectil(Proyectil p) {
		proyectil = p;
	}
	
	public void visit (Zombie z) {
		proyectil.setActivo(false);
		z.accept(this);
	}

	@Override
	public void visit(Planta p) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
