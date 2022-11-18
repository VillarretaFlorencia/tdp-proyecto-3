package Plantas;
import Visitores.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import Estados.*;
import Logica.Nivel;
import Logica.Posicion;

public class Girasol extends Planta{
	
	protected ImageIcon imagen;
    protected int vida;
    protected Posicion posicion;
    protected int precio;
    protected Nivel n = Nivel.getNivel();

    public Girasol(){
    	imagen = new ImageIcon(this.getClass().getResource("/recursos/sunflower.png"));
        vida = 7;
        precio = 50;
        this.setIcon(imagen);
    }

    public void atacar() {
    }
    
    public void setNormal() {
    	//ACA IRIA LA BRILLATE
    	imagen = new ImageIcon(this.getClass().getResource("/recursos/sunflower.png")); 
    	this.setIcon(imagen);
    }
    
    public void setBrillate() {
    	imagen = new ImageIcon(this.getClass().getResource("/recursos/sunflower.png"));
    	this.setIcon(imagen);
    }
    
    
}
