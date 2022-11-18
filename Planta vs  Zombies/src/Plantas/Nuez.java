package Plantas;

import java.awt.Image;

import javax.swing.ImageIcon;

import Logica.Nivel;
import Logica.Posicion;
import Visitores.Visitor;

public class Nuez extends Planta{
   
    public Nuez(){
    	imagen = "/recursos/walnut_full_life.gif";
        vida = 7;
    }

	@Override
	public void atacar() {
		imagen = "/recursos/walnut_half_life.gif";
		
	}

	public void move() {
		// TODO Auto-generated method stub
		
	}
 
}
