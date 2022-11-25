package Plantas;

import Logica.EntidadGrafica;

public class LanzaGuisantesDoble extends Planta {

  public LanzaGuisantesDoble() {
    imagen = "/recursos/repeater.gif";
    imagenProyectil = "/recursos/pea.png";
    danio = 2;
    tiempoDeAtaque = 5;
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
