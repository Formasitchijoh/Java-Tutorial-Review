
/* 
   An applet that displays four randomly colored rectangles.  Each rectangle is
   a canvas belonging to the class ColorSwatchCanvas.  Every so often, a thread
   picks one of the canvasses at random and changes its color.  The user can 
   change the color of one of the canvasses by clicking on it.
   
   This file is meant to demonstrate nested classes and anonymous classes.
   The thread belongs to the class, Runner, which is a nested class inside
   the RandomColorGrid class.  The MouseListeners that respond to user clicks
   belong to an anonymous class.  See the constructor in the ColorSwatchCanvas
   class.  (This file defines both the RandomColorGrid class and 
   ColorSwatchCanvas classes.  If you complile this file, you get 4 class
   files:  RandomColorGrid.class, ColorSwatchCanvas.class, 
   RandomColorGrid$Runner.class, and ColorSwatchCanvas$1.class.  The latter
   two class files are the nested classes.)

   David Eck
   August 12, 1998
*/

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class RandomColorGrid extends Applet {

   ColorSwatchCanvas canvas0, canvas1, canvas2, canvas3;  //  canvases to be displayed in applet
   
   Thread runner;   // A thread that randomly changes the color of a canvas every so often.
                    // Note that all synchronization in this applet is done on the Thread object.

   volatile int status;  // Status variable for controlling the thread.
   final static int GO = 0, SUSPEND = 1, TERMINATE = 2;  // Possible values for status variable.
   

   class Runner extends Thread {
   
        // The runner for the RandomColorGrid canvas will be an
        // object belonging to this nested class.
        
      public void run() {
            // Run method picks a random canvas, changes it's color, then waits for
            // a random time between 30 and 3029 milliseconds, and then repeats.
         while (status != TERMINATE) {
            synchronized(this) {
               while (status == SUSPEND)  // wait while applet is suspended
                  try { wait(); }
                  catch (InterruptedException e) {  }
            }
            switch ( (int)(4*Math.random()) ) {  // change the color of a randomly chosen canvas
               case 0: canvas0.randomColor(); break;
               case 1: canvas1.randomColor(); break;
               case 2: canvas2.randomColor(); break;
               case 3: canvas3.randomColor(); break;
            }
            synchronized(this) {  // delay for a bit
              try { wait( (int)(3000*Math.random() + 30) ); }
              catch (InterruptedException e) { } 
            }
         }
      } // end run()

   } // end nested class Runner


   public void init() {
         // Initialize the applet.  Create 4 ColorSwatchCanvasses and
         // arrange them in a horizontal grid.
      setBackground(Color.black);
      setLayout(new GridLayout(1,0,2,2));
      canvas0 = new ColorSwatchCanvas();
      canvas1 = new ColorSwatchCanvas();
      canvas2 = new ColorSwatchCanvas();
      canvas3 = new ColorSwatchCanvas();
      add(canvas0);
      add(canvas1);
      add(canvas2);
      add(canvas3);
   }
   

   public Insets getInsets() {
        // Put a 2-pixel black border around the applet.
      return new Insets(2,2,2,2);
   }
   

   public void start() {
         // Applet is being started or restarted.  Create a thread or
         // tell the existing thread to restart.
      status = GO;
      if (runner == null || ! runner.isAlive()) {
         runner = new Runner();
         runner.start();
      }
      else {
         runner.notify();
      }
   }
   

   public void stop() {
         // Applet is about to be stopped.  Tell thread to suspend.
      synchronized(runner) {
         status = SUSPEND;
         runner.notify();
      }
   }
   

   public void destroy() {
         // Applet is about to be destroyed.  Tell thread to terminate.
      synchronized(runner) {
         status = TERMINATE;
         runner.notify();
      }
   }
   

}  // end class RandomColorGridApplets



class ColorSwatchCanvas extends Canvas {

     // A canvas that displays a random color.  It changes to another random color
     // if the user clicks on it, or if the randomColor()  method is called.

   ColorSwatchCanvas() {  // constructor
   
     randomColor();  // Select the canvas's initial random color.
   
     addMouseListener( new MouseAdapter() {  // set up an object to listen for mouse clicks
                         public void mousePressed(MouseEvent evt) {
                           randomColor();
                         }
                    });
   } // end constructor

   void randomColor() {
         // Change the color of the canvas to a random color.
      int r = (int)(256*Math.random());
      int g = (int)(256*Math.random());
      int b = (int)(256*Math.random());
      setBackground(new Color(r,g,b));
      repaint();
   }
   
}  // end class ColorSwatchCanvas
