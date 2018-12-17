package fr.alexandrebertrand.sc.ui.background;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;

/**
 * Star entity with random attributes
 * 
 * @author Alexandre Bertrand
 */
public class Star {
    
    /*
     * Attributes
     */
    
    /** Current position of the star */
    private Point position;
    
    /** Size of the star */
    private int size;
    
    /** Color of the star */
    private Color color;
    
    /*
     * Constructors
     */
    
    /**
     * Initialize a star with position, size and color
     * 
     * @param d Dimensions of the board
     */
    public Star(Dimension d) {
        initSize();
        initPosition(d);
        initColor();
    }
    
    /*
     * Methods
     */
    
    /**
     * Initialize the star size
     */
    private void initSize() {
        Random r = new Random();
        int n = r.nextInt(12);
        if (0 <= n && n <= 8) {
            size = 18;
        } else if (9 <= n && n <= 10) {
            size = 24;
        } else {
            size = 32;
        }
    }
    
    /**
     * Initialize the star position
     * 
     * @param d Dimensions of the board
     */
    private void initPosition(Dimension d) {
        Random r = new Random();
        int x = r.nextInt((int) d.getWidth() + size * 2) - size;
        int y = r.nextInt((int) d.getHeight() + size * 2) - size;
        position = new Point(x, y);
    }
    
    /**
     * Initialize the star color
     */
    private void initColor() {
        Random r = new Random();
        int n = r.nextInt(60);
        if (0 <= n && n <= 50) {
            color = new Color(255, 255, 255);
        } else if (51 <= n && n <= 54) {
            color = new Color(255, 222, 132);
        } else if (55 <= n && n <= 57) {
            color = new Color(122, 153, 255);
        } else {
            color = new Color(247, 131, 131);
        }
    }
    
    /*
     * Getters & Setters
     */
    
    /**
     * Indicate if star is dead
     * Seams that star is out of the screen
     * 
     * @return true if star is dead,
     *         else false
     */
    public boolean isDead() {
        if (position.x + size < 0) {
            return true;
        } // else
        return false;
    }
    
    /**
     * Get current position of the star
     * 
     * @return Position of the star
     */
    public Point getPosition() {
        return this.position;
    }
    
    /**
     * Get size of the star
     * 
     * @return Size of the star
     */
    public int getSize() {
        return this.size;
    }
    
    /**
     * Get color of the star
     * 
     * @return Color of the star
     */
    public Color getColor() {
        return this.color;
    }
    
}
