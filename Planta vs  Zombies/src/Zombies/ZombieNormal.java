package Zombies;

import Entidades.*;

public class ZombieNormal extends Zombie {

  public ZombieNormal() {
    vida = 6;
    danio = 1;
    velocidad = 10;
    imagenNormal = "/recursos/Zombie.gif";
    imagenAtacando = "/recursos/ZombieAttack.gif";
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
