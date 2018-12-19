package fr.alexandrebertrand.sc.ui.background;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Board of the game
 * 
 * @author Alexandre Bertrand
 */
public class Board extends JPanel implements ActionListener {
    
    /*
     * Constants
     */

    /** Preferized number of fraps per second */
    private static final int FRAPS_PER_SECOND = 60;
    
    private int a = 1; // STUB to delete
    
    private Star s; // STUB to delete
    
    /*
     * Attributes
     */

    /** Main timer of the game */
    private Timer timer;
        
    /*
     * Constructors
     */
    
    /**
     * Initialize the board and the game
     */
    public Board() {
        super();
        initBoard();
        s = new Star(getSize());
    }
    
    /*
     * Methods
     */

    /**
     * Initialize the board
     */
    public void initBoard() {
        int ms = (int) Math.round(1000d / FRAPS_PER_SECOND);
        timer = new Timer(ms, this);
        timer.start();
        setOpaque(true);
        setBackground(new Color(30, 30, 30));
    }

    /**
     * Performed action
     * 
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        manageLoop();
        repaint();
    }

    /**
     * Manage current loop operations
     */
    private void manageLoop() {
        // StarManager.update(getSize()); // STUB to uncomment
    }
    
    /**
     * Paint components
     * 
     * @param g Graphic context
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        //StarPainter.paint(g2); // STUB to uncomment
        
        /* STUB BEGIN To delete */
        if (a % 50 == 0) {
	        s = new Star(getSize());
	        a = 1;
        }
        a++;
        g2.setPaint(StarPainter.getGradient(s));
        g2.fillOval(s.getPosition().x, s.getPosition().y,
                    s.getSize(), s.getSize());
        /* STUB END To delete */
        
        g2.dispose();
        
    }
    
}
