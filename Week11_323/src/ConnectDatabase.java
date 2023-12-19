import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    // 데이터베이스 연결 메서드
    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/book_db";
        String id = "root";
        String password = "";
        Connection con = null;

        try {
            // JDBC 드라이버를 로드합니다.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 적재 성공");

            // 데이터베이스에 연결합니다.
            con = DriverManager.getConnection(url, id, password);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("연결에 실패하였습니다.");
        }

        return con;
    }

    public static void main(String[] args) throws SQLException {
        Connection con = makeConnection(); // 데이터베이스 연결

        // 연결이 성공적으로 이루어지면 메시지 출력
        if (con != null) {
            System.out.println("데이터베이스 연결 성공");
            con.close(); // 연결을 닫습니다.
        }
    }
}
