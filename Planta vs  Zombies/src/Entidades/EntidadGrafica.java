package Entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Nivel;
import Posicion.Posicion;

/**
 * Esta clase describe el comportamiento de las entidades dentro de la entidad grafica
 * 
 *
 */
public class EntidadGrafica {

  protected int alto;
  protected int ancho;
  protected JLabel label;
  protected Posicion posicion;
  
  Nivel nivel = Nivel.getNivel();
  
  public EntidadGrafica(int ancho, int alto) {
    this.alto = alto;
    this.ancho = ancho;
    label = new JLabel();
  }
  
  /**
   * Cambia la imgaen dentro del label
   * @param imagen
   */
  public void setImagen(String imagen) {
    label.setIcon(new ImageIcon(this.getClass().getResource(imagen)));
  }
  /**
   * cambia la posicion en la pantalla (Pixel x Pixel)
   * @param x
   * @param y
   */
  public void setPosicion(int x, int y) {
	  posicion = new Posicion (x,y);
	  label.setBounds(x,y, ancho, alto);
	  label.setLocation(x, y);
  }
  
  /**
   * Obtiene el ancho de la entidad grafica
   * @return ancho
   */
  public int getAncho() {
	    return ancho;
  }

  /**
   * Obtiene el alto de la entidad grfacica
   * @return alto
   */
  public int getAlto() {
    return alto;
  }

  /**
   * Obtiene el label asociado a la entidad grafica
   * @return JLabel
   */
  public JLabel getLabel() {
    return label;
  }

  /**
   * Obtiene la posicion en pantalla del label
   * @return Posicion
   */
  public Posicion getPosicion () {return posicion;}

  
}
