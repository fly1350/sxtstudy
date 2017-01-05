package com.sgxrmyy.tankwar;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 袁明 on 2017/1/5.
 */
public class TankWarClient extends Frame {

    Integer x = 50, y = 50;

    @Override
    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, 30, 30);
        g.setColor(c);
        y+=5;
    }

    public void lauchFrame() {
        this.setLocation(400, 150);
        this.setSize(800, 600);
        this.setTitle("TankWar");
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setBackground(Color.GRAY);
        this.setVisible(true);
        new Thread(new TankThread()).start();
    }

    public static void main(String[] args) {
        TankWarClient warClient = new TankWarClient();
        warClient.lauchFrame();
    }

    private class TankThread implements Runnable{

        @Override
        public void run() {
            while(true){
                repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
