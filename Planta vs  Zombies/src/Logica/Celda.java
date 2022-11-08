package Logica;

import Estados.EstadoEntidad;
import Visitores.Visitor;

public class Celda extends Entidad{

    @Override
    public int getVida() {
        // TODO Auto-generated method stub
        return 0;
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

    @Override
    public void recibirDanio(int danio) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void accept(Visitor v) {
        // TODO Auto-generated method stub
        
    }
    
}
