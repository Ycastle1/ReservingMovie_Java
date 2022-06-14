import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import DAO.MovieDAO;
import DTO.MovieDTO;

public class UpdateDialog extends JDialog {
	private JFileChooser chooser;
	FileNameExtensionFilter filter;
	
	public UpdateDialog(MovieDTO movie) {
		setTitle(" 완료");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		MovieDAO movieDAO = new MovieDAO();

		JTextField movieName = new JTextField(movie.getMovieName());
		JTextField movieSrc = new JTextField(movie.getMoviePosterSrc());
		JButton checkFilePathBtn = new JButton("찾아보기");
		JButton goodBtn = new JButton("확인");
		JButton cancelBtn = new JButton("취소");
		
		
		movieName.setBounds(10, 10, 250, 30);
		movieSrc.setBounds(10, 60, 250, 30);
		checkFilePathBtn.setBounds(270, 60, 100, 30);
		goodBtn.setBounds(70, 100, 100, 30);
		cancelBtn.setBounds(200, 100, 100, 30);
		
		movieSrc.setEditable(false);
		
		checkFilePathBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser();
				filter = new FileNameExtensionFilter("JPG, PNG Files", "jpg", "png");
				
				chooser.setFileFilter(filter);
				
				int ret = chooser.showOpenDialog(null);
				if(ret == JFileChooser.APPROVE_OPTION) {
					String pathName = chooser.getSelectedFile().getPath();
					pathName = pathName.replace('\\', '/');
					movieSrc.setText("." + pathName.substring(73, 96));
				}
			}
			
		});
		

		goodBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (movieDAO.updateMovieInfo(movie.getRoomNumber(), movieName.getText(), movieSrc.getText())) {
					System.out.println(movie.getRoomNumber());
					new ResultDialog("수정");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "수정 실패, 다시 시도하세요", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		add(movieName);
		add(movieSrc);
		add(checkFilePathBtn);
		add(goodBtn);
		add(cancelBtn);

		setSize(400, 180);
		setVisible(true);
	}
}



