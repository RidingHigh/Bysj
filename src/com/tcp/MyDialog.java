package com.tcp;


import javax.swing.*;
import java.awt.*;


/*
 **“关于”窗口
 */
public class MyDialog extends JDialog
{
    JPanel jMainPane = new JPanel();

    JTabbedPane jTabbedPane = new JTabbedPane();
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();

    private JTextArea jt1 = new JTextArea(6,6);
    private JTextArea jt2 = new JTextArea(6,6);

    /*
     **构造函数
     */
    public MyDialog()
    {
        setTitle("端口扫描");
        setSize(300,200);
        setLocation(360, 320);
        setResizable(false);
        setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);

        Container c = this.getContentPane();

        jt1.setSize(500,200);
        jt2.setSize(500,200);

        jt1.setEditable(false);
        jt2.setEditable(false);

        jt1.setLineWrap(true);
        jt2.setLineWrap(true);

        jt1.setText("用同一信息对目标计算机的所有所需扫描的端口进行发送，然后根据返回端口状态来分析目标计算机的端口是否打开、是否可用。");
        jt2.setText("1、选择扫描方式\n"+"2、点击“开始扫描”\n"+"3、点击“保存扫描结果”进行扫描结果的保存\n"+"4、点击“停止扫描”，可中止扫描");

        jt1.setFont(new Font("楷体_GB2312", java.awt.Font.BOLD, 20));
        jt1.setForeground(Color.blue);

        jt2.setFont(new Font("楷体_GB2312", java.awt.Font.BOLD, 20));
        jt2.setForeground(Color.black);

        jPanel1.add(jt1);
        jPanel2.add(jt2);

        jTabbedPane.setSize(300,200);
        jTabbedPane.addTab("扫描原理", null, jPanel1, null);
        jTabbedPane.addTab("使用说明", null, jPanel2, null);

        jMainPane.add(jTabbedPane);
        c.add(jMainPane);

        pack();
        this.setVisible(true);
    }
}
