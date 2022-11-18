package Plantas;

import java.util.Iterator;

import Estados.EstadoEntidad;
import Logica.Nivel;
import Proyectil.Proyectil;
import Visitores.Visitor;
import Zombies.Zombie;

public class LanzaGuisantes extends Planta{
    protected int precio;
    protected int vida;
    protected int danio;
    protected EstadoEntidad estado;
    protected Visitor visitor;

    public LanzaGuisantes(){
        precio = 100;
        vida = 10;
        danio = 2;
        //estado = new EstadoPlanta();
    }

    public void atacar() {
        /*aca dispara un gisante asi que se debe hacer la clase guisante */
    	if (hayZombiesEnRango())
    		n.setProyectil(new Proyectil(this.posicion, "imagen proyectil"));      
    }

    public void recibirDanio(int danio) {
        vida -= danio;
		if (vida<=0) {
			//autoreMove
			//opcional que se haga desde el nivel
		} 
    }


    public EstadoEntidad getEstadoEntidad() {
        return estado;
    }

    public int getVelocidad() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getDanio() {
        // TODO Auto-generated method stub
        return 0;
    }

    public double getMultiplicador() {
        // TODO Auto-generated method stub
        return 0;
    }

	
}
