package Zombies;

import java.awt.Rectangle;
import Estados.EstadoZombie;
import Logica.Entidad;
import Logica.Posicion;
import Visitores.*;

public abstract class Zombie extends Entidad{
	//Atributos
	protected int vida;
	protected int velocidad;
	protected int danio = 1;
	protected Posicion posicion;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected String imagenNormal;
	protected String imagenAtacando;
	protected String imagen;
	
	//Setters & Getters
	public int getVida(){
		return vida;
	}
	public int getVelocidad(){
		return velocidad;
	}
	public int getDanio(){
		return danio;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion p) {
		posicion = p;
	}
	public EstadoZombie getEstado() {
		return estado;
	}
	public Visitor getVisitor() {
		return visitor;
	}
	public String getImagen(){
		return imagen;
	}
	public String getImagenAtacando(){
		return imagenAtacando;
	}
	public String getImagenNormal(){
		return imagenNormal;
	}
	public void setImagen(String i) {
		imagen = i;
	}
	
	//Metodos propios
	public void recibirDanio (int danio) {
		vida -= danio;
	}
	public void atacar() {
		estado.accionar(this);
	}
		
	public Rectangle getBounds() {
		return new Rectangle(getPosicion().getX(), getPosicion().getY(), 60, 60);
	}
	//public abstract void atacar();
}

