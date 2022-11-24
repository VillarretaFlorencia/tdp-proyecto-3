package Logica;

import javax.swing.JLabel;

public class EntidadGrafica{
	protected JLabel imagen;
	protected Posicion pos;
	
	public EntidadGrafica() {
		imagen = new JLabel();
	}
	
	public void setImagen(JLabel i) {
		imagen = i;
	}
	public JLabel getImagen() {
		return imagen;
	}
	public void setPosicion(Posicion p) {
		pos = p;
	}
	public Posicion getPosicion() {
		return pos;
	}
}
