
package propio.pong2_1;

import java.awt.Color;
import java.awt.Graphics;



public class Pala {
    
    
    private int x,y,cx,cy, velocidad;
    

    public Pala(int x, int y, int cx, int cy, int velocidad) {
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.velocidad = velocidad;
    }

    public void pintar(Graphics g){     
        g.setColor(Color.red);
        g.drawRect(x, y, 60, 20);   
    }
    
    public void moverPala(int direccion){
        
        
        if (direccion==0){
            x+=velocidad;
        } 
        if (direccion ==1){
            x-=velocidad;
        }
        
    }
    
    

    public int getX() {
        return x;
    }
    
    
    
    
    
    
}
