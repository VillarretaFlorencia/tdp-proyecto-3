package Plantas;

import Entidades.*;

public class SetaDesporadora extends Planta {

  public SetaDesporadora() {
    imagen = "/recursos/PuffShroom.gif";
    imagenProyectil = "/recursos/PuffShroom_puff2.png";
    danio = 5;
    tiempoDeAtaque = 4;
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
