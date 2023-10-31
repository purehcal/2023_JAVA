import java.awt.*;
import javax.swing.*;

public class Olympic extends JFrame {
    public Olympic() {
        super("오륜기"); // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우를 닫을 때 프로그램 종료
        setContentPane(new MyPanel()); // MyPanel을 컨텐츠 패널로 설정
        setSize(210, 150); // 프레임 크기 설정
        setVisible(true); // 프레임 표시
    }

    // 그래픽을 그리는 패널을 정의하는 내부 클래스
    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // JPanel을 초기화하고 기존 그래픽을 지우는 역할

            // 다양한 색상으로 동그라미 그리기
            g.setColor(Color.BLUE);
            g.drawOval(10, 10, 50, 50);

            g.setColor(Color.BLACK);
            g.drawOval(70, 10, 50, 50);

            g.setColor(Color.RED);
            g.drawOval(130, 10, 50, 50);

            g.setColor(Color.YELLOW);
            g.drawOval(40, 30, 50, 50);

            g.setColor(Color.GREEN);
            g.drawOval(100, 30, 50, 50);
        }
    }

    public static void main(String[] args) {
        new Olympic(); // Olympic 객체를 생성하여 애플리케이션 실행
    }
}
