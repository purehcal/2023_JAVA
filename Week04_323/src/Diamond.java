import java.awt.*;
import javax.swing.*;

public class Diamond extends JFrame {
    public Diamond() {
        super("다이아몬드"); // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우를 닫을 때 프로그램 종료
        setContentPane(new MyPanel()); // MyPanel을 컨텐츠 패널로 설정
        setSize(150, 160); // 프레임 크기 설정
        setVisible(true); // 프레임 표시
    }

    // 그래픽을 그리는 패널을 정의하는 내부 클래스
    class MyPanel extends JPanel {
        private int x[] = new int[4]; // x 좌표 배열
        private int y[] = new int[4]; // y 좌표 배열

        public void paintComponent(Graphics g) {
            super.paintComponent(g); // JPanel을 초기화하고 기존 그래픽을 지우는 역할

            g.setColor(Color.BLUE);

            // 다이아몬드 모양을 그리기 위한 좌표 설정
            x[0] = getWidth() / 2; // 화면 가로 중앙
            y[0] = 0;
            x[1] = 0;
            y[1] = getHeight() / 2; // 화면 세로 중앙
            x[2] = getWidth() / 2; // 화면 가로 중앙
            y[2] = getHeight();
            x[3] = getWidth();
            y[3] = getHeight() / 2; // 화면 세로 중앙

            g.drawPolygon(x, y, 4); // 지정된 좌표로 다이아몬드를 그림
        }
    }

    public static void main(String[] args) {
        new Diamond(); // Diamond 객체를 생성하여 애플리케이션 실행
    }
}
