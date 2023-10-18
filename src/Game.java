import processing.core.PApplet;

import java.util.ArrayList;

public class Game extends PApplet {
    // TODO: declare game variables
    Paddle paddle;
    Ball ball;
    int x;
    Brick brick;
    Brick[] bricks;
    public void settings() {
        size(800, 800);   // set the window size

    }

    public void setup() {
        // TODO: initialize game variables
        x = 200;
        bricks = new ArrayList<>();
        paddle = new Paddle(x,20, 100,20);
        ball = new Ball(400,500, 30, 2,-5);
        brick = new Brick(5, 0, 80,40);

        for (int i = 0; i < bricks.length; i++) {
            bricks[i] = new Brick(10 + 13*i, i * 20, 60, 20);
        }
    }

    /***
     * Draws each frame to the screen.  Runs automatically in a loop at frameRate frames a second.
     * tick each object (have it update itself), and draw each object
     */
    public void draw() {
        background(0);
        fill(0,0,255);
        paddle.draw(this);

        for (Brick brick : bricks) {
            brick.draw(this);
        }
        ball.draw(this);
        ball.move(this);
        paddle.move(this);
        if (ball.x>=800){
            ball.xBorderBounce(this);
        }

        if (ball.y>=800){
            ball.y = 400;
        }

        if (ball.x<=0){
            ball.xBorderBounce(this);
        }

        if (ball.y<=0){
            ball.yBorderBounce(this);
        }

        if (ball.paddleCollision(paddle)){
            ball.yBorderBounce(this);

        }
    }

    public static void main(String[] args) {
        PApplet.main("Game");
    }
}
