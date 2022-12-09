package Zombies;

import Entidades.*;

public class ZombieBalde extends Zombie {
	
  public ZombieBalde() {
    vida = 12;
    danio = 4;
    velocidad = 4;
    imagenNormal = "/recursos/BucketheadZombie.gif";
    imagenAtacando = "/recursos/BucketheadZombieAttack.gif";
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
