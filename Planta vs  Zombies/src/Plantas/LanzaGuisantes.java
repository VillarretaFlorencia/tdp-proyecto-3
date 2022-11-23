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
    	imagenProyectil = "/recursos/pea.png";
        danio = 1000;
        tiempoDeAtaque = 3000;
    }
    
  
	
}
