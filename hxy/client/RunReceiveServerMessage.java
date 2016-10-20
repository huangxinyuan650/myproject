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
		System.out.println("接收服务器消息线程启动");
		while(true){
			try {
				System.out.println("服务器消息："+new Date().toString()+receiveMsg.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
