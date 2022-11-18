package Plantas;
    import java.util.Iterator;

import Estados.*;
import Logica.Entidad;
import Logica.Nivel;
import Logica.Posicion;
import Proyectil.Proyectil;
import Visitores.*;
import Zombies.Zombie;

public abstract class Planta extends Entidad {
	protected int precio;
    protected int vida;
    protected int soles;
    protected EstadoEntidad estado;
    protected Visitor visitor;
    protected Posicion posicion;
    protected int rango;
    protected Nivel n = Nivel.getNivel();
    public int getVida() {
    	return vida;
    }
    public abstract void atacar();//este en el caso del girasol en vez de atacar lanza flores y la nuez no hace nada
    
    public int getRango () {return rango;}
    
    public void recibirDanio(int danio) {
    	vida = vida - danio;
    	//aca faltaria que cuando la vida llegue a 0 desaparezca
    }
    
    
    public EstadoEntidad getEstadoEntidad() {
    	return estado;
    }
    public Posicion getPosicion() {
    	return posicion;
    }
    public void setPosicion(Posicion pos) {
    	posicion = pos;
    	rango = 8 - pos.getX();
    }
    
    public boolean hayZombiesEnRango() {
    	Nivel n = Nivel.getNivel();
    	Iterator <Zombie> it = n.getFilas().getFila(posicion.getY()).getZombies().iterator();
    	boolean hayEnRango = false;
    	while (it.hasNext() && !hayEnRango) {
    		Zombie z = it.next();
    		hayEnRango = z.getPosicion().getX() >= posicion.getX() && z.getPosicion().getX() < 570;  //esta en el rango
    	}        
    	return hayEnRango;
    }
}
