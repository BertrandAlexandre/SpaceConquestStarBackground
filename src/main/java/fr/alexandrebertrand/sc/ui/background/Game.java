package fr.alexandrebertrand.sc.ui.background;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Toolkit;

/**
 * Entry point of the game
 * 
 * @author Alexandre Bertrand
 */
public class Game extends JFrame {

    /*
     * Constructors
     */

    /**
     * Constructor to initialize the UI view
     */
    public Game() {
        initUI();
    }

    /*
     * Methods
     */

    /**
     * Initialize the UI view
     */
    public void initUI() {
        add(new Board());
        
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setTitle("Space Conquest Star Background");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Launcher of the game
     * 
     * @param args Main arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Game ex = new Game();
            ex.setVisible(true);
        });
    }

}
