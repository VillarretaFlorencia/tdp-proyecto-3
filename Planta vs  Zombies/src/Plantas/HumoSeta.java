package Plantas;

import Estados.EstadoEntidad;
import Visitores.Visitor;

public class HumoSeta extends Planta{
    protected int precio;
    protected int vida;
    protected int danio;
    protected EstadoEntidad estado;
    protected Visitor visitor;

    public HumoSeta(){
        precio = 75;
        vida = 8;
        danio = 1;
        //estado = new EstadoPlanta();
    }

    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public int Atacar() {
        /*aca dispara un monton de esporas en 3 cuadrados delante de el
         * como una escopeta
        */
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
