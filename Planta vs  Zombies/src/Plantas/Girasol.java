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
    
    public int getVida() {
        return vida;
    }

    public int Atacar() {
        /*aca en vez de atacar lo que hace es soltar un sol */
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
    
    public EstadoEntidad getEstado() {
        // TODO Auto-generated method stub
        return null;
    }
}
