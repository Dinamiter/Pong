package propio.pong2_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Panel extends JPanel implements KeyListener {

    Pala pala;
    Bola bola;
    int direccion = 2;
    int puntuacion = 0;
    int altoCampoJuego = 450, anchoCampoJuego = 430;
    boolean punto = false;
    Graphics g;

    public Panel() {

        this.addKeyListener(this);
        this.setFocusable(true);
        pala = new Pala(200, 430, 60, 20, 8);
        bola = new Bola(150, 50, 3, 3, 20, 10, 10, Color.ORANGE);

    }

    @Override
    public void keyTyped(KeyEvent e) {

        System.out.println(e.getKeyChar());
        if (e.getKeyChar() == 'd') {
            direccion = 0;
            if (pala.getX() < 430) {
                pala.moverPala(direccion);
            }

        }
        if (e.getKeyChar() == 'a') {
            direccion = 1;
            if (pala.getX() > 0) {
                pala.moverPala(direccion);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println(e.getKeyCode());
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 485, 485);
        g.setColor(Color.WHITE);
        g.drawString("Puntos: " + puntuacion, 180, 30);
        g.drawRect(5, 35, 470, 470);
        pala.pintar(g);
        bola.pintar(g);   
    }

    public void punto() {
        if (bola.getY() > 460) {
            puntuacion++;
            //reset();
            
        }
    }

    public void tocarPala() {
        int distanciaX = pala.getX() + 60;
        if (bola.getY() > 425) {
            if (bola.getX() > pala.getX() && bola.getX() < distanciaX) {
                bola.invertirY();
            }
        }

    }

    public void logica() {

        bola.pared();
        bola.moverBola();
        tocarPala();
        punto();

    }

}
