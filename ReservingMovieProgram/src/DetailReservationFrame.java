import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DetailReservationFrame extends JFrame {

   private JPanel cpane;
   private JLabel textField_name;
   private JLabel textField_id;
   private JLabel textField_pw;
   private JLabel textField_em;
   private JLabel textField_num;
   private JLabel textField_num1;
   private JLabel textField_num2;
   
   private JButton returnBtn;
   private JButton editBtn;
   private JButton deleteBtn;
   
   private CustomerDTO customer;
   
   ImageIcon img1 = new ImageIcon("./Moive_image/javaicon.jpg");
   Image img1_1 = img1.getImage();
   Image changeImg1 = img1_1.getScaledInstance(570,870, Image.SCALE_SMOOTH);
   ImageIcon lastimg1 = new ImageIcon(changeImg1);
   
   public DetailReservationFrame(TicketDTO ticket) {
      setTitle("영수증 출력");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
      cpane = new JPanel();
      cpane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(cpane);
      cpane.setLayout(null);
      setResizable(false);

      ConnectDB con = new ConnectDB();

      JLabel la_log = new JLabel("영수증");
      JLabel moive_name = new JLabel("상영 영화 :");
      JLabel la_id = new JLabel("영화관 :");
      JLabel la_pw = new JLabel("상영관 :");
      JLabel la_em = new JLabel("상영 일자 :");
      JLabel la_num = new JLabel("상영 시간 :");
      JLabel la_num1 = new JLabel("가격 :");
      JLabel la_num2 = new JLabel("좌석 번호 :");
      
      JLabel laimg = new JLabel(lastimg1);
      
      
      textField_name = new JLabel(ticket.getMovieName());
      textField_id = new JLabel(ticket.getTheatherName());
      textField_pw = new JLabel(ticket.getRoomNumber());
      textField_em = new JLabel(ticket.getDate());
      textField_num = new JLabel(ticket.getScreenTime());
      Integer cost = ticket.getCost();
      textField_num1 = new JLabel(cost.toString());
      textField_num2 = new JLabel(ticket.getSeatNumber());
      
      returnBtn = new JButton("돌아가기");
      editBtn = new JButton("좌석변경");
      deleteBtn = new JButton("예약취소");
      
      la_log.setFont(new Font("굴림", Font.BOLD, 20));
      moive_name.setFont(new Font("굴림", Font.BOLD, 15));
      la_id.setFont(new Font("굴림", Font.BOLD, 15));
      la_pw.setFont(new Font("굴림", Font.BOLD, 15));
      la_em.setFont(new Font("굴림", Font.BOLD, 15));
      la_num.setFont(new Font("굴림", Font.BOLD, 15));
      la_num1.setFont(new Font("굴림", Font.BOLD, 15));
      la_num2.setFont(new Font("굴림", Font.BOLD, 15));
      
      la_log.setBounds(245, 80, 80, 24);
      moive_name.setBounds(38, 162, 90, 44);
      la_id.setBounds(38, 227, 90, 44);
      la_pw.setBounds(38, 292, 90, 44);
      la_em.setBounds(38, 354, 90, 44);
      la_num.setBounds(38, 422, 90, 44);
      la_num1.setBounds(38, 482, 90, 44);
      la_num2.setBounds(38, 542, 90, 44);

      laimg.setBounds(106, 600, 350, 100);
      
      returnBtn.setBounds(220, 750, 100, 44);
      editBtn.setBounds(60, 750, 100, 44);
      deleteBtn.setBounds(380, 750, 100, 44);
      
      textField_name.setBounds(206- 70, 170 - 5, 380, 29);
      textField_id.setBounds(206 - 100, 239 - 5, 380, 29);
      textField_pw.setBounds(206 - 100, 304 - 5, 380, 29);
      textField_em.setBounds(206 - 70, 372 - 15, 380, 29);
      textField_num.setBounds(206 - 70, 450 - 20, 380, 29);
      textField_num1.setBounds(206 - 120, 518 - 30, 380, 29);
      textField_num2.setBounds(206 - 70, 586 - 40, 380, 29);
      
      
      returnBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
      
      editBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdatingSeatFrame(ticket);
				dispose();
			}
		});
      
      deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (con.deleteTicketTblColumns(ticket)) {
					new ResultDialog("삭제");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "삭제 실패, 다시 시도하세요", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
      
      cpane.add(la_log);
      cpane.add(moive_name);
      cpane.add(la_id);
      cpane.add(la_pw);
      cpane.add(la_em);
      cpane.add(la_num);
      cpane.add(la_num1);
      cpane.add(la_num2);
         
      cpane.add(textField_name);
      cpane.add(textField_id);
      cpane.add(textField_pw);
      cpane.add(textField_em);
      cpane.add(textField_num);
      cpane.add(textField_num1);
      cpane.add(textField_num2);
      cpane.add(laimg);
      cpane.add(returnBtn);
      cpane.add(editBtn);
      cpane.add(deleteBtn);
      
      
      setSize(600,900);
      setVisible(true);
   }
}