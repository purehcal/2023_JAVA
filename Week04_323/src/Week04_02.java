import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Week04_02 extends JPanel implements ItemListener {
    JCheckBox[] buttons = new JCheckBox[4]; // 4개의 체크박스 배열
    String[] items = { "엔진오일 교환", "자동변속기오일 교환", "에어컨 필터 교환", "타이어 교환" }; // 서비스 항목 배열
    int[] prices = { 45000, 80000, 30000, 100000 }; // 각 서비스 항목의 가격 배열
    int money = 0; // 현재까지의 가격
    JLabel label; // 결과를 표시할 레이블

    public Week04_02() {
        super();

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JCheckBox(items[i]); // 서비스 항목에 대한 체크박스 생성
            buttons[i].addItemListener(this); // 체크박스에 아이템 리스너 등록
            add(buttons[i]); // 패널에 체크박스 추가
        }
        label = new JLabel("현재까지의 가격은 " + money + "원입니다.");
        label.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30)); // 레이블의 폰트 설정
        add(label); // 패널에 결과 레이블 추가
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        money = 0; // 초기화

        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].isSelected()) {
                money += prices[i]; // 체크된 항목의 가격을 더함
            }
        }

        label.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30)); // 레이블 폰트 설정
        add(label); // 패널에 결과 레이블 추가
        label.setText("현재까지의 가격은 " + money + "원입니다.");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new Week04_02();
        frame.setContentPane(newContentPane);
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
}
