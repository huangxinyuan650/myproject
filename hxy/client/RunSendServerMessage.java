package hxy.client;

import java.io.PrintWriter;
import java.util.Scanner;

public class RunSendServerMessage implements Runnable{

	private PrintWriter sendMsg;
	
	public RunSendServerMessage(PrintWriter sendMsg) {
		this.sendMsg = sendMsg;
	}
	@Override
	public void run() {
		System.out.println("������Ϣ���������߳�����");
		String msg;
		while(true){
			Scanner cin = new Scanner(System.in);
			msg = cin.nextLine();
			sendMsg.println(msg);
			sendMsg.flush();
		}
	}

}
