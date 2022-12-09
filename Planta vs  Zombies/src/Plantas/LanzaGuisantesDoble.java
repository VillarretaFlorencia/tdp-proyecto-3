package Plantas;

import Entidades.*;

public class LanzaGuisantesDoble extends Planta {

  public LanzaGuisantesDoble() {
    imagen = "/recursos/repeater.gif";
    imagenProyectil = "/recursos/pea.png";
    danio = 2;
    tiempoDeAtaque = 3;
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
