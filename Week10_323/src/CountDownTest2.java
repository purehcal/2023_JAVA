import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownTest2 extends JFrame {

    private JLabel label;
    Thread t;

    class Counter extends Thread {
        public void run() {
            for (int i = 0; i <= 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
                label.setText(i + "");
            }
        }
    }

    public CountDownTest2() {
        setTitle("카운트다운");
        setSize(400, 150);
        getContentPane().setLayout(null);

        label = new JLabel("0");
        label.setBounds(0, 0, 384, 111);
        label.setFont(new Font("Serif", Font.BOLD, 100));
        getContentPane().add(label);

        JButton btnNewButton1 = new JButton("카운터 중지");
        btnNewButton1.setBounds(247, 25, 125, 23);
        JButton btnNewButton2 = new JButton("카운트 다시시작");
        btnNewButton2.setBounds(247, 75, 125, 23);

        btnNewButton1.addActionListener(e -> t.interrupt());
        getContentPane().add(btnNewButton1);

        // Add an action listener to the "카운트 다시시작" button
        btnNewButton2.addActionListener(e -> {
            // Stop the current countdown thread if it's running
            if (t != null && t.isAlive()) {
                t.interrupt();
            }
            
            // Start a new countdown thread
            t = new Counter();
            t.start();
        });
        getContentPane().add(btnNewButton2);
        setVisible(true);
        t = new Counter();
        t.start();
    }

    public static void main(String[] args) {
        CountDownTest2 t = new CountDownTest2();
    }
}
