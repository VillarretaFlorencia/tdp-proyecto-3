package Plantas;
import Visitores.*;
import Estados.*;
public class Girasol extends Planta{
    protected int precio;
    protected int vida;
    protected int soles;
    protected EstadoEntidad estado;
    protected Visitor visitor;

    public Girasol(){
        precio = 50;
        vida = 7;
        soles = 50;
        //estado = new EstadoPlanta();
    }

    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public int Atacar() {
        /*aca en vez de atacar lo que hace es soltar un sol */
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
