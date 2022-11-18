package Plantas;
import Visitores.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import Estados.*;
import Logica.Nivel;
import Logica.Posicion;

public class Girasol extends Planta{
   
    public Girasol(){
    	
        vida = 7;
        imagen = "/recursos/sunflower.gif";
    }

    public void atacar() {
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
