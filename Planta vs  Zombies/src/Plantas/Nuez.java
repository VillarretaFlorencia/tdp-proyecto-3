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
    public int getVida() {
        return vida;
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
    public void accept(Visitor v) {
        v.visit(this);
        
    }

    @Override
    public EstadoEntidad getEstadoEntidad() {
        return estado;
    }
}
