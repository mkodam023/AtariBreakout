import processing.core.PApplet;

public class Brick {
    int x,y;
    int xSize, ySize;
    boolean ifHit;

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public Brick(int x, int y, int xs, int ys){
        this.x = x;
        this.y = y;
        ifHit = false;
        this.xSize = xs;
        this.ySize = ys;
    }

    public void ifHit(int x, int y){
        // if it gets by a ball make x and y equal large number off screen
    }

    public void draw(PApplet window){
        if (y<=100){
            window.fill(255,0,0);       // red
          //  y=y;
        }else if(y>100&&y<=200){
            window.fill(255,165,0);     // orange
           // y= y+20;
        }else if(y>200&&y<=300){
            window.fill(255,255,10);   // yellow
          //  y=y+40;
        }else if(y>300&&y<=400){
            window.fill(0,255,0);      // green
          //  y=y+60;
        }else if(y>400&&y<=500){
            window.fill(0,0,255);      //blue
           // y=y+80;
        }else if(y>500&&y<=600){
            window.fill(255,0,255);    //purple
           // y = y+100;
        }
        window.rect(x,y,xSize,ySize);
    }
}
