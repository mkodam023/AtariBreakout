import processing.core.PApplet;

public class Ball {
    int x,y, rad;
    //int xSpeed, ySpeed;
    public Ball(int x, int y,int rad){
        this.x = x;
        this.y = y;
//        this.xSpeed = xs;
//        this.ySpeed = ys;
        this.rad = rad;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

//    public void setX(int x) {
//        this.x = x;
//    }

    //public void bounce(){
     //   ySpeed = -1*ySpeed;
   // }

    public void draw(PApplet window){
       window.fill(255,0,0);
       window.ellipse(x,y,rad,rad);
    }
}
