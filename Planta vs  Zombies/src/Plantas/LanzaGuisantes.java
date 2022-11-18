package Plantas;

import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;

import Logica.Nivel;
import Logica.Posicion;
import Proyectil.Proyectil;
import Visitores.Visitor;
import Zombies.Zombie;

public class LanzaGuisantes extends Planta{
   

    public LanzaGuisantes(){
    	imagen = "/recursos/peashooter.gif";
        vida = 7;
    }
    public void atacar() {
        /*aca dispara un gisante asi que se debe hacer la clase guisante */
    	if (hayZombiesEnRango())
    		n.setProyectil(new Proyectil(this.posicion, "imagen proyectil", 50));      
    }

	public void move() {
		// TODO Auto-generated method stub
	}
	
}
