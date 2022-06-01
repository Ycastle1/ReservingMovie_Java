import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SeatFrame extends JFrame {
	TicketDTO ticket;
	ConnectDB con;
	SeatPanel seatPanel;
	SeatFrame() {
		setTitle("좌석 선택");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		seatPanel = new SeatPanel();
		seatPanel.setSize(550, 800);
		add(seatPanel);
		

		setSize(800, 700);
		setVisible(true);
	}
	static public void main(String[] args) {
		new SeatFrame();
	}
	class SeatPanel extends JPanel {
		private SeatGrid seatGrid;
		public SeatPanel() {
		    
		     setLayout(new BorderLayout());
		     
		     seatGrid = new SeatGrid();
		     seatGrid.setBounds(0, 0, 550, 800);
		     JTextField txtScreen = new JTextField();
		   
		     txtScreen.setFont(new Font("굴림", Font.BOLD, 20));
	         txtScreen.setBackground(Color.black);
	         txtScreen.setForeground(SystemColor.textHighlightText);
	         txtScreen.setHorizontalAlignment(SwingConstants.CENTER);
	         txtScreen.setText("SCREEN");
	         add(txtScreen,BorderLayout.NORTH);
	         add(new SeatGrid(),BorderLayout.CENTER);
		}
		
		class SeatGrid extends JPanel{
	        public SeatGrid() {
	        	con = new ConnectDB();
	        	setLayout(null);
	        	
	           	JButton btnNewButton = new JButton("예매하기");
	           	btnNewButton.setPreferredSize(new Dimension(450,40));
	           	btnNewButton.setBackground(Color.black);
	           	btnNewButton.setForeground(SystemColor.textHighlightText);
	           	
	           	ticket = new TicketDTO();
	           	ticket.setTheatherName("범죄도시2");
	           	ticket.setRoomNumber("1");
	           	ticket.setDate("220603");
	           	ticket.setscreenTime("09:00");
	   		   
	   		     
	        	char Acode = 65; // 이건 아스키코드값으로 a부터 값을 받도록 했으
	        	boolean seatflag[][] = new boolean[10][10];
	            JButton seat[][] = new JButton[10][10];
	        
	        	for (int i = 0; i < 10; i++) {
	        		int k= i; //윤성아 그냥 i,j값을 배열에 넣으면 이상하게 에러가 떠서 해결이 안된다 ㅠㅠ 그래서 담을 값을 변경하니 성공
	        		String Aseat = String.valueOf(Acode);
	        		
	        		for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
	        			
	        			int l= j; // 
	        			seat [i][j] = new JButton(Aseat+(j+1));
	        			ticket.setSeatNumber(seat[i][j].getText());
	        			seat[i][j].setFont(new Font("굴림", Font.BOLD, 10));
	        			seat[i][j].setBounds((55 * (j + 1)) - 55, (50 * (i + 1)), 52, 30);
	        			
	        			if (j == 9) {
	        				seat[i][j].setFont(new Font("굴림", Font.BOLD, 9));
	        			}
	        			add(seat[i][j]);
	                 
	        			if(!con.checkReserved(ticket)) {
	        				seat[i][j].addMouseListener(new MouseAdapter() {
		        				@Override
								public void mouseClicked(MouseEvent e) {
		        					if (e.getButton()==1 && seatflag[k][l] ==false) { // flag로 ture, false 구별
		        						seat[k][l].setBackground(Color.red);
		        						seatflag[k][l] = true;
		        					} else if (e.getButton()==1 && seatflag[k][l]==true) {
		        						seat[k][l].setBackground(Color.getColor(Aseat));
		        						seatflag[k][l] = false;
		        					}
		        				}
		        			});
	        			} else {
	        				seat[i][j].setEnabled(false);
	        			}
	        		}
	        		Acode++;
	        	}
	        	add(btnNewButton);
	        	setVisible(true);
	        }
	
		}
	}
}