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

    @Override
    public int Atacar() {
        /*aca no hace nada*/
        return 0;
    }

    @Override
    public void recibirDanio(int danio) {
        vida -= danio;
		if (vida<=0) {
			//autoreMove
			//opcional que se haga desde el nivel
		} 
    }

    @Override
    public EstadoEntidad getEstadoEntidad() {
        return estado;
    }

    @Override
    public int getVelocidad() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getDanio() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getMultiplicador() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public EstadoEntidad getEstado() {
        // TODO Auto-generated method stub
        return null;
    }
}
