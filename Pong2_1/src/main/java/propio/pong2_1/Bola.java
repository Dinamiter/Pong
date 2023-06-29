package propio.pong2_1;

import java.awt.Color;
import java.awt.Graphics;

public class Bola {

    private int x, y, cx, cy, velocidad, ancho, alto;
    private Color color;
    

    public Bola(int x, int y, int cx, int cy, int velocidad, int ancho, int alto, Color color) {
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.velocidad = velocidad;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }

    public void moverBola() {
        x += cx;
        y += cy;
        
        System.out.println("X:" + x);
        System.out.println("Y"+ y);

    }

    public void pintar(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, alto, ancho);
    }

    public void pared() {
        if (x < 3) {
            invertirX();
        } else if (x > 460) {
            invertirX();
        }
        if (y < 40) {
            invertirY();
        } else if (y > 460) {
            reset();
          }
    }
    
    public void reset(){
       x=(int) (1 + Math.random() * 500);
       y=150;
    }

    public void invertirX() {
        cx*=(-1);
        System.out.println("invierte x");
    }

    public void invertirY() {
        cy *= -1;
        System.out.println("invierte y");
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    
    

}
