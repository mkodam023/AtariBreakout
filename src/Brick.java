import processing.core.PApplet;

import java.util.ArrayList;

public class Brick {
    int x;
    int y;
    int xSize, ySize;
    boolean ifHit;


    public Brick(int x, int y, int xs, int ys) {
        this.x = x;
        this.y = y;
        ifHit = false;
        this.xSize = xs;
        this.ySize = ys;
    }


    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }


    public void ifHit(PApplet window) {
        this.x = 80000;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(PApplet window) {
        if (y < 40) {
            window.fill(255, 0, 0);       // red

        } else if (y >= 40 && y < 80) {
            window.fill(255, 165, 0);     // orange

        } else if (y >= 80 && y < 120) {
            window.fill(255, 255, 10);   // yellow

        } else if (y >= 120 && y < 140) {
            window.fill(0, 255, 0);      // green

        } else if (y >= 140 && y < 180) {
            window.fill(0, 0, 255);      //blue

        } else if (y >= 180 && y < 240) {
            window.fill(255, 0, 255);    //purple
        }
        window.rect(x,y,xSize,ySize);
    }


    }






