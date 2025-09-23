import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        File path = new File("Lab4/Poker cards/");
        File[] allFiles = path.listFiles();
        BufferedImage[] allImages = new BufferedImage[allFiles.length];

        Arrays.sort(allFiles);
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(4, 13));
        JLabel label[] = new JLabel[allFiles.length];

        for(int i=0; i < allFiles.length; i++){
            try{
                allImages[i] = ImageIO.read(allFiles[i]);
                label[i] = new JLabel();

                Image newImg = allImages[i].getScaledInstance(500 / 3, 726 / 3,  Image.SCALE_SMOOTH); // scale it the smooth way
                ImageIcon scaledImage = new ImageIcon(newImg);

                label[i].setIcon(scaledImage);
                window.add(label[i]);

            }catch(IOException e){

            }
        }
        window.pack();
        window.setVisible(true);
    }

}