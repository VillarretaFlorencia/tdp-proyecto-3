package Logica;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AutoRemove extends Thread {

  protected JLabel label;
  protected JPanel panel;

  public AutoRemove(JLabel label, JPanel panel) {
    this.label = label;
    this.panel = panel;
  }

  public void run() {
    try {
      Thread.sleep(800);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    this.panel.remove(this.label);
    panel.repaint();
  }
}
