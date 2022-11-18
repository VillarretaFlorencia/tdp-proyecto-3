package Plantas;

import java.awt.Image;

import javax.swing.ImageIcon;

import Logica.Nivel;
import Logica.Posicion;
import Visitores.Visitor;

public class Nuez extends Planta{
	protected Image imagen;
    protected int vida;
    protected Posicion posicion;
    protected int precio;
    protected Nivel n = Nivel.getNivel();

    public Nuez(){
    	imagen = new ImageIcon(this.getClass().getResource("/recursos/wallnut_full_life.png")).getImage();
        vida = 7;
        precio = 50;
    }

    public void atacar() {
    	imagen = new ImageIcon(this.getClass().getResource("/recursos/wallnut_half_life.png")).getImage();
    }    
}
