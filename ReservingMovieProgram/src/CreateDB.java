import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

public class CreateDB {	
	
	public Connection createDB() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // ����̹� �ε�.
			System.out.println("����̹� ���� ����");
			
			String url = "jdbc:mysql://localhost:3306/reservemoviedb?serverTimezome=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			con = DriverManager.getConnection(url, user, password); //  ���� ��ü ������.
			System.out.println("DB 연결 성고 !");
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� ���߽��ϴ�.");
		} catch (SQLException e) {
			System.out.println("�����ͺ��̽� ���� ����");
		}
		
		return con;
	}
	
//	public boolean login(String id, String pw) {
//		String sql = "SELECT * FROM usertbl where userid = '" + id + "'";
//		Connection con = connectDB();
//		
//		try {
//			Statement stmt = con.createStatement();
//			ResultSet rs;
//			
//			rs = stmt.executeQuery(sql);
//			if (rs.next()){
//				String correctPassword = rs.getString("userPw");
//				if (pw.equals(correctPassword)) {		
//					System.out.println("����");			
//					return true;
//				}
//				else {
//					//��й�ȣ ����		
//					System.out.println("��й�ȣ ����");
//					return false;
//				}
//			}				
//			else {		
//				//���̵� ����
//				System.out.println("���̵� ����");
//				return false;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			//�����ͺ��̽� ����
//			System.out.println("�����ͺ��̽� ����");
//			return false;
//		}
//	}
	
	public void createSeatDB() {
		Connection con = createDB();
		char Acode = 65;
		String seat;
		
		try {
			Statement stmt = con.createStatement();
			
			if (stmt.executeUpdate("CREATE TABLE `reservemoviedb`.`seattbl` (\r\n"
					+ "  `theathername` VARCHAR(30) NOT NULL,\r\n"
					+ "  `roomnumber` VARCHAR(2) NOT NULL,\r\n"
					+ "  `seatnumber` VARCHAR(4) NOT NULL,\r\n"
					+ "  `screentime` VARCHAR(6) NOT NULL,\r\n"
					+ "  `day` VARCHAR(7) NOT NULL,\r\n"
					+ "  `reserved` INT NULL);\r\n"
					+ "") == 1)
				System.out.println("테이블 설치 성공");
			else 
				System.out.println("테이블 설치 실패");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String Aseat;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO seattbl ");
		sql.append("VALUES (?, ?, ?, ?, ?, 0)");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
	
			pstmt.setString(1, "범죄도시2");
			pstmt.setString(2, "1");
			pstmt.setString(4, "09:00");
			pstmt.setString(5, "220603");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(3, Aseat + (j+1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  					
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	public static void main(String[] args) {
		CreateDB con = new CreateDB();
		con.createSeatDB();
	}
}
