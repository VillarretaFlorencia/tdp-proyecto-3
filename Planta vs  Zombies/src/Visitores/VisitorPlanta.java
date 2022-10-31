package Visitores;

import Plantas.Planta;
import Zombies.Zombie;

public class VisitorPlanta extends Visitor {
    Planta planta;

    public VisitorPlanta(Planta planta){
        this.planta = planta;
    }

    @Override
    public void visit(Zombie z) {
        // Falta por hacer
        
    }

    @Override
    public void visit(Planta p) {
        // Falta por hacer
        
    }
    
}
