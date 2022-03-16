package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEvents implements MouseListener,MouseMotionListener {

    public Point Position = new Point(0,0);
    JFrame frame;
    public MouseEvents(JFrame frame){
        frame.addMouseListener(this);
        this.frame = frame;
    }

    public void mouseMoved(MouseEvent e) {

    }
    public void mouseDragged(MouseEvent e) {

    }
    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
    }



}
