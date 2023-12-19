import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

// Receiver 클래스는 UDP를 이용한 간단한 메시지 수신 프로그램을 나타냅니다.
public class Receiver {
    
    public static void main(String[] args) throws IOException {
        
        byte[] buf = new byte[256]; // 수신된 데이터를 저장할 배열

        DatagramSocket socket = new DatagramSocket(5001); // 수신용 소켓 생성
        DatagramPacket packet = new DatagramPacket(buf, buf.length); // 패킷 생성

        socket.receive(packet); // 패킷 수신

        System.out.println(new String(buf)); // 수신된 데이터 출력
    }
}
