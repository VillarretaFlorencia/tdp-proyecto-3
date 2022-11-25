package Zombies;

import Logica.EntidadGrafica;

public class ZombieCono extends Zombie {

  public ZombieCono() {
    vida = 5;
    velocidad = 4;
    danio = 1;
    imagenNormal = "/recursos/ConeheadZombie.gif";
    imagenAtacando = "/recursos/ConeheadZombieAttack.gif";
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
