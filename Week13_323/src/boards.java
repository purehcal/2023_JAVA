import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class boards {
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
            String sql = new StringBuilder()
                    .append("UPDATE boards SET ")
                    .append("btitle=?, ")
                    .append("bcontent=?, ")
                    .append("bfilename=?, ")
                    .append("bfiledata=? ")
                    .append("WHERE bno=?")
                    .toString();

            // PreparedStatement 객체 생성
            PreparedStatement pstmt = con.prepareStatement(sql);

            // SQL 쿼리문에 파라미터 값 설정
            pstmt.setString(1, "눈사람");
            pstmt.setString(2, "눈으로 만든 사람");
            pstmt.setString(3, "snowman.jpg");

            try {
                // 파일 입력 스트림을 이용하여 Blob 데이터 설정
                pstmt.setBlob(4, new FileInputStream("snowman.jpg"));
            } catch (FileNotFoundException e) {
                System.out.println("파일을 찾을 수 없습니다.");
                e.printStackTrace();
            }

            pstmt.setInt(5, 1); // WHERE 조건에 해당하는 bno 값 설정

            // SQL 쿼리 실행 및 결과 출력
            int rows = pstmt.executeUpdate();
            System.out.println("수정된 행 수: " + rows);

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 연결 닫기
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}

