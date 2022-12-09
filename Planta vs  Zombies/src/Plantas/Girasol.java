package Plantas;

import Entidades.*;

public class Girasol extends Planta {

  protected String imagenNormal = "/recursos/sunflower.gif";
  protected String imagenBrillante = "/recursos/sunflowerB.gif";
  int tiempoEnAccion = 3;

  public Girasol() {
    imagen = imagenNormal;
    tiempoDeAtaque = 16;
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }

  
  public void atacar() {
	tiempoActual++;
    if (tiempoActual % tiempoDeAtaque == 0) {
      imagen = imagenBrillante;
      entidadGrafica.setImagen(imagenBrillante);
    }
    if (tiempoActual % (tiempoDeAtaque + tiempoEnAccion) == 0) {
      imagen = imagenNormal;
      entidadGrafica.setImagen(imagenNormal);
      nivel.actualizarSoles(nivel.getValorSol());
    }
  }
  
}
