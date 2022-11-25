package GUI;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class WinScreen extends JLayeredPane {

	  public WinScreen() {
	    this.setBounds(0, 0, 570, 450);
	    JLabel lblstart = new JLabel("");
	    ImageIcon imagenInicio = new ImageIcon(
	      this.getClass().getResource("/recursos/winscreen.png")
	    );
	    Image start = imagenInicio.getImage();
	    start = start.getScaledInstance(570, 450, java.awt.Image.SCALE_SMOOTH);
	    imagenInicio = new ImageIcon(start);
	    lblstart.setBounds(0, 11, 570, 450);
	    lblstart.setVisible(true);
	    setVisible(true);
	    setLayout(null);
	    add(lblstart, Integer.valueOf(6));
	    }
}
