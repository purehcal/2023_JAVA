import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class TriCircle extends JFrame {
    public TriCircle() {
        super("삼색원"); // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우를 닫을 때 프로그램 종료
        setContentPane(new MyPanel()); // MyPanel을 컨텐츠 패널로 설정
        setSize(120, 150); // 프레임 크기 설정
        setVisible(true); // 프레임 표시
    }

    // 그래픽을 그리는 패널을 정의하는 내부 클래스
    class MyPanel extends JPanel {
        // 그래픽을 그리는 메서드
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // JPanel을 초기화하고 기존 그래픽을 지우는 역할

            // 첫 번째 부채꼴 (빨간색)
            g.setColor(Color.RED);
            g.fillArc(10, 10, 100, 100, 90, 120);

            // 두 번째 부채꼴 (파란색)
            g.setColor(Color.BLUE);
            g.fillArc(10, 10, 100, 100, 210, 120);

            // 세 번째 부채꼴 (노란색)
            g.setColor(Color.YELLOW);
            g.fillArc(10, 10, 100, 100, 330, 120);
        }
    }

    public static void main(String[] args) {
        new TriCircle(); // TriCircle 객체 생성하여 애플리케이션 실행
    }
}
