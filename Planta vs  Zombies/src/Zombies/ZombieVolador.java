package Zombies;

import Entidades.*;

public class ZombieVolador extends Zombie {

  public ZombieVolador() {
    vida = 5;
    danio = 1;
    velocidad = 2;
    imagenNormal = "/recursos/Zombie.gif";
    imagenAtacando = "/recursos/ZombieAttack.gif";
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
