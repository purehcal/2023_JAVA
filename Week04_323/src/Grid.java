import java.awt.*;
import javax.swing.*;

public class Grid extends JFrame {
    public Grid() {
        super("액자 그리기"); // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우를 닫을 때 프로그램 종료
        setContentPane(new MyPanel()); // MyPanel을 컨텐츠 패널로 설정
        setSize(150, 160); // 프레임 크기 설정
        setVisible(true); // 프레임 표시
    }

    // 그래픽을 그리는 패널을 정의하는 내부 클래스
    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // JPanel을 초기화하고 기존 그래픽을 지우는 역할

            int dw = getWidth() / 10; // 가로 그리드 간격 계산
            for (int i = 1; i <= 9; i++) {
                g.drawLine(i * dw, 0, i * dw, getHeight()); // 수직 그리드 라인 그리기
            }

            int dh = getHeight() / 10; // 세로 그리드 간격 계산
            for (int i = 0; i <= 9; i++) {
                g.drawLine(0, i * dh, getWidth(), i * dh); // 수평 그리드 라인 그리기
            }
        }
    }

    public static void main(String[] args) {
        new Grid(); // Grid 객체를 생성하여 애플리케이션 실행
    }
}
