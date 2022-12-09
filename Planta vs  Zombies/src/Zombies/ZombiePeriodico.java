package Zombies;

import Entidades.*;

public class ZombiePeriodico extends Zombie {

  public ZombiePeriodico() {
    vida = 8;
    danio = 2;
    velocidad = 8;
    imagenNormal = "/recursos/Newspaper.gif";
    imagenAtacando = "/recursos/NewspaperAttack.gif";
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
