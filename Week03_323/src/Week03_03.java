import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Week03_03 extends JFrame {
    JButton b1, b2;
    JPanel panel;
    JLabel label;
    int initialX = 0;
    int imageX = 0;

    public Week03_03() {
        setSize(600, 600); // 프레임 크기 설정

        // 좌우로 이미지를 이동시키는 버튼 생성
        b1 = new JButton("LEFT");
        b2 = new JButton("RIGHT");

        panel = new JPanel();
        label = new JLabel();

        // 이미지 아이콘을 설정하고 초기 위치를 계산
        ImageIcon icon = new ImageIcon("C://CAR.png"); // 이미지 아이콘 로드
        label.setIcon(icon);
        initialX = (getWidth() - icon.getIconWidth()) / 2; // 이미지 초기 X 위치 계산
        imageX = initialX; // 이미지의 현재 X 위치 초기화
        label.setLocation(initialX, label.getY()); // 라벨 위치 설정
        panel.add(label);
        add(panel);

        // 좌측 버튼 클릭 시 이미지를 왼쪽으로 이동하는 리스너 설정
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveImage(-10); // 이미지를 왼쪽으로 10 픽셀 이동
            }
        });

        // 우측 버튼 클릭 시 이미지를 오른쪽으로 이동하는 리스너 설정
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveImage(10); // 이미지를 오른쪽으로 10 픽셀 이동
            }
        });

        // 버튼을 담는 패널을 하단에 추가
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true); // 프레임 표시
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 윈도우를 닫을 때 프로그램 종료
    }

    // 이미지를 이동하는 메서드
    private void moveImage(int deltaX) {
        imageX += deltaX;
        label.setLocation(imageX, label.getY());
    }

    public static void main(String[] args) {
        Week03_03 k = new Week03_03();
        k.setVisible(true);
    }
}
