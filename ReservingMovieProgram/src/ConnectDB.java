import java.sql.Connection;
import java.sql.DriverManager;
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
