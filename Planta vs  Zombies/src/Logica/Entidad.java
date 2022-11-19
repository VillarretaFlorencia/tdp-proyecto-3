package Logica;

import java.awt.Rectangle;

import javax.swing.JLabel;

import Visitores.Visitor;

public abstract class Entidad {

	protected String imagen;
	protected Posicion posicion;
	protected int danio;
	
	
	public abstract Rectangle getBounds();
	public  String getImagen() {return imagen;}
	public void setPosicion (Posicion p) {posicion = p;}
	public Posicion getPosicion() {return posicion;}
	public abstract void move();
	public int getDanio() {return danio;}
	public abstract void recibirDanio (int d);

}
