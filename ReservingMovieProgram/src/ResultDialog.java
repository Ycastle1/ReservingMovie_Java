import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResultDialog extends JDialog {
	private JLabel success;
	public ResultDialog(String word) {
		setTitle(word + " 완료");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		success = new JLabel(word + " 완료되었습니다 !");
		
		success.setBounds(25, 15, 250, 80);
		success.setFont(new Font("굴림", Font.BOLD, 20));
		
		add(success);
		
		setSize(300, 150);
		setVisible(true);
	}
}
