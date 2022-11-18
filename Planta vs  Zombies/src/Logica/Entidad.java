package Logica;

import java.awt.Rectangle;

import javax.swing.JLabel;

import Visitores.Visitor;

public abstract class Entidad {
	
	public abstract Rectangle getBounds();
	public abstract String getImagen();

}
