package hxy.client;

public class MainActivity {

	public static void main(String[] args) {
//		new ClientMainForm();
		Thread thread = new Thread(new ConnectServerSocket("127.0.0.1", 2650));
		thread.start();
	}
}
