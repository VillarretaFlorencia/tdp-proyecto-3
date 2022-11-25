package Plantas;

import Logica.EntidadGrafica;

public class HumoSeta extends Planta {

  public HumoSeta() {
    imagen = "/recursos/FumeShroom.gif";
    imagenProyectil = "/recursos/PuffShroom_puff1.png";
    danio = 2;
    tiempoDeAtaque = 5;
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
}
