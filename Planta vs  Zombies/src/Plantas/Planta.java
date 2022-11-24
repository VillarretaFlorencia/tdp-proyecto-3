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
	  
	protected int vida = 10000;
	protected int tiempoDeAtaque;
	protected int tiempo = 0;
	protected String imagenProyectil;
	
	Nivel n = Nivel.getNivel();
	
	public int getVida() {return vida;}
	
	
    public void atacar() {
    	if (hayZombiesEnRango()) {
    		if (tiempo % tiempoDeAtaque == 0) {
    			System.out.println("IMAGEN PROYECTIL" + imagenProyectil);
    			Proyectil proyectil = new Proyectil(this.posicion, imagenProyectil, danio);
    			proyectil.inicializarEntidadGrafica(imagenProyectil, this.posicion);
    			n.setProyectil(proyectil);     
    		}
    	}
    	tiempo ++;
    }
  
    public boolean hayZombiesEnRango() {
    	
    	Iterator <Zombie> it = n.getFilas().getFila(posicion.getY()).getZombies().iterator();
    	boolean hayEnRango = false;
    	while (it.hasNext() && !hayEnRango) {
    		Zombie z = it.next();
    		hayEnRango = z.getPosicion().getX() >= posicion.getX() && z.getPosicion().getX() < 570;  //esta en el rango
    	}        
    	return hayEnRango;
    }
    
    public void recibirDanio (int d) {vida -= d;}
    
    public Rectangle getBounds() {
		return new Rectangle(getPosicion().getX(), getPosicion().getY(), 60, 60);
	}
    
    public void accept (Visitor v) {
    	v.visit (this);
    }
    
    
}
