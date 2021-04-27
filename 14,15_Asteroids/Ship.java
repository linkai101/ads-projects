import java.awt.*;
import java.awt.event.*;  

class Ship extends Polygon implements KeyListener {
  private int width, height;
  private int health = 100;
  private boolean forward = false;
  private boolean left = false;
  private boolean right = false;
  
  public Ship(Point[] inShape, Point inPosition, double inRotation, int width, int height)
  {
    super(inShape, inPosition, inRotation);
    this.width = width;
    this.height = height;
  }

  public void paint(Graphics brush) {
    int[] xCoords = new int[this.getPoints().length];
    int[] yCoords = new int[this.getPoints().length];
    for (int i=0; i<this.getPoints().length; i++) {
      xCoords[i] = (int) this.getPoints()[i].getX();
      yCoords[i] = (int) this.getPoints()[i].getY();
    }
    brush.fillPolygon(xCoords, yCoords, this.getPoints().length);
  }

  public int getHealth() {
    return health;
  }

  public void takeDamage() {
    health--;
  }

  public void move() {
    Point pos = this.position;
    double stepSize = 4;
    //pos.setX(pos.getX()+stepSize);
    //this.rotation += stepSize; // rotation
    
    if(pos.x > width || pos.x < 0){
      pos.setX(width - pos.x);
    }
    if(pos.y > height || pos.y < 0){
      pos.setY(height - pos.y);
    }
    
    if (forward) {
      pos.setX(pos.x + Math.cos(Math.toRadians(this.rotation))*stepSize);
      pos.setY(pos.y + Math.sin(Math.toRadians(this.rotation))*stepSize);
    }
    if (left){
      this.rotation -= stepSize;
    }
    if (right){
      this.rotation += stepSize;
    }
  }

  public void keyTyped(KeyEvent e) {
    int key = e.getKeyCode();
  }

  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_UP) {
      forward = true;
    }
    if (key == KeyEvent.VK_LEFT) {
      left = true;
    }
    if (key == KeyEvent.VK_RIGHT) {
      right = true;
    }
  }

  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_UP) {
      forward = false;
    }
    if (key == KeyEvent.VK_LEFT) {
      left = false;
    }
    if (key == KeyEvent.VK_RIGHT) {
      right = false;
    }
  }

}