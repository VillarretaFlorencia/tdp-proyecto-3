package Plantas;

import java.awt.Image;

import javax.swing.ImageIcon;

import Logica.EntidadGrafica;
import Logica.Nivel;
import Logica.Posicion;
import Proyectil.Proyectil;
import Visitores.Visitor;

public class HumoSeta extends Planta{
   

    public HumoSeta(){
    	imagen = "/recursos/FumeShroom.gif";
    	imagenProyectil = "/recursos/PuffShroom_puff1.png";
        danio = 2;
        tiempoDeAtaque = 5;
        entidadGrafica = new EntidadGrafica(ancho, alto);
    }
    
    
    
}
