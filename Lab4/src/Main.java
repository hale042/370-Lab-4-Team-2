import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        final int IMAGE_WIDTH = 500 / 4;
        final int IMAGE_HEIGHT = 726 / 4;
        File path = new File("Lab4/Poker cards/");
        File[] allFiles = path.listFiles();
        assert allFiles != null;
        BufferedImage[] allImages = new BufferedImage[allFiles.length];
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(allFiles);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;

        JLabel[] label = new JLabel[allFiles.length];
            for (int i = 0; i < allFiles.length; i++) {
                try {
                    list.add(i);
                    allImages[i] = ImageIO.read(allFiles[i]);
                    label[i] = new JLabel();

                    Image newImg = allImages[i].getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH); // scale it the smooth way
                    ImageIcon scaledImage = new ImageIcon(newImg);

                    label[i].setIcon(scaledImage);
                    c.gridx = i % 13;
                    c.gridy = i / 13;
                    frame.add(label[i], c);

                } catch (IOException _) {

                }
            }
        c.gridx = 6;
        c.gridy = 4;

        JButton button1 = new JButton("Shuffle"); // button; setting its text
        button1.setPreferredSize(new Dimension(40, 40));
        frame.add(button1, c); // Adds Button to content pane of frame
        button1.addActionListener(_ -> {

            Collections.shuffle(list);

                for (int i = 0; i < allFiles.length; i++) {
                    Image newImg = allImages[list.get(i)].getScaledInstance(IMAGE_WIDTH,IMAGE_HEIGHT, Image.SCALE_SMOOTH); // scale it the smooth way
                    ImageIcon scaledImage = new ImageIcon(newImg);
                    label[i].setIcon(scaledImage);
                }
        });

        frame.pack();
        frame.setVisible(true);
    }

}