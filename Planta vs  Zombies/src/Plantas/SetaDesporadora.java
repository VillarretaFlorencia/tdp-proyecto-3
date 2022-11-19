package Plantas;

import java.awt.Image;

import javax.swing.ImageIcon;

import Logica.Nivel;
import Logica.Posicion;
import Proyectil.Proyectil;
import Visitores.Visitor;

public class SetaDesporadora extends Planta{

   
    public SetaDesporadora(){
    	imagen = "/recursos/PuffShroom.gif";
        danio = 500;
    }
    
    public void atacar() {
        /*aca dispara un gisante asi que se debe hacer la clase guisante */
    	if (hayZombiesEnRango())
    		n.setProyectil(new Proyectil(this.posicion, "imagen proyectil", danio));      
    }
    

	public void move() {
		// TODO Auto-generated method stub
		
	}
}
