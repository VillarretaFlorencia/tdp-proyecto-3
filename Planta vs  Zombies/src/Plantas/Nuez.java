package Plantas;

import Logica.EntidadGrafica;

public class Nuez extends Planta{
   
	int vidaInicial;
    public Nuez(){
    	imagen = "/recursos/walnut_full_life.gif";
        vida = vidaInicial = 20;
        tiempoDeAtaque = 0;
        entidadGrafica = new EntidadGrafica(ancho, alto);
    }

    
	public void atacar() {
		if (vida == vidaInicial / 2)
			imagen = "/recursos/walnut_half_life.gif";		
	}

	 
}
