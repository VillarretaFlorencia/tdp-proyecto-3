package Logica;

import java.awt.Rectangle;

import javax.swing.JLabel;

import Visitores.Visitor;

public abstract class Entidad {
	protected String imagen;
	public abstract Rectangle getBounds();
	public  String getImagen() {return imagen;}

}
