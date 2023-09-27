import java.awt.*;
import javax.swing.*;

public class Week04_03 extends JFrame {
    JLabel label,label1,label2,label3;
    public Week04_03() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BusinessCard");
        
        setSize(500,200);
        setLayout(null);
        
        ImageIcon icon = new ImageIcon("C:/keyring.png"); 
        label = new JLabel(icon);
        label.setBounds(30,20,90,90);
        add(label);
        
        label1=new JLabel("김덕성");
        label1.setBounds(150,20,200,30);
        add(label1); // 프레임에 라벨 추가
        
        label2=new JLabel("프로젝트 매니저");
        label2.setBounds(150,40,200,30); // Y 좌표 조정
        add(label2); // 프레임에 라벨 추가
        
        label3=new JLabel("덕성주식회사");
        label3.setBounds(150,60,200,30); // Y 좌표 조정
        add(label3); 
    }

    public static void main(String[] args) {
        Week04_03 frame=new Week04_03();
        frame.setVisible(true); // 프레임을 보이게 하기 위해 추가
    }
}
