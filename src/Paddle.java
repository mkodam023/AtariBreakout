import processing.core.PApplet;

public class Paddle {
        int x,y;
        int xSize;
        int ySize;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Paddle(int x, int y, int xs, int ys){
            this.x = x;
            this.y = y;
            this.xSize = xs;
            this.ySize = ys;
        }

        public void ballHit(){
            //if the ball hits the paddle change ball direction
        }

        public  void draw(PApplet window){
            window.fill(255,255,255);
            window.rect(x, 600, xSize, ySize);
        }


    }