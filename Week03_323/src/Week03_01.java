import javax.swing.*;
import java.awt.*;

public class Week03_01 extends JFrame {
	public Week03_01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFrame f=new JFrame();
		JLabel label=new JLabel("회원 등록하기");
		label.setBounds(160,10,80,30);
		
		JLabel label1=new JLabel("이름");
		label1.setBounds(20,40,80,30);
		JTextField field1=new JTextField(15);
		field1.setBounds(200,40,150,30);
		JLabel label2=new JLabel("패스워드");
		label2.setBounds(20,80,80,30);
		JTextField field2=new JTextField(15);
		field2.setBounds(200,80,150,30);
		JLabel label3=new JLabel("이메일 주소");
		label3.setBounds(20,120,80,30);
		JTextField field3=new JTextField(15);
		field3.setBounds(200,120,150,30);
		JLabel label4=new JLabel("전화번호");
		label4.setBounds(20,160,80,30);
		JTextField field4=new JTextField(15);
		field4.setBounds(200,160,150,30);
		
		JButton button1 =new JButton("등록하기");
		button1.setBounds(80,200,100,30);
		JButton button2 =new JButton("취소");
		button2.setBounds(200,200,100,30);
		
		f.add(label);
		f.add(label1); f.add(field1);
		f.add(label2); f.add(field2);
		f.add(label3); f.add(field3);
		f.add(label4); f.add(field4);
		f.add(button1); f.add(button2);
		
		f.setSize(400,300);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Week03_01 f=new Week03_01();
	}

}