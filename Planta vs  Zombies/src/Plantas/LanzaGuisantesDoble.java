package Plantas;

import java.awt.Image;

import javax.swing.ImageIcon;

import Logica.Nivel;
import Logica.Posicion;
import Proyectil.Proyectil;
import Visitores.Visitor;

public class LanzaGuisantesDoble extends Planta {
	
    
    public LanzaGuisantesDoble(){
    	imagen = "/recursos/repeater.gif";
        vida = 7;
    }
    
    public void atacar() {
        /*aca dispara un gisante asi que se debe hacer la clase guisante */
    	if (hayZombiesEnRango()) {
    		n.setProyectil(new Proyectil(this.posicion, "imagen proyectil",100));
    		//Posicion p = new Posicion (this.posicion.getX() + 50 , this.posicion.getY());
    		//n.setProyectil(new Proyectil(p, "imagen proyectil"));
    	}
    }

	public void move() {
		// TODO Auto-generated method stub
	}
  
}
