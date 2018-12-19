package fr.alexandrebertrand.sc.ui.background;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
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
    
    /** Glow color of the star */
    private Color glowColor;
    
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
        
        size = 2;
        Random r = new Random();
    	double n = Math.floor(Math.log((Math.random() * t) + 1)/Math.log(l));
    	if (n >= m) {
    		double hn = h - n;
    		double h2 = h / 2;
    		double c = Math.pow(hn, hn / h2) / (h2 / 2);
    		float v = (r.nextFloat() - 1) / 4;
    		size = (int) Math.round(c + c * v);
    	}
    	
    	size = 200; // STUB To delete
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
        
        position = new Point(100, 100); // STUB To delete
    }
    
    /**
     * Initialize the star color
     */
    private void initColor() {
    	Random rand = new Random();
    	
    	double t = 255d;
    	double l = 170d;
    	
    	List<Double> c1 = new ArrayList<>();
    	List<Double> c2 = new ArrayList<>();
    	for (int i = 0; i < 3; i++) {
    		c1.add(t);
    		c2.add(t);
    	}
    	
    	int c = rand.nextInt(6);
    	
    	if (true) { // STUB c == 0
    		int min = rand.nextInt(3);
    		int var = rand.nextInt(2);
    		if (min == var) {
    			min = 2;
    		}
    		
    		double h = (double) rand.nextInt((int) (t + 1));
    		c2.set(min, 0d);
    		c2.set(var, h);
    		
        	c1.set(min, l);
        	double f = (t - h) * l / t;
        	c1.set(var, h + f);
    	}
    	
    	color = new Color(c1.get(0).intValue(), c1.get(1).intValue(),
    			c1.get(2).intValue());
		glowColor = new Color(c2.get(0).intValue(), c2.get(1).intValue(), 
				c2.get(2).intValue(), 50);
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
    
    /**
     * Get glow color of the star
     * 
     * @return Glow color of the star
     */
    public Color getGlowColor() {
        return this.glowColor;
    }
    
}
