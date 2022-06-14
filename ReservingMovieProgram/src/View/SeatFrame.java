package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.SeatDAO;
import DAO.TicketDAO;
import DTO.SeatDTO;
import DTO.TicketDTO;

public class SeatFrame extends JFrame {
	ResultDialog resultDialog;
	
	TicketDAO ticketDAO;
	SeatDAO seatDAO;
	
	TicketDTO ticket;
	SeatDTO seatDto;
	
	
	SeatPanel seatPanel;
	InfoPanel infoPanel;
	
	String[] seatArray;
	ArrayList<JLabel> seatInfoLabel;
	
	int personCount = 0;
	SeatFrame(TicketDTO ticket) {
		setTitle("좌석 선택");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		this.ticket = ticket;
		
       	personCount = ticket.getPersonCount();
       	
       	seatDto = new SeatDTO();
       	seatDto.setMovieName(ticket.getMovieName());
       	seatDto.setTheatherName(ticket.getTheatherName());
       	seatDto.setRoomNumber(ticket.getRoomNumber());
       	seatDto.setDate(ticket.getDate());
       	seatDto.setScreenTime(ticket.getScreenTime());

		infoPanel = new InfoPanel();
		infoPanel.setBounds(600, 0, 170, 700);
		add(infoPanel);
		
		seatPanel = new SeatPanel();
		seatPanel.setBounds(20, 0, 550, 700);
		add(seatPanel);
		
		setSize(800, 700);
		setVisible(true);
	}
	
	class SeatPanel extends JPanel {
		private SeatGrid seatGrid;
		public SeatPanel() {
		    
		     setLayout(new BorderLayout());
		   

		     JTextField txtScreen = new JTextField();
		     txtScreen.setFont(new Font("굴림", Font.BOLD, 20));
	         txtScreen.setBackground(Color.black);
	         txtScreen.setForeground(SystemColor.textHighlightText);
	         txtScreen.setHorizontalAlignment(SwingConstants.CENTER);
	         txtScreen.setText("SCREEN");
		     
		     seatGrid = new SeatGrid();
		     seatGrid.setBounds(0, 0, 550, 700);
		     
	         
	         add(txtScreen, BorderLayout.NORTH);
	         add(new SeatGrid(), BorderLayout.CENTER);
		}
		
		class SeatGrid extends JPanel{
	        public SeatGrid() {
	        	ticketDAO = new TicketDAO();
	        	seatDAO = new SeatDAO();
	        	setLayout(null);
	        	
	           	JButton btnNewButton = new JButton("예매하기");
	           	btnNewButton.setPreferredSize(new Dimension(450,40));
	           	btnNewButton.setBackground(Color.black);
	           	btnNewButton.setForeground(SystemColor.textHighlightText);
	           	btnNewButton.setBounds(220, 560, 110, 40);
	   		   
	   		     
	        	boolean seatflag[][] = new boolean[10][10];
	            JButton seat[][] = new JButton[10][10];
	        	char Acode = 65; // 좌석번호에서 활용할 아스키코드 a값

	        	for (int i = 0; i < 10; i++) {
	        		int k = i; 
	        		String Aseat = String.valueOf(Acode);
	        		
	        		for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
	        			int l= j;
	        			
	        			seat [i][j] = new JButton(Aseat+(j+1));
	        			seat[i][j].setFont(new Font("굴림", Font.BOLD, 10));
	        			seat[i][j].setBounds((55 * (j + 1)) - 55, (50 * (i + 1)), 52, 30);
	        			
	        			if (j == 9) {
	        				seat[i][j].setFont(new Font("굴림", Font.BOLD, 9));
	        			}
	        			add(seat[i][j]);
	        			
	        			ticket.setSeatNumber(seat[i][j].getText());
	                 
	        			if (!seatDAO.checkReserved(ticket)) {
	        				seat[i][j].addMouseListener(new MouseAdapter() {
		        				@Override
								public void mouseClicked(MouseEvent e) {
		        					int i;
		        					if (e.getButton() == 1 && seatflag[k][l] == false && personCount > 0) { // flag로 ture, false 구별
		        						seat[k][l].setBackground(Color.red);
		        						seatflag[k][l] = true;
	        							i = 1;
		        						for (JLabel label : seatInfoLabel) {
		        							if (label.getText().equals("좌석 " + i)) {
		        								label.setText(seat[k][l].getText());
		        								break;
		        							}
		        							i++;
		        						}
		        						personCount--;
		        					} else if (e.getButton() == 1 && seatflag[k][l] == true) {
		        						seat[k][l].setBackground(Color.getColor(Aseat));
		        						seatflag[k][l] = false;
	        							i = 1;
		        						for (JLabel label : seatInfoLabel) {
		        							if (label.getText().equals(seat[k][l].getText())) {
		        								label.setText("좌석 " + i);
		        								break;
		        							}
		        							i++;
		        						}
		        						personCount++;
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
	        	btnNewButton.addMouseListener(new MouseAdapter() {
    				@Override
					public void mouseClicked(MouseEvent e) {
    					if (personCount == 0) {
    						seatArray = new String[ticket.getPersonCount()];
    						int index = 0;
    						char Acode = 65;
    						for (int i = 0; i < 10; i++) {
    			        		String Aseat = String.valueOf(Acode);
    			        		
    			        		for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    			        			if (seatflag[i][j]) {
    			        				seatArray[index] = seat[i][j].getText();
    			        				index++;
    			        			}
    			        		}
    			        		Acode++;
    			        	}
    						String seatNumber = seatArray[0];
    						seatDto.setSeatNumber(seatArray[0]);
        					seatDAO.reserveSeat(seatDto);
    						for (int i = 1; i < seatArray.length; i++) {
    							seatNumber = seatNumber.concat(", ");
    							seatNumber = seatNumber.concat(seatArray[i]);
    							
    							seatDto.setSeatNumber(seatArray[i]);
            					seatDAO.reserveSeat(seatDto);
    						}
    						ticket.setSeatNumber(seatNumber);
    					}
    					ticketDAO.addTicketTblColumns(ticket);
    					resultDialog = new ResultDialog("예매"); 
    					dispose();
    				}
    			});
	        	setVisible(true);
	        }
		}
	}
	
	class InfoPanel extends JPanel {
		public InfoPanel() {
			setLayout(null);
			setBackground(Color.WHITE);
			
			
			JLabel movieNameLabel = new JLabel("상영 영화 : " );
			JLabel movieNameInfoLabel = new JLabel(ticket.getMovieName());
			JLabel theatherNameLabel = new JLabel("영화관 : " );
			JLabel theatherNameInfoLabel = new JLabel(ticket.getTheatherName());
			JLabel roomNameLabel = new JLabel("상영관 : ");
			JLabel roomNameInfoLabel = new JLabel(ticket.getRoomNumber() + "관");
			JLabel dateLabel = new JLabel("상영일자 : ");
			JLabel dateInfoLabel = new JLabel(ticket.getDate());
			JLabel timeLabel = new JLabel("상영시간 : ");
			JLabel timeInfoLabel = new JLabel(ticket.getScreenTime());
			JLabel seatLabel = new JLabel("좌석 :");

			movieNameLabel.setBounds(10, 10, 150, 40);
			movieNameInfoLabel.setBounds(40, 40, 100, 40);
			theatherNameLabel.setBounds(10, 70, 70, 40);
			theatherNameInfoLabel.setBounds(40, 100, 100, 40);
			roomNameLabel.setBounds(10, 130, 100, 40);
			roomNameInfoLabel.setBounds(40, 160, 100, 40);
			dateLabel.setBounds(10, 190, 100, 40);
			dateInfoLabel.setBounds(40, 220, 100, 40);
			timeLabel.setBounds(10, 250, 100, 40);
			timeInfoLabel.setBounds(40, 280, 100, 40);
			seatLabel.setBounds(10, 310, 100, 40);

			add(movieNameLabel);
			add(movieNameInfoLabel);
			add(theatherNameLabel);
			add(theatherNameInfoLabel);
			add(roomNameLabel);
			add(roomNameInfoLabel);
			add(theatherNameLabel);
			add(theatherNameInfoLabel);
			add(dateLabel);
			add(dateInfoLabel);
			add(timeLabel);
			add(timeInfoLabel);
			add(seatLabel);
			
			
			seatInfoLabel = new ArrayList<>();
			
			for (int i = 0; i < personCount; i++) {
				seatInfoLabel.add(new JLabel("좌석 " + (i + 1)));
				seatInfoLabel.get(i).setBounds(50, 40 * (i + 1) + 300, 70, 40);
				add(seatInfoLabel.get(i));
			}
		}
	}
}