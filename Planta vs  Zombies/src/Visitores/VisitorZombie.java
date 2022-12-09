package Visitores;

import Estados.*;
import Logica.Nivel;
import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;

public class VisitorZombie extends Visitor {

  Zombie zombie;
  Nivel nivel = Nivel.getNivel();

  public VisitorZombie(Zombie z) {
    zombie = z;
  }

  public void visit(Proyectil proyectil) {
    int daniar = proyectil.getDanio();
    if (zombie.getVida() > daniar) {
      zombie.recibirDanio(daniar);
    } else {
      nivel.matarZombie(zombie);
    }
    nivel.matarProyectil(proyectil);
  }

  public void visit(Planta planta) {
    
    int daniar = zombie.getDanio();
    if (planta.getVida() <= daniar) {
      zombie.setEstado(new EstadoZombieNormal(zombie));
      nivel.matarPlanta(planta);
    } else {
    	zombie.setEstado(new EstadoZombieAtacando(zombie));
    	planta.recibirDanio(zombie.getDanio());
    }
  }
}
