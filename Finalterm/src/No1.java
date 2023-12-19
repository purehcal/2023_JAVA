import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

// CarGame 클래스는 JFrame을 상속받아 자동차 경주 게임을 나타냅니다.
public class No1 extends JFrame {

    // MyThread 내부 클래스는 Thread를 상속받아 각각의 자동차를 표현하며 움직이는 기능을 구현합니다.
    class MyThread extends Thread {
        private JLabel label; // 자동차 이미지를 표시할 JLabel
        private int x, y; // 자동차의 현재 위치 (x, y) 좌표

        // 생성자에서는 이미지 파일명과 초기 위치(x, y)를 받아와 해당 위치에 자동차 이미지를 표시합니다.
        public MyThread(String fname, int x, int y) {
            this.x = x;
            this.y = y;
            label = new JLabel();
            label.setIcon(new ImageIcon(fname));
            label.setBounds(x, y, 100, 100); // JLabel의 위치와 크기를 설정합니다.
            add(label); // JLabel을 JFrame에 추가합니다.
        }

        // run 메서드는 스레드가 실행될 때 호출되는 메서드로, 자동차를 움직이는 로직을 담고 있습니다.
        public void run() {
            for (int i = 0; i < 200; i++) {
                x += 10 * Math.random(); // 자동차를 랜덤한 속도로 오른쪽으로 이동시킵니다.
                label.setBounds(x, y, 100, 100); // JLabel의 위치를 업데이트합니다.
                repaint(); // 변경된 위치를 다시 그립니다.
                try {
                    Thread.sleep(100); // 0.1초 동안 일시 정지합니다.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }			
        }
    }

    // CarGame의 생성자에서는 창의 설정, 레이아웃 설정, 그리고 MyThread를 이용하여 자동차를 생성하고 시작합니다.
    public No1() {
        setTitle("CarRace"); // 창의 제목을 설정합니다.
        setSize(600, 300); // 창의 크기를 설정합니다.

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 때 프로그램을 종료합니다.
        setLayout(null); // 레이아웃을 null로 설정하여 자유로운 위치에 컴포넌트를 배치합니다.

        // MyThread를 이용하여 각각의 자동차를 생성하고 시작합니다.
        (new MyThread("car1.gif", 100, 0)).start();
        (new MyThread("car2.gif", 100, 50)).start();
        (new MyThread("car3.gif", 100, 100)).start();
        (new MyThread("car4.gif", 100, 150)).start();
        (new MyThread("car5.gif", 100, 200)).start();
        new MyThread("race.gif", 500, 0);

        setVisible(true); // 창을 화면에 표시합니다.
    }

    // main 메서드는 프로그램의 시작점입니다.
    public static void main(String[] args) {
        No1 t = new No1(); // CarGame 객체를 생성하여 프로그램을 시작합니다.
    }
}