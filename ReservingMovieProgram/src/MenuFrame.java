import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuFrame extends JFrame{
	ImageIcon img1 = new ImageIcon("./Moive_image/moive1.png");
	ImageIcon img2 = new ImageIcon("./Moive_image/moive2.jpg");
	ImageIcon img3 = new ImageIcon("./Moive_image/moive3.jpg");
	ImageIcon img4 = new ImageIcon("./Moive_image/moive4.jpg");
	ImageIcon img5 = new ImageIcon("./Moive_image/moive5.jpg");
	ImageIcon img6 = new ImageIcon("./Moive_image/moive6.jpg");
      public MenuFrame() {
    	  JFrame JFrameAll = new JFrame();
    	  JPanel panel = new JPanel();
    	  JPanel panel2 = new JPanel();
    	  JLabel label = new JLabel("영화를 선택해주세요.");
    	  JButton Movie1 = new JButton(img1);
    	  JButton Movie2 = new JButton(img2);
    	  JButton Movie3 = new JButton(img3);
    	  JButton Movie4 = new JButton(img4);
    	  JButton Movie5 = new JButton(img5);
    	  JButton Movie6 = new JButton(img6);
    	  
    	  Movie1.setPreferredSize(new Dimension(170,290));
    	  Movie2.setPreferredSize(new Dimension(170,290));
    	  Movie3.setPreferredSize(new Dimension(170,290));
    	  Movie4.setPreferredSize(new Dimension(170,290));
    	  Movie5.setPreferredSize(new Dimension(170,290));
    	  Movie6.setPreferredSize(new Dimension(170,290));
    	  
    	  JFrameAll.setTitle("극장");
    	  panel.add(label);
    	  
    	 
    	  panel2.add(Movie1);
    	  panel2.add(Movie2);
    	  panel2.add(Movie3);
    	  panel2.add(Movie4);
    	  panel2.add(Movie5);
    	  panel2.add(Movie6);
    	  
    	  
    	  JFrameAll.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  JFrameAll.getContentPane().add(BorderLayout.NORTH, panel);
    	  JFrameAll.getContentPane().add(BorderLayout.CENTER, panel2);
    	  JFrameAll.setSize(550, 700);
    	  JFrameAll.setVisible(true);
    	  
    	  Movie1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("성공");
				  new ChooseFrame();
			        setVisible(false);
			}
    		  
    	  });
    	  Movie2.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent e) {
  				// TODO Auto-generated method stub
  				System.out.println("성공");
  			  new ChooseFrame();
		        setVisible(false);
  			}
      		  
      	  });
    	  Movie3.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent e) {
  				// TODO Auto-generated method stub
  				System.out.println("성공");
  			  new ChooseFrame();
		        setVisible(false);
  			}
      		  
      	  });
    	  Movie4.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent e) {
  				// TODO Auto-generated method stub
  				System.out.println("성공");
  			  new ChooseFrame();
		        setVisible(false);
  			}
      		  
      	  });
    	  Movie5.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent e) {
  				// TODO Auto-generated method stub
  				System.out.println("성공");
  			  new ChooseFrame();
		        setVisible(false);
  			}
      		  
      	  });
    	  Movie6.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent e) {
  				// TODO Auto-generated method stub
  				System.out.println("성공");
  			  new ChooseFrame();
		        setVisible(false);
  			}
      		  
      	  });
      }
public static void main(String[] args) {
	new MenuFrame();
  }
}
