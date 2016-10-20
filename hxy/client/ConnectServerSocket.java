package hxy.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class ConnectServerSocket implements Runnable{
	private String ip;
	private int port;
	
	public ConnectServerSocket(String ip,int port) {
		this.ip = ip;
		this.port = port;
	}	
	
	@Override
	public void run() {
		InetAddress inet;
		Socket client;
		try {
			inet = InetAddress.getByName(ip);
			try {
				Socket clientTest = new Socket(inet, port);//连接服务器获取分配的端口
				BufferedReader br = new BufferedReader(new InputStreamReader(clientTest.getInputStream()));
				sortUrlAndPort(br.readLine());
				System.out.println("连接新端口为："+port);
				br.close();
				clientTest.close();
				
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("端口重新分配");
				inet = InetAddress.getByName(ip);
				client = new Socket(inet, port);  //连接新分配的端口
				BufferedReader brNew = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter pw = new PrintWriter(client.getOutputStream());
				pw.println("huangxinyuan huang650");  //传入用户名密码验证
				pw.flush();
				System.out.println("将用户名和密码传入到服务器");
				Thread receiveMsgThread = new Thread(new RunReceiveServerMessage(brNew));
				Thread sendMsgThread = new Thread(new RunSendServerMessage(pw));
				receiveMsgThread.start();
				sendMsgThread.start();
//				while(true){					
//					System.out.println(brNew.readLine());  //读取服务器返回的数据
////					try {
////						Thread.currentThread().sleep(500);
////					} catch (InterruptedException e) {
////						e.printStackTrace();
////					}
//				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Connect failed！！！");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	private void sortUrlAndPort(String str){  //第一个是ip，第二个是port
		StringTokenizer st = new StringTokenizer(str);
		if(st.hasMoreTokens()){
			this.ip = st.nextToken().trim();
			this.port = Integer.parseInt(st.nextToken().trim());
		}
	}
}
