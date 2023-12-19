import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// CountDownTest1 클래스는 JFrame을 상속받아 간단한 카운트 다운을 나타내는 GUI 프로그램입니다.
public class CountDownTest1 extends JFrame {

    private JLabel label; // GUI에서 숫자를 표시할 JLabel
    Thread t; // 카운트 다운을 처리할 스레드

    // Counter 내부 클래스는 Thread를 상속받아 카운트 다운을 처리합니다.
    class Counter extends Thread {
        // run 메서드는 스레드가 실행될 때 수행되는 로직을 정의합니다.
        public void run() {
            for (int i = 0; i <= 10; i++) {
                try {
                    Thread.sleep(1000); // 1초씩 쉬면서 진행합니다.
                } catch (InterruptedException e) {
                    // 인터럽트가 발생하면 스레드를 종료합니다.
                    return;
                }
                label.setText(i + ""); // JLabel에 현재 카운트 값을 표시합니다.
            }
        }
    }

    // CountDownTest1의 생성자에서 GUI를 초기화하고 카운트 다운을 시작합니다.
    public CountDownTest1() {
        setTitle("카운트다운"); // 창의 제목을 설정합니다.
        setSize(400, 150); // 창의 크기를 설정합니다.
        getContentPane().setLayout(null); // 레이아웃을 null로 설정하여 자유로운 위치에 컴포넌트를 배치합니다.

        label = new JLabel("0"); // 초기에는 0이 표시되는 JLabel을 생성합니다.
        label.setBounds(0, 0, 384, 111); // JLabel의 위치와 크기를 설정합니다.
        label.setFont(new Font("Serif", Font.BOLD, 100)); // 폰트를 설정합니다.
        getContentPane().add(label); // JLabel을 GUI에 추가합니다.

        JButton btnNewButton = new JButton("카운터 중지"); // "카운터 중지" 버튼을 생성합니다.
        btnNewButton.setBounds(247, 25, 125, 23); // 버튼의 위치와 크기를 설정합니다.

        // "카운터 중지" 버튼에 액션 리스너를 추가하여 현재 스레드를 인터럽트합니다.
        btnNewButton.addActionListener(e -> t.interrupt());
        getContentPane().add(btnNewButton); // 버튼을 GUI에 추가합니다.

        setVisible(true); // GUI를 화면에 표시합니다.
        t = new Counter(); // 초기에 카운트 다운을 수행할 스레드를 생성합니다.
        t.start(); // 스레드를 시작합니다.
    }

    // main 메서드는 프로그램의 시작점입니다.
    public static void main(String[] args) {
        CountDownTest1 t = new CountDownTest1(); // CountDownTest1 객체를 생성하여 프로그램을 시작합니다.
    }
}
