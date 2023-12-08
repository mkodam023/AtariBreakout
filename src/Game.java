import processing.core.PApplet;

import java.util.ArrayList;

public class Game extends PApplet {
    // TODO: declare game variables
    Paddle paddle;
    Ball ball;
    int x;
    int points;
    ArrayList<Brick> bricks;
    public void settings() {
        size(800, 800);   // set the window size

    }

    public void setup() {
        // TODO: initialize game variables
        x = 200;
        bricks = new ArrayList<>();
        paddle = new Paddle(x,20, 100,20);
        ball = new Ball(400,600, 30, 2,-5);

        for (int i = 1; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                bricks.add(new Brick(80, j * 40, 80, 40));
              //  System.out.println(bricks.get(x));

            }
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
        textSize(100);
        text(points, 650, 750);



        for (Brick brick : bricks) {
            brick.draw(this);
            System.out.println(brick.x + ", " + brick.y);
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

        if (ball.paddleLeftCollision(paddle)){
            ball.yBorderBounce(this);
            if (ball.x>0) {
                ball.leftPaddleHit(this);
            }
        }
        if (ball.paddleRightCollision(paddle)){
            ball.yBorderBounce(this);
            if (ball.x<0){
                ball.rightPaddleHit(this);
            }
        }

        for (Brick value : bricks) {
            if (ball.x >= value.x && ball.x <= value.x + 80) {
                if (ball.y <= value.y + 40) {
                    value.ifHit(this);
                    ball.yBorderBounce(this);
                    points++;
                }
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("Game");
    }
}