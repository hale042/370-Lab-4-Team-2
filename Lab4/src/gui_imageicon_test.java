import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
// import javax.swing.;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
// import java.awt.Image.SCALE_SMOOTH;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
https://www.guru99.com/java-swing-gui.html#what-is-swing-in-java
https://docs.oracle.com/javase/8/docs/api/javax/swing/ImageIcon.html
https://zetcode.com/java/imageicon/
*/

class gui {
    public static void BasicTest() {
        // creating the frame
        JFrame frame = new JFrame("My First GUI"); // window name
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // what function to run when the window is closed
        frame.setSize(300, 300); // window size

        // adding buttons
        JButton button1 = new JButton("button 1"); // button; setting its text
        frame.getContentPane().add(button1); // Adds Button to content pane of frame
        button1.addActionListener(new ActionListener() {
            @Override // overide might not be neccessary here
            public void actionPerformed(ActionEvent e) {
                System.out.println("This is a test");
            }
        });

        // JButton button2 = new JButton("Button 2");
        // frame.getContentPane().add(button2);

        // frame.pack(); // Causes this Window to be sized to fit the preferred size and layouts of its subcomponents. overwritten by the setMinimumSize function
        frame.setVisible(true);
    }

    public static void ChatExample() {
        //Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        // frame.

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar(); // menubar
        JMenu m1 = new JMenu("FILE"); // menu tabs
        JMenu m2 = new JMenu("Help");
        mb.add(m1); // add menu tab to the menu bar
        mb.add(m2);

        JMenuItem m11 = new JMenuItem("Open"); // options under the menu tabs
        JMenuItem m12 = new JMenuItem("Save as");
        m1.add(m11); // add menu item to the menu(tab)
        m1.add(m12);

        JMenuItem m21 = new JMenuItem("Search on the Internet");
        m2.add(m21);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        
        frame.setVisible(true);
    }

    public static void ImageDisplay() {
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creating dimension object for the frame window('s size)
        // https://www.geeksforgeeks.org/java/java-awt-dimension-class/
        int frameWidth = 300;
        int frameHeight = 300;
        Dimension frameDimension = new Dimension(frameWidth, frameHeight);
        // frame.setSize(300, 300);
        // frame.setSize(frameDimension);
        frame.setMinimumSize(frameDimension);
        // frame.getSize().height

        // JLabel label = new JLabel("Hello World");
        // frame.getContentPane().add(label);

        // row = suit, value = column
        // https://www.youtube.com/watch?v=ntirmRhy6Fw
        // try catch for displaying the image
        try {
            ImageIcon image = new ImageIcon("Lab4\\Poker cards\\ace_of_spades2.png"); // create imageicon object
            int imageW = image.getIconWidth();
            int imageH = image.getIconHeight();
            
            // scaling test (https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon)
            Image testImage = image.getImage(); // transform it 
            Image newimg = testImage.getScaledInstance(imageW/2, imageH/2, Image.SCALE_SMOOTH); // scale it the smooth way  
            ImageIcon scaledImage = new ImageIcon(newimg);  // transform it back
            
            // // ImageIcon test = image.getImage();
            // // ImageIcon test = image.getImage().getScaledInstance(frameWidth, frameHeight, SCALE_SMOOTH);
            // ImageIcon test = image.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT);
            
            // JLabel displayField = new JLabel(image); // use jlabel to display image
            JLabel displayField = new JLabel(scaledImage); // use jlabel to display image
            frame.add(displayField);
            // JLabel img2 = new JLabel(image); // use jlabel to display image
            // frame.add(img2);
        } catch (Exception e) {
            System.out.println("Unable to get image");
        }

        frame.pack();
        frame.setVisible(true);
    }

    public static void DisplayImagesFromDirectory(String dir) {
        dir = (dir != null) ? dir : "Lab4\\Poker cards";

        // get the paths of all the files in the image folder
        File directory = new File(dir);
        File[] imagePaths = directory.listFiles();
        
        System.out.println(imagePaths.length);
        
        // might be the hard way...
        ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();

        // print list of file paths
        if (imagePaths != null) {
            for (File file : imagePaths) {
                System.out.println(file.getName());
                // should probably check file extensions :shrug:
            }
        }
        
    }

    public static void listShuffleTest() {
        ArrayList<String> TheList = new ArrayList<String>(Arrays.asList("Apples", "Bananas", "Oranges", "Pears", "Kiwis", "Dragonfruit"));

        JFrame frame = new JFrame("My First GUI"); // window name
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // what function to run when the window is closed
        frame.setSize(300, 300); // window size

        // adding buttons
        JButton button1 = new JButton("button 1"); // button; setting its text
        frame.getContentPane().add(button1); // Adds Button to content pane of frame
        button1.addActionListener(new ActionListener() {
            @Override // overide might not be neccessary here
            public void actionPerformed(ActionEvent e) {
                // print out list
                for (String item : TheList) {
                    System.out.println(item);
                }
                System.out.println("-------------");

                Collections.shuffle(TheList); // use shuffle function from Collections to shuffle the list
            }
        });

        // JButton button2 = new JButton("Button 2");
        // frame.getContentPane().add(button2);

        // frame.pack(); // Causes this Window to be sized to fit the preferred size and layouts of its subcomponents. overwritten by the setMinimumSize function
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        //Schedule a job for the event-dispatching thread("Swing data structures aren't thread-safe")
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // BasicTest();
                // ChatExample();
                // ImageDisplay();
                DisplayImagesFromDirectory(null);
                // listShuffleTest();
            }
        });
    }
}