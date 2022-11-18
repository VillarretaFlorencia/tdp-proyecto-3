package Plantas;
import Visitores.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import Estados.*;
import Logica.Nivel;
import Logica.Posicion;

public class Girasol extends Planta{
	
	protected Image imagen;
    protected int vida;
    protected Posicion posicion;
    protected int precio;
    protected Nivel n = Nivel.getNivel();

    public Girasol(){
    	imagen = new ImageIcon(this.getClass().getResource("/recursos/sunflower.png")).getImage();
        vida = 7;
        precio = 50;
    }

    public void atacar() {
    }
    
    public void setNormal() {
    	//ACA IRIA LA BRILLATE
    	imagen = new ImageIcon(this.getClass().getResource("/recursos/sunflower.png")).getImage(); 
    }
    
    public void setBrillate() {
    	imagen = new ImageIcon(this.getClass().getResource("/recursos/sunflower.png")).getImage();
    }
}
