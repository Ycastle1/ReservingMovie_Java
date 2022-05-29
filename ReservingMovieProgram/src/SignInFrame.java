import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignInFrame extends JFrame{
	private LoginPanel loginPanel = new LoginPanel();
	
	public SignInFrame() {
		setContentPane(loginPanel);
		setTitle("�α���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(320, 150);
		setResizable(false);
		setVisible(true);
	}	
	
	public static void main(String[] args) {
		new SignInFrame();
	}
	
	
	public class LoginPanel extends JPanel {
		private JLabel idLabel = new  JLabel(" �� �� ��  :");
		private JLabel pwLabel = new  JLabel("��й�ȣ :");
		
		private JTextField idTextField = new JTextField();
		private JPasswordField pwTextField = new JPasswordField();
		
		private String id = "";
		private String pw;	
		
		private JButton loginButton = new JButton("�α���");
		
		private MenuFrame menuFrame;
		
		public LoginPanel() {
			setLayout(null);
			
			idLabel.setBounds(10, 20, 70, 20);
			pwLabel.setBounds(10, 60, 60, 20);
			add(idLabel);
			add(pwLabel);
			
			idTextField.setBounds(80, 20, 110, 20);
			pwTextField.setBounds(80, 60, 110, 20);
			add(idTextField);
			add(pwTextField);
			
			loginButton.setBounds(200, 20, 80, 60);
			add(loginButton);
			
			
			//����Ű �����ʵ� �߰��� �� ���� ����
			loginButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					id = idTextField.getText();
					pw = pwTextField.getText();
					
					ConnectDB connectDB = new ConnectDB();
					
					if (connectDB.login(id, pw)) {
						System.out.println("����");
						menuFrame = new MenuFrame();
					}
				}
				
			});
		}		
	}		
}
