import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class No2 extends JFrame {
	JButton button1, button2;
    public No2() {
        // 프레임 설정
        setTitle("버블 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        button1 = new JButton("시작");
        button2 = new JButton("종료");
        button1.setBounds(150, 400, 100, 30);
        button2.setBounds(250, 400, 100, 30);

        // 게임 패널 추가
        GamePanel p = new GamePanel();
        setContentPane(p);
        add(button1);
        add(button2);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        // 프레임 생성
        new No2();
    }
}

class GamePanel extends JPanel {
    public GamePanel() {
        // 레이아웃 설정
        setLayout(null);

        // 마우스 클릭 이벤트 처리
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // 클릭 시 새로운 버블 스레드 시작
                new BubbleThread(e.getX(), e.getY()).start();
            }
        });
    }

    class BubbleThread extends Thread {
        private JLabel bubble;

        public BubbleThread(int bubbleX, int bubbleY) {
            // 버블 이미지 설정
            ImageIcon img = new ImageIcon("C:/JAVA/Week14_323/src/bubble.jpg");

            // 버블 레이블 생성 및 위치 설정
            bubble = new JLabel(img);
            bubble.setSize(img.getIconWidth(), img.getIconWidth());
            bubble.setLocation(bubbleX - img.getIconWidth() / 2, bubbleY - img.getIconHeight() / 2);

            // 버블을 패널에 추가
            add(bubble);

            // 패널 다시 그리기
            repaint();
        }

        public void run() {
            try {
                // 버블이 프레임을 벗어날 때까지 위로 움직임
                while (bubble.getY() + bubble.getHeight() > 0) {
                    Thread.sleep(20); // 20ms 마다
                    bubble.setLocation(bubble.getX(), bubble.getY() - 5); // 5픽셀씩 위로 이동
                    repaint();
                }

                // 버블이 프레임을 벗어나면 레이블 제거
                remove(bubble);
                repaint();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
