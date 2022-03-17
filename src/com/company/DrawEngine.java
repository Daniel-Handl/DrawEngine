package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import  java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
public class DrawEngine {

    int width,height,FPS;
    boolean running = true;

    public DrawEngine(int width, int height, int FPS){
        this.FPS = FPS;
        this.width = width;
        this.height = height;

        MyFrame frame = new MyFrame(width,height,this);
        long ftime = System.currentTimeMillis();
        long stime = System.currentTimeMillis();
        int count = 0;
        int miliseconds = 1000/FPS;
        long wait;
        frame.paint(frame.getGraphics());
        while(running){
            if (System.currentTimeMillis() - stime > miliseconds){
                stime = System.currentTimeMillis();
                //vykresli
                frame.paint(frame.getGraphics());
                count++;
            }
            if (System.currentTimeMillis() - ftime>= 5000){
                ftime = System.currentTimeMillis();
                Refresh();
                frame.setTitle(count/5 + "FPS");
                count = 0;
            }
        }
    }
    public void Stop(){running = false;}
    public void Refresh(){
        Main.Update();
    }
    public void mouseMove(MouseEvent e){

    }
    public void mousePressed(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
    }
    public BufferedImage Draw(BufferedImage g2d){
        return g2d;
    }

}
class MyFrame extends JFrame {
    MyPanel panel;
    public MyFrame(int width, int height, DrawEngine instance){
        panel  = new com.company.MyPanel(width,height,instance);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        MouseEvents mouseEvents = new MouseEvents(this,instance);

    }




}
class MyPanel extends  JPanel{
    int width;
    int height;
    DrawEngine instance;
    MyPanel(int width, int height,DrawEngine instance){
        this.instance = instance;
        this.height = height;
        this.width = width;
        this.setPreferredSize(new Dimension(width,height));
    }
    public void paint(Graphics g){
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        Dimension grid_block = new Dimension((width)/ Main.field.length,(height)/Main.field[0].length);
        for (int y = 0; y <  Main.field[0].length; y++){
            for (int x = 0; x <  Main.field.length; x++){
                if ((Integer) Main.field[x][y] == 0) g2d.setColor(new Color(0,0,0));
                else g2d.setColor(new Color(255,255,255));
                g2d.fill(new Rectangle(x*grid_block.width,y*grid_block.height,grid_block.width,grid_block.height));
            }
        }
        g.drawImage(bufferedImage,0,0,this);

    }
}
 class MouseEvents implements MouseListener,MouseMotionListener {
    JFrame frame;
     DrawEngine instance;
    public MouseEvents(JFrame frame, DrawEngine instance){
        frame.addMouseListener(this);
        this.frame = frame;
    }

    public void mouseMoved(MouseEvent e) {
        Main.Moved(e);
    }
    public void mouseDragged(MouseEvent e) {

    }
    public void mousePressed(MouseEvent e) {
        Main.pressed = true;
        Main.Moved(e);
    }
    public void mouseReleased(MouseEvent e) {
        Main.Moved(e);
        Main.pressed = false;
    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {

    }
}
