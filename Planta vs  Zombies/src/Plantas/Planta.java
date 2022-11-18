package Plantas;
    import java.awt.Image;
import java.awt.Rectangle;
import java.util.Iterator;

import javax.swing.ImageIcon;

import Estados.*;
import Logica.Entidad;
import Logica.Nivel;
import Logica.Posicion;
import Proyectil.Proyectil;
import Visitores.*;
import Zombies.Zombie;

public abstract class Planta extends Entidad {
	
    protected int vida;
    protected Posicion posicion;
    protected int precio;
    protected Nivel n = Nivel.getNivel();
    
    //Setters y Getters
    public int getVida() {
    	return vida;
    }
    public Posicion getPosicion() {
    	return posicion;
    }
    public void setPosicion(Posicion pos) {
    	posicion = pos;
    }
    
    //Metodos propios
    public void recibirDanio(int danio) {
    	vida = vida - danio;
    }
    public abstract void atacar();//este en el caso del girasol en vez de atacar lanza soles y la nuez no hace nada
  
    public boolean hayZombiesEnRango() {
    	Nivel n = Nivel.getNivel();
    	Iterator <Zombie> it = n.getFilas().getFila(posicion.getY()).getZombies().iterator();
    	boolean hayEnRango = false;
    	while (it.hasNext() && !hayEnRango) {
    		Zombie z = it.next();
    		hayEnRango = z.getPosicion().getX() >= posicion.getX() && z.getPosicion().getX() < 570;  //esta en el rango
    	}        
    	return hayEnRango;
    }
    public Rectangle getBounds() {
		return new Rectangle(getPosicion().getX(), getPosicion().getY(), 60, 60);
	}
    
}
