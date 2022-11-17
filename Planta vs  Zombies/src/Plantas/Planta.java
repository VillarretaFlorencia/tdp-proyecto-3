package Plantas;
    import Estados.*;
import Logica.Entidad;
import Logica.Posicion;
import Visitores.*;

public abstract class Planta extends Entidad {
	protected int precio;
    protected int vida;
    protected int soles;
    protected EstadoEntidad estado;
    protected Visitor visitor;
    protected Posicion posicion;
    protected int rango;
    
    public int getVida() {
    	return vida;
    }
    public abstract int Atacar();//este en el caso del girasol en vez de atacar lanza flores y la nuez no hace nada
    
    public int getRango () {return rango;}
    
    public void recibirDanio(int danio) {
    	vida = vida - danio;
    	//aca faltaria que cuando la vida llegue a 0 desaparezca
    }
    public void accept(Visitor v) {
    	v.visit(this);
    }
    public EstadoEntidad getEstadoEntidad() {
    	return estado;
    }
    public Posicion getPosicion() {
    	return posicion;
    }
    public int compareTo (Planta p) {//
    	int res = 0;
    	if (posicion.getY() < p.getPosicion().getY()) 
    		res = -1;
    	else if (posicion.getY() > p.getPosicion().getY()) 
    		res = 1;
    	return res;
    }
    public void setPosicion(Posicion pos) {
    	posicion = pos;
    	rango = 8 - pos.getX();
    }
}
