package propio.pong2_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Principal {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        Panel panel=new Panel();
        frame.add(panel);

        frame.setSize(500, 500);
        frame.getDefaultCloseOperation();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        Timer timer = new Timer(33, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.logica();
                panel.repaint();
            }
        });
        timer.start();

        
    }

}
