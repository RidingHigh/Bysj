package com.duankou;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;

import javax.swing.*;
public class Hello extends JFrame{
    public static void main(String[] args) {
        JFrame frame=new JFrame("20151681310212信安3班周光臻毕业设计");
        //JLabel label=new JLabel("?????????",SwingConstants.CENTER);
        //frame.add(label);
        JPanel p1=new JPanel(),p2=new JPanel();
        p1.setBackground(Color.orange);
        p2.add(new JButton("开始扫描"));
        p2.add(new JButton("停止扫描"));
        p2.add(new JButton("退出"));
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
