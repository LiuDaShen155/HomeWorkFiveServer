package MyServer;

import java.net.*;
import java.io.*;
import java.util.*;

public class MyServer{
    //定义保存所有Socket的ArrayList
    public static ArrayList<Socket> socketList = new ArrayList<Socket>();
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(40000);
        while(true){
            //此行代码会阻塞，将一直等待别人的连接
            System.out.println("***服务器等待***");
            Socket s =ss.accept();
            //打印连接的设备的ip地址
            InetAddress address=s.getInetAddress();
            System.out.println(address);

            socketList.add(s);
            //每当客户端连接后启动一条ServerThread线程为该客户端服务
            new Thread(new ServerThread(s)).start();
        }
    }
}
