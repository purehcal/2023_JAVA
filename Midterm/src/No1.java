import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class No1 extends JFrame implements ActionListener {
    JLabel label, label1, label2, label3;
    JTextField field1, field2, field3;
    JButton button1, button2;
	
	public No1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JFrame f = new JFrame();
        
        f.setTitle("덕성여대 화이팅");

        label = new JLabel("학생 등록하기");
        label.setBounds(20, 10, 80, 30);
        
        label1 = new JLabel("이름");
        label1.setBounds(20, 40, 80, 30);
        field1 = new JTextField(15);
        field1.setBounds(200, 40, 150, 30);
        
        label2 = new JLabel("학번");
        label2.setBounds(20, 80, 80, 30);
        field2 = new JTextField(15);
        field2.setBounds(200, 80, 150, 30);
        
        label3 = new JLabel("성적");
        label3.setBounds(20, 120, 80, 30);
        field3 = new JTextField(15);
        field3.setBounds(200, 120, 150, 30);
        
        button1 = new JButton("등록하기");
        button1.setBounds(80, 200, 100, 30);
        button1.addActionListener(this);
        button2 = new JButton("취소");
        button2.setBounds(200, 200, 100, 30);
        button1.addActionListener(this);
        
        f.add(label);
        f.add(label1); f.add(field1);
        f.add(label2); f.add(field2);
        f.add(label3); f.add(field3);
        f.add(button1); f.add(button2);
        
        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
    	No1 n = new No1();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        String text1=field1.getText();
        int text2=Integer.parseInt(field2.getText());
        double text3=Double.parseDouble(field3.getText());
        
        if(e.getSource()==button1) {
        	System.out.print("이름: "+text1+" 학번: "+text2+" 성적: "+text3);
        	System.exit(0);
        }
    }
}
