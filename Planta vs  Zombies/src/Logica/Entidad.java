package Logica;

import java.awt.Rectangle;

import javax.swing.JLabel;

import Visitores.Visitor;

public abstract class Entidad {
<<<<<<< Updated upstream
	protected String imagen;
	public abstract Rectangle getBounds();
	public  String getImagen() {return imagen;}
=======
<<<<<<< HEAD
	protected Posicion posicion;
	public abstract Rectangle getBounds();
	public abstract String getImagen();
	public abstract void move();
	public abstract Posicion getPosicion();
=======
	protected String imagen;
	public abstract Rectangle getBounds();
	public  String getImagen() {return imagen;}
>>>>>>> 04ea838d3ee732737fafee29d0a73888593914f5
>>>>>>> Stashed changes

}
