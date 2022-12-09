package Entidades;

import java.awt.Rectangle;

import Posicion.Posicion;
/**
 * Esta clase describe los comportamientos de cada entidad(plantas, proyectiles y zombies) en el juego.
 * 
 *
 */
public abstract class Entidad {	
  protected int danio;//Cantidad de daño de 
  protected int ancho;//ancho de la hitbox
  protected int alto;//alto de la hitbox
  protected Posicion posicion;//posicion de la entidad esta puede ser en pantalla o valida
  protected String imagen;//imagen asociada a la entidad
  protected EntidadGrafica entidadGrafica;//entidad grafica asociada a la entidad

  /**
   * Cambia la posicion de la entidad
   * @param Posicion (En pantalla o Valida)
   */
  public void setPosicion(Posicion p) {
    posicion = p;
  }
  
  /**
   * Obtiene el daño capaz de producir la entidad
   * @return Daño de la entidad
   */
  public int getDanio() {
    return danio;
  }
  
  /**
   * Obtiene la posicion de la entidad (En pantalla o valida)
   * @return Posicion
   */
  public Posicion getPosicion() {
    return posicion;
  }
  
  /**
   * Obtiene la ruta de la imagen asociada a la entidad
   * @return String
   */
  public String getImagen() {
    return imagen;
  }
  
  /**
   * Obtiene la entidad grafica asociada a la entidad
   * @return Entidad Grafica
   */
  public EntidadGrafica getEntidadGrafica() {
    return entidadGrafica;
  }
  
  /**
   * Este metodo ayuda a la entidad grafica a inicializarse dentro de la EntidadGrafica
   * @param String ruta imagen
   * @param posicion Pixel
   */
  public void inicializarEntidadGrafica(String imagen, Posicion posicion) {
    entidadGrafica.setImagen(imagen);
    entidadGrafica.setPosicion(posicion.getX(), posicion.getY());
  }
   
  /**
   * Este metodo la entidad ataca a otra entidad
   */
  public abstract void atacar();
  
  /**
   * obtiene la hitbox de la entidad
   * @return Rectangulo
   */
  public abstract Rectangle getBounds();
}
