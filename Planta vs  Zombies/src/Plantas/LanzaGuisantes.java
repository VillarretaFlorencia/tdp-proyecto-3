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

    public int Atacar() {
        /*aca dispara un gisante asi que se debe hacer la clase guisante */
        return 0;
    }

    public void recibirDanio(int danio) {
        vida -= danio;
		if (vida<=0) {
			//autoreMove
			//opcional que se haga desde el nivel
		} 
    }

    public void accept(Visitor v) {
        v.visit(this);        
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
