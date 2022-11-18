package Visitores;

import Logica.Nivel;
import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;

public class VisitorZombie extends Visitor{
	
	Zombie zombie;
	Nivel n = Nivel.getNivel();

	public VisitorZombie (Zombie z) {
		zombie = z;
	}
	
	public void visit (Proyectil p) {
		int daniar = p.getDanio();
		if (zombie.getVida() > daniar) {
			zombie.recibirDanio (daniar);
			n.matarProyectil(p);
		}
		else {
			n.matarZombie(zombie);
		}
		
	}

	
	public void visit(Planta p) {
		p.recibirDanio (zombie.getDanio());
		zombie.atacar();
		if (p.getVida() <= 0)
			n.matarPlanta(p);
	}

	
	
}
