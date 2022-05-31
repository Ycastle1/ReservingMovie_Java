import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.toedter.calendar.JCalendar;

public class ChooseFrame extends JFrame implements ItemListener {
	
	private TicketDTO ticket;
	
	private String theatherName;
	private String screenTime;
	private String date;

	private int childrenCount;
	private int adultCount;
	private int cost;
	
	private JRadioButton theatherCh_time1;
	private JRadioButton theatherCh_time2;
	private JRadioButton theatherCh_time3;
	private JRadioButton theatherCh_time4;
	private JRadioButton theatherCh_time5;
	
	private	JRadioButton peopleCh_1;
	private	JRadioButton peopleCh_2;
	private	JRadioButton peopleCh_3;
	private	JRadioButton peopleCh_4;
	private	JRadioButton peopleCh_5;
	private	JRadioButton peopleCh_6;
	private	JRadioButton peopleCh_7;
	private	JRadioButton peopleCh_8;
	private	JRadioButton peopleCh_9;
	private	JRadioButton peopleCh_10;
	
	private SeatView seatView;
//	private JPanel contentPane;
	
	public static void main(String[] args) {
        new ChooseFrame();
	}
	public ChooseFrame() {
		setTitle("예매하기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container contentPane = getContentPane();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		String[] theathers = { "송내점", "주안점", "의정부점", "살려줘" };
		JList<String> theatherList = new JList<String>(theathers);
		
		theatherList.setBackground(new Color(255, 255, 255));
		theatherList.setToolTipText("");
		theatherList.setBounds(70, 62, 251, 169);
		contentPane.add(theatherList);
		
		theatherList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (theatherList.getSelectedValue()!=null) { //getSelectedValue() : 선택된 항목(Object 타입) 반환
					theatherName = (String)theatherList.getSelectedValue();
				}
			}
		});
		
		
		JLabel theatherCh = new JLabel("극장선택");
		theatherCh.setFont(new Font("굴림", Font.BOLD, 16));
		theatherCh.setBounds(159, 10, 102, 60);
		contentPane.add(theatherCh);
		
		JLabel theatherCh_1 = new JLabel("시간 선택");
		theatherCh_1.setFont(new Font("굴림", Font.BOLD, 16));
		theatherCh_1.setBounds(512, 10, 102, 60);
		contentPane.add(theatherCh_1);
		
		ButtonGroup timeGroup = new ButtonGroup();
		
		theatherCh_time1 = new JRadioButton(" 9:00 ~ 10:47");
		theatherCh_time1.setFont(new Font("굴림", Font.PLAIN, 15));
		theatherCh_time1.setBounds(463, 50, 153, 45);
		
		theatherCh_time2 = new JRadioButton("12:00 ~ 13:47");
		theatherCh_time2.setFont(new Font("굴림", Font.PLAIN, 15));
		theatherCh_time2.setBounds(461, 85, 153, 45);
		
		theatherCh_time3 = new JRadioButton("15:00 ~ 16:47");
		theatherCh_time3.setFont(new Font("굴림", Font.PLAIN, 15));
		theatherCh_time3.setBounds(461, 120, 153, 45);
		
		theatherCh_time4 = new JRadioButton("18:00 ~ 19:47");
		theatherCh_time4.setFont(new Font("굴림", Font.PLAIN, 15));
		theatherCh_time4.setBounds(461, 155, 157, 45);
		
		theatherCh_time5 = new JRadioButton("21:00 ~ 22:47");
		theatherCh_time5.setFont(new Font("굴림", Font.PLAIN, 15));
		theatherCh_time5.setBounds(461, 190, 146, 45);
		
		timeGroup.add(theatherCh_time1);
		timeGroup.add(theatherCh_time2);
		timeGroup.add(theatherCh_time3);
		timeGroup.add(theatherCh_time4);
		timeGroup.add(theatherCh_time5);
		

		contentPane.add(theatherCh_time1);
		contentPane.add(theatherCh_time2);
		contentPane.add(theatherCh_time3);
		contentPane.add(theatherCh_time4);
		contentPane.add(theatherCh_time5);
		
		theatherCh_time1.addItemListener(this);
		theatherCh_time2.addItemListener(this);
		theatherCh_time3.addItemListener(this);
		theatherCh_time4.addItemListener(this);
		theatherCh_time5.addItemListener(this);
		
		JLabel peopleCh = new JLabel("인원 선택");
		peopleCh.setFont(new Font("굴림", Font.BOLD, 16));
		peopleCh.setBounds(160, 250, 77, 60);
		contentPane.add(peopleCh);
		
		JLabel peopleCh_ad = new JLabel("성인");
		peopleCh_ad.setBounds(57, 320 - 20, 138, 45);
		contentPane.add(peopleCh_ad);
		
		JLabel peopleCh_cl = new JLabel("청소년");
		peopleCh_cl.setBounds(57, 418 - 30, 138, 45);
		contentPane.add(peopleCh_cl);
		
		ButtonGroup childrenGroup = new ButtonGroup();
		
		peopleCh_1 = new JRadioButton("0", true);
		peopleCh_1.setBounds(57, 370 - 30, 45, 23);
		
		peopleCh_2 = new JRadioButton("1");
		peopleCh_2.setBounds(106, 370 - 30, 45, 23);
		
		peopleCh_3 = new JRadioButton("2");
		peopleCh_3.setBounds(159, 370 - 30, 45, 23);
		
		peopleCh_4 = new JRadioButton("3");
		peopleCh_4.setBounds(208, 370 - 30, 45, 23);
		
		peopleCh_5 = new JRadioButton("4");
		peopleCh_5.setBounds(257, 370 - 30, 45, 23);
		
		childrenGroup.add(peopleCh_1);
		childrenGroup.add(peopleCh_2);
		childrenGroup.add(peopleCh_3);
		childrenGroup.add(peopleCh_4);
		childrenGroup.add(peopleCh_5);
		

		contentPane.add(peopleCh_1);
		contentPane.add(peopleCh_2);
		contentPane.add(peopleCh_3);
		contentPane.add(peopleCh_4);
		contentPane.add(peopleCh_5);
		
		peopleCh_1.addItemListener(this);
		peopleCh_2.addItemListener(this);
		peopleCh_3.addItemListener(this);
		peopleCh_4.addItemListener(this);
		peopleCh_5.addItemListener(this);
		
		ButtonGroup adultGroup = new ButtonGroup();
		
		peopleCh_6 = new JRadioButton("0", true);
		peopleCh_6.setBounds(57, 470 - 30, 45, 23);
		
		peopleCh_7 = new JRadioButton("1");
		peopleCh_7.setBounds(106, 470 - 30, 45, 23);
		
		peopleCh_8 = new JRadioButton("2");
		peopleCh_8.setBounds(159, 470 - 30, 45, 23);
		
		peopleCh_9 = new JRadioButton("3");
		peopleCh_9.setBounds(208, 470 - 30, 45, 23);
		
		peopleCh_10 = new JRadioButton("4");
		peopleCh_10.setBounds(257, 470 - 30, 45, 23);
		
		adultGroup.add(peopleCh_6);
		adultGroup.add(peopleCh_7);
		adultGroup.add(peopleCh_8);
		adultGroup.add(peopleCh_9);
		adultGroup.add(peopleCh_10);
		
		contentPane.add(peopleCh_6);
		contentPane.add(peopleCh_7);
		contentPane.add(peopleCh_8);
		contentPane.add(peopleCh_9);
		contentPane.add(peopleCh_10);		

		peopleCh_6.addItemListener(this);
		peopleCh_7.addItemListener(this);
		peopleCh_8.addItemListener(this);
		peopleCh_9.addItemListener(this);
		peopleCh_10.addItemListener(this);
		
		JPanel mCalendarPanel = new JPanel();
		JLabel choiceCalendarLabel = new JLabel("날짜 선택");		
		JCalendar calendar = new JCalendar();
		
		mCalendarPanel.setBounds(450, 250, 221, 325);
		mCalendarPanel.setLayout(null);
		add(mCalendarPanel);

		choiceCalendarLabel.setFont(new Font("굴림", Font.BOLD, 16));
		choiceCalendarLabel.setBounds(65, 0, 77, 60);
		mCalendarPanel.add(choiceCalendarLabel);
		
		calendar.setBounds(0, 55, 220, 200);
		mCalendarPanel.add(calendar);
		
		calendar.addPropertyChangeListener("calendar", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				final Calendar c = (Calendar) e.getNewValue();
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH)+1;
				int day = c.get(Calendar.DAY_OF_MONTH);
				//System.out.println(year + "," + month +"," +day);
				date = Integer.toString(year) + "년 " + Integer.toString(month) +"월 " + Integer.toString(day) +"일";
			}
		});
		
		JButton btnNewButton = new JButton("예매하기");
		btnNewButton.setBackground(SystemColor.controlLtHighlight);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 14));
		btnNewButton.setBounds(290, 591, 197, 60);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton) {
					ticket = new TicketDTO();
					ticket.setScreenTime(screenTime);
					ticket.setTheatherName(theatherName);
					ticket.setDate(date);
					ticket.setPersonCount(adultCount + childrenCount);
					ticket.setCost(adultCount * 10000 + childrenCount * 7000);
					seatView = new SeatView(ticket);
					dispose();
				}
			}
		});
		
		setSize(800,700);
		setVisible(true);
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(theatherCh_time1.isSelected()) {
			screenTime = theatherCh_time1.getText();
		}else if(theatherCh_time2.isSelected()) {
			screenTime = theatherCh_time2.getText();
		} else if(theatherCh_time3.isSelected()) {
			screenTime = theatherCh_time3.getText();
		} else if(theatherCh_time4.isSelected()) {
			screenTime = theatherCh_time4.getText();
		} else if(theatherCh_time5.isSelected()) {
			screenTime = theatherCh_time5.getText();
		}
			
		if(peopleCh_1.isSelected()) {
			adultCount = 0;
		} else if(peopleCh_2.isSelected()) {
			adultCount = 1;
		} else if(peopleCh_3.isSelected()) {
			adultCount = 2;
		} else if(peopleCh_4.isSelected()) {
			adultCount = 3;
		} else if(peopleCh_5.isSelected()) {
			adultCount = 4;
		}
		
		if(peopleCh_6.isSelected()) {
			childrenCount = 0;
		} else if(peopleCh_7.isSelected()) {
			childrenCount = 1;
		} else if(peopleCh_8.isSelected()) {
			childrenCount = 2;
		} else if(peopleCh_9.isSelected()) {
			childrenCount = 3;
		} else if(peopleCh_10.isSelected()) {
			childrenCount = 4;
		}
	}
}