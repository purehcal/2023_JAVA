import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	public static Connection makeConnection() {
		String url="jdbc:mysql://localhost:3306/book_db";
		String id="root";
		String password="";
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			con=DriverManager.getConnection(url, id, password);
			}catch(ClassNotFoundException e) {
				System.out.println("드라이버를 찾을 수 없습니다.");
			}catch(SQLException e) {
				System.out.println("연결에 실패하였습니다.");
			}
		return con;
	}
	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub
		Connection con=makeConnection();
		con.close();
		
	}

}
