package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.CustomerDAO;
import DTO.TicketDTO;

public class SignInFrame extends JFrame{
	private LoginPanel loginPanel = new LoginPanel();
	private TicketDTO ticket = new TicketDTO();
	
	public SignInFrame() {
		setContentPane(loginPanel);
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(320, 150);
		setResizable(false);
		setVisible(true);
	}	
	
	
	class LoginPanel extends JPanel {
		private JLabel idLabel = new  JLabel(" 아 이 디  : ");
		private JLabel pwLabel = new  JLabel("비밀번호 :");
		
		private JTextField idTextField = new JTextField();
		private JPasswordField pwTextField = new JPasswordField();
		
		private String id = "";
		private String pw;	
		
		private JButton loginButton = new JButton("로그인");
		private JButton signupButton = new JButton("회원가입");
		
		private MenuFrame menuFrame;
		private SignUpFrame signUpFrame;
		
		public LoginPanel() {
			setLayout(null);
			
			idLabel.setBounds(10, 20, 70, 20);
			pwLabel.setBounds(10, 60, 60, 20);
			add(idLabel);
			add(pwLabel);
			
			idTextField.setBounds(80, 20, 110, 30);
			pwTextField.setBounds(80, 60, 110, 30);
			add(idTextField);
			add(pwTextField);
			
			loginButton.setBounds(205, 20, 85, 30);
			signupButton.setBounds(205, 60, 85, 30);
			add(loginButton);
			add(signupButton);
			
			
			
			loginButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					id = idTextField.getText();
					pw = pwTextField.getText();
					
					CustomerDAO customerDAO = new CustomerDAO();
					
					if (customerDAO.login(id, pw)) {
						System.out.println("login ok");
						ticket.setCustomerId(id);
						ticket.setCustomerName(customerDAO.getCustomerNameById(id));
						System.out.println(ticket.getCustomerName());
						menuFrame = new MenuFrame(ticket);
						dispose();
					}
				}
				
			});
			
			signupButton.addActionListener(new ActionListener () {

				@Override
				public void actionPerformed(ActionEvent e) {
					signUpFrame = new SignUpFrame();					
				}
			});
		}		
	}	
	
	public static void main(String[] args) {
		new SignInFrame();
	}
}
