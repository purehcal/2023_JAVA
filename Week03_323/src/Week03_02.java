import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Week03_02 extends JFrame implements ActionListener {
    JPanel p1;
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1;

    public Week03_02() {
        setTitle("Mile->Km");

        p1 = new JPanel();
        l1 = new JLabel("마일을 입력하시오");
        t1 = new JTextField(10);
        l2 = new JLabel("->");
        t2 = new JTextField(10);
        b1 = new JButton("변환");

        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(b1);

        b1.addActionListener(this);

        add(p1);

        setSize(400, 150); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
    }

    public static void main(String[] args) {
        Week03_02 w = new Week03_02();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double km = 1.609344;
        try {
            double dap = Double.parseDouble(t1.getText()) * km; // 정수로 파싱하지 않고 실수로 파싱
            t2.setText(String.valueOf(dap+"km"));
        } catch (NumberFormatException a) {
            t1.setText("숫자 입력");
        }
    }
}