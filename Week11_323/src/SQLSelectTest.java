import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSelectTest {
    // 데이터베이스 연결 메서드
    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/book_db";
        String id = "root";
        String password = "";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 적재 성공");
            con = DriverManager.getConnection(url, id, password);
            System.out.println("데이터베이스 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("연결에 실패하였습니다.");
        }
        return con;
    }

    public static void main(String[] args) throws SQLException {
        Connection con = makeConnection(); // 데이터베이스 연결

        // SQL 쿼리를 준비합니다.
        String query = "SELECT books.title, books.price " +
                       "FROM books " +
                       "WHERE books.publisher=?";

        // PreparedStatement를 사용하여 SQL 쿼리를 실행합니다.
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, "Wiley"); // 매개변수를 설정합니다.

        ResultSet rs = stmt.executeQuery(); // 쿼리 실행 결과를 받아옵니다.

        // 결과를 출력합니다.
        while (rs.next()) {
            String title = rs.getString("title");
            int price = rs.getInt("price");
            System.out.println(title + " " + price);
        }

        con.close(); // 연결을 닫습니다.
    }
}
