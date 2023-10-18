import processing.core.PApplet;

public class Paddle {
        int x;
        int xSize;
        int ySize;
        public Paddle(int x, int xs, int ys){
            this.x = x;
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