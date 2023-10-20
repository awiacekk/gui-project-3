package com.company;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SetColors extends JFrame implements ChangeListener{
    private final List<JSlider> sliderList;
    private final JTextField text1;
    private final JTextField text2;
    private final JPanel panel1;
    private final JPanel rect;
    private final int[] value;
    public SetColors() {

        this.setTitle("GUI Projekt 2 - zadanie 1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(666, 566);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        setIconImage(icon);
        setLayout(new FlowLayout());
        sliderList = new ArrayList<>();
        for(int i = 0; i<6; i++){
            sliderList.add(new JSlider(JSlider.VERTICAL,0,255,127));
            sliderList.get(i).setMajorTickSpacing(85);
            sliderList.get(i).setMinorTickSpacing(5);
            sliderList.get(i).setPaintTicks(true);
            sliderList.get(i).setPaintLabels(true);
            sliderList.get(i).addChangeListener(this);
        }
        value = new int[6];
        for(int i = 0; i<value.length; i++){
            value[i]=sliderList.get(i).getValue();
        }
        JPanel sliders1=new JPanel();
            sliders1.setLayout(new BorderLayout());
            sliders1.add(sliderList.get(0),BorderLayout.WEST);
            sliders1.add(sliderList.get(1),BorderLayout.CENTER);
            sliders1.add(sliderList.get(2),BorderLayout.EAST);
        JPanel sliders2=new JPanel();
            sliders2.setLayout(new BorderLayout());
            sliders2.add(sliderList.get(3),BorderLayout.WEST);
            sliders2.add(sliderList.get(4),BorderLayout.CENTER);
            sliders2.add(sliderList.get(5),BorderLayout.EAST);

        text1 = new JTextField();
        text1.setHorizontalAlignment(0);
        text1.setText("R: "+value[0]+", G: "+value[1]+", B: "+value[2]);
        text2 = new JTextField();
        text2.setHorizontalAlignment(0);
        text2.setText("R: "+value[3]+", G: "+value[4]+", B: "+value[5]);

        panel1=new Panels(true,value);
        rect=new Panels(false,value);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.fill = GridBagConstraints.HORIZONTAL;
        g.weightx = 0;
        g.gridheight=0;
        g.insets = new Insets(0,0,170,20);
        g.ipady = 130;
        g.gridx = 0;
        g.gridy = 0;
        panel2.add(sliders1,g);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(0,0,170,20);
        g.gridheight=0;
        g.ipady = 130;
        g.weightx = 0;
        g.gridx = 1;
        g.gridy = 0;
        panel2.add(sliders2,g);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridheight=0;
        g.weightx = 0.5;
        g.ipady = 0;
        g.insets = new Insets(200,30,10,40);
        g.gridx = 0;
        g.gridy = 1;
        panel2.add(text1,g);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.weightx = 0.5;
        g.insets = new Insets(200,30,10,40);
        g.gridx = 1;
        g.gridy = 1;
        panel2.add(text2,g);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.weightx = 0.5;
        g.ipady = 50;
        g.gridheight=0;
        g.gridwidth = 3;
        g.insets = new Insets(380,0,0,20);
        g.gridx = 0;
        g.gridy = 2;
        panel2.add(rect,g);
        this.getContentPane().add(panel1);
        this.getContentPane().add(panel2);
        this.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        for(int i = 0; i<value.length; i++){
            if(value[i]!=sliderList.get(i).getValue()){
                value[i]=sliderList.get(i).getValue();
                ((Panels)panel1).setValue(value);
                ((Panels)rect).setValue(value);
                break;
            }
        }
        text1.setText("R: "+value[0]+", G: "+value[1]+", B: "+value[2]);
        text2.setText("R: "+value[3]+", G: "+value[4]+", B: "+value[5]);

        panel1.repaint();
        rect.repaint();
    }
}