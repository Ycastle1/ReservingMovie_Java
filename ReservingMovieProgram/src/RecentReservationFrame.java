import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RecentReservationFrame extends JFrame {
	ConnectDB con;
	DetailReservationFrame drf;

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	

	private JLabel titleLabel;
	
	private ArrayList<JLabel> indexLabelList = new ArrayList<>();
	private ArrayList<JLabel> dateLabelList = new ArrayList<>();
	private ArrayList<JLabel> theatherNameLabelList = new ArrayList<>();
	private ArrayList<JLabel> movieNameLabelList = new ArrayList<>();
	private ArrayList<JLabel> personCountLabelList = new ArrayList<>();
	
	private ArrayList<JButton> goBillDialogButtonList = new ArrayList<>();
	
	private ResultSet rs;
	
	private JButton returnButton;
	
	public RecentReservationFrame(TicketDTO ticket1) {
		setTitle("상세 선택");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		
		con = new ConnectDB();
		
		titleLabel = new JLabel("예매 내역");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 16));
		panel1.add(titleLabel);
		
		panel2.setLayout(null);
		rs = con.getReservationResultSet(ticket1.getCustomerId()); //ticket.getCustomerId
		Integer i  = 0;
		try {
			while (rs.next()) {
				Integer personCount = rs.getInt("personcount");
				
				indexLabelList.add(new JLabel(i.toString()));
				dateLabelList.add(new JLabel(rs.getString("date")));
				theatherNameLabelList.add(new JLabel(rs.getString("theathername")));
				movieNameLabelList.add(new JLabel(rs.getString("moviename")));
				personCountLabelList.add(new JLabel(personCount.toString() + "명"));
				goBillDialogButtonList.add(new JButton("상세내역"));
				
				indexLabelList.get(i).setBounds(10, (i * 30), 20, 100);
				dateLabelList.get(i).setBounds(50, (i * 30), 100, 100);
				theatherNameLabelList.get(i).setBounds(150, (i * 30), 100, 100);
				movieNameLabelList.get(i).setBounds(230, (i * 30), 100, 100);
				personCountLabelList.get(i).setBounds(350, (i * 30), 100, 100);
				goBillDialogButtonList.get(i).setBounds(410, (i * 30) +  40, 90, 20);
				
				TicketDTO ticket = new TicketDTO(rs.getString("customerName"),
												rs.getString("customerId"),
												rs.getString("seatNumber"),
												rs.getString("theatherName"),
												rs.getString("roomNumber"),
												rs.getString("movieName"),
												rs.getString("date"),
												rs.getString("screenTime"),
												rs.getInt("cost"),
												rs.getInt("personCount"));
				
				goBillDialogButtonList.get(i).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						drf = new DetailReservationFrame(ticket);
					}
				});
				
				panel2.add(indexLabelList.get(i));
				panel2.add(dateLabelList.get(i));
				panel2.add(theatherNameLabelList.get(i));
				panel2.add(movieNameLabelList.get(i));
				panel2.add(personCountLabelList.get(i));
				panel2.add(goBillDialogButtonList.get(i));
				
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
}
