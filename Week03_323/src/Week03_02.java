import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Week03_02 extends JFrame implements ActionListener {
    JPanel p1;
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1;

    public Week03_02() {
        setTitle("Mile->Km"); // 프레임의 제목 설정

        p1 = new JPanel(); // 패널 생성

        // 라벨, 텍스트 필드, 버튼 등의 GUI 요소 초기화
        l1 = new JLabel("마일을 입력하시오");
        t1 = new JTextField(10);
        l2 = new JLabel("->");
        t2 = new JTextField(10);
        b1 = new JButton("변환");

        // 패널에 GUI 요소를 추가
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(b1);

        // 버튼에 ActionListener 등록
        b1.addActionListener(this);

        // 프레임에 패널을 추가
        add(p1);

        setSize(400, 150); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우를 닫을 때 프로그램 종료
        setVisible(true); // 프레임 표시
    }

    public static void main(String[] args) {
        Week03_02 w = new Week03_02();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double km = 1.609344;
        try {
            double dap = Double.parseDouble(t1.getText()) * km; // 마일을 킬로미터로 변환
            t2.setText(String.valueOf(dap + "km")); // 변환된 결과를 텍스트 필드에 출력
        } catch (NumberFormatException a) {
            t1.setText("숫자 입력"); // 숫자가 아닌 입력에 대한 오류 메시지 출력
        }
    }
}
