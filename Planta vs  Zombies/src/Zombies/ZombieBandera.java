package Zombies;

import Entidades.*;

public class ZombieBandera extends Zombie {

  public ZombieBandera() {
    vida = 10;
    danio = 6;
    velocidad = 4;
    imagenNormal = "/recursos/FlagZombie.gif";
    imagenAtacando = "/recursos/FlagZombieAttack.gif";
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
