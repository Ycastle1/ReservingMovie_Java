package View;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class emptyDialog extends JDialog {
	private JLabel success = new JLabel("해당 상영관에 상영 중인 영화가 없습니다.");
	public emptyDialog() {
		super();
		setTitle("에러");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		success.setBounds(25, 15, 250, 80);
		success.setFont(new Font("굴림", Font.BOLD, 20));
		
		add(success);
		
		setSize(300, 150);
		setVisible(true);
	}
}
