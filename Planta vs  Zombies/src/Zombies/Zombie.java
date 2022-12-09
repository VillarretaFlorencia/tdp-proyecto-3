package Zombies;

import Estados.EstadoZombie;
import Visitores.*;
import java.awt.Rectangle;

import Entidades.*;

public abstract class Zombie extends Entidad {

  //Atributos
  protected int vida;
  protected int velocidad;
  protected int alto = 80;
  protected int ancho = 80;
  protected String imagenNormal;
  protected String imagenAtacando;
  protected EstadoZombie estado;
  protected Visitor visitor;

  //Setters & Getters
  public void setImagen(String i) {
    imagen = i;
  }
  public void setEstado(EstadoZombie e) {
    estado = e;
  }
  
  public void setVisitor(Visitor v) {
    visitor = v;
  }
  
  public int getVida() {
    return vida;
  }

  public int getVelocidad() {
    return velocidad;
  }
  
  public String getImagenAtacando() {
    return imagenAtacando;
  }

  public String getImagenNormal() {
    return imagenNormal;
  }

  public void recibirDanio(int danio) {
    vida -= danio;
  }

  public void atacar() {
    estado.accionar();
  }

  public Rectangle getBounds() {
    return new Rectangle(getPosicion().getX()+50, getPosicion().getY(),ancho,alto);
  }

  public EstadoZombie getEstado() {
    return estado;
  }

  public Visitor getVisitor() {
    return visitor;
  }

}
