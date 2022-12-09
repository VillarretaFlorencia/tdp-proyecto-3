package Zombies;

import Entidades.*;

public class ZombiePuerta extends Zombie {

  public ZombiePuerta() {
    vida = 14;
    danio = 5;
    velocidad = 2;
    imagenNormal = "/recursos/DoorZombie.gif";
    imagenAtacando = "/recursos/DoorZombieAttack.gif";
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
