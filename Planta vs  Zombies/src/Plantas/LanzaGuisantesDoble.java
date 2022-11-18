package Plantas;

import Estados.EstadoEntidad;
import Logica.Nivel;
import Logica.Posicion;
import Proyectil.Proyectil;
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
    public void atacar() {
        /*aca dispara un gisante asi que se debe hacer la clase guisante */
    	if (hayZombiesEnRango()) {
    		n.setProyectil(new Proyectil(this.posicion, "imagen proyectil"));
    		Posicion p = new Posicion (this.posicion.getX() + 50 , this.posicion.getY());
    		n.setProyectil(new Proyectil(p, "imagen proyectil"));
    	}
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
}
