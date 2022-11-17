package Plantas;

import Estados.EstadoEntidad;
import Visitores.Visitor;

public class Nuez extends Planta{
    protected int precio;
    protected int vida;
    protected EstadoEntidad estado;
    protected Visitor visitor;

    public Nuez(){
        precio = 50;
        vida = 20;
        //estado = new EstadoPlanta();
    }

    public int Atacar() {
        /*aca no hace nada*/
        return 0;
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
