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
        setSize(600, 600);
        b1 = new JButton("LEFT");
        b2 = new JButton("RIGHT");

        panel = new JPanel();
        label = new JLabel();
        ImageIcon icon = new ImageIcon("C://CAR.png"); 
        label.setIcon(icon);
        initialX = (getWidth() - icon.getIconWidth()) / 2;
        imageX = initialX; 
        label.setLocation(initialX, label.getY()); 
        panel.add(label);
        add(panel);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveImage(-10);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveImage(10);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void moveImage(int deltaX) {
        imageX += deltaX;
        label.setLocation(imageX, label.getY());
    }

    public static void main(String[] args) {
        Week03_03 k = new Week03_03();
        k.setVisible(true);
    }
}