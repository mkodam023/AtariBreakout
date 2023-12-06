import processing.core.PApplet;

public class Brick {
    int x;
    int y;
    int xSize, ySize;
    boolean ifHit;



    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public Brick(int x, int y, int xs, int ys){
        this.y = y;
        ifHit = false;
        this.xSize = xs;
        this.ySize = ys;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void ifHit(PApplet window){
        this.x = 800;

    }

    public void draw(PApplet window){
        if (y<20){
            window.fill(255,0,0);       // red
          //  y=y;
        }else if(y>39&&y<=80){
            window.fill(255,165,0);     // orange
           // y= y+20;
        }else if(y>79&&y<=120){
            window.fill(255,255,10);   // yellow
          //  y=y+40;
        }else if(y>119&&y<=160){
            window.fill(0,255,0);      // green
          //  y=y+60;
        }else if(y>159&&y<=200){
            window.fill(0,0,255);      //blue
           // y=y+80;
        }else if(y>199&&y<=240){
            window.fill(255,0,255);    //purple
           // y = y+100;
        }
        window.rect(x,y,xSize,ySize);


    }
}
