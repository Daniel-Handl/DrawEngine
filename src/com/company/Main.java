package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import  java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Main {
    public static Integer[][] field;
    public static boolean pressed;
    public static Random rand = new Random();
    public static int width;
    public static int height;
    public static void main(String[] args) {
        field = Fill(3,3);
        width = 750;
        height = width;
        DrawEngine dre = new DrawEngine(width,height,60);

    }

    public static Integer[][] Fill(int width, int height){
        Integer[][] field = new Integer[width][height];
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                field[x][y] = 0;
                if (rand.nextInt(100) < 50) field[x][y] = 1;
            }
        }
        return field;
    }
    public static void Moved(MouseEvent e){
        Point pos = e.getPoint();
        pos.x = pos.x/width/ field.length;
        pos.y = pos.y/height/field[0].length;
        if (pressed) field[pos.x][pos.y] = 1;
        System.out.println(pressed);
    }
    public static void Update(){
        Integer[][] fieldr = field;
        int neighbours;
        for (int y = 0; y < field[0].length; y++){
            for (int x = 0; x < field.length; x++){
                neighbours = 0;
                for (int yr = -1; yr < 2; yr++){
                    for (int xr = -1; xr < 2; xr++){
                        if (x+xr >= 0 && y+yr >= 0 && x+xr < field.length && y+yr < field[0].length){
                            if (xr != 0 && yr != 0)neighbours += field[x+xr][y+yr];
                        }
                    }
                }
                if (field[x][y] == 0){
                    if (neighbours == 3) fieldr[x][y] = 1;
                }
                else{
                    if (neighbours > 1 && neighbours < 4 ) fieldr[x][y] = 1;
                    else fieldr[x][y] = 0;
                }
                System.out.println(neighbours);
            }
        }
        field = fieldr;
    }
}


