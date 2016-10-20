package hxy.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

public class RunReceiveServerMessage implements Runnable{
	private BufferedReader receiveMsg;
	
	public RunReceiveServerMessage(BufferedReader receiveMsg) {
		this.receiveMsg = receiveMsg;
	}
	@Override
	public void run() {
		System.out.println("���շ�������Ϣ�߳�����");
		while(true){
			try {
				System.out.println("��������Ϣ��"+new Date().toString()+receiveMsg.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
