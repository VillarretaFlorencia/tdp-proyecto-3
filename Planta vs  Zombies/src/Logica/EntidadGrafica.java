package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGrafica{
	protected JLabel label;
	
	public EntidadGrafica() {
		label = new JLabel();
	}
	
	public void cambiarImagen(String imagen) {
		label.setIcon(new ImageIcon(this.getClass().getResource(imagen)));
	}
	public JLabel getLabel() {
		return label;
	}
}
