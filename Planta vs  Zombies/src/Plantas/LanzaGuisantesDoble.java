package Plantas;

import java.awt.Image;

import javax.swing.ImageIcon;

import Logica.Nivel;
import Logica.Posicion;
import Proyectil.Proyectil;
import Visitores.Visitor;

public class LanzaGuisantesDoble extends Planta {
	
	protected ImageIcon imagen;
    protected int vida;
    protected Posicion posicion;
    protected int precio;
    protected Nivel n = Nivel.getNivel();

    public LanzaGuisantesDoble(){
    	imagen = new ImageIcon(this.getClass().getResource("/recursos/repeater.png"));
        vida = 7;
        precio = 50;
        this.setIcon(imagen);
    }
    public void atacar() {
        /*aca dispara un gisante asi que se debe hacer la clase guisante */
    	if (hayZombiesEnRango()) {
    		n.setProyectil(new Proyectil(this.posicion, "imagen proyectil"));
    		Posicion p = new Posicion (this.posicion.getX() + 50 , this.posicion.getY());
    		n.setProyectil(new Proyectil(p, "imagen proyectil"));
    	}
    }
}
