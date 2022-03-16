package com.company;
import javax.swing.*;
import  java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class MyFrame extends JFrame {
    MyPanel panel;

    public MyFrame(int width, int height){
        panel  = new MyPanel(width,height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        MouseEvents mouseEvents = new MouseEvents(this);

    }

}
class MyPanel extends  JPanel{
    int width;
    int height;
    public int grid_width = 100;
    MyPanel(int width, int height){
        this.height = height;
        this.width = width;
        this.setPreferredSize(new Dimension(width,height));
    }
    public void paint(Graphics g){
        Random rand = new Random();
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d_buff = bufferedImage.createGraphics();
        g2d_buff.setStroke(new BasicStroke(6));
        g2d_buff.setFont(new Font(g2d_buff.getFont().getFontName(),g2d_buff.getFont().getStyle(),50));
        int grid_height = grid_width;
        Dimension grid_block = new Dimension(width/grid_width,height/grid_height);
        for (int y = 0; y < grid_height; y++){
            for (int x = 0; x < grid_width; x++){
                g2d_buff.setColor(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
                g2d_buff.fill(new Rectangle(x*grid_block.width,y*grid_block.height,grid_block.width,grid_block.height));
            }
        }
        g.drawImage(bufferedImage,0,0,this);

    }
}