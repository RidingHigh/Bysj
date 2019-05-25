package com.tcp;


import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TCPThread extends Thread{

    public static InetAddress hostAddress;

    //最小的端口号
    public static int MIN_port;
    //最大的端口号
    public static int MAX_port;

    //线程总数
    private int threadnum;

    //查询方式：0为ip；1为主机名
    public static int type;

    //端口的类别
    String porttype = "0";

    /*
     *构造函数
     */
    public TCPThread(String name,int threadnum){
        super(name);
        this.threadnum = threadnum;
    }

    /*
     *运行函数
     */
    public void run() {

        //ip地址
        int h = 0;
        //端口号
        int i = 0;
        Socket theTCPsocket;

        //根据ip地址进行扫描
        if(type == 0){
            //不同的端口循环扫描
            for (i = MIN_port+threadnum;
                 i < MAX_port + Integer.parseInt(PortScan.maxThread.getText()) && PortScan.StopFlag;
                 i += Integer.parseInt(PortScan.maxThread.getText()))
            {

                try{
                    theTCPsocket=new Socket(hostAddress,i);
                    theTCPsocket.close();

                    //判断端口的类别
                    switch(i){
                        case 21:
                            porttype = "(FTP)";
                            break;
                        case 22:
                            porttype = "(SSH)";
                            break;
                        case 23:
                            porttype = "(TELNET)";
                            break;
                        case 25:
                            porttype = "(SMTP)";
                            break;
                        case 80:
                            porttype = "(HTTP)";
                            break;
                        case 110:
                            porttype = "(POP)";
                            break;
                        case 139:
                            porttype = "(netBIOS)";
                            break;
                        case 1433:
                            porttype = "(SQL Server)";
                            break;
                        case 3389:
                            porttype = "(Terminal Service)";
                            break;
                        case 443:
                            porttype = "(HTTPS)";
                            break;
                        case 1521:
                            porttype = "(Oracle)";
                            break;
                        default :
                            porttype = "(UnknownPort:Open)";
                            break;
                    }

                    //将开放端口内容添加到显示区域
                    synchronized (PortScan.Result) {
                        PortScan.Result.append(" "+i);
                        PortScan.Result.append(":"+porttype+"\n");
                    }
                    synchronized (PortScan.ResultAll) {
                        PortScan.ResultAll.append(" "+i);
                        PortScan.ResultAll.append(":"+porttype+"\n");
                    }
                }
                catch (IOException e){
                    synchronized (PortScan.ResultAll) {
                        //将所有端口内容添加到显示区域
                        PortScan.ResultAll.append(" "+i);
                        PortScan.ResultAll.append(":Closed"+"\n");
                    }
                }
            }


            //扫描完成后，显示扫描完成，并将“确定”按钮设置为可用
            if (i==MAX_port+Integer.parseInt(PortScan.maxThread.getText())){
                try {Thread.sleep(1000);} catch (InterruptedException e) {}
                PortScan.Result.append("扫描完毕...");

                //将"确定"按钮设置成为可用
                if(!PortScan.Submit.isEnabled()){
                    PortScan.Submit.setEnabled(true);
                }
            }
        }

        //按照主机名进行端口扫描
        if(type == 1){

            for (i = MIN_port+threadnum;
                 i < MAX_port+Integer.parseInt(PortScan.maxThread.getText()) && PortScan.StopFlag;
                 i += Integer.parseInt(PortScan.maxThread.getText())){

                try{
                    theTCPsocket=new Socket(hostAddress,i);
                    theTCPsocket.close();
                    switch(i){
                        case 21:
                            porttype = "(FTP)";
                            break;
                        case 22:
                            porttype = "(SSH)";
                            break;
                        case 23:
                            porttype = "(TELNET)";
                            break;
                        case 25:
                            porttype = "(SMTP)";
                            break;
                        case 80:
                            porttype = "(HTTP)";
                            break;
                        case 110:
                            porttype = "(POP)";
                            break;
                        case 139:
                            porttype = "(netBIOS)";
                            break;
                        case 1433:
                            porttype = "(SQL Server)";
                            break;
                        case 3389:
                            porttype = "(Terminal Service)";
                            break;
                        case 443:
                            porttype = "(HTTPS)";
                            break;
                        case 1521:
                            porttype = "(Oracle)";
                            break;
                        default :
                            porttype = "(UnknownPort:Open)";
                            break;
                    }

                    //将开放端口内容添加到显示区域
                    synchronized (PortScan.Result) {
                        PortScan.Result.append(" "+i);
                        PortScan.Result.append(":"+porttype+"\n");
                    }
                    synchronized (PortScan.ResultAll) {
                        PortScan.ResultAll.append(" "+i);
                        PortScan.ResultAll.append(":"+porttype+"\n");
                    }
                }
                catch (IOException e){
                    synchronized (PortScan.ResultAll) {
                        //将所有端口内容添加到显示区域
                        PortScan.ResultAll.append(" "+i);
                        PortScan.ResultAll.append(":Closed"+"\n");
                    }
                }
            }

            //扫描完成后，显示扫描完成，并将【确定】按钮设置为可用
            if (i==MAX_port+Integer.parseInt(PortScan.maxThread.getText())){
                try {Thread.sleep(1000);} catch (InterruptedException e) {}
               PortScan.Result.append("扫描完成...");

                //将【确定】按钮设置成为可用
                if(!PortScan.Submit.isEnabled()){
                    PortScan.Submit.setEnabled(true);
                }
            }
        }
    }
}