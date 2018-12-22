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

    /** Preferred number of frames per second */
    private static final int FRAMES_PER_SECOND = 60;
    
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
    }
    
    /*
     * Methods
     */

    /**
     * Initialize the board
     */
    public void initBoard() {
        int ms = (int) Math.round(1000d / FRAMES_PER_SECOND);
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
        StarManager.update(getSize());
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
        
        StarPainter.paint(g2);
        
        g2.dispose();
        
    }
    
}
