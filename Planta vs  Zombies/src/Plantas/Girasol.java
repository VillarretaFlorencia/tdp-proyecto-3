package Plantas;
import Visitores.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import Estados.*;
import Logica.Nivel;
import Logica.Posicion;

public class Girasol extends Planta{
   
<<<<<<< HEAD
		String imagenNormal = "/recursos/sunflowerB.png";
		String imagenBrillante = "/recursos/sunflowerB.png";
		int tiempoEnAccion = 1000;
		
=======
	private int tiempo; 
	private String imagenAtaque = "/recursos/sunflowerB.png";
	
>>>>>>> aed03a22f8574e7d8c3d3d924184931434ce3fc1
    public Girasol(){
        imagen = imagenNormal;
        danio = 0;
        tiempoDeAtaque = 29000;
    }

    //generalizarlo con rango amplio, o sobrescribir el hay zombie en rango con true, o sobrescribir el metodo para evitar el habilidad ya que todos en el fono hacen lo mismo 
    public void atacar() {
<<<<<<< HEAD
    	if (tiempo % tiempoDeAtaque == 0) {
    		imagen = imagenBrillante;
    		n.aumentarSoles();
    	}
    	if (tiempo % (tiempoDeAtaque + tiempoEnAccion) == 0) {
    		imagen = imagenNormal;
=======
    	tiempo ++;
    	if (tiempo == 29000) {
    		imagen = imagenAtaque;
    		n.aumentarSoles();
    	}
    	if (tiempo == 30000) {
    		imagen = "/recursos/sunflower.png";
    		tiempo = 0;
>>>>>>> aed03a22f8574e7d8c3d3d924184931434ce3fc1
    	}
    	tiempo ++;
    }

	
     
    
}
