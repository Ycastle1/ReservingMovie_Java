import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CreateDB {	
	public Connection createDB() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // ����̹� �ε�.
			System.out.println("연결중");
			
			String url = "jdbc:mysql://localhost:3306/reservemoviedb?serverTimezome=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			con = DriverManager.getConnection(url, user, password); //  ���� ��ü ������.
			System.out.println("DB 연결 성공 !");
			
		} catch (ClassNotFoundException e) {
			System.out.println("클래스");
		} catch (SQLException e) {
			System.out.println("SQL");
		}
		
		return con;
	}

	public void createcustomerTbl() {
		Connection con = createDB();
		try {
			Statement stmt = con.createStatement();
			
			if (stmt.executeUpdate("CREATE TABLE `reservemoviedb`.`customertbl` ("
					+ "  `customerId` VARCHAR(10) NOT NULL,"
					+ "  `customerPassword` VARCHAR(20) NOT NULL,"
					+ "  `customerName` VARCHAR(10) NOT NULL,"
					+ "  `customerEmail` VARCHAR(25) NOT NULL,"
					+ "  `customerPhoneNumber` VARCHAR(12) NOT NULL,"
					+ "  PRIMARY KEY (`customerId`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;") == 1)
				return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createMovieTbl() {
		Connection con = createDB();
		try {
			Statement stmt = con.createStatement();
			
			if (stmt.executeUpdate("CREATE TABLE `reservemoviedb`.`movietbl` ("
					+ "  `roomNumber` VARCHAR(2) NOT NULL,"
					+ "  `movieName` VARCHAR(20) NOT NULL,"
					+ "  `moviePosterSrc` VARCHAR(45) NULL,"
					+ "  PRIMARY KEY (`roomNumber`))ENGINE=InnoDB DEFAULT CHARSET=utf8;") == 1)
				return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createTheatherTbl() {
		Connection con = createDB();
		try {
			Statement stmt = con.createStatement();
			
			if (stmt.executeUpdate("CREATE TABLE `reservemoviedb`.`theathertbl` ("
					+ "  `theatherName` VARCHAR(10) NOT NULL,"
					+ "  `roomNumber` VARCHAR(2) NOT NULL,"
					+ "  `movieName` VARCHAR(20) NOT NULL,"
					+ "  `date` VARCHAR(14) NOT NULL,"
					+ "  `screenTime` VARCHAR(13) NOT NULL);") == 1)
				return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createSeatTbl() {
		Connection con = createDB();
		try {
			Statement stmt = con.createStatement();
			
			if (stmt.executeUpdate("CREATE TABLE `reservemoviedb`.`seattbl` ("
					+ "  `theathername` VARCHAR(10) NOT NULL,"
					+ "  `roomnumber` VARCHAR(2) NOT NULL,"
					+ "  `movieName` VARCHAR(20) NOT NULL,"
					+ "  `seatnumber` VARCHAR(4) NOT NULL,"
					+ "  `screentime` VARCHAR(13) NOT NULL,"
					+ "  `date` VARCHAR(14) NOT NULL,"
					+ "  `reserved` INT NULL);") == 1)
				return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createTicketTbl() {
		Connection con = createDB();
		try {
			Statement stmt = con.createStatement();
			
			if (stmt.executeUpdate("CREATE TABLE `reservemoviedb`.`tickettbl` ("
					+ "  `customerName` VARCHAR(20) NOT NULL,"
					+ "  `customerId` VARCHAR(10) NOT NULL,"
					+ "  `seatnumber` VARCHAR(45) NOT NULL,"
					+ "  `theathername` VARCHAR(10) NOT NULL,"
					+ "  `roomnumber` VARCHAR(2) NOT NULL,"
					+ "  `movieName` VARCHAR(20) NOT NULL,"
					+ "  `date` VARCHAR(14) NOT NULL,"
					+ "  `screentime` VARCHAR(13) NOT NULL,"
					+ "  `cost` INT NOT NULL,"
					+ "  `personCount` INT NOT NULL);") == 1)
				return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public void createMovieTblColumns() {
		Connection con = createDB();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO movietbl ");
		sql.append("VALUES (?, ?, ?)");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
	

    		pstmt.setString(1, "1");
			pstmt.setString(2, "범죄도시2");
			pstmt.setString(3, "./Moive_image/moive1.png");
    		if (pstmt.executeUpdate() == 1) 
    			System.out.println("INSERT 성공");
    		else
    			System.out.println("INSERT 실패");
    		pstmt.setString(1, "2");
    		pstmt.setString(2, "닥터스트레인지2");
			pstmt.setString(3, "./Moive_image/moive2.jpg");
    		if (pstmt.executeUpdate() == 1) 
    			System.out.println("INSERT 성공");
    		else
    			System.out.println("INSERT 실패");
    		pstmt.setString(1, "3");
    		pstmt.setString(2, "베놈2");
			pstmt.setString(3, "./Moive_image/moive3.jpg");
    		if (pstmt.executeUpdate() == 1) 
    			System.out.println("INSERT 성공");
    		else
    			System.out.println("INSERT 실패");
    		pstmt.setString(1, "4");
    		pstmt.setString(2, "스파이더맨3");
			pstmt.setString(3, "./Moive_image/moive4.jpg");
    		if (pstmt.executeUpdate() == 1) 
    			System.out.println("INSERT 성공");
    		else
    			System.out.println("INSERT 실패");
    		pstmt.setString(1, "5");
    		pstmt.setString(2, "공기살인");
			pstmt.setString(3, "./Moive_image/moive5.jpg");
    		if (pstmt.executeUpdate() == 1) 
    			System.out.println("INSERT 성공");
    		else
    			System.out.println("INSERT 실패");
    		pstmt.setString(1, "6");
    		pstmt.setString(2, "마녀2");
			pstmt.setString(3, "./Moive_image/moive6.jpg");
    		if (pstmt.executeUpdate() == 1) 
    			System.out.println("INSERT 성공");
    		else
    			System.out.println("INSERT 실패");
	    } catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void createTheatherTblColumns() {
		Connection con = createDB();
		
		StringBuilder sql = new StringBuilder();
		ArrayList<String> screenTimeArrayList = new ArrayList<>();
		
		sql.append("INSERT INTO theathertbl ");
		sql.append("VALUES (?, ?, ?, ?, ?)");
		
		screenTimeArrayList.add("9:00 ~ 10:47");
		screenTimeArrayList.add("12:00 ~ 13:47");
		screenTimeArrayList.add("15:00 ~ 16:47");
		screenTimeArrayList.add("18:00 ~ 19:47");
		screenTimeArrayList.add("21:00 ~ 22:47");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
	


			pstmt.setString(4, "2022.6.3");
			pstmt.setString(1, "송내점");
			pstmt.setString(3, "범죄도시2");
			pstmt.setString(2, "1");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "닥터스트레인지2");
			pstmt.setString(2, "2");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "베놈2");
			pstmt.setString(2, "3");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "스파이더맨3");
			pstmt.setString(2, "4");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "공기살인");
			pstmt.setString(2, "5");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
	    		
			pstmt.setString(3, "마녀2");
			pstmt.setString(2, "6");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
		   		if (pstmt.executeUpdate() == 1) 
		   			System.out.println("INSERT 성공");
		    	else
		    		System.out.println("INSERT 실패");
			}
			
			pstmt.setString(1, "주안점");
			pstmt.setString(3, "범죄도시2");
			pstmt.setString(2, "1");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "닥터스트레인지2");
			pstmt.setString(2, "2");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "베놈2");
			pstmt.setString(2, "3");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "스파이더맨3");
			pstmt.setString(2, "4");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "공기살인");
			pstmt.setString(2, "5");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
	    		
			pstmt.setString(3, "마녀2");
			pstmt.setString(2, "6");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
		   		if (pstmt.executeUpdate() == 1) 
		   			System.out.println("INSERT 성공");
		    	else
		    		System.out.println("INSERT 실패");
			}
			
			pstmt.setString(1, "의정부점");
			pstmt.setString(3, "범죄도시2");
			pstmt.setString(2, "1");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "닥터스트레인지2");
			pstmt.setString(2, "2");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "베놈2");
			pstmt.setString(2, "3");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "스파이더맨3");
			pstmt.setString(2, "4");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "공기살인");
			pstmt.setString(2, "5");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
	    		
			pstmt.setString(3, "마녀2");
			pstmt.setString(2, "6");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
		   		if (pstmt.executeUpdate() == 1) 
		   			System.out.println("INSERT 성공");
		    	else
		    		System.out.println("INSERT 실패");
			}
			
			pstmt.setString(1, "부천점");
			pstmt.setString(3, "범죄도시2");
			pstmt.setString(2, "1");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "닥터스트레인지2");
			pstmt.setString(2, "2");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "베놈2");
			pstmt.setString(2, "3");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "스파이더맨3");
			pstmt.setString(2, "4");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			pstmt.setString(3, "공기살인");
			pstmt.setString(2, "5");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
	    		if (pstmt.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
	    		
			pstmt.setString(3, "마녀2");
			pstmt.setString(2, "6");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt.setString(5, screenTime);
				
		   		if (pstmt.executeUpdate() == 1) 
		   			System.out.println("INSERT 성공");
		    	else
		    		System.out.println("INSERT 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void createSeatTblColumns() {
		Connection con = createDB();
		char Acode = 65;
		String Aseat;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO seattbl ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, 0)");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
	

			pstmt.setString(6, "2022.6.3");
			pstmt.setString(1, "송내점");
			pstmt.setString(3, "범죄도시2");
			pstmt.setString(2, "1");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "닥터스트레인지2");
			pstmt.setString(2, "2");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "베놈2");
			pstmt.setString(2, "3");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "공기살인");
			pstmt.setString(2, "5");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "스파이더맨3");
			pstmt.setString(2, "4");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "공기살인");
			pstmt.setString(2, "5");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "마녀2");
			pstmt.setString(2, "6");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(1, "주안점");
			pstmt.setString(3, "범죄도시2");
			pstmt.setString(2, "1");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "닥터스트레인지2");
			pstmt.setString(2, "2");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "베놈2");
			pstmt.setString(2, "3");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "공기살인");
			pstmt.setString(2, "5");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "스파이더맨3");
			pstmt.setString(2, "4");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "공기살인");
			pstmt.setString(2, "5");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "마녀2");
			pstmt.setString(2, "6");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(1, "의정부점");
			pstmt.setString(3, "범죄도시2");
			pstmt.setString(2, "1");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "닥터스트레인지2");
			pstmt.setString(2, "2");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "베놈2");
			pstmt.setString(2, "3");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "공기살인");
			pstmt.setString(2, "5");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "스파이더맨3");
			pstmt.setString(2, "4");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "공기살인");
			pstmt.setString(2, "5");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "마녀2");
			pstmt.setString(2, "6");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(1, "부천점");
			pstmt.setString(3, "범죄도시2");
			pstmt.setString(2, "1");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "닥터스트레인지2");
			pstmt.setString(2, "2");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "베놈2");
			pstmt.setString(2, "3");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "공기살인");
			pstmt.setString(2, "5");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "스파이더맨3");
			pstmt.setString(2, "4");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "공기살인");
			pstmt.setString(2, "5");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(3, "마녀2");
			pstmt.setString(2, "6");
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	public static void main(String[] args) {
		CreateDB con = new CreateDB();
		con.createMovieTbl();
		con.createTheatherTbl();
		con.createSeatTbl();
		con.createcustomerTbl();
		con.createTicketTbl();
		
		con.createMovieTblColumns();
		con.createTheatherTblColumns();
		con.createSeatTblColumns();
		System.out.println("끝.");
	}
	
	public boolean createNewMovieColumns(int roomNumber, String name) {
		Connection con = createDB();
		
		StringBuilder sql1 = new StringBuilder();
		ArrayList<String> screenTimeArrayList = new ArrayList<>();
		
		sql1.append("INSERT INTO theathertbl ");
		sql1.append("VALUES (?, ?, ?, ?, ?)");
		
		screenTimeArrayList.add("9:00 ~ 10:47");
		screenTimeArrayList.add("12:00 ~ 13:47");
		screenTimeArrayList.add("15:00 ~ 16:47");
		screenTimeArrayList.add("18:00 ~ 19:47");
		screenTimeArrayList.add("21:00 ~ 22:47");
		
		PreparedStatement pstmt1;
		
		Integer num = roomNumber;
		String room = num.toString();
		try {
			pstmt1 = con.prepareStatement(sql1.toString());

			pstmt1.setString(4, "2022.6.10");
			pstmt1.setString(3, name);
			pstmt1.setString(2, room);
			
			
			pstmt1.setString(1, "송내점");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt1.setString(5, screenTime);
				
	    		if (pstmt1.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			
			pstmt1.setString(1, "주안점");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt1.setString(5, screenTime);
				
	    		if (pstmt1.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			
			pstmt1.setString(1, "의정부점");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt1.setString(5, screenTime);
				
	    		if (pstmt1.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
			
			pstmt1.setString(1, "부천점");
			
			for (String screenTime : screenTimeArrayList) {
				pstmt1.setString(5, screenTime);
				
	    		if (pstmt1.executeUpdate() == 1) 
	    			System.out.println("INSERT 성공");
	    		else
	    			System.out.println("INSERT 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		char Acode = 65;
		String Aseat;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO seattbl ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, 0)");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
	

			pstmt.setString(6, "2022.6.10");
			pstmt.setString(3, name);
			pstmt.setString(2, room);

			pstmt.setString(1, "송내점");
			
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			pstmt.setString(1, "주안점");
			
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			pstmt.setString(1, "의정부점");
			
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			pstmt.setString(1, "부천점");
			
			pstmt.setString(5, "9:00 ~ 10:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) { //a좌석에 1번부터 받아오기
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "12:00 ~ 13:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "15:00 ~ 16:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "18:00 ~ 19:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}  			
			Acode = 65;
			
			pstmt.setString(5, "21:00 ~ 22:47");
			for (int i = 0; i < 10; i++) {
				Aseat = String.valueOf(Acode);
			
				for (int j = 0; j < 10; j++) {
    				pstmt.setString(4, Aseat + (j + 1));
    				if (pstmt.executeUpdate() == 1) 
    					System.out.println("INSERT 성공");
    				else
    					System.out.println("INSERT 실패");
	    		}
	    		Acode++;
			}
			return true;
    	} catch (SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
	}
	
}