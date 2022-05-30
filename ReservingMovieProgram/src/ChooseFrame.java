import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChooseFrame extends JFrame {
   public ChooseFrame() {
	   this.setTitle("선택하기");
       JPanel jPanel = new JPanel();
       JLabel la = new JLabel("선택하기");
       
       jPanel.add(la);   
       add(jPanel);
       this.setSize(550, 700);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            new ChooseFrame();
	}

}
