package Plantas;

import java.awt.Image;

import javax.swing.ImageIcon;

import Logica.EntidadGrafica;
import Logica.Nivel;
import Logica.Posicion;
import Proyectil.Proyectil;
import Visitores.Visitor;

public class LanzaGuisantesDoble extends Planta {
	
    
    public LanzaGuisantesDoble(){
    	imagen = "/recursos/repeater.gif";
    	imagenProyectil = "/recursos/pea.png";
        danio = 2000;
        tiempoDeAtaque = 1500;
        entidad = new EntidadGrafica();
    }
  
  
}
