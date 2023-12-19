import javax.swing.*;
import java.awt.*;

// CountDownTest 클래스는 JFrame을 상속받는 GUI 프로그램입니다.
public class CountDownTest extends JFrame {
    private JLabel label; // GUI에서 숫자를 표시할 JLabel을 선언합니다.

    // MyThread 내부 클래스는 Thread를 상속받아 카운트다운을 처리합니다.
    class MyThread extends Thread {
        // run 메서드는 스레드가 실행될 때 수행되는 로직을 정의합니다.
        public void run() {
            // 0부터 10까지의 숫자를 카운트 다운합니다.
            for (int i = 0; i <= 10; i++) {
                try {
                    // 1초씩 쉬어가며 진행합니다.
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // JLabel에 현재 카운트 값을 표시합니다.
                label.setText(i + "");
            }
        }
    }

    // CountDownTest의 생성자는 GUI 창을 설정하고 스레드를 시작합니다.
    public CountDownTest() {
        setTitle("카운트다운"); // 창의 제목을 설정합니다.
        setSize(400, 150); // 창의 크기를 설정합니다.
        label = new JLabel("0"); // 초기에는 0이 표시되는 JLabel을 생성합니다.
        label.setFont(new Font("Serif", Font.BOLD, 100)); // 폰트를 설정합니다.
        add(label); // JLabel을 GUI에 추가합니다.
        setVisible(true); // GUI를 화면에 표시합니다.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 창을 닫을 때 프로그램을 종료합니다.
        (new MyThread()).start(); // MyThread 스레드를 시작합니다.
    }

    // main 메서드는 프로그램의 시작점입니다.
    public static void main(String[] args) {
        CountDownTest t = new CountDownTest(); // CountDownTest 객체를 생성하여 프로그램을 시작합니다.
    }
}
