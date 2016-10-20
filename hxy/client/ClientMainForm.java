package hxy.client;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClientMainForm extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel headPanel;
	private JPanel bodyPanel;
	private JPanel footPanel;
	/**
	 * Create the frame.
	 */
	public ClientMainForm() {
		//主界面初始化
		init();
		//显示数据
		showData();
	}
	
	private void showData(){
		//1.连接服务器Socket套件字
		//2.
		
	}
	
	private void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 473);
		getContentPane().setLayout(null);
		getContentPane().setSize(getWidth(), getHeight());
		setVisible(true);
		setTitle("Client");
		sortBlocks();	
	}
	
	private void sortBlocks(){
		headPanel = new JPanel();
		headPanel.setBounds(0, 0, getContentPane().getWidth()-2, 33);
		getContentPane().add(headPanel);
		headPanel.setLayout(null);
		
		bodyPanel = new JPanel();
		bodyPanel.setBounds(0, 34, getContentPane().getWidth()-2, getContentPane().getHeight()-68);
		getContentPane().add(bodyPanel);
		bodyPanel.setLayout(null);
		
		footPanel = new JPanel();
		footPanel.setBounds(0, getContentPane().getHeight()-33, getContentPane().getWidth()-2, 33);
		getContentPane().add(footPanel);
		footPanel.setLayout(null);
		
		JButton btnNewButton1 = new JButton("New button1");
		JButton btnNewButton2 = new JButton("New button2");
		JButton btnNewButton3 = new JButton("New button3");
		footPanel.add(btnNewButton3);
		btnNewButton3.setBounds(0, 0, footPanel.getWidth()/2, 33);
		bodyPanel.add(btnNewButton2);
		btnNewButton2.setBounds(bodyPanel.getWidth()/2, bodyPanel.getHeight()-33, footPanel.getWidth()/2, 33);
		headPanel.add(btnNewButton1);
		btnNewButton1.setBounds(0, 0, footPanel.getWidth()/2, 33);
	}
}
