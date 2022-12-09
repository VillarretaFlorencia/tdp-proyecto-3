package Plantas;

import Entidades.*;

public class HumoSeta extends Planta {

  public HumoSeta() {
    imagen = "/recursos/FumeShroom.gif";
    imagenProyectil = "/recursos/PuffShroom_puff1.png";
    danio = 2;
    tiempoDeAtaque = 2;
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
