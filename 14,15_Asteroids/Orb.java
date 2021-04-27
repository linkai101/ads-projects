import java.awt.*;
import java.lang.Math.*;

class Orb extends Polygon{
  private int width, height;

  public Orb(Point[] inShape, Point inPosition, double inRotation, int width, int height)
  {
    super(inShape, inPosition, inRotation);
    this.width = width;
    this.height = height;
    newPosition();
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

  public void newPosition() {
    this.position = new Point(2*Math.random()*width/3, 2*Math.random()*height/3);
  }
}