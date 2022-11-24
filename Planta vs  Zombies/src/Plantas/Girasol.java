package Plantas;
import Visitores.*;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Estados.*;
import Logica.EntidadGrafica;
import Logica.Nivel;
import Logica.Posicion;

public class Girasol extends Planta{

		protected String imagenNormal = "/recursos/sunflower.gif";
		protected String imagenBrillante = "/recursos/sunflowerB.gif";
		int tiempoEnAccion = 1000;
		
    public Girasol(){
        imagen = imagenNormal;
        danio = 0;
        tiempoDeAtaque = 29000;
        entidadGrafica = new EntidadGrafica(imagen);
    }

    //generalizarlo con rango amplio, o sobrescribir el hay zombie en rango con true, o sobrescribir el metodo para evitar el habilidad ya que todos en el fono hacen lo mismo 
    public void atacar() {
    	if (tiempo % tiempoDeAtaque == 0) {
    		imagen = imagenBrillante;
    		n.aumentarSoles();
    	}
    	if (tiempo % (tiempoDeAtaque + tiempoEnAccion) == 0) {
    		imagen = imagenNormal;
    	}
    	tiempo ++;
    }
    

}
