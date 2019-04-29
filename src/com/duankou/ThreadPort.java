package com.duankou;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyleConstants;

import junit.framework.Test;

/*
 *ʵ��ɨ����������
 */
public class ThreadPort {

    public static JFrame main=new JFrame("毕业设计");
    //��ʾɨ����
    public static JTextArea Result=new JTextArea("",4,40);
    //���������
    public static JScrollPane resultPane = new JScrollPane(Result,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


    //�����������ı���
    public static JTextField hostname=new JTextField("localhost",8);

    //����ip��ַǰ3λ�������
    public static JTextField fromip1=new JTextField("0",3);
    //����ip��ַ4~6λ�������
    public static JTextField fromip2=new JTextField("0",3);
    //����ip��ַ7~9λ�������
    public static JTextField fromip3=new JTextField("0",3);
    //������ʼip��ַ���4λ�������
    public static JTextField fromip4=new JTextField("0",3);
    //����Ŀ��ip��ַ���4λ�������
    public static JTextField toip=new JTextField("0",3);

    //������С�˿ڵ������
    public static JTextField minPort=new JTextField("0",4);
    //�������˿ڵ������
    public static JTextField maxPort=new JTextField("1000",4);
    //��������߳������������
    public static JTextField maxThread=new JTextField("100",3);

    //������ʾ��
    public static JDialog DLGError=new JDialog(main,"错误!");
    public static JLabel DLGINFO=new JLabel("");

    //public static JLabel type=new JLabel("��ѡ��");

    //ɨ������
    public static JRadioButton radioIp = new JRadioButton("IP地址：");
    public static JRadioButton radioHost = new JRadioButton("主机名",true);
    //��ѡ����
    public static ButtonGroup group = new ButtonGroup();

    public static JLabel P1=new JLabel("端口范围:");
    public static JLabel P2=new JLabel("~");
    public static JLabel P3=new JLabel("~");
    public static JLabel Pdot1 = new JLabel(".");
    public static JLabel Pdot2 = new JLabel(".");
    public static JLabel Pdot3 = new JLabel(".");
    public static JLabel TNUM=new JLabel("线程数:");
    public static JLabel RST=new JLabel("扫描结果:                                       ");
    public static JLabel con=new JLabel("                                                                                                              ");

    //���尴ť
    public static JButton OK = new JButton("确定");
    public static JButton Submit = new JButton("开始扫描");
    public static JButton Cancel = new JButton("退出");
    public static JButton saveButton = new JButton("保存扫描结果");

    //�˵���
    public static JMenuBar myBar = new JMenuBar();
    public static JMenu myMenu = new JMenu("文件(F)");
    public static JMenuItem saveItem = new JMenuItem("保存扫描结果退出（S）");
    public static JMenuItem exitItem = new JMenuItem("退出(Q)");
    public static JMenu myMenu2 = new JMenu("帮助");
    public static JMenuItem helpItem = new JMenuItem("阅读");

    public static void main(String[] args){
        main.setSize(500,400);
        main.setLocation(300,300);
        main.getContentPane().setVisible(true);
        main.setLayout(new GridBagLayout());
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setBackground(Color.green);
        DLGError.setSize(300,100);
        DLGError.setLocation(400,400);
        //JFrame frame=new JFrame();
        //frame.getContentPane().setBackground(Color.orange);
        //���ӡ��˵�����
        //myMenu.add(saveItem);
        //myMenu.add(exitItem);

        //myMenu2.add(helpItem);

        //myBar.add(myMenu);
        //myBar.add(myMenu2);
        main.setJMenuBar(myBar);

        //�����ȼ�
        //myMenu.setMnemonic('F');
        saveItem.setMnemonic ('S');
        //Ϊ������Ϊ��������ÿ�ݼ�Ϊctrl+s
        saveItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_S,InputEvent.CTRL_MASK));
        exitItem.setMnemonic('Q');
        exitItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_E,InputEvent.CTRL_MASK));

        //���ñ�����Ͳ���
        Container mPanel = main.getContentPane();
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,0,0,10);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 10;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        //mPanel.add(type,c);

        group.add(radioIp);
        group.add(radioHost);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(radioIp,c);

        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(fromip1,c);

        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(Pdot1,c);

        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(fromip2,c);

        c.gridx = 4;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(Pdot2,c);

        c.gridx = 5;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(fromip3,c);

        c.gridx = 6;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(Pdot3,c);

        c.gridx = 7;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(fromip4,c);

        c.gridx = 8;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(P2,c);

        c.gridx = 9;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(toip,c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(radioHost,c);

        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(hostname,c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(P1,c);

        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(minPort,c);

        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(P3,c);

        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(maxPort,c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(TNUM,c);

        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(maxThread,c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(Submit,c);

        c.gridx = 3;
        c.gridy = 5;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(saveButton,c);

        c.gridx = 6;
        c.gridy = 5;
        c.gridwidth = 4;
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(Cancel,c);

        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 10;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(RST,c);

        //�����ı�������Ի���
        Result.setLineWrap(true);
        //�����ı����򲻿ɱ༭
        Result.setEditable(false);

        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 10;
        c.gridheight = 4;
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(resultPane,c);

        Container dPanel = DLGError.getContentPane();
        dPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        dPanel.add(DLGINFO);
        dPanel.add(OK);

        Submit.addActionListener(new SubmitAction());
        Cancel.addActionListener(new CancleAction());
        OK.addActionListener(new OKAction());

        //ʵ�ֱ��湦��
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                JFileChooser fc=new JFileChooser();
                int returnVal=fc.showSaveDialog(null);

                //��������桱
                if(returnVal == 0){
                    File saveFile=fc.getSelectedFile();
                    try {
                        FileWriter writeOut = new FileWriter(saveFile);
                        writeOut.write(ThreadPort.Result.getText());
                        writeOut.close();
                    }
                    catch (IOException ex) {
                        System.out.println("保存失败");
                    }
                }
                //�����ȡ����
                else
                    return;
            }
        });

        //ʵ���˳�����
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.exit(0);
            }
        });

        //ʵ�ְ�������
        helpItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new Chuangkou();
            }
        });

        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                JFileChooser fc=new JFileChooser();
                int returnVal=fc.showSaveDialog(null);

                //点击保存
                if(returnVal == 0){
                    File saveFile=fc.getSelectedFile();
                    try {
                        FileWriter writeOut = new FileWriter(saveFile);
                        writeOut.write(ThreadPort.Result.getText());
                        writeOut.close();
                    }
                    catch (IOException ex) {
                        System.out.println("保存失败");
                    }
                }
                //�����ȡ����
                else
                    return;
            }
        });

        main.setVisible(true);
    }
}

/*
 *ʵ�֡�ȡ��������
 *�˳�����
 */
class CancleAction implements ActionListener{

    public void actionPerformed (ActionEvent e){
        System.exit(0);
    }
}

/*
 *ʵ�֡�ȷ��������
 *���ɨ��
 */
class SubmitAction implements ActionListener{

    public void actionPerformed (ActionEvent a){

        int minPort;
        int maxPort;
        int maxThread;

        int ip1 = 0;
        int ip2 = 0;
        int ip3 = 0;
        int ipstart = 0;
        int ipend = 0;

        String ipaddress = "";
        String hostname = "";

        ThreadPort.Result.setText("");
        //��"ȷ��"��ť���ó�Ϊ������
        if(ThreadPort.Submit.isEnabled()){
            ThreadPort.Submit.setEnabled(false);
        }

        /*
         *�ж�����������
         *����ip��ַɨ�裺type = 0
         *������������ɨ�裺type = 1
         */
        if(ThreadPort.radioIp.isSelected()){

            TCPThread.type = 0;

            //�ж�ip��ǰ3λ�Ƿ�Ϊint��
            try{
                ip1=Integer.parseInt(ThreadPort.fromip1.getText());
            }
            catch(NumberFormatException e){
                ThreadPort.DLGINFO.setText("ip地址范围只能在0到255之间");
                ThreadPort.DLGError.setVisible(true);
                return;
            }

            //�ж�ip��4~6λ�Ƿ�Ϊint��
            try{
                ip2=Integer.parseInt(ThreadPort.fromip2.getText());
            }
            catch(NumberFormatException e){
                ThreadPort.DLGINFO.setText("ip地址范围只能在0到255之间");
                ThreadPort.DLGError.setVisible(true);
                return;
            }

            //�ж�ip��7~9λ�Ƿ�Ϊint��
            try{
                ip3=Integer.parseInt(ThreadPort.fromip3.getText());
            }
            catch(NumberFormatException e){
                ThreadPort.DLGINFO.setText("ip地址范围只能在0到255之间");
                ThreadPort.DLGError.setVisible(true);
                return;
            }

            //�ж���ʼip�����3λ�Ƿ�Ϊint��
            try{
                ipstart=Integer.parseInt(ThreadPort.fromip4.getText());
            }
            catch(NumberFormatException e){
                ThreadPort.DLGINFO.setText("ip地址范围只能在0到255之间");
                ThreadPort.DLGError.setVisible(true);
                return;
            }

            //�ж�Ŀ��ip�����4λ�Ƿ�Ϊint��
            try{
                ipend=Integer.parseInt(ThreadPort.toip.getText());
            }
            catch(NumberFormatException e){
                ThreadPort.DLGINFO.setText("ip地址范围只能在0到255之间");
                ThreadPort.DLGError.setVisible(true);
                return;
            }

            //�ж���ʼip�Ƿ���ȷ
            //�ж�����������0��С�ڵ���255
            if(ip1<0 || ip1>255||ip2<0 || ip2>255||ip3<0 || ip3>255||ipstart<0 || ipstart>255){
                ThreadPort.DLGINFO.setText("                    ip地址为0-255到整数!                    ");
                ThreadPort.DLGError.setVisible(true);
                return;
            }
            else{
                TCPThread.ip1 = ip1;
                TCPThread.ip2 = ip2;
                TCPThread.ip3 = ip3;
                TCPThread.ipstart = ipstart;
            }

            //�ж�Ŀ��ip�Ƿ���ȷ
            //�ж�����������0��С�ڵ���255
            if(ipend<0 || ipend>255){
                ThreadPort.DLGINFO.setText("                    目标ip地址为0-255到整数!                    ");
                ThreadPort.DLGError.setVisible(true);
                return;
            }
            else{
                TCPThread.ipend = ipend;
            }

            ipaddress = "" + ip1 + ip2 + ip3 + ipstart;

            /*
             *�ж�ip��ַ����Ч��
             */
            try{
                TCPThread.hostAddress=InetAddress.getByName(ipaddress);
            }
            catch(UnknownHostException e){
                ThreadPort.DLGINFO.setText("            错误的ip或地址不可达!            ");
                ThreadPort.DLGError.setVisible(true);
                return;
            }
        }

        //�������������ж˿�ɨ��
        if(ThreadPort.radioHost.isSelected()){

            TCPThread.type = 1;

            /*
             *�ж��������Ƶ���Ч��
             */
            try{
                TCPThread.hostAddress=InetAddress.getByName(ThreadPort.hostname.getText());
            }
            catch(UnknownHostException e){
                ThreadPort.DLGINFO.setText("            错误的域名或地址不可达!            ");
                ThreadPort.DLGError.setVisible(true);
                return;
            }
        }

        /*
         *�ж϶˿ںŵ���Ч��
         */
        try{
            minPort=Integer.parseInt(ThreadPort.minPort.getText());
            maxPort=Integer.parseInt(ThreadPort.maxPort.getText());
            maxThread=Integer.parseInt(ThreadPort.maxThread.getText());
        }
        catch(NumberFormatException e){
            ThreadPort.DLGINFO.setText("错误的端口号或线程数!端口号和线程数必须为整数！");
            ThreadPort.DLGError.setVisible(true);
            return;
        }

        /*
         *�ж���С�˿ںŵ���Ч��Χ
         *�ж�����������0��С��65535�����˿�Ӧ������С�˿�
         */
        if(minPort<0 || minPort>65535 || minPort>maxPort){
            ThreadPort.DLGINFO.setText("最小端口必须是0-65535并且小于最大端口到整数!");
            ThreadPort.DLGError.setVisible(true);
            return;
        }
        else{
            TCPThread.MIN_port=minPort;
        }

        /*
         *�ж����˿ںŵ���Ч��Χ
         *�ж�����������0��С��65535�����˿�Ӧ������С�˿�
         */
        if(maxPort<0 || maxPort>65535 || maxPort<minPort){
            ThreadPort.DLGINFO.setText("最大端口必须是0-65535并且小于最小端口到整数!");
            ThreadPort.DLGError.setVisible(true);
            return;
        }
        else{
            TCPThread.MAX_port=maxPort;
        }

        /*
         *�ж��߳���������Ч��Χ
         *�ж�����������1��С��200
         */
        if(maxThread<1 || maxThread>200){
            ThreadPort.DLGINFO.setText("                    线程数为1-200的整数!                    ");
            ThreadPort.DLGError.setVisible(true);
            return;
        }

        ThreadPort.Result.append("线程数 "+ThreadPort.maxThread.getText()+"\n");

        //�����߳�
        for(int i=0;i<maxThread;i++){
            new TCPThread("T" + i,i).start();
        }
    }
}

/*
 *ʵ�ִ�����ʾ���еġ�ȷ������ť����
 */
class OKAction implements ActionListener{

    public void actionPerformed (ActionEvent e){
        ThreadPort.DLGError.dispose();
    }
}

