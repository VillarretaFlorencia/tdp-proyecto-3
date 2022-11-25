package Zombies;

import Estados.EstadoZombie;
import Logica.Entidad;
import Visitores.*;
import java.awt.Rectangle;

public abstract class Zombie extends Entidad {

  //Atributos
  protected int vida;
  protected int velocidad;
  protected EstadoZombie estado;
  protected Visitor visitor;
  protected String imagenNormal;
  protected String imagenAtacando;

  protected int alto = 70;
  protected int ancho = 80;

  //Setters & Getters
  public int getVida() {
    return vida;
  }

  public int getVelocidad() {
    return velocidad;
  }

  public EstadoZombie getEstado() {
    return estado;
  }

  public void setEstado(EstadoZombie e) {
    estado = e;
  }

  public Visitor getVisitor() {
    return visitor;
  }

  public void setVisitor(Visitor v) {
    visitor = v;
  }

  public String getImagenAtacando() {
    return imagenAtacando;
  }

  public String getImagenNormal() {
    return imagenNormal;
  }

  public void setImagen(String i) {
    imagen = i;
  }

  //Metodos propios
  public void recibirDanio(int danio) {
    vida -= danio;
  }

  public void atacar() {
    estado.accionar();
  }

  public Rectangle getBounds() {
    return new Rectangle(
      getPosicion().getX(),
      getPosicion().getY(),
      ancho,
      alto
    );
  }
}
