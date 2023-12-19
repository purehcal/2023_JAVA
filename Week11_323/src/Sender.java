import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// Sender 클래스는 UDP를 이용하여 메시지를 전송하는 간단한 프로그램을 나타냅니다.
public class Sender {
    
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(); // UDP 소켓 생성

            String s = "우리는 여전히 우리 운명의 주인이다.."; // 전송할 메시지
            byte[] buf = s.getBytes(); // 문자열을 바이트 배열로 변환

            InetAddress address = InetAddress.getByName("127.0.0.1"); // 수신자의 주소 (로컬 호스트)
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 5001); // 패킷 생성

            socket.send(packet); // 소켓을 통해 패킷 전송
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close(); // 소켓 닫기
            }
        }
    }
}
