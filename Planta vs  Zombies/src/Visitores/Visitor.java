package Visitores;

import Plantas.Planta;
import Proyectil.Proyectil;

public abstract class Visitor {

  public abstract void visit(Proyectil proyectil);

  public abstract void visit(Planta planta);
}
