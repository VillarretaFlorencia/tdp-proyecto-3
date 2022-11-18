package Logica;

import java.awt.Rectangle;

import javax.swing.JLabel;

import Visitores.Visitor;

public abstract class Entidad {

	protected String imagen;
	protected Posicion posicion;
	
	public abstract Rectangle getBounds();
	public  String getImagen() {return imagen;}
	public abstract void move();
	public Posicion getPosicion() {return posicion;}

}
