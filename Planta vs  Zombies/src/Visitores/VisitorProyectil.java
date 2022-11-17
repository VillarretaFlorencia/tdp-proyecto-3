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
		z.recibirDanio(proyectil.getDanio());
		miNivel.getInstancia().matarProyectil(proyectil); //este metodo en la logica lo borra de la lista de la fila correspondiente y le dice a la GUI que lo borre		
		//decirle al juego que lo destruya y l
	}
	@Override
	public void visit(Planta p) {
		// TODO Auto-generated method stub
	}
}
