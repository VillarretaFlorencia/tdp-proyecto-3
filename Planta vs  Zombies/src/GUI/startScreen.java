package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class startScreen extends JPanel implements ActionListener {

  private JButton btnStart; // no me mires feo flor esto tiene una razon
  private int ancho = 570;
  private int alto = 450;

  public startScreen() {
    this.setBounds(0, 0, ancho, alto);
    JLabel lblstart = new JLabel("");
    ImageIcon imagenInicio = new ImageIcon(
      this.getClass().getResource("/recursos/start.png")
    );
    Image start = imagenInicio.getImage();
    start = start.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
    imagenInicio = new ImageIcon(start);
    lblstart.setBounds(0, 0, ancho, alto);
    lblstart.setIcon(imagenInicio);
    lblstart.setVisible(true);
    setVisible(true);
    setLayout(null);
    //el boton es transparente aprobechando la estructura de la pantalla de titulo
    btnStart = new JButton();
    btnStart.setBounds(178, 405, 213, 23);
    btnStart.setOpaque(false);
    btnStart.setContentAreaFilled(false);
    btnStart.setBorderPainted(false);
    add(btnStart);
    btnStart.addActionListener(this);
    add(lblstart);
  }

  @Override
  public void actionPerformed(ActionEvent e) {}

  public JButton getStart() {
    return btnStart;
  }
}
