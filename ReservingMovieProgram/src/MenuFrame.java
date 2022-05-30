import java.awt.BorderLayout;
import java.awt.Container;
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
    	setTitle("극장");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  
    	JPanel panel = new JPanel();
    	JPanel panel2 = new JPanel();
    	  
    	JLabel label = new JLabel("영화를 선택해주세요.");
    	  
    	JButton movie1 = new JButton(img1);
    	JButton movie2 = new JButton(img2);
    	JButton movie3 = new JButton(img3);
    	JButton movie4 = new JButton(img4);
    	JButton movie5 = new JButton(img5);
    	JButton movie6 = new JButton(img6);
    	  
    	movie1.setPreferredSize(new Dimension(170, 290));
    	movie2.setPreferredSize(new Dimension(170, 290));
    	movie3.setPreferredSize(new Dimension(170, 290));
    	movie4.setPreferredSize(new Dimension(170, 290));
    	movie5.setPreferredSize(new Dimension(170, 290));
    	movie6.setPreferredSize(new Dimension(170, 290));
    	
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
    
	public static void main(String[] args) {
		new MenuFrame();
	}
	
	class MenuActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("성공");
			new ChooseFrame();
			setVisible(false);
		}    	  
	}
}
