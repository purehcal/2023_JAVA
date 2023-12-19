import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardSelectExample02 {
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

    public static void main(String arg[]) {
        Connection con = makeConnection();

        try {
            // SQL 쿼리문 준비
            String sql = "SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata " +
                    "FROM boards " +
                    "WHERE bwriter=?";

            // PreparedStatement 객체 생성
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "winter"); // 첫 번째 매개변수에 'winter' 설정

            // SQL 쿼리 실행 및 결과셋 가져오기
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Board 객체 생성 및 필드 값 설정
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                board.setBfilename(rs.getString("bfilename"));
                board.setBfiledata(rs.getBlob("bfiledata"));

                System.out.println(board); // Board 객체 정보 출력

                Blob blob = board.getBfiledata();
                if (blob != null) {
                    try (InputStream is = blob.getBinaryStream();
                         OutputStream os = new FileOutputStream("C:/JAVA/Week13_323/" + board.getBfilename())) {
                        // 입력 스트림에서 출력 스트림으로 데이터 복사
                        is.transferTo(os);
                        os.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            rs.close(); // 결과셋 닫기

            pstmt.close(); // PreparedStatement 닫기
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
