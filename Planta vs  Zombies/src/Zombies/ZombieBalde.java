package Zombies;

import Logica.EntidadGrafica;

public class ZombieBalde extends Zombie {

  public ZombieBalde() {
    vida = 5;
    velocidad = 6;
    danio = 1;
    imagenNormal = "/recursos/BucketheadZombie.gif";
    imagenAtacando = "/recursos/BucketheadZombieAttack.gif";
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
