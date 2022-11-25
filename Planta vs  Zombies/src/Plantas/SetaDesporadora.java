package Plantas;

import Logica.EntidadGrafica;

public class SetaDesporadora extends Planta {

  public SetaDesporadora() {
    imagen = "/recursos/PuffShroom.gif";
    imagenProyectil = "/recursos/PuffShroom_puff2.png";
    danio = 5;
    tiempoDeAtaque = 15;
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
