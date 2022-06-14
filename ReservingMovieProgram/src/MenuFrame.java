import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuFrame extends JFrame{
	RecentReservationFrame rrf;	
	TicketDTO ticket;
	MovieDTO[] movieList = new MovieDTO[6];
	ArrayList<Image> imageList = new ArrayList<>();
	
	//영화 이미지 등록
	
	ImageIcon img1;
	ImageIcon img2;
	ImageIcon img3;
	ImageIcon img4;
	ImageIcon img5;
	ImageIcon img6;
	
	Image img1_1;
	Image img2_1;
	Image img3_1;
	Image img4_1;
	Image img5_1;
	Image img6_1;
	
	
	Image changeImg1;
	Image changeImg2;
	Image changeImg3;
	Image changeImg4;
	Image changeImg5;
	Image changeImg6;
	
	ImageIcon lastimg1;
	ImageIcon lastimg2;
	ImageIcon lastimg3;
	ImageIcon lastimg4;
	ImageIcon lastimg5;
	ImageIcon lastimg6;
	
	JButton movie1;
	JButton movie2;
	JButton movie3;
	JButton movie4;
	JButton movie5;
	JButton movie6;
	
	
    public MenuFrame(TicketDTO ticket) {
    	setTitle("극장");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
    	
    	ConnectDB con = new ConnectDB();
    	
    	this.ticket = ticket;
    	JPanel panel = new JPanel();
    	JPanel panel2 = new JPanel();
    	JPanel panel3 = new JPanel();
    	  
    	JLabel label = new JLabel("영화를 선택해주세요.");

    	movieList = con.getMovieList(movieList);
    	
    	img1 = new ImageIcon(movieList[0].getMoviePosterSrc());
    	img2 = new ImageIcon(movieList[1].getMoviePosterSrc());
    	img3 = new ImageIcon(movieList[2].getMoviePosterSrc());
    	img4 = new ImageIcon(movieList[3].getMoviePosterSrc());
    	img5 = new ImageIcon(movieList[4].getMoviePosterSrc());
    	img6 = new ImageIcon(movieList[5].getMoviePosterSrc());
    	
    	img1_1 = img1.getImage();
    	img2_1 = img2.getImage();
    	img3_1 = img3.getImage();
    	img4_1 = img4.getImage();
    	img5_1 = img5.getImage();
    	img6_1 = img6.getImage();
    	
    	changeImg1 = img1_1.getScaledInstance(210,370, Image.SCALE_SMOOTH);
    	changeImg2 = img2_1.getScaledInstance(200,300, Image.SCALE_SMOOTH);
    	changeImg3 = img3_1.getScaledInstance(200,288, Image.SCALE_SMOOTH);
    	changeImg4 = img4_1.getScaledInstance(200,288, Image.SCALE_SMOOTH);
    	changeImg5 = img5_1.getScaledInstance(190,330, Image.SCALE_SMOOTH);
    	changeImg6 = img6_1.getScaledInstance(190,300, Image.SCALE_SMOOTH);
    	
    	lastimg1 = new ImageIcon(changeImg1);
    	lastimg2 = new ImageIcon(changeImg2);
    	lastimg3 = new ImageIcon(changeImg3);
    	lastimg4 = new ImageIcon(changeImg4);
    	lastimg5 = new ImageIcon(changeImg5);
    	lastimg6 = new ImageIcon(changeImg6);
    	
    	//영화 포스터가 삽입된 이미지버튼으로 프레임 구성
    	movie1 = new JButton(lastimg1);
    	movie2 = new JButton(lastimg2);
    	movie3 = new JButton(lastimg3);
    	movie4 = new JButton(lastimg4);
    	movie5 = new JButton(lastimg5);
    	movie6 = new JButton(lastimg6);
    	  
    	movie1.setPreferredSize(new Dimension(170, 290));
    	movie2.setPreferredSize(new Dimension(170, 290));
    	movie3.setPreferredSize(new Dimension(170, 290));
    	movie4.setPreferredSize(new Dimension(170, 290));
    	movie5.setPreferredSize(new Dimension(170, 290));
    	movie6.setPreferredSize(new Dimension(170, 290));
    	
    	movie1.setName(movieList[0].getMovieName());
    	movie2.setName(movieList[1].getMovieName());
    	movie3.setName(movieList[2].getMovieName());
    	movie4.setName(movieList[3].getMovieName());
    	movie5.setName(movieList[4].getMovieName());
    	movie6.setName(movieList[5].getMovieName());
    	
    	movie1.addActionListener(new MenuActionListener());
    	movie2.addActionListener(new MenuActionListener());
    	movie3.addActionListener(new MenuActionListener());
    	movie4.addActionListener(new MenuActionListener());
    	movie5.addActionListener(new MenuActionListener());
    	movie6.addActionListener(new MenuActionListener());
    	
    	panel.add(label);
    	
    	panel2.add(movie1);
    	panel2.add(movie2);
    	panel2.add(movie3);
    	panel2.add(movie4);
    	panel2.add(movie5);
    	panel2.add(movie6);
    	//예매한 내역을 보여주는 프레임으로 이동할 버튼
    	JButton managingMovieBtn = new JButton("영화 관리");
    	JButton checkReservationBtn = new JButton("예매 내역");
    	panel3.add(BorderLayout.CENTER, checkReservationBtn);
    	checkReservationBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rrf = new RecentReservationFrame(ticket);
			}
    		
    	});

    	getContentPane().add(BorderLayout.NORTH, panel);
    	getContentPane().add(BorderLayout.CENTER, panel2);
    	getContentPane().add(BorderLayout.SOUTH, panel3);
    	
    	setSize(550, 700);
    	setVisible(true);
    }	
    
//	public static void main(String[] args) {
//		new MenuFrame();
//	}
	
	class MenuActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			System.out.println("성공");
			ticket.setMovieName(btn.getName());
			System.out.println(ticket.getMovieName());
			
			if (!ticket.getMovieName().equals("null")) {
				new ChooseFrame(ticket);
			}
			else {
				new emptyDialog();
			}
		}    	  
	}
}
