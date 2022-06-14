package View;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.CustomerDAO;
import DTO.CustomerDTO;

public class SignUpFrame extends JFrame {

	private JPanel cpane;
	private JTextField textField_name;
	private JTextField textField_id;
	private JTextField textField_pw;
	private JTextField textField_em;
	private JTextField textField_num;
	
	private CustomerDTO customer;

	public static void main(String[] args) {
        new SignUpFrame();
	}
	public SignUpFrame() {
		setTitle("회원가입 화면");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cpane = new JPanel();
		cpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cpane);
		cpane.setLayout(null);
		
		JLabel la_log = new JLabel("회원 가입");
		JLabel la_name = new JLabel("이름");
		JLabel la_id = new JLabel("아이디");
		JLabel la_pw = new JLabel("비밀번호");
		JLabel la_em = new JLabel("이메일");
		JLabel la_num = new JLabel("전화 번호");
		
		textField_name = new JTextField();
		textField_id = new JTextField();
		textField_pw = new JTextField();
		textField_em = new JTextField();
		textField_num = new JTextField();
		
		la_log.setFont(new Font("굴림", Font.BOLD, 20));
		la_name.setFont(new Font("굴림", Font.BOLD, 15));
		la_id.setFont(new Font("굴림", Font.BOLD, 15));
		la_pw.setFont(new Font("굴림", Font.BOLD, 15));
		la_em.setFont(new Font("굴림", Font.BOLD, 15));
		la_num.setFont(new Font("굴림", Font.BOLD, 15));
		
		la_log.setBounds(325, 50, 130, 44);
		la_name.setBounds(118, 162, 90, 44);
		la_id.setBounds(118, 227, 90, 44);
		la_pw.setBounds(118, 292, 90, 44);
		la_em.setBounds(118, 364, 90, 44);
		la_num.setBounds(118, 442, 90, 44);
		
		
		textField_name.setBounds(206, 170, 380, 29);
		textField_id.setBounds(206, 239, 380, 29);
		textField_pw.setBounds(206, 304, 380, 29);
		textField_em.setBounds(206, 372, 380, 29);
		textField_num.setBounds(206, 450, 380, 29);
		
		textField_name.setColumns(10);
		textField_id.setColumns(10);
		textField_pw.setColumns(20);
		textField_em.setColumns(20);
		textField_num.setColumns(10);
		
		cpane.add(la_log);
		cpane.add(la_name);
		cpane.add(la_id);
		cpane.add(la_pw);
		cpane.add(la_em);
		cpane.add(la_num);
			
		cpane.add(textField_name);
		cpane.add(textField_id);
		cpane.add(textField_pw);
		cpane.add(textField_em);
		cpane.add(textField_num);
		
		JButton btnokok = new JButton("정보 입력");
		btnokok.setFont(new Font("굴림", Font.BOLD, 12));
		btnokok.setBounds(296, 576, 179, 59);
		cpane.add(btnokok);
		
		btnokok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				customer = new CustomerDTO();
				
				customer.setCustomerId(textField_id.getText());
				customer.setCustomerPassword(textField_pw.getText());
				customer.setCustomerName(textField_name.getText());
				customer.setCustomerEmail(textField_em.getText());
				customer.setCustomerPhoneNumber(textField_num.getText());
				
				CustomerDAO customerDAO = new CustomerDAO();
				
				customerDAO.registerCustomer(customer);
			}
		});
		
		
		setSize(800,700);
		setVisible(true);
	}
}
