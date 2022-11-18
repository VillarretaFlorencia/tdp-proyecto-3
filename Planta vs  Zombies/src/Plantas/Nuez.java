package Plantas;

import java.awt.Image;

import javax.swing.ImageIcon;

import Logica.Nivel;
import Logica.Posicion;
import Visitores.Visitor;

public class Nuez extends Planta{
    protected int vida;
    protected Posicion posicion;
    protected int precio;
    protected Nivel n = Nivel.getNivel();

    public Nuez(){
    	imagen = "/recursos/walnut_full_life.gif";
        vida = 7;
        precio = 50;
    }

	@Override
	public void atacar() {
		imagen = "/recursos/walnut_half_life.gif";
		
	}
	
	
 
}
