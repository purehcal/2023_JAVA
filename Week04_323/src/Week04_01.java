import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class Person {
    String name;
    String tel;
    String address;

    // 생성자로 Person 객체 초기화
    public Person(String name, String tel, String address) {
        this.name = name;
        this.tel = tel;
        this.address = address;
    }

    // getter 및 setter 메서드 정의
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

public class Week04_01 extends JFrame {
    ArrayList<Person> list = new ArrayList<>();
    private JPanel contentPane;
    private JTextField textField, textField_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Week04_01 frame = new Week04_01();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Week04_01() {
        setTitle("Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 360, 252);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 이름 입력 레이블과 텍스트 필드
        JLabel lblNewLabel = new JLabel("이름");
        lblNewLabel.setBounds(12, 10, 57, 15);
        contentPane.add(lblNewLabel);

        // 전화번호 입력 레이블과 텍스트 필드
        JLabel lblNewLabel_1 = new JLabel("전화번호");
        lblNewLabel_1.setBounds(12, 42, 57, 15);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(81, 7, 243, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(81, 39, 243, 21);
        contentPane.add(textField_1);

        // 주소 입력 레이블과 텍스트 영역
        JLabel lblNewLabel_2 = new JLabel("주소");
        lblNewLabel_2.setBounds(12, 79, 57, 15);
        contentPane.add(lblNewLabel_2);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(12, 104, 312, 67);
        contentPane.add(textArea);

        // "저장" 버튼 - 입력 정보를 리스트에 추가
        JButton btnNewButton = new JButton("저장");
        btnNewButton.setBounds(12, 181, 97, 23);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(e -> {
            String name = textField.getText();
            String tel = textField_1.getText();
            String address = textArea.getText();
            list.add(new Person(name, tel, address));
        });

        // "검색" 버튼 - 이름을 기반으로 정보 검색
        JButton btnNewButton_1 = new JButton("검색");
        btnNewButton_1.setBounds(117, 181, 97, 23);
        contentPane.add(btnNewButton_1);
        btnNewButton_1.addActionListener(e -> {
            String name = textField.getText();
            for (Person p : list) {
                if (p.getName().equals(name)) {
                    textField_1.setText(p.getTel());
                    textArea.setText(p.getAddress());
                }
            }
        });

        // "종료" 버튼 - 애플리케이션 종료
        JButton btnNewButton_1_1 = new JButton("종료");
        btnNewButton_1_1.setBounds(227, 181, 97, 23);
        contentPane.add(btnNewButton_1_1);
        btnNewButton_1_1.addActionListener(e -> {
            System.exit(0);
        });
    }
}

