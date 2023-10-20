package com.company;

import javax.swing.*;
import java.awt.*;

public class Panels extends JPanel{
        private boolean square;
        private int[] value;
        public Panels(boolean square, int[] kody) {
            this.square = square;
            this.value=kody;
            if(square) this.setPreferredSize(new Dimension(250, 550));
            else this.setPreferredSize(new Dimension(371, 96));
        }

        @Override
        public void paint(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            if(square) {
                g2.setStroke(new BasicStroke(4));
                g2.drawRect(19,20,221,220);
                g2.setColor(new Color(value[0], value[1], value[2]));
                g2.fillRect(20, 20, 220, 220);
                g2.fillRect(20, 275, 220, 220);
                g2.setColor(new Color(value[3], value[4], value[5]));
                g2.fillRect(60, 60, 140, 140);
                g2.fillRect(130, 275, 110, 110);
                g2.fillRect(20, 385, 110, 110);
            }
            else{
                g2.setColor(new Color(value[3], value[4], value[5]));
                g2.fillRect(0, 0, 371, 106);
                g2.setColor(new Color(value[0], value[1], value[2]));
                Font f = new Font("Arial", Font.BOLD, 20);
                g2.setFont(f);
                g2.drawString("GUI - Projekt II, zadanie 1, s22749",25,55);
            }
        }

        public void setValue(int[] value) {
            this.value = value;
        }
    }
