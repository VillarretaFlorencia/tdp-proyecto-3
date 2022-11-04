package Plantas;

import Estados.EstadoEntidad;
import Visitores.Visitor;

public class LanzaGuisantesDoble extends Planta {
    protected int precio;
    protected int vida;
    protected int danio;
    protected EstadoEntidad estado;
    protected Visitor visitor;

    public LanzaGuisantesDoble(){
        precio = 200;
        vida = 10;
        danio = 2; //pero dispara dos veces
        //estado = new EstadoPlanta();
    }

    @Override
    public int getVida() {
        return vida;
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
    
}
