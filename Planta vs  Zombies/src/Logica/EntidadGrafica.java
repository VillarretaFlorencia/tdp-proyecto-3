package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGrafica{
	protected JLabel label;
	protected int alto;
	protected int ancho;
	
	public EntidadGrafica(int alto, int ancho) {
		label = new JLabel();
		this.alto = alto;
		this.ancho = ancho;
	}
	
	public void setImagen(String imagen) {
		label.setIcon(new ImageIcon(this.getClass().getResource(imagen)));
	}
	public JLabel getLabel() {
		return label;
	}
	public void setPosicion(int x, int y) {
		label.setLocation(x, y);
	}
	
	public void mover (int x, int y) {
		label.move(x,y);
	}
}
