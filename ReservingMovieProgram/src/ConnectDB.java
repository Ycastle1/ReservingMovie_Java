import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {	
	
	public Connection connectDB() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // ����̹� �ε�.
			System.out.println("����̹� ���� ����");
			
			String url = "jdbc:mysql://localhost:3306/reservemoviedb?serverTimezome=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			con = DriverManager.getConnection(url, user, password); //  ���� ��ü ������.
			System.out.println("DB ���� ���� !");
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� ���߽��ϴ�.");
		} catch (SQLException e) {
			System.out.println("�����ͺ��̽� ���� ����");
		}
		
		return con;
	}
	
	public boolean checkReserved(TicketDTO ticket) {
		String Aseat;
		StringBuilder sql = new StringBuilder();
		Connection con = connectDB();
		ResultSet rs;
		
		sql.append("SELECT * FROM seattbl where theathername = ? AND ");
		sql.append("roomnumber = ? AND ");
		sql.append("seatnumber = ? AND ");
		sql.append("screentime = ? AND ");
		sql.append("day = ?;");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
	
			pstmt.setString(1, "범죄도시2");
			pstmt.setString(2, "1");
			pstmt.setString(3, ticket.getSeatNumber());
			pstmt.setString(4, "09:00");
			pstmt.setString(5, "220603");  	
			
			rs = pstmt.executeQuery();
			rs.next();
			int result = rs.getInt("reserved");
			if (result == 1) {		
				System.out.println("예약되어있음");			
				return true;
			}
			else {
				System.out.println("예매 가능");
				return false;
			}	
    	} catch (SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
	}
	
	
	public boolean login(String id, String pw) {
		String sql = "SELECT * FROM usertbl where userid = '" + id + "'";
		Connection con = connectDB();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs;
			
			rs = stmt.executeQuery(sql);
			if (rs.next()){
				String correctPassword = rs.getString("userPw");
				if (pw.equals(correctPassword)) {		
					System.out.println("����");			
					return true;
				}
				else {
					//��й�ȣ ����		
					System.out.println("��й�ȣ ����");
					return false;
				}
			}				
			else {		
				//���̵� ����
				System.out.println("���̵� ����");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//�����ͺ��̽� ����
			System.out.println("�����ͺ��̽� ����");
			return false;
		}
	}
}
