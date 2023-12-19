import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// MessengerB 클래스는 UDP를 이용한 간단한 메신저 프로그램의 일부를 나타냅니다.
public class MessengerB {
    protected JTextField textField; // 사용자 입력을 받을 텍스트 필드
    protected JTextArea textArea; // 수신된 메시지를 표시할 텍스트 영역
    DatagramSocket socket; // UDP 소켓
    DatagramPacket packet; // UDP 패킷
    InetAddress address = null; // 상대방 주소
    final int myPort = 6000; // 수신용 포트 번호
    final int otherPort = 5000; // 송신용 포트 번호

    // 생성자에서 GUI 프레임을 초기화하고 소켓을 생성합니다.
    public MessengerB() throws IOException {
        MyFrame f = new MyFrame();
        address = InetAddress.getByName("127.0.0.1"); // 상대방 주소 설정
        socket = new DatagramSocket(myPort); // UDP 소켓 생성
    }

    // 수신된 패킷을 처리하는 메서드
    public void process() {
        while (true) {
            try {
                byte[] buf = new byte[256];
                packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet); // 패킷을 받음

                // 받은 패킷의 내용을 텍스트 영역에 표시함
                textArea.append("RECEIVED: " + new String(buf) + "\n");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    // GUI 프레임을 나타내는 내부 클래스
    class MyFrame extends JFrame implements ActionListener {

        // GUI 프레임 초기화
        public MyFrame() {
            super("MessengerB");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            textField = new JTextField(30);
            textField.addActionListener(this);

            textArea = new JTextArea(10, 30);
            textArea.setEditable(false);

            add(textField, BorderLayout.PAGE_END);
            add(textArea, BorderLayout.CENTER);
            pack();
            setVisible(true);
        }

        // "Enter" 키 입력에 대한 액션 이벤트 처리
        public void actionPerformed(ActionEvent evt) {
            String s = textField.getText();
            byte[] buffer = s.getBytes();
            DatagramPacket packet;

            // 패킷 생성
            packet = new DatagramPacket(buffer, buffer.length, address, otherPort);
            try {
                socket.send(packet); // 패킷 전송
            } catch (IOException e) {
                e.printStackTrace();
            }
            textArea.append("SENT: " + s + "\n");
            textField.selectAll();
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }

    // 메인 메서드: MessengerB 객체를 생성하고 수신 처리를 시작함
    public static void main(String[] args) throws IOException {
        MessengerB m = new MessengerB();
        m.process();
    }
}
