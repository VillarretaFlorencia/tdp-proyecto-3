package Plantas;
    import java.awt.Image;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import Conversor.Conversor;
import Estados.*;
import Logica.Entidad;
import Logica.Nivel;
import Logica.Posicion;
import Proyectil.Proyectil;
import Visitores.*;
import Zombies.Zombie;

public abstract class Planta extends Entidad {
	  
	protected int vida = 5;
	protected int tiempoDeAtaque;
	protected int tiempo = 0;
	protected String imagenProyectil;
	protected int alto = 70;
	protected int ancho = 60;
	Conversor conversor = Conversor.getConversor();
	
	
	Nivel nivel = Nivel.getNivel();
	
	public int getVida() {return vida;}
	
	
    public void atacar() {
    	if (hayZombiesEnRango()) {
    		if (tiempo % tiempoDeAtaque == 0) {
    			System.out.println("IMAGEN PROYECTIL" + imagenProyectil);
    			Proyectil proyectil = new Proyectil(new Posicion (posicion.getX(), posicion.getY()), imagenProyectil, danio);
    			proyectil.inicializarEntidadGrafica(imagenProyectil, this.posicion);
    			nivel.setProyectil(proyectil);     
    		}
    	}
    	tiempo ++;
    }
  
    public boolean hayZombiesEnRango() {
    	
		int pos = conversor.convertirFila(posicion.getY());
		LinkedList <Zombie> copiaZombies = (LinkedList<Zombie>) nivel.getFilas().getFila(pos).getZombies().clone();
    	Iterator <Zombie> it = copiaZombies.iterator();
    	boolean hayEnRango = false;
    	while (it.hasNext() && !hayEnRango) {
    		Zombie z = it.next();
    		hayEnRango = z.getPosicion().getX() >= posicion.getX() && z.getPosicion().getX() < 570;  //esta en el rango
    	}        
    	return hayEnRango;
    }
    
    public void recibirDanio (int d) {vida = vida - d;}
    
    public Rectangle getBounds() {
		return new Rectangle(getPosicion().getX(), getPosicion().getY(), ancho, alto);
	}
    
    public void accept (Visitor v) {
    	v.visit (this);
    }
    
    
}
