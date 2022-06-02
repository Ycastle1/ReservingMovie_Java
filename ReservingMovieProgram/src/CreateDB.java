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
			System.out.println("DB 연결 성고 !");
			
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
					+ "  `customerPhoneNumber` VARCHAR(10) NOT NULL,"
					+ "  `customertblcol` VARCHAR(45) NOT NULL,"
					+ "  PRIMARY KEY (`customerId`));") == 1)
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
					+ "  `movieName` VARCHAR(20) NOT NULL,"
					+ "  `moviePosterSrc` VARCHAR(45) NULL,"
					+ "  PRIMARY KEY (`movieName`));") == 1)
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
					+ "  `screenTime` VARCHAR(13) NOT NULL,"
					+ "  CONSTRAINT `FK_movietbl_theathertbl`"
					+ "  FOREIGN KEY (`movieName`)"
					+ "  REFERENCES `reservemoviedb`.`movietbl` (`movieName`));") == 1)
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
					+ "  `reserved` INT NULL,"
					+ "  CONSTRAINT `FK_movietbl_seattbl`"
					+ "  FOREIGN KEY (`movieName`)"
					+ "  REFERENCES `reservemoviedb`.`movietbl` (`movieName`));") == 1)
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
			
			if (stmt.executeUpdate("CREATE TABLE `reservemoviedb`.`new_table` ("
					+ "  `customerName` VARCHAR(20) NOT NULL,"
					+ "  `customerId` VARCHAR(10) NOT NULL,"
					+ "  `seatnumber` VARCHAR(4) NOT NULL,"
					+ "  `theathername` VARCHAR(10) NOT NULL,"
					+ "  `roomnumber` VARCHAR(2) NOT NULL,"
					+ "  `movieName` VARCHAR(20) NOT NULL,"
					+ "  `date` VARCHAR(14) NOT NULL,"
					+ "  `screentime` VARCHAR(13) NOT NULL,"
					+ "  `cost` INT NOT NULL,"
					+ "  `personCount` INT NOT NULL,"
					+ "  CONSTRAINT `FK_customertbl_tickettbl`"
					+ "  FOREIGN KEY (`customerId`)"
					+ "  REFERENCES `reservemoviedb`.`customertbl` (`customerId`));") == 1)
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
		sql.append("VALUES (?, ?)");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
	

			pstmt.setString(1, "범죄도시2");
			pstmt.setString(2, "./Moive_image/moive1.png");
    		if (pstmt.executeUpdate() == 1) 
    			System.out.println("INSERT 성공");
    		else
    			System.out.println("INSERT 실패");
    		pstmt.setString(1, "닥터스트레인지2");
			pstmt.setString(2, "./Moive_image/moive2.jpg");
    		if (pstmt.executeUpdate() == 1) 
    			System.out.println("INSERT 성공");
    		else
    			System.out.println("INSERT 실패");
    		pstmt.setString(1, "베놈2");
			pstmt.setString(2, "./Moive_image/moive3.jpg");
    		if (pstmt.executeUpdate() == 1) 
    			System.out.println("INSERT 성공");
    		else
    			System.out.println("INSERT 실패");
    		pstmt.setString(1, "스파이더맨3");
			pstmt.setString(2, "./Moive_image/moive4.jpg");
    		if (pstmt.executeUpdate() == 1) 
    			System.out.println("INSERT 성공");
    		else
    			System.out.println("INSERT 실패");
    		pstmt.setString(1, "공기살인");
			pstmt.setString(2, "./Moive_image/moive5.jpg");
    		if (pstmt.executeUpdate() == 1) 
    			System.out.println("INSERT 성공");
    		else
    			System.out.println("INSERT 실패");
    		pstmt.setString(1, "마녀2");
			pstmt.setString(2, "./Moive_image/moive6.jpg");
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
	


			pstmt.setString(4, "22. 6. 3");
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
	

			pstmt.setString(6, "22. 6. 3");
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
}