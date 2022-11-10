package Plantas;

import Estados.EstadoEntidad;
import Visitores.Visitor;

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

    @Override
    public int Atacar() {
        /*aca dispara un gisante asi que se debe hacer la clase guisante */
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
    public void accept(Visitor v) {
        v.visit(this);
        
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
