package GUI;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class finalscreen extends JLayeredPane {

  public finalscreen() {
    this.setBounds(0, 0, 570, 450);
    JLabel lblstart = new JLabel("");
    ImageIcon imagenInicio = new ImageIcon(
      this.getClass().getResource("/recursos/finalscreen.jpg")
    );
    Image start = imagenInicio.getImage();
    start = start.getScaledInstance(570, 450, java.awt.Image.SCALE_SMOOTH);
    imagenInicio = new ImageIcon(start);
    lblstart.setBounds(0, 0, 570, 450);
    lblstart.setIcon(imagenInicio);
    lblstart.setVisible(true);
    setVisible(true);
    setLayout(null);
    add(lblstart, Integer.valueOf(0));

    JButton restart = new JButton("");
    restart.setBounds(35, 232, 89, 193);
    restart.setOpaque(false);
    restart.setOpaque(false);
    restart.setContentAreaFilled(false);
    restart.setBorderPainted(false);
    restart.setVisible(true);
    add(restart, Integer.valueOf(1));

    JButton startScreen = new JButton("");
    startScreen.setBounds(444, 232, 89, 193);
    startScreen.setOpaque(false);
    startScreen.setContentAreaFilled(false);
    startScreen.setBorderPainted(false);
    startScreen.setVisible(true);
    add(startScreen, Integer.valueOf(1));
  }
}
