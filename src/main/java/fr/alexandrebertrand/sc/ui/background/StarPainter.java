package fr.alexandrebertrand.sc.ui.background;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;

/**
 * Star painter of the game
 * 
 * @author Alexandre Bertrand
 */
public final class StarPainter {
    
    /*
     * Constants
     */
    
    /** Background color of space */
    private static final Color BACKGROUND_COLOR = new Color(30, 30, 30);
    
    /*
     * Constructors
     */
    
    /**
     * Empty private constructor
     */
    private StarPainter() {
    }
    
    /*
     * Methods
     */
    
    /**
     * Paint stars and space background
     * 
     * @param g Graphic context
     */
    public static void paint(Graphics2D g) {
        Star[] stars = StarManager.getStars();
        if (stars == null) {
            return;
        }
        g.setBackground(BACKGROUND_COLOR);
        for (int i = 0; i < stars.length; i++) {
            if (stars[i] != null) {
            	System.out.println(stars[i].getSize());
                g.setPaint(getGradient(stars[i]));
                g.fillOval(stars[i].getPosition().x, stars[i].getPosition().y,
                           stars[i].getSize(), stars[i].getSize());
            }
        }
    }
    
    /**
     * Get gradient of the current star
     * 
     * @param star Star used to determinate the gradient
     * @return Gradient of the star
     */
    public static Paint getGradient(Star star) { // STUB private
        float x = star.getPosition().x + star.getSize() / 2;
        float y = star.getPosition().y + star.getSize() / 2;
        Point2D center = new Point2D.Float(x, y);
        float radius = star.getSize() / 2;
        float[] dist = {0.0f, 0.1f, 0.35f, 0.43f, 1.0f};
        Color[] colors = {
        	Color.WHITE,
        	Color.WHITE,
        	star.getColor(),
            star.getGlowColor(),
            new Color (255, 255, 255, 0)
        };
        return new RadialGradientPaint(center, radius, dist, colors);
    }
    
}
