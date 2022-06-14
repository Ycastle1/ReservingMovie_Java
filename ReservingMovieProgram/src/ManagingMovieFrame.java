import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManagingMovieFrame extends JFrame {
	ConnectDB con;

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	

	private JLabel titleLabel;
	
	private JLabel[] roomNumberLabelList = new JLabel[6];
	private JLabel[] movieNameLabelList = new JLabel[6];
	private JLabel[] moviePosterSrcLabelList = new JLabel[6];
	
	private JButton[] updateButtonList = new JButton[6];
	private JButton[] deleteButtonList = new JButton[6];
	
	private ResultSet rs;
	
	private JButton returnButton;
	private JButton refreshBtn;
	
	public ManagingMovieFrame() {
		setTitle("상세 선택");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		
		con = new ConnectDB();
		
		titleLabel = new JLabel("상영 영화 정보");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 16));
		panel1.add(titleLabel);
		
		panel2.setLayout(null);
		rs = con.getMovieResultSet(); //ticket.getCustomerId
		try {
			int i = 0;
			while (rs.next()) {
				Integer roomNumber = rs.getInt("roomNumber");
				roomNumberLabelList[i] = new JLabel(roomNumber.toString());
				movieNameLabelList[i] = new JLabel(rs.getString("moviename"));
				moviePosterSrcLabelList[i] = new JLabel(rs.getString("moviePosterSrc"));
				updateButtonList[i] = new JButton("수정");
				if (movieNameLabelList[i].getText().equals("null")) {
					updateButtonList[i].setText("생성");
				}
				deleteButtonList[i] = new JButton("삭제");
				
				roomNumberLabelList[i].setBounds(10, (i * 30), 20, 100);
				movieNameLabelList[i].setBounds(50, (i * 30), 120, 100);
				moviePosterSrcLabelList[i].setBounds(180, (i * 30), 200, 100);
				updateButtonList[i].setBounds(380, (i * 30) +  40, 60, 20);
				deleteButtonList[i].setBounds(450, (i * 30) +  40, 60, 20);
				

				int j = i;
				//수정 버튼
				updateButtonList[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MovieDTO movie = new MovieDTO();

						movie.setMovieName(movieNameLabelList[j].getText());
						movie.setMoviePosterSrc(moviePosterSrcLabelList[j].getText());
						movie.setRoomNumber(Integer.parseInt(roomNumberLabelList[j].getText()));
						new UpdateDialog(movie);
					}
				});
				//삭제 버튼 
				deleteButtonList[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println(j);
						if (!movieNameLabelList[j].getText().equals("null")) {
							System.out.println(j);
							if (con.updateMovieInfo(j + 1, "null", "./Moive_image/empty.png")) {
								new ResultDialog("삭제");
							} else {
								System.out.println("삭제 오류.");
							}
						} else {
							System.out.println("삭제할 영화가 없습니다.");
						}
					}
				});
				
				panel2.add(roomNumberLabelList[i]);
				panel2.add(movieNameLabelList[i]);
				panel2.add(moviePosterSrcLabelList[i]);
				panel2.add(updateButtonList[i]);
				panel2.add(deleteButtonList[i]);
				
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		refreshBtn = new JButton("새로고침");
		refreshBtn.setBounds(10, 230, 510, 40);
		//새로고침 버튼
		refreshBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rs = con.getMovieResultSet(); //ticket.getCustomerId
				try {
					int i = 0;
					while (rs.next()) {
						Integer roomNumber = rs.getInt("roomNumber");
						roomNumberLabelList[i].setText(roomNumber.toString());
						movieNameLabelList[i].setText(rs.getString("moviename"));
						moviePosterSrcLabelList[i].setText(rs.getString("moviePosterSrc"));
						
						if (movieNameLabelList[i].getText().equals("null")) {
							updateButtonList[i].setText("생성");
						} else {
							updateButtonList[i].setText("수정");
						}
						deleteButtonList[i] = new JButton("삭제");
						
						i++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		panel2.add(refreshBtn);
		returnButton = new JButton("돌아가기");
		panel3.add(returnButton);
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
    	add(BorderLayout.NORTH, panel1);
    	add(BorderLayout.CENTER, panel2);
    	add(BorderLayout.SOUTH, panel3);

		setSize(550,700);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ManagingMovieFrame();
	}
}
