package Proyectil;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import Estados.EstadoEntidad;
import Logica.Entidad;
import Logica.Fila;
import Logica.Nivel;
import Logica.Posicion;
import Visitores.Visitor;

public class Proyectil extends Entidad{
	private int danio;
	private Posicion pos;
	private Nivel juego;
	private Map map;
	private String imagen;
	
	public Proyectil(Posicion pos) {
		this.pos = pos;
		danio = 0;
		move();
	}
	
	public void atacar() {
		
	}
	//public Posicion getPosicion(Posicion p) {}

	public void move() {
		while(this.colision()!=true) {
			pos.setY(pos.getY()+1);
		}
	}

	private boolean colision() {
		Fila f = map.getFila(pos.posX());
		return f.getZombies().getBounds().intersects(getBounds());
	}
	/*protected void Colisiones(){
		Point l= arma.getLocation();
		Point n;
		if(vive() && arma.isVisible()){
			for (NaveEnemiga Nave : MiNivel.obtenerNavesEnemigas()) {
				if(Nave.isVisible()){
					n= Nave.getLocation();
					boolean morira= (l.getX()>=n.getX()) && (l.getX()<= n.getX()+ Nave.getWidth()) && n.getY()>=15;
					if (morira ){
						int puntos= Nave.serAtacado();
						setPuntaje(puntos);
						MiNivel.juego.jLabelPuntos.setText(" "+ obtenerPuntaje());				 
					}
				}
			}
		}
	}
	
	*/
	
	public Rectangle getBounds() {
		return new Rectangle(pos.getX(), pos.getY(),50, 50);
	}
	@Override
	public int getVida() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getVelocidad() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getDanio() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getMultiplicador() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public EstadoEntidad getEstado() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void recibirDanio(int danio) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
}
