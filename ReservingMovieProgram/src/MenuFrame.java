import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuFrame extends JFrame{
	TicketDTO ticket;
	
	ImageIcon img1 = new ImageIcon("./Moive_image/moive1.png");
	ImageIcon img2 = new ImageIcon("./Moive_image/moive2.jpg");
	ImageIcon img3 = new ImageIcon("./Moive_image/moive3.jpg");
	ImageIcon img4 = new ImageIcon("./Moive_image/moive4.jpg");
	ImageIcon img5 = new ImageIcon("./Moive_image/moive5.jpg");
	ImageIcon img6 = new ImageIcon("./Moive_image/moive6.jpg");
	
	Image img1_1 = img1.getImage();
	Image img2_1 = img2.getImage();
	Image img3_1 = img3.getImage();
	Image img4_1 = img4.getImage();
	Image img5_1 = img5.getImage();
	Image img6_1 = img6.getImage();
	
	Image changeImg1 = img1_1.getScaledInstance(210,370, Image.SCALE_SMOOTH);
	Image changeImg2 = img2_1.getScaledInstance(200,300, Image.SCALE_SMOOTH);
	Image changeImg3 = img3_1.getScaledInstance(200,288, Image.SCALE_SMOOTH);
	Image changeImg4 = img4_1.getScaledInstance(200,288, Image.SCALE_SMOOTH);
	Image changeImg5 = img5_1.getScaledInstance(190,330, Image.SCALE_SMOOTH);
	Image changeImg6 = img6_1.getScaledInstance(190,300, Image.SCALE_SMOOTH);
	
	ImageIcon lastimg1 = new ImageIcon(changeImg1);
	ImageIcon lastimg2 = new ImageIcon(changeImg2);
	ImageIcon lastimg3 = new ImageIcon(changeImg3);
	ImageIcon lastimg4 = new ImageIcon(changeImg4);
	ImageIcon lastimg5 = new ImageIcon(changeImg5);
	ImageIcon lastimg6 = new ImageIcon(changeImg6);
	
	
    public MenuFrame(TicketDTO ticket) {
    	setTitle("극장");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
    	
    	this.ticket = ticket;
    	JPanel panel = new JPanel();
    	JPanel panel2 = new JPanel();
    	  
    	JLabel label = new JLabel("영화를 선택해주세요.");
    	  
    	JButton movie1 = new JButton(lastimg1);
    	JButton movie2 = new JButton(lastimg2);
    	JButton movie3 = new JButton(lastimg3);
    	JButton movie4 = new JButton(lastimg4);
    	JButton movie5 = new JButton(lastimg5);
    	JButton movie6 = new JButton(lastimg6);
    	  
    	movie1.setPreferredSize(new Dimension(170, 290));
    	movie2.setPreferredSize(new Dimension(170, 290));
    	movie3.setPreferredSize(new Dimension(170, 290));
    	movie4.setPreferredSize(new Dimension(170, 290));
    	movie5.setPreferredSize(new Dimension(170, 290));
    	movie6.setPreferredSize(new Dimension(170, 290));
    	
    	movie1.setName("범죄도시2");
    	movie2.setName("닥터스트레인지2");
    	movie3.setName("베놈2");
    	movie4.setName("스파이더맨3");
    	movie5.setName("공기살인");
    	movie6.setName("마녀2");
    	
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

    	getContentPane().add(BorderLayout.NORTH, panel);
    	getContentPane().add(BorderLayout.CENTER, panel2);
    	
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
			new ChooseFrame(ticket);
//			setVisible(false);
		}    	  
	}
}
