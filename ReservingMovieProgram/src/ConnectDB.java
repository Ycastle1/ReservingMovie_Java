import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {	
	
	public Connection connectDB() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 로딩.
			System.out.println("드라이버 연결 성공");
			
			String url = "jdbc:mysql://localhost:3306/reservemoviedb?serverTimezome=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			con = DriverManager.getConnection(url, user, password); //  연결 객체 생성문.
			System.out.println("DB 연결 성공 !");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾지 못했습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패");
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
					System.out.println("성공");			
					return true;
				}
				else {
					//비밀번호 오류		
					System.out.println("비밀번호 오류");
					return false;
				}
			}				
			else {		
				//아이디 오류
				System.out.println("아이디 오류");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//데이터베이스 오류
			System.out.println("데이터베이스 오류");
			return false;
		}
	}


	private boolean checkPw(String id, String pw) {
		// TODO Auto-generated method stub
		return false;
	}
}
