import processing.core.PApplet;

public class Ball {
    int x, y, rad;
    int xSpeed, ySpeed;

    public Ball(int x, int y, int rad, int xs, int ys) {
        this.x = x;
        this.y = y;
        this.xSpeed = xs;
        this.ySpeed = ys;
        this.rad = rad;
    }

    public void draw(PApplet window) {
        window.fill(255, 0, 0);
        window.ellipse(x, y, rad, rad);
    }

    public void xBorderBounce(PApplet window) {
        xSpeed = -xSpeed;
    }

    public void yBorderBounce(PApplet window) {
        ySpeed = -ySpeed;
    }

    public void leftPaddleHit(PApplet window) {
        xSpeed = -xSpeed;
    }

    public void move(PApplet window) {
        x += xSpeed;
        y -= ySpeed;
    }

    public boolean paddleLeftCollision(Paddle paddle) {
        return y >= 590 && y <= 591 && x >= paddle.x && x <= paddle.x + 50;
    }

    public void rightPaddleHit(Game game) {
        xSpeed = -xSpeed;
    }

    public boolean paddleRightCollision(Paddle paddle) {
        return y >= 590 && y <= 591 && x > paddle.x + 50 && x <= paddle.x + 100;
    }
}
