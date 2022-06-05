import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResultDialog extends JDialog {
	private JLabel success = new JLabel("예매가 완료되었습니다 !");
	
	public ResultDialog() {
		setTitle("예매 완료");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		success.setBounds(25, 15, 250, 80);
		success.setFont(new Font("굴림", Font.BOLD, 20));
		
		add(success);
		
		setSize(300, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ResultDialog();
	}
}
