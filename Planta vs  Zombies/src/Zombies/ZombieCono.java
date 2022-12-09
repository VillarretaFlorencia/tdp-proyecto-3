package Zombies;

import Entidades.*;

public class ZombieCono extends Zombie {

  public ZombieCono() {
    vida = 10;
    danio = 1;
    velocidad = 6;
    imagenNormal = "/recursos/ConeheadZombie.gif";
    imagenAtacando = "/recursos/ConeheadZombieAttack.gif";
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
