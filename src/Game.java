import processing.core.PApplet;
import processing.core.PImage;

import java.io.*;
import java.util.ArrayList;
//  fix side collision of bricks
// restart game
public class Game extends PApplet {
    // TODO: declare game variables
    Paddle paddle;
    Ball ball;
    PImage cat;
    int x;
    int points;
    int lives;
    ArrayList<Brick> bricks;
    public void settings() {
        size(800, 800);   // set the window size

    }

    public void setup() {
        // TODO: initialize game variables
        x = 0;
        points  = 0;
        lives = 3;
        bricks = new ArrayList<>();
        paddle = new Paddle(x,20, 100,20);
        ball = new Ball(400,600, 30, 2,-5);
        cat = loadImage("cat.jpg");
        cat.resize(800,800);

        // add bricks into list
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                bricks.add(new Brick(i * 80, j * 40, 80, 40));
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
        fill(255,0,0);
        text(lives, 10,750);



        ball.draw(this);
        ball.move(this);
        paddle.move(this);

        for (Brick brick : bricks) {
            brick.draw(this);
        }

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


            // hitting left side of paddle
            if (ball.paddleLeftCollision(paddle)) {
                ball.yBorderBounce(this);
                if (ball.x > 0) {
                    ball.leftPaddleHit(this);
                }
            }
            // hitting right side of paddle
            if (ball.paddleRightCollision(paddle)) {
                ball.yBorderBounce(this);
                if (ball.x < 0) {
                    ball.rightPaddleHit(this);
                }
            }


            // brick collision

            for (Brick value : bricks) {
                    if (ball.y <= value.y + 40) {
                        if (ball.x >= value.x && ball.x <= value.x + 80) {

                          value.ifHit(this);
                        ball.yBorderBounce(this);
                        points+=1;
                    }
                }
            }

            // game over screen
            if (lives <= 0) {
                image(cat, 0, 0);
                text("GAME OVER", 110, 400);
                text("Press r to restart", 10, 200);

            }


        if (keyPressed){
            if (key == 'r'){
                points = 0;
                lives = 3;

                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 6; j++) {

                        bricks.add(new Brick(i * 80, j * 40, 80, 40));
                    }
                }

                for (Brick brick:bricks) {

                    brick.draw(this);
                }
            }
        }

    }

//    public void keyReleased(){
//        if (key == 's'){
//            try {
//                PrintWriter out = new PrintWriter(new FileWriter("../saveGame.txt"));
//                for (int i = 0; i < bricks.size(); i++) {
//                    Brick brick = bricks.get(i);
//                    System.out.println(brick.getX() + ", " + brick.getY());
//                }
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//        if (key == 'l'){
//            bricks.clear();
//            try {
//                BufferedReader in = new BufferedReader( new FileReader("../saveGame.txt"));
//                String line = null;
//                while (){
//
//                    String[] vals = line.split(",");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//
//            }
//        }



    public static void main(String[] args) {
        PApplet.main("Game");
    }

}