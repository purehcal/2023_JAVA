import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardSelecExample {
    // 데이터베이스 연결을 수행하는 메서드
    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/boards";
        String id = "root";
        String password = "";
        Connection con = null;
        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 적재 성공");

            // 데이터베이스 연결
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
        Connection con = makeConnection();

        try {
            // SQL 쿼리문을 준비
            String sql = "SELECT userid, username, userpassword, userage, useremail " +
                    "FROM users " +
                    "WHERE userid=?";

            // PreparedStatement 객체 생성
            PreparedStatement pstmt = con.prepareStatement(sql);

            // SQL 쿼리문에 파라미터 값 설정
            pstmt.setString(1, "winter");

            // SQL 쿼리 실행 및 결과 가져오기
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // ResultSet에서 결과를 가져와 User 객체에 저장
                User user = new User();
                user.setUserId(rs.getString("userid"));
                user.setUserName(rs.getString("username"));
                user.setUserPassword(rs.getString("userpassword"));
                user.setUserAge(rs.getInt("userage"));
                user.setUserEmail(rs.getString("useremail"));
                System.out.println(user);
            } else {
                System.out.println("사용자 아이디가 존재하지 않음");
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 연결 닫기
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
