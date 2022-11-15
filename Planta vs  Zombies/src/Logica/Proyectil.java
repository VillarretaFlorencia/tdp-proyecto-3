package Logica;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

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
}
