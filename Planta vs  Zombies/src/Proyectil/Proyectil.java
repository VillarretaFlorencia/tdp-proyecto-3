package Proyectil;

import java.awt.Rectangle;

import Fila.*;
import Logica.Entidad;
import Logica.Nivel;
import Logica.Posicion;
import Visitores.Visitor;

public class Proyectil extends Entidad{
	
	public Proyectil(Posicion pos, String i, int d) {
		posicion = pos;
		danio = d;
		imagen = i;
	}
	
	public void atacar() {
		posicion.setX(posicion.getX()+1);
		entidadGrafica.mover(posicion.getX(),posicion.getY());
	}
	
		
	public Rectangle getBounds() {
		return new Rectangle(posicion.getX(), posicion.getY(),50, 50);
	}
	
	 public void accept (Visitor v) {
	    	v.visit (this);
	 }

	@Override
	public void recibirDanio(int d) {
		// TODO Auto-generated method stub
		
	}
}
