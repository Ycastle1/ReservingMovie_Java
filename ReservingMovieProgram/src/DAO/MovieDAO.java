package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.MovieDTO;

public class MovieDAO {	
		
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
}
