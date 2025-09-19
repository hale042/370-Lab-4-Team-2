/*
https://docs.oracle.com/javase/8/docs/api/javax/swing/ImageIcon.html
https://zetcode.com/java/imageicon/
*/ 

// package com.zetcode;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawingPanel extends JPanel { // for the GUI panel?

    private ImageIcon icon; // initialize the image icon var

    public DrawingPanel() { // the window in which the image will be displayed

        loadImage();
        initPanel(); // load image into icon obj and initialize the panel(/window?)
    }

    private void loadImage() { // loading the image into the icon var

        icon = new ImageIcon("Lab4\\Poker cards\\ace_of_spades2.png");
    }
    
    private void initPanel() { // initialize the panel

        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        setPreferredSize(new Dimension(w, h)); // set the window's prefered sized to the dimensions of the input image
    }    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        icon.paintIcon(this, g, 0, 0);
    }
}

public class PaintingIconEx extends JFrame {

    public PaintingIconEx() {

        initUI();
    }

    private void initUI() {

        DrawingPanel dpnl = new DrawingPanel();

        createLayout(dpnl);

        setTitle("Image");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame ex = new PaintingIconEx();
            ex.setVisible(true);
        });
    }
}