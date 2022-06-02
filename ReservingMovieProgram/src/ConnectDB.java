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
			System.out.println("driver");
			
			String url = "jdbc:mysql://localhost:3306/reservemoviedb?serverTimezome=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			con = DriverManager.getConnection(url, user, password); //  ���� ��ü ������.
			System.out.println("DB schema");
			
		} catch (ClassNotFoundException e) {
			System.out.println("x1.");
		} catch (SQLException e) {
			System.out.println("x2");
		}
		
		return con;
	}
	
	
	public void registerCustomer(CustomerDTO customer) {
		Connection con = connectDB();
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO customertbl ");
		sql.append("VALUES (?, ?, ?, ?, ?)");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
	

			pstmt.setString(1, customer.getCustomerId());
			pstmt.setString(2, customer.getCustomerPassword());
			pstmt.setString(3, customer.getCustomerName());
			pstmt.setString(4, customer.getCustomerEmail());
			pstmt.setString(5, customer.getCustomerPhoneNumber());
    		
    		if (pstmt.executeUpdate() == 1) 
    			System.out.println("Register O");
    		else
    					System.out.println("Register X");
	    	} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed, SQL");
			}
	}
	
	public boolean login(String id, String pw) {
		String sql = "SELECT * FROM customertbl where customerId = '" + id + "'";
		Connection con = connectDB();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs;
			
			rs = stmt.executeQuery(sql);
			if (rs.next()){
				String correctPassword = rs.getString("customerPassword");
				if (pw.equals(correctPassword)) {		
					System.out.println("good");			
					return true;
				}
				else {
					//��й�ȣ ����		
					System.out.println("password");
					return false;
				}
			}				
			else {		
				//���̵� ����
				System.out.println("id");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//�����ͺ��̽� ����
			System.out.println("sql");
			return false;
		}
	}
	
	public String getCustomerNameById(String id) {
		String sql = "SELECT * FROM customertbl where customerId = '" + id + "';";
		Connection con = connectDB();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs;
			
			rs = stmt.executeQuery(sql);
			if (rs.next()){
				String name = rs.getString("customerName");
				return name;
			}				
			else {		
				System.out.println("class");
				return "-1";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql");
			return "-1";
		}
	}
	
	public String getRoomName(TicketDTO ticket) {
		String sql = "SELECT * FROM theathertbl where theatherName = '" + ticket.getTheatherName() + "' AND "
				+ "movieName = '" + ticket.getMovieName() + "' AND date = '" + ticket.getDate() + "' AND "
				+ "screenTime = '" + ticket.getScreenTime() + "';";
		Connection con = connectDB();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs;
			
			rs = stmt.executeQuery(sql);
			if (rs.next()){
				String roomNumber = rs.getString("roomnumber");
				return roomNumber;
			}				
			else {		
				System.out.println("class");
				return "-1";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql");
			return "-1";
		}
	}
	
	public boolean checkReserved(TicketDTO ticket) {
		StringBuilder sql = new StringBuilder();
		Connection con = connectDB();
		ResultSet rs;
		System.out.println(ticket.getDate());
		sql.append("SELECT * FROM seattbl where theathername = ? AND ");
		sql.append("roomnumber = ? AND ");
		sql.append("moviename = ? AND ");
		sql.append("screentime = ? AND ");
		sql.append("date = ? AND ");
		sql.append("seatnumber = ?");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, ticket.getTheatherName());
			pstmt.setString(2, ticket.getRoomNumber());
			pstmt.setString(3, ticket.getMovieName());
			pstmt.setString(4, ticket.getScreenTime());
			pstmt.setString(5, ticket.getDate());  	
			pstmt.setString(6, ticket.getSeatNumber());  	
			
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
	
	public void addTicketTblColumns(TicketDTO ticket) {
		StringBuilder sql = new StringBuilder();
		Connection con = connectDB();
		System.out.println(ticket.getDate());
		sql.append("INSERT INTO tickettbl VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
			System.out.println(ticket.getCustomerName());
			pstmt.setString(1, ticket.getCustomerName());
			pstmt.setString(2, ticket.getCustomerId());
			pstmt.setString(3, ticket.getSeatNumber());
			pstmt.setString(4, ticket.getTheatherName());
			pstmt.setString(5, ticket.getRoomNumber());  	
			pstmt.setString(6, ticket.getMovieName());  	
			pstmt.setString(7, ticket.getDate());  	
			pstmt.setString(8, ticket.getScreenTime());  	
			pstmt.setLong(9, ticket.getCost());  	
			pstmt.setLong(10, ticket.getPersonCount());  	
			
			if (pstmt.executeUpdate() == 1) 
    			System.out.println("Add O");
    		else
    			System.out.println("Add X");
	    	} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed, SQL");
			}
	}


	public void reserveSeat(SeatDTO seatDto) {
		
		StringBuilder sql = new StringBuilder();
		Connection con = connectDB();
		
		sql.append("UPDATE reservemoviedb.seattbl SET reserved = 1 where(theathername = ? AND ");
		sql.append("movieName =  ? AND ");
		sql.append("date = ? AND ");
		sql.append("screenTime = ? AND ");
		sql.append("seatnumber = ?);");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, seatDto.getTheatherName());
			pstmt.setString(2, seatDto.getMovieName());
			pstmt.setString(3, seatDto.getDate());
			pstmt.setString(4, seatDto.getScreenTime());
			pstmt.setString(5, seatDto.getSeatNumber());  	
			
			if (pstmt.executeUpdate() == 1) 
    			System.out.println("Reserve O");
    		else
    			System.out.println("Reserve X");
	    	} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed, SQL");
			}
	}
}
