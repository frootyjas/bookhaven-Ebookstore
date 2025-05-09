
package com.bookstore.casestudy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Jerickson Mayor
 */
    public class RoundedPanel extends JPanel {

    /** Stroke size. it is recommended to set it to 1 for better view */
    protected int strokeSize = 0;
    /** Color of shadow */
    protected Color shadowColor = Color.black;
    /** Sets if it drops shadow */
    protected boolean shady = true;
    /** Sets if it has an High Quality view */
    protected boolean highQuality = true;
    /** Double values for Horizontal and Vertical radius of corner arcs */
    protected Dimension arcs = new Dimension(45, 45);
    /** Distance between shadow border and opaque panel border */
    protected int shadowGap = 0;
    /** The offset of shadow.  */
    protected int shadowOffset = 0;
    /** The transparency value of shadow. ( 0 - 255) */
    protected int shadowAlpha = 0;

    public RoundedPanel(Dimension arcs, int strokeSize) {
        super();
        this.arcs = arcs;
        this.strokeSize = strokeSize;
        
        
        setOpaque(false);
   }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int shadowGap = this.shadowGap;
        Color shadowColorA = new Color(shadowColor.getRed(), shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
        Graphics2D graphics = (Graphics2D) g;
        
        // Sets antialiasing if HQ.
        if (highQuality) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        
        // Draws shadow borders if any.
        if (shady) {
            graphics.setColor(shadowColorA);
            graphics.fillRoundRect(
                    shadowOffset, // X position
                    shadowOffset, // Y position
                    width - shadowOffset, // width
                    height - shadowOffset, // height
                    arcs.width, arcs.height); // arc Dimension
        } else {
            shadowGap = 1;
        }
        
        // Draws the rounded opaque panel.
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);
        
        // Sets strokes to default, is better.
        graphics.setStroke(new BasicStroke());
    }
    }
        

