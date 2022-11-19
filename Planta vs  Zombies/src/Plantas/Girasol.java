package Plantas;
import Visitores.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import Estados.*;
import Logica.Nivel;
import Logica.Posicion;

public class Girasol extends Planta{
   
	private int tiempo; 
	
    public Girasol(){
    	tiempo = 0;
        imagen = "/recursos/sunflower.gif";
        danio = 0;
    }

    public void atacar() {
    	tiempo ++;
    	if (tiempo == 29000) {
    		imagen = "/recursos/sunflowerB.png";
    		n.aumentarSoles();
    	}
    	if (tiempo == 30000) {
    		imagen = "/recursos/sunflower.png";
    	}
  	
    	// quizas poner sol con contador de tiempo;
    	// que en determinado tiempo vuelva a la imagen normal
    }  
           
    public void setNormal() {
    	//ACA IRIA LA BRILLATE
    	imagen = "/recursos/sunflower.png";
    }
    
    public void setBrillate() {
    	imagen = "/recursos/sunflowerB.png";
    }

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
    
    
}
