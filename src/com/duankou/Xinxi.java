package com.duankou;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Xinxi extends JFrame {
    JPanel p1=new JPanel(),p2=new JPanel();
    public Xinxi(String title){
        super(title);
        JLabel label=new JLabel("毕业设计好难",SwingConstants.CENTER);
        p1.add(label);
        p1.setBackground(Color.orange);
        p2.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));

        p2.add(new JButton("开始扫描"));
        p2.add(new JButton("ֹͣ停止扫描"));
        p2.add(new JButton("退出"));
        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.PAGE_END);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame=new Xinxi("毕业设计端口扫描器");
    }
}
