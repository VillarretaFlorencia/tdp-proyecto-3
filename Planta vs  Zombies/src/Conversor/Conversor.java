package Conversor;
/**
 * Esta clase ayuda a la conversion de medidas Pixel x Pixel a posiciones validas y visceversa
 * Esta clase sigue el modelo singleton
 *
 */
public class Conversor {

  //las dimensiones de cada cuadrado del jardin es 63 x 63
  protected static final int ladoCuadrado = 63;
  private static Conversor conversor = new Conversor();

  public static Conversor getConversor() {
    return conversor;
  }
  
  /**
   * Convierte un numero posicion a Pixel
   * @param Numero posicion
   * @return posicion en pantalla
   */
  public int convertirPantalla(int numero) {
    return numero * ladoCuadrado;
  }
  
  /**
   * Convierte una posicion de pixel a posicion
   * @param Posicion en pantalla
   * @return Numero posicion
   */
  public int convertirFila(int num) {
    return (int) (Math.floor(num / ladoCuadrado));
  }
  
  /**
   * Convierte el numero recibido por parametro en una coordenada valida para mostrar en pantalla, 
   * de acuerdo a la fila o columna a la que corresponde >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>CHECKEAR
   * @param Posicion en pantalla
   * @return Numero posicion
   */
  public int convertirXY(int num) {
	  int posicion = 0;
	    if (num >= ladoCuadrado && num < (ladoCuadrado*2)) {
	      posicion = ladoCuadrado;
	    }
	    if (num >= (ladoCuadrado*2) && num < (ladoCuadrado*3)) {
	      posicion = (ladoCuadrado*2);
	    }
	    if (num >= (ladoCuadrado*3) && num < (ladoCuadrado*4)) {
	      posicion = (ladoCuadrado*3);
	    }
	    if (num >= (ladoCuadrado*4) && num < (ladoCuadrado*5)) {
	      posicion = (ladoCuadrado*4);
	    }
	    if (num >= (ladoCuadrado*5) && num < (ladoCuadrado*6)) {
	      posicion = (ladoCuadrado*5);
	    }
	    if (num >= (ladoCuadrado*6) && num < (ladoCuadrado*7)) {
		      posicion = (ladoCuadrado*6);
		}
	    if (num >= (ladoCuadrado*7) && num < (ladoCuadrado*8)) {
		      posicion = (ladoCuadrado*7);
		}
	    if (num >= (ladoCuadrado*8)) {
		      posicion = (ladoCuadrado*8);
		}
	    
	    return posicion;
  }
}
