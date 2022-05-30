import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.SystemColor;

public class ChooseFrame extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
        new ChooseFrame();
	}
	public ChooseFrame() {
		setTitle("øπ∏≈«œ±‚");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBackground(new Color(255, 255, 255));
		list.setToolTipText("");
		list.setBounds(70, 62, 251, 169);
		contentPane.add(list);
		
		JLabel theatherCh = new JLabel("±ÿ¿Âº±≈√");
		theatherCh.setFont(new Font("±º∏≤", Font.BOLD, 16));
		theatherCh.setBounds(159, 10, 102, 60);
		contentPane.add(theatherCh);
		
		JLabel theatherCh_1 = new JLabel("Ω√∞£ º±≈√");
		theatherCh_1.setFont(new Font("±º∏≤", Font.BOLD, 16));
		theatherCh_1.setBounds(512, 10, 102, 60);
		contentPane.add(theatherCh_1);
		
		JRadioButton theatherCh_time = new JRadioButton("9:00 ~ 10:47");
		theatherCh_time.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		theatherCh_time.setBounds(461, 48, 153, 45);
		contentPane.add(theatherCh_time);
		
		JRadioButton theatherCh_time1 = new JRadioButton("12:00 ~ 13:47");
		theatherCh_time1.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		theatherCh_time1.setBounds(461, 86, 153, 45);
		contentPane.add(theatherCh_time1);
		
		JRadioButton theatherCh_time2 = new JRadioButton("15:00 ~ 16:47");
		theatherCh_time2.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		theatherCh_time2.setBounds(461, 120, 153, 45);
		contentPane.add(theatherCh_time2);
		
		JRadioButton theatherCh_time3 = new JRadioButton("18:00 ~ 19:47");
		theatherCh_time3.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		theatherCh_time3.setBounds(461, 155, 157, 45);
		contentPane.add(theatherCh_time3);
		
		JRadioButton theatherCh_time4 = new JRadioButton("21:00 ~ 22:47");
		theatherCh_time4.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		theatherCh_time4.setBounds(461, 186, 146, 45);
		contentPane.add(theatherCh_time4);
		
		JLabel peopleCh = new JLabel("¿Œø¯ º±≈√");
		peopleCh.setFont(new Font("±º∏≤", Font.BOLD, 16));
		peopleCh.setBounds(160, 295, 77, 60);
		contentPane.add(peopleCh);
		
		JLabel peopleCh_ad = new JLabel("º∫¿Œ");
		peopleCh_ad.setBounds(57, 349, 138, 45);
		contentPane.add(peopleCh_ad);
		
		JLabel peopleCh_cl = new JLabel("√ªº“≥‚");
		peopleCh_cl.setBounds(57, 442, 138, 45);
		contentPane.add(peopleCh_cl);
		
		JRadioButton peopleCh_1 = new JRadioButton("0");
		peopleCh_1.setBounds(57, 400, 45, 23);
		contentPane.add(peopleCh_1);
		
		JRadioButton peopleCh_2 = new JRadioButton("1");
		peopleCh_2.setBounds(106, 400, 45, 23);
		contentPane.add(peopleCh_2);
		
		JRadioButton peopleCh_3 = new JRadioButton("3");
		peopleCh_3.setBounds(208, 400, 45, 23);
		contentPane.add(peopleCh_3);
		
		JRadioButton peopleCh_4 = new JRadioButton("2");
		peopleCh_4.setBounds(159, 400, 45, 23);
		contentPane.add(peopleCh_4);
		
		JRadioButton peopleCh_5 = new JRadioButton("1");
		peopleCh_5.setBounds(57, 500, 45, 23);
		contentPane.add(peopleCh_5);
		
		JRadioButton peopleCh_6 = new JRadioButton("1");
		peopleCh_6.setBounds(106, 500, 45, 23);
		contentPane.add(peopleCh_6);
		
		JRadioButton peopleCh_7 = new JRadioButton("2");
		peopleCh_7.setBounds(159, 500, 45, 23);
		contentPane.add(peopleCh_7);
		
		JRadioButton peopleCh_8 = new JRadioButton("3");
		peopleCh_8.setBounds(208, 500, 45, 23);
		contentPane.add(peopleCh_8);
		
		JRadioButton peopleCh_9 = new JRadioButton("4");
		peopleCh_9.setBounds(257, 400, 45, 23);
		contentPane.add(peopleCh_9);
		
		JRadioButton peopleCh_10 = new JRadioButton("4");
		peopleCh_10.setBounds(257, 500, 45, 23);
		contentPane.add(peopleCh_10);
		
		JLabel peopleCh_11 = new JLabel("≥Ø¬• º±≈√");
		peopleCh_11.setFont(new Font("±º∏≤", Font.BOLD, 16));
		peopleCh_11.setBounds(493, 295, 77, 60);
		contentPane.add(peopleCh_11);
		
		JButton btnNewButton = new JButton("øπ∏≈«œ±‚");
		btnNewButton.setBackground(SystemColor.controlLtHighlight);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("±º∏≤", Font.BOLD, 14));
		btnNewButton.setBounds(290, 591, 197, 60);
		contentPane.add(btnNewButton);
		

		
		
		setSize(800,700);
		setVisible(true);
	}
}
