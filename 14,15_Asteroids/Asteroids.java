
/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
it is your control center.

*/
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.lang.Math.*;

class Asteroids extends Game {
	static int counter = 0;
  Point[] shipPoints = {
    new Point(0,0),
    new Point(40,10),
    new Point (0,20),
    new Point(10,10)
  };
  Point position = new Point(width/2, height/2);
  Ship rocket = new Ship(shipPoints, position, 0, width, height);

  Point[] asteroidPoints = {
    new Point(0,40),
    new Point(26,18),
    new Point(36,0),
    new Point(20,-16),
    new Point(0,-46),
    new Point(-24,-22),
    new Point(-14,0),
    new Point(-28,22),
  };
  int asteroidCount = 10;
  ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();

  boolean gameOver = false;
  
  static int score = 0;  

  Point[] orbPoints = {
    new Point(-5,-10),
    new Point(5, -10),
    new Point(10, -5),
    new Point(10, 5),
    new Point(5, 10),
    new Point(-5, 10),
    new Point(-10, 5),
    new Point(-10, -5),
  };
  int orbCount = 3;
  ArrayList<Orb> orbs = new ArrayList<Orb>();

  public Asteroids() {
    super("Asteroids!",800,600);
    this.setFocusable(true);
	  this.requestFocus();
    this.addKeyListener(rocket);

    for (int i=0; i<asteroidCount; i++) {
      asteroids.add(new Asteroid(
        asteroidPoints,
        new Point(Math.random()*width, Math.random()*height),
        0,
        width, height)
      );
    }
    for (int i=0; i<orbCount; i++) {
      orbs.add(new Orb(
        orbPoints,
        new Point(Math.random()*width, Math.random()*height),
        0,
        width, height)
      );
    }
  }
  
	public void paint(Graphics brush) {
    if (!gameOver) {
      brush.setColor(Color.black);
      brush.fillRect(0,0,width,height);
      
      // sample code for printing message for debugging
      // counter is incremented and this message printed
      // each time the canvas is repainted
      counter++;
      score++;
      brush.setColor(Color.white);
      brush.drawString("Score: " + (score/100),10,10);
      brush.drawString("Health: " + rocket.getHealth(),10,50);
      rocket.paint(brush);
      rocket.move();

      for (Asteroid asteroid : asteroids) {
        asteroid.paint(brush);
        asteroid.move();

        if (rocket.collides(asteroid)) {
          rocket.takeDamage();
          if (rocket.getHealth() <= 0) gameOver = true;
        }
      }

      for (Orb orb : orbs) {
        orb.paint(brush);
        if (rocket.collides(orb)) {
          score += 1000;
          orb.newPosition();
        }
      }
    } 
    else {
      brush.setColor(Color.black);
      brush.fillRect(0,0,width,height);
      brush.setColor(Color.red);
      brush.drawString("Game over!",width/2,height/2);
      brush.drawString("Your score was: " + (score/100), width/2, height/2 + 30);
    }
    
  }
  
	public static void main(String[] args) {
    Asteroids a = new Asteroids();
		a.repaint();
  }
}