package Visitores;

import Estados.*;
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
		System.out.println("PRoyectilVisitor------------VISITOR");
		int daniar = p.getDanio();
		if (zombie.getVida() > daniar) {
			zombie.recibirDanio(daniar);
		}
		else {
			n.matarZombie(zombie);
		}
		n.matarProyectil(p);
		
	}

	
	public void visit(Planta p) {
		System.out.println("PlantaVisitor------------VISITOR"+p.getClass().getSimpleName());
		zombie.setEstado(new EstadoZombieAtacando(zombie));
		p.recibirDanio (zombie.getDanio());
		if (p.getVida() <= 0) {
			n.matarPlanta(p);
			zombie.setEstado(new EstadoZombieNormal(zombie));
		}
	}

	
	
}
