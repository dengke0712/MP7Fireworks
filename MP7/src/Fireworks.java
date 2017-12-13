import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;


public class Fireworks extends Applet implements MouseListener,Runnable{
	/**
	 * The type Fireworks must implement the inherited abstract method of MouseListener.
	 */
	  public void mouseReleased(MouseEvent e) {
		  
	  }
	   
	  public void mouseEntered(MouseEvent e) {
		  
	  }
	 
	  public void mouseExited(MouseEvent e) {
		  
	  }
	 
	  public void mouseClicked(MouseEvent e) {
		  
	  }
	  //Begin with mouse pressed.
	  public void mousePressed (MouseEvent action) {
		  //Get the coordinates that mouse pressed.
	   	 clickPositionX = action.getX();
         clickPositionY = action.getY();
         
   	     Thread threadForFireworks = new Thread(this);
   	     threadForFireworks.start();
   	     threadForFireworks = null;
	   }

	  
	/**
	 * the coordinates of mouse clicks.
	 */
	int clickPositionX;
    int clickPositionY;
 
    
    public void initiation() {
     	clickPositionX = 0;
   	    clickPositionY = 0;
   	    /**
   	     * set the background color to black.
   	     */
        setBackground(Color.black);
        /**
         * add the mouse listener.
         */
        addMouseListener(this);
    }
  
    
    /**
     * The run method in the Runnable interface
     */
    public void run() {
    	  /**
    	   * Initiate all the variables.
    	   */
    	 
    	  /**
    	   * Create a graphics context for this component.
    	   */
    	  Graphics g1 = getGraphics();
    	  /**
    	   * Record the y coordinate of the moving point. Initiate it to the max height of the screen.
    	   */
    	  int yChange = 400;
    	  /**
    	   * Calculate the waiting time.
    	   */
    	  int waitingTime = 3;
    	  /**
    	   * Record the coordinate user clicks. The thread will change the coordinates.
    	   */
    	  int clickX = clickPositionX;
    	  int clickY = clickPositionY;
    	  
    	  /**
    	   * Three primary colors: red, green, blue. Represented as integers.
    	   */
    	  int r,g,b;
   
    	  
    	  //The following while loop is the effect when fireworks moving upward.
    	  /*If the click position is less than the max height, 
    	    which means when you click in the effective zone.
    	  */
    	  while(yChange > clickY) {
    		  /**
    		   * Subtract the highest point by 5.
    		   */
    		  yChange -= 5;
    		  /**
    		   * The random color of fireworks, in the scope of 55-254, in case the color is too dark.
    		   */
    	      r = (((int)Math.round(Math.random()*4321))%200)+55;
    	      g = (((int)Math.round(Math.random()*4321))%200)+55;
    	      b = (((int)Math.round(Math.random()*4321))%200)+55;
    	      
    	      /**
    	       * Change the graphics to the color randomly generated above.
    	       */
    	      g1.setColor(new Color(r,g,b));
    	      /**
    	       * Draw an oval.
    	       * The center of the oval's x position is the same as the clicked point 
    	       * and y position at the highest point in the screen.
    	       * with length 5 and width 5.
    	       */
    	      g1.fillOval(clickX,yChange,5,5);
    	        
    	      /**
    	       * Change the color and draw ovals.
    	       */
      	    for(int i = 0 ; i <= 10; i++) {
      	    	   if (r > 55) {
      	    		   r -= 20;
      	    	   }
      	    	   if (g > 55) {
      	    		   g -= 20;
      	    	   }
      	    	   if (b > 55) {
      	    		   b -= 20;
      	    	   }          	   
      	    	   
      	    	   g1.setColor(new Color(r,g,b));
          	   g1.fillOval(clickX, yChange + i * 5, 5, 5);
      	    }
      	    
      	    //Use black graphics to draw the same ovals that were colored before
      	    //so that they can disappear in the black background.
      	    g1.setColor(Color.black);
      	    g1.fillOval(clickX,yChange + 5 * 10, 5, 5);
      	    
      	    
      	    //Let the program sleep for a moment to let users see the effect of fireworks.
      	    //Otherwise the drawing work will disappear suddenly.
      	    try {
      	    	   Thread.currentThread().sleep(waitingTime++);
      	    } catch (InterruptedException e) {
      	    	
      	    }
      	       	        	  
    	  }
      	   //Let the string of points disappear that produce when fireworks moving upward.
    	    for(int i = 12; i >= 0; i--) {
    	    	
    	        g1.setColor(Color.black);
    	        g1.fillOval(clickX, yChange + (i * 5), 5, 5);
    	        
       	    try {
   	    	    Thread.currentThread().sleep((waitingTime++)/3);
   	        } catch (InterruptedException e) {
   	    	
   	        }   	  
    	    }
    	  
      	  
    	    //The explosion effect of fireworks.
    	    waitingTime = 15;
      	for(int i = 0; i <= 25; i++) {
      		r = (((int) Math.round(Math.random() * 4321)) % 200) + 55;
            g = (((int) Math.round(Math.random() * 4321)) % 200) + 55;
            b = (((int) Math.round(Math.random() * 4321)) % 200) + 55;
            g1.setColor(new Color(r, g, b));
            g1.drawOval(clickX - 3 * i, clickY - 3 * i, 6 * i, 6 * i);
            if (i < 23) {
                g1.drawOval(clickX - 3 * (i + 1), clickY - 3 * (i + 1), 6 * (i + 1), 6 * (i + 1));
                g1.drawOval(clickX - 3 * (i + 2), clickY - 3 * (i + 2), 6 * (i + 2), 6 * (i + 2));
            }
            
            //sleep for a moment to see the effect.
      	    try {
   	    	    Thread.currentThread().sleep(waitingTime++);
   	        } catch (InterruptedException e) {
   	    	
   	        }
      	    
      	    //Draw black ovals to let colored ovals disappear in the background.
      	    g1.setColor(Color.black);
      	    g1.drawOval(clickX-3*i,clickY-3*i,6*i,6*i);
      	}
      	
    }//end of run method.
    
    
    public static void main (String args []) {
       	Fireworks firework = new Fireworks();
        JFrame frame = new JFrame("frameForFirework");
        
        frame.addWindowListener(new WindowAdapter() {          
        	public void windowClosing(WindowEvent event) {  
            System.exit(0);
          }      	
        });
        
        frame.getContentPane().add(firework, BorderLayout.CENTER);
        frame.setSize(2000,400);
        firework.initiation();
        firework.start();
        frame.setVisible(true);	
    }

 
    }//end of fireworks class

