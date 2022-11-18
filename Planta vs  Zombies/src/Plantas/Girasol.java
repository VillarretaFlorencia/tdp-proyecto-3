package Plantas;
import Visitores.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import Estados.*;
import Logica.Nivel;
import Logica.Posicion;

public class Girasol extends Planta{
    protected int vida;
    protected Posicion posicion;
    protected int precio;
    protected Nivel n = Nivel.getNivel();

    public Girasol(){
    	
        vida = 7;
        precio = 50;
        imagen = "/recursos/sunflower.gif";
    }

    public void atacar() {
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
