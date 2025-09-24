import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        File path = new File("Lab4/Poker cards/");
        File[] allFiles = path.listFiles();
        assert allFiles != null;
        BufferedImage[] allImages = new BufferedImage[allFiles.length];
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(allFiles);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 13));
        JLabel[] label = new JLabel[allFiles.length];

        int imageWidth = 500;
        int imageHeight = 726;
        int imageScaleValue = 6;

        for (int i = 0; i < allFiles.length; i++) {
            try {
                list.add(i);
                allImages[i] = ImageIO.read(allFiles[i]);
                label[i] = new JLabel();

                Image newImg = allImages[i].getScaledInstance(imageWidth / imageScaleValue, imageHeight / imageScaleValue, Image.SCALE_SMOOTH); // scale it the smooth way
                ImageIcon scaledImage = new ImageIcon(newImg);

                label[i].setIcon(scaledImage);
                frame.add(label[i]);

            } catch (IOException e) {

            }
        }

        JButton button1 = new JButton("button 1"); // button; setting its text
        frame.getContentPane().add(button1); // Adds Button to content pane of frame
        button1.addActionListener(new ActionListener() {
            @Override // overide might not be neccessary here
            public void actionPerformed(ActionEvent E) {
                Collections.shuffle(list);

                for (int i = 0; i < allFiles.length; i++) {
                    Image newImg = allImages[list.get(i)].getScaledInstance(imageWidth / imageScaleValue, imageHeight / imageScaleValue, Image.SCALE_SMOOTH); // scale it the smooth way
                    ImageIcon scaledImage = new ImageIcon(newImg);
                    label[i].setIcon(scaledImage);
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

}