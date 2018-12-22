package fr.alexandrebertrand.sc.ui.background;

import java.awt.Dimension;

/**
 * Star manager of the game
 * 
 * @author Alexandre Bertrand
 */
public final class StarManager {
    
    /*
     * Constants
     */
    
    /** Number of stars on the screen */
    public static final int STAR_NUMBER = 1000;
    
    /*
     * Attributes
     */
    
    /** Array of stars to display */
    private static Star[] stars;
    
    /*
     * Constructors
     */
    
    /**
     * Empty private constructor
     */
    private StarManager() {
    }
    
    /*
     * Methods
     */
    
    /**
     * Update stars
     * 
     * @param d Dimension of the board
     */
    public static void update(Dimension d) {
        if (stars == null) {
            stars = new Star[STAR_NUMBER];
        }
        for (int i = 0; i < stars.length; i++) {
            if (stars[i] == null || stars[i].isDead()) {
                stars[i] = new Star(d);
            } else {
            	stars[i].move();
            }
        }
    }
    
    /*
     * Getters & Setters
     */
    
    /**
     * Get stars of the game
     * 
     * @return Array of stars
     */
    public static Star[] getStars() {
        return stars;
    }

}
