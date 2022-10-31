package Plantas;
    import Estados.*;
import Logica.Entidad;
import Visitores.*;

public abstract class Planta extends Entidad {
    public abstract int getVida();
    public abstract int Atacar();//este en el caso del girasol en vez de atacar lanza flores y la nuez no hace nada
    public abstract void recibirDanio(int danio);
    public abstract void accept(Visitor v);
    public abstract EstadoEntidad getEstadoEntidad();
}
