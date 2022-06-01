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

public class SeatView extends JFrame {

	public SeatView(TicketDTO ticket) {
		this.setTitle("좌석선택");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setBounds(100,100,500,500);
	    setLayout(new BorderLayout());
	     
	     JTextField txtScreen = new JTextField();
	   
	     txtScreen.setFont(new Font("굴림", Font.BOLD, 20));
         txtScreen.setBackground(Color.black);
         txtScreen.setForeground(SystemColor.textHighlightText);
         txtScreen.setHorizontalAlignment(SwingConstants.CENTER);
         txtScreen.setText("SCREEN");
	    add(txtScreen,BorderLayout.NORTH);
	    add(new SecondSeat(),BorderLayout.CENTER);
		add(new seatokpanel(),BorderLayout.SOUTH);
	     this.setVisible(true);

	}
	public class SecondSeat extends JPanel{
		char Acode = 65; // 이건 아스키코드값으로 a부터 값을 받도록 했으
    	boolean seatflag[][] = new boolean[5][5];
        JButton seat[][] = new JButton[5][5];
        public SecondSeat() {
        	setSize(20,20);
        	setLayout(new FlowLayout(0,40,40));

        	for(int i = 0; i<5; i++) {
        		int k= i; //윤성아 그냥 i,j값을 배열에 넣으면 이상하게 에러가 떠서 해결이 안된다 ㅠㅠ 그래서 담을 값을 변경하니 성공
        		String Aseat = String.valueOf(Acode);
        		for(int j=0; j<5; j++) { //a좌석에 1번부터 받아오기
                int l= j; // 
				seat [i][j] = new JButton(Aseat+(j+1));
                 add(seat[i][j]);
                 
                seat[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if(e.getButton()==1 && seatflag[k][l] ==false) { // flag로 ture, false 구별
						seat[k][l].setBackground(Color.red);
						seatflag[k][l] = true;
					}
					else if(e.getButton()==1 && seatflag[k][l]==true) {
						seat[k][l].setBackground(Color.getColor(Aseat));
						seatflag[k][l] = false;
					}
					}
				   
                });

        		}
        		Acode++;
        	}
        
        	setVisible(true);
        }

}
	public class seatokpanel extends JPanel {
	
		public seatokpanel() {
           	JButton btnOkButton = new JButton("예매하기");
           	btnOkButton.setPreferredSize(new Dimension(400,40));
           	btnOkButton.setBackground(Color.black);
           	btnOkButton.setForeground(SystemColor.textHighlightText);
           	
            btnOkButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
                  System.out.println("성공");
				}
            	
            });
           	
           	
           	add(btnOkButton);
            this.setVisible(true);
		}
	}

	
}

