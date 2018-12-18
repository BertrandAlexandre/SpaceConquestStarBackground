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
        int t = 1000;
        int h = 40;
        int m = 7;
        double l = 1.5;
        
        this.size = 2;
        Random r = new Random();
    	double n = Math.floor(Math.log((Math.random() * t) + 1)/Math.log(l));
    	if (n >= m) {
    		double hn = h - n;
    		double h2 = h / 2;
    		double c = Math.pow(hn, hn / h2) / (h2 - 1);
    		float v = (r.nextFloat() - 1) / 4;
    		this.size = (int) Math.round(c + c * v);
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
            color = new Color(137, 221, 255);
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
    
    
    public void setPosition(Point position) {
        this.position = position;
    }
    
    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(int i) {
    	if (i == 1) {
    		this.color = new Color(255, 222, 132);
    	} else if (i == 2) {
    		this.color = new Color(137, 221, 255);
    	} else if (i == 3) {
    		this.color = new Color(247, 131, 131);
    	} else {
    		this.color = new Color(255, 255, 255);
    	}
    }
    
}
