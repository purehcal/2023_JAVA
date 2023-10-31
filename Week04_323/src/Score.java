import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Score extends JFrame {
    private JPanel contentPane;
    private JTextField textField, textField_1;
    ArrayList<Integer> list = new ArrayList<>(); // 성적을 저장할 리스트

    public Score() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우를 닫을 때 프로그램 종료
        setBounds(100, 100, 377, 154); // 프레임 위치와 크기 설정
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // 패널 경계 설정
        setContentPane(contentPane);
        contentPane.setLayout(null); // 패널의 레이아웃을 수동 설정

        JLabel lblNewLabel = new JLabel("성적"); // "성적" 레이블 생성
        lblNewLabel.setBounds(61, 13, 57, 15); // 레이블 위치와 크기 설정
        contentPane.add(lblNewLabel); // 레이블을 패널에 추가

        textField = new JTextField(); // 성적을 입력할 텍스트 필드 생성
        textField.setBounds(170, 10, 97, 21); // 텍스트 필드 위치와 크기 설정
        contentPane.add(textField); // 텍스트 필드를 패널에 추가
        textField.setColumns(10); // 텍스트 필드의 열 수 설정

        JButton btnNewButton = new JButton("입력"); // "입력" 버튼 생성
        btnNewButton.addActionListener(e -> {
            list.add(Integer.parseInt(textField.getText())); // 입력된 성적을 리스트에 추가
        });
        btnNewButton.setBounds(61, 38, 97, 23); // 버튼 위치와 크기 설정
        contentPane.add(btnNewButton); // 버튼을 패널에 추가

        JButton btnNewButton_1 = new JButton("평균계산"); // "평균계산" 버튼 생성
        btnNewButton_1.setBounds(170, 38, 97, 23); // 버튼 위치와 크기 설정
        contentPane.add(btnNewButton_1); // 버튼을 패널에 추가

        JLabel lblNewLabel_1 = new JLabel("모든 학생의 평균"); // "모든 학생의 평균" 레이블 생성
        lblNewLabel_1.setBounds(61, 80, 122, 15); // 레이블 위치와 크기 설정
        contentPane.add(lblNewLabel_1); // 레이블을 패널에 추가

        textField_1 = new JTextField(); // 평균을 표시할 텍스트 필드 생성
        textField_1.setBounds(170, 77, 97, 21); // 텍스트 필드 위치와 크기 설정
        contentPane.add(textField_1); // 텍스트 필드를 패널에 추가

        // "평균계산" 버튼 클릭 시, 입력된 성적의 평균 계산
        btnNewButton_1.addActionListener(e -> {
            int sum = 0;
            for (int s : list) {
                sum += s;
            }
            textField_1.setText("" + (sum / list.size())); // 평균을 텍스트 필드에 표시
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Score s = new Score();
                    s.setVisible(true); // 애플리케이션 실행
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

