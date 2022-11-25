package Visitores;

import Plantas.Planta;
import Proyectil.Proyectil;

public abstract class Visitor {

	public abstract void visit (Proyectil p);
	public abstract void visit (Planta p);
}
