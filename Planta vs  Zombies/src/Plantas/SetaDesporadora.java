package Plantas;

import Estados.EstadoEntidad;
import Visitores.Visitor;

public class SetaDesporadora extends Planta{
    protected int precio;
    protected int vida;
    protected int danio;
    protected EstadoEntidad estado;
    protected Visitor visitor;

    public SetaDesporadora(){
        precio = 25;
        vida = 4;
        danio = 1;
        //estado = new EstadoPlanta();
    }

    @Override
    public int Atacar() {
        /*aca dispara una espora asi que se debe hacer la clase espora */
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
