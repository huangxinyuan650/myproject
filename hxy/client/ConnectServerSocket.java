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
				Socket clientTest = new Socket(inet, port);//���ӷ�������ȡ����Ķ˿�
				BufferedReader br = new BufferedReader(new InputStreamReader(clientTest.getInputStream()));
				sortUrlAndPort(br.readLine());
				System.out.println("�����¶˿�Ϊ��"+port);
				br.close();
				clientTest.close();
				
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("�˿����·���");
				inet = InetAddress.getByName(ip);
				client = new Socket(inet, port);  //�����·���Ķ˿�
				BufferedReader brNew = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter pw = new PrintWriter(client.getOutputStream());
				pw.println("huangxinyuan huang650");  //�����û���������֤
				pw.flush();
				System.out.println("���û��������봫�뵽������");
				Thread receiveMsgThread = new Thread(new RunReceiveServerMessage(brNew));
				Thread sendMsgThread = new Thread(new RunSendServerMessage(pw));
				receiveMsgThread.start();
				sendMsgThread.start();
//				while(true){					
//					System.out.println(brNew.readLine());  //��ȡ���������ص�����
////					try {
////						Thread.currentThread().sleep(500);
////					} catch (InterruptedException e) {
////						e.printStackTrace();
////					}
//				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Connect failed������");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	private void sortUrlAndPort(String str){  //��һ����ip���ڶ�����port
		StringTokenizer st = new StringTokenizer(str);
		if(st.hasMoreTokens()){
			this.ip = st.nextToken().trim();
			this.port = Integer.parseInt(st.nextToken().trim());
		}
	}
}
