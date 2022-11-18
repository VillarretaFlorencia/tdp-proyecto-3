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
	protected Image imagen;
    protected int vida;
    protected Posicion posicion;
    protected int precio;
    protected Nivel n = Nivel.getNivel();

    public LanzaGuisantes(){
    	imagen = new ImageIcon(this.getClass().getResource("/recursos/peashooter.png")).getImage();
        vida = 7;
        precio = 50;
    }
    public void atacar() {
        /*aca dispara un gisante asi que se debe hacer la clase guisante */
    	if (hayZombiesEnRango())
    		n.setProyectil(new Proyectil(this.posicion, "imagen proyectil"));      
    }	
}
