package Zombies;

import Logica.EntidadGrafica;

public class ZombiePeriodico extends Zombie {

  public ZombiePeriodico() {
    vida = 5;
    velocidad = 4;
    danio = 1;
    imagenNormal = "/recursos/Newspaper.gif";
    imagenAtacando = "/recursos/NewspaperAttack.gif";
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
