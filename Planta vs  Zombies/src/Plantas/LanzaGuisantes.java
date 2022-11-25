package Plantas;

import Logica.EntidadGrafica;

public class LanzaGuisantes extends Planta {

  public LanzaGuisantes() {
    imagen = "/recursos/peashooter.gif";
    imagenProyectil = "/recursos/pea.png";
    danio = 1;
    tiempoDeAtaque = 10;
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
