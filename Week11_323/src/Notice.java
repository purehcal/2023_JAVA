import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// JFrame을 상속받은 Notice 클래스 정의
class Notice extends JFrame {
    JTextField id, title, p, year, price, author;
    JButton previousButton, nextButton, insertButton, deleteButton,
            searchButton, clearButton;
    ResultSet rs;
    Statement stmt;

    // 생성자에서 SQLException 처리
    public Notice() throws SQLException {
        super("Database Viewer");
        // 데이터베이스 연결을 위한 Connection 객체 생성
        Connection con = makeConnection();
        // Scrollable 및 Updatable한 ResultSet을 생성하는 Statement 객체 생성
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        // "books" 테이블에서 모든 데이터를 가져오는 ResultSet 생성
        rs = stmt.executeQuery("SELECT * FROM books");

        // 그리드 레이아웃 설정
        setLayout(new GridLayout(0, 2));

        // 레이블과 텍스트 필드 추가
        add(new JLabel("ID", JLabel.CENTER));
        add(id = new JTextField());

        add(new JLabel("TITLE", JLabel.CENTER));
        add(title = new JTextField());

        add(new JLabel("PUBLISHER", JLabel.CENTER));
        add(p = new JTextField());

        add(new JLabel("YEAR", JLabel.CENTER));
        add(year = new JTextField());

        add(new JLabel("PRICE", JLabel.CENTER));
        add(price = new JTextField());

        add(new JLabel("출판사 검색", JLabel.CENTER));
        add(author = new JTextField());

        // Previous 버튼 및 이벤트 리스너 추가
        previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    rs.previous();
                    // ResultSet에서 데이터를 읽어와 각 텍스트 필드에 설정
                    id.setText("" + rs.getInt("book_id"));
                    title.setText("" + rs.getString("title"));
                    p.setText("" + rs.getString("publisher"));
                    year.setText("" + rs.getString("year"));
                    price.setText("" + rs.getInt("price"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        // Next 버튼 및 이벤트 리스너 추가
        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    rs.next();
                    // ResultSet에서 데이터를 읽어와 각 텍스트 필드에 설정
                    id.setText("" + rs.getInt("book_id"));
                    title.setText("" + rs.getString("title"));
                    p.setText("" + rs.getString("publisher"));
                    year.setText("" + rs.getString("year"));
                    price.setText("" + rs.getInt("price"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        // Insert, Delete, Search, Clear 버튼 추가
        insertButton = new JButton("Insert");
        deleteButton = new JButton("Delete");
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String searchKeyword = author.getText();
                try {
                    // 출판사를 기준으로 LIKE 연산자를 사용하여 검색하는 쿼리
                    String query = "SELECT * FROM books WHERE publisher LIKE '%" + searchKeyword + "%'";
                    // ResultSet을 검색 결과로 업데이트
                    ResultSet searchResult = stmt.executeQuery(query);

                    if (searchResult.next()) {
                        // 검색 결과가 있다면 각 텍스트 필드에 설정
                        id.setText("" + searchResult.getInt("book_id"));
                        title.setText("" + searchResult.getString("title"));
                        p.setText("" + searchResult.getString("publisher"));
                        year.setText("" + searchResult.getString("year"));
                        price.setText("" + searchResult.getInt("price"));
                    } else {
                        System.out.println("검색 결과가 없습니다.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        clearButton = new JButton("Clear");

        // 각 버튼을 프레임에 추가
        add(previousButton);
        add(nextButton);
        add(insertButton);
        add(deleteButton);
        add(searchButton);
        add(clearButton);

        // 프레임 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setVisible(true);
    }

 // 데이터베이스 연결을 수행하는 메서드
    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/book_db"; // 수정된 부분
        String user = "root";
        String password = "";
        Connection con = null;

        try {
            // MySQL JDBC 드라이버를 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 적재 성공");

            // 지정된 URL, 사용자 이름, 암호를 이용하여 데이터베이스에 연결
            con = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("연결에 실패하였습니다.");
        }
        return con;
    }

    // ConnectionDatabase 클래스의 main 메서드
    public static void main(String[] args) throws SQLException {
        new Notice();
    }
}
