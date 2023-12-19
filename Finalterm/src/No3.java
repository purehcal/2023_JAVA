import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class No3 {
    // 데이터베이스 연결 메서드
    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/Duksung";
        String id = "root";
        String password = "";
        Connection con = null;

        try {
            // JDBC 드라이버를 로드합니다.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 적재 성공");

            // 데이터베이스에 연결합니다.
            con = DriverManager.getConnection(url, id, password);
            System.out.println("데이터베이스 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("연결에 실패하였습니다.");
        }

        return con;
    }

    // 학생 추가 메서드
    private static void addStudent(int stuId, String name, String tel, String dept) {
        Connection con = makeConnection(); // 데이터베이스 연결

        try {
            Statement stmt = con.createStatement();
            String query = "INSERT INTO Stuednt(stuId, name, tel, dept) VALUES " +
                           "('" + stuId + "', '" + name + "', '" + tel + "', '" + dept + "')";

            System.out.println(query);
            int i = stmt.executeUpdate(query); // SQL 쿼리 실행

            if (i == 1)
                System.out.println("레코드 추가 성공");
            else
                System.out.println("레코드 추가 실패");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } finally {
            try {
                if (con != null) {
                    con.close(); // 연결을 닫습니다.
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        // 메인 메서드에서 학생 추가를 호출합니다.
        addStudent(2022001, "Minji lee", "000-0000-0001", "Cyber Security");
        addStudent(2022002, "Hanni park", "000-0000-0002", "Computer");
        addStudent(2022003, "Danielle chung", "000-0000-0003", "IT Media");
        addStudent(202004, "Hyein choi", "000-0000-0004", "Software");
        
    }
}
