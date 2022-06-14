import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDB {	
	
	public Connection connectDB() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // ����̹� �ε�.
			System.out.println("driver connected");
			
			String url = "jdbc:mysql://localhost:3306/reservemoviedb?serverTimezome=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			con = DriverManager.getConnection(url, user, password); //  ���� ��ü ������.
			System.out.println("DB schema connected");
			
		} catch (ClassNotFoundException e) {
			System.out.println("x1.class");
		} catch (SQLException e) {
			System.out.println("x2.sql");
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
					System.out.println("password");
					return false;
				}
			}				
			else {		
				System.out.println("id");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql");
			return false;
		}
	}
	
	public MovieDTO[] getMovieList(MovieDTO[] movieList) {
		String sql = "SELECT * FROM movietbl ORDER BY roomNumber ";
		Connection con = connectDB();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs;
			int i = 0;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				int roomNumber = rs.getInt("roomNumber");
				String name = rs.getString("movieName");
				String src = rs.getString("moviePosterSrc");
				
				MovieDTO movieListFromDB = new MovieDTO();
				movieListFromDB.setRoomNumber(roomNumber);
				movieListFromDB.setMovieName(name);
				movieListFromDB.setMoviePosterSrc(src);
				
				movieList[i] = movieListFromDB;
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql");
			return movieList;
		}
		
		return movieList;
		
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
	
	public ResultSet getReservationResultSet(String id) {
		String sql = "SELECT * FROM tickettbl where customerId = '" + id + "';";
		Connection con = connectDB();
		ResultSet rs = null;
		
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql");
			return rs;
		}
	}
	
	public ResultSet getMovieResultSet() {
		String sql = "SELECT * FROM movietbl ORDER BY roomNumber ASC;";
		Connection con = connectDB();
		ResultSet rs = null;
		
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql");
			return rs;
		}
	}
	
	public ResultSet getReservationTicket(String id) {
		String sql = "SELECT * FROM tickettbl where customerId = '" + id + "';";
		Connection con = connectDB();
		ResultSet rs = null;
		
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql");
			return rs;
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
		ResultSet rs1;
		System.out.println(ticket.getDate());
		sql.append("SELECT * FROM seattbl where theathername = ? AND ");
		sql.append("roomnumber = ? AND ");
		sql.append("moviename = ? AND ");
		sql.append("screentime = ? AND ");
		sql.append("date = ? AND ");
		sql.append("seatnumber = ?;");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, ticket.getTheatherName());
			System.out.println(ticket.getTheatherName());
			pstmt.setString(2, ticket.getRoomNumber());
			System.out.println(ticket.getRoomNumber());
			pstmt.setString(3, ticket.getMovieName());
			System.out.println(ticket.getMovieName());
			pstmt.setString(4, ticket.getScreenTime());
			System.out.println(ticket.getScreenTime());
			pstmt.setString(5, ticket.getDate());  	
			System.out.println(ticket.getDate());
			pstmt.setString(6, ticket.getSeatNumber());  	
			System.out.println(ticket.getSeatNumber());
			
			rs1 = pstmt.executeQuery();
			rs1.next();
			int result = rs1.getInt("reserved");
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
		sql.append("INSERT INTO tickettbl VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
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
	
	public void updateTicketTblColumns(TicketDTO ticket) {
		StringBuilder sql = new StringBuilder();
		Connection con = connectDB();
		sql.append("UPDATE tickettbl SET seatnumber = ? WHERE (customername = ? AND customerid =  ? AND theathername = ? AND roomnumber = ? AND moviename =  ? AND date = ? AND"
				+ " screentime =  ? AND cost = ? personcount = ?);");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, ticket.getSeatNumber());
			pstmt.setString(2, ticket.getCustomerName());
			pstmt.setString(3, ticket.getCustomerId());
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
	
	public boolean deleteTicketTblColumns(TicketDTO ticket) {
		StringBuilder sql = new StringBuilder();
		Connection con = connectDB();
		sql.append("DELETE FROM tickettbl WHERE (customerName = ? AND customerid =  ? AND seatnumber = ? AND theatherName =  ? AND roomnumber =  ? AND moviename = ? AND date = ? AND screentime = ? AND cost =  ? AND personcount = ?);");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
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
			
			if (pstmt.executeUpdate() == 1) {
    			System.out.println("Delete O");
				return true;
			}
    		else {
    			System.out.println("Delete X");
				return false;
    		}
	    	} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed, SQL");
				return false;
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
	
	public void refundSeat(TicketDTO ticket) {
		StringBuilder sql = new StringBuilder();
		Connection con = connectDB();
		
		sql.append("UPDATE reservemoviedb.seattbl SET reserved = 0 where(theathername = ? AND ");
		sql.append("movieName =  ? AND ");
		sql.append("date = ? AND ");
		sql.append("screenTime = ? AND ");
		sql.append("seatnumber = ?);");
		System.out.println(ticket.getSeatNumber());
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, ticket.getTheatherName());
			pstmt.setString(2, ticket.getMovieName());
			pstmt.setString(3, ticket.getDate());
			pstmt.setString(4, ticket.getScreenTime());
			pstmt.setString(5, ticket.getSeatNumber());  	
			
			if (pstmt.executeUpdate() == 1) 
    			System.out.println("return O");
    		else
    			System.out.println("return X");
	    	} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed, SQL");
			}
	}


	public boolean updateMovieInfo(int roomNumber, String name, String posterSrc) {
		String sql;
		Connection con = connectDB();
		if (!isEmptyRoom(roomNumber)) {
			sql = "DELETE FROM theathertbl WHERE roomnumber = '" + roomNumber + "';";
			
			try {
				Statement stmt = con.createStatement();
				if (stmt.executeUpdate(sql) != 0) { 
	    			System.out.println("update O");
				}
	    		else {
	    			System.out.println("update X");
	    			return false;
	    		}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("sql");
    			return false;
			}
			
			sql = "DELETE FROM seattbl WHERE roomnumber = '" + roomNumber + "';";
			
			try {
				Statement stmt = con.createStatement();
				
				if (stmt.executeUpdate(sql) != 0) { 
	    			System.out.println("update O");
				}
	    		else {
	    			System.out.println("update X");
	    			return false;
	    		}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("sql");
    			return false;
			}
		}
		
		sql = "UPDATE movietbl SET movieName = '" + name + "', moviePosterSrc = '" + posterSrc + "' WHERE roomNumber = '" + roomNumber + "';";
		try {
			Statement stmt = con.createStatement();
			
			if (stmt.executeUpdate(sql) == 1) { 
				System.out.println("update O");
			}
			else {
				System.out.println("update X");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql");
			return false;
		}

		
		if (name.equals("null")) {
			System.out.println("삭제 완료.");
			return true;
		}
		
		CreateDB con1 = new CreateDB();
		if (con1.createNewMovieColumns(roomNumber, name)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEmptyRoom(int roomNumber) {
		String sql = "SELECT * FROM movietbl where roomNumber = '" + roomNumber + "';";
		Connection con = connectDB();
		ResultSet rs = null;
		
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				if (rs.getString("movieName").equals("null")) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql");
			return false;
		}
	}
}
