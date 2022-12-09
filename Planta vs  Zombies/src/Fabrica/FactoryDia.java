package Fabrica;

import Plantas.LanzaGuisantes;
import Plantas.LanzaGuisantesDoble;
import Plantas.Planta;
/**
 * Esta clase define el comportamiento de la fabrica durante los niveles de dia
 * 
 *
 */
public class FactoryDia extends Factory {
	
  public Planta createPlantaA() {
    Planta lanzaGuisantes = new LanzaGuisantes();
    return lanzaGuisantes;
  }

  public Planta createPlantaB() {
    Planta lanzaGuisantesD = new LanzaGuisantesDoble();
    return lanzaGuisantesD;
  }
}
