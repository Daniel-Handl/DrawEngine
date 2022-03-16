package com.company;

public class Main {

    public static void main(String[] args){

        MyFrame frame = new MyFrame(800,800);
        long ftime = System.currentTimeMillis();
        long stime = System.currentTimeMillis();
        int count = 0;
        int FPS = 60;
        int miliseconds = 1000/FPS;
        long wait;
        while(true){
            frame.paint(frame.getGraphics());
            count++;
            if (System.currentTimeMillis() - stime > miliseconds){
                stime = System.currentTimeMillis();
                //vykresli
                frame.paint(frame.getGraphics());
                count++;
            }
            if (System.currentTimeMillis() - ftime>= 1000){
                ftime = System.currentTimeMillis();
                System.out.println(count + " za sekundu");
                count = 0;
            }
        }
    }
}
