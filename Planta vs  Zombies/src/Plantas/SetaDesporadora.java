package Plantas;

import java.awt.Image;

import javax.swing.ImageIcon;

import Logica.EntidadGrafica;
import Logica.Nivel;
import Logica.Posicion;
import Proyectil.Proyectil;
import Visitores.Visitor;

public class SetaDesporadora extends Planta{

   
    public SetaDesporadora(){
    	imagen = "/recursos/PuffShroom.gif";
    	imagenProyectil = "/recursos/PuffShroom_puff2.png";
        danio = 500;
        tiempoDeAtaque = 1500;
        entidadGrafica = new EntidadGrafica(imagen);
    }
    
}
