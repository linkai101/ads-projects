import java.awt.*;

class Asteroid extends Polygon {
  private int width, height;
  private double angle;

  public Asteroid(Point[] inShape, Point inPosition, double inRotation, int width, int height) {
    super(inShape, inPosition, inRotation);
    this.width = width;
    this.height = height;
    this.angle = Math.random() * 360;
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

//The asteroid moves in a random direction
 public void move() {
    Point pos = this.position;
    double stepSize = Math.random() * 5;
    
    if(pos.x > width || pos.x < 0){
      pos.setX(width - pos.x);
    }
    if(pos.y > height || pos.y < 0){
      pos.setY(height - pos.y);
    }
    pos.setX(pos.x + Math.cos(Math.toRadians(this.angle))*stepSize);
    pos.setY(pos.y + Math.sin(Math.toRadians(this.angle))*stepSize);
  }
}