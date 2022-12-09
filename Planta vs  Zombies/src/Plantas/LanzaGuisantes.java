package Plantas;

import Entidades.*;

public class LanzaGuisantes extends Planta {

  public LanzaGuisantes() {
    imagen = "/recursos/peashooter.gif";
    imagenProyectil = "/recursos/pea.png";
    danio = 1;
    tiempoDeAtaque = 6;
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
